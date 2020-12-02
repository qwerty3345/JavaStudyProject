import java.util.ArrayList;

public class Hero extends Human implements Flyable {
    private int power;
    Hero.ExposedState exposedState;
    ArrayList<Human> savedHuman;

    Hero() {
        this("기본히어로", 100, 10);
    }

    Hero(String name, int power, int healthPoint) {
        this.savedHuman = new ArrayList();
        this.name = name;
        this.power = power;
        this.healthPoint = healthPoint;
    }

    public int getPower() {
        return this.power + this.savedHuman.size() * 10;
    }

    public void fly() {
        if (this.exposedState.compareTo(Hero.ExposedState.EXPOSED) == 0) {
            this.exposedState = Hero.ExposedState.NORMAL;
            System.out.println(this.name + ": 날아서 이상상태가 해제됨");
        } else {
            System.out.println(this.name + ": 기분 좋아짐");
        }

    }

    public void saveHuman(int num) {
        if (this.exposedState == Hero.ExposedState.EXPOSED) {
            this.cry();
            System.out.println(this.name + ": 이상상태 때문에 시민을 구하지 못했습니다. 날아서 떨쳐내야 함다.");
        } else {
            for(int i = 0; i < num; ++i) {
                this.savedHuman.add(new Human());
            }

            System.out.println(this.name + ": 시민 " + num + "명을 구했습니다.");
        }

    }

    static enum ExposedState {
        EXPOSED,
        NORMAL;

        private ExposedState() {
        }
    }
}
