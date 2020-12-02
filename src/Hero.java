import java.util.ArrayList;

// Hero는 Human을 상속받고, Flyable을 구현함
public class Hero extends Human implements Flyable {
    private int power;
    Hero.ExposedState exposedState;
    ArrayList<Human> savedHuman = new ArrayList(); // 구한 사람들 목록

    // 약점에 노출된 이상상태 enum
    static enum ExposedState {
        EXPOSED,
        NORMAL;
        private ExposedState() { }
    }

    // 기본 생성자
    Hero() {
        this("기본히어로", 100, 10);
    }

    // 생성자 (이름, 파워, 체력)
    Hero(String name, int power, int healthPoint) {
        this.name = name;
        this.power = power;
        this.healthPoint = healthPoint;
    }

    // Hero의 파워는 기본파워 + 구한 사람들의 수 만큼 늘어남
    public int getPower() {
        return this.power + this.savedHuman.size() * 10;
    }

    // 날아오름으로서 약점노출 이상상태 벗어날 수 있음
    public void fly() {
        if (this.exposedState.compareTo(Hero.ExposedState.EXPOSED) == 0) {
            this.exposedState = Hero.ExposedState.NORMAL;
            System.out.println(this.name + ": 날아서 이상상태가 해제됨");
        } else {
            System.out.println(this.name + ": 기분 좋아짐");
        }
    }

    // 사람을 구함
    public void saveHuman(int num) {
        if (this.exposedState == Hero.ExposedState.EXPOSED) { // 이상상태이면
            this.cry();
            System.out.println(this.name + ": 이상상태 때문에 시민을 구하지 못했습니다. 날아서 떨쳐내야 함다.");
        } else {
            for(int i = 0; i < num; ++i) {
                this.savedHuman.add(new Human());
            }
            System.out.println(this.name + ": 시민 " + num + "명을 구했습니다.");
        }
    }
}
