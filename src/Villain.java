import java.util.Stack;

public class Villain extends Human {
    Stack<Human> servant= new Stack(); //빌런의 부하.
    private int power; // 파워

    // 빌런 기본 생성자
    Villain() {
        this("기본빌런", 100, 10);
    }

    // 빌런 생성자
    Villain(String name, int power, int healthPoint) {
        this.name = name;
        this.power = power;
        this.healthPoint = healthPoint;
    }

    // 기본 파워 + 하수인의 수 만큼 파워 늘어남
    public int getPower() {
        return this.power + this.servant.size() * 10;
    }

    // 부하 영입
    void makeServant(int num) {
        for(int i = 0; i < num; ++i) {
            this.servant.add(new Human());
        }
        System.out.println(this.name + ": 부하 " + num + "명을 영입했다.");
    }

    // 기본 1명만 영입 (오버로딩)
    void makeServant() {
        this.servant.add(new Human());
        System.out.println(this.name + ": 부하 1명을 영입했다.");
    }

    // 부하를 잃음
    void loseServant(int num) {
        if (this.servant.size() > num) {
            for(int i = 0; i < num; ++i) {
                this.servant.pop(); // Stack구조. 최근에 들어온 신입부터 때려침.
            }
            System.out.println(this.name + "의 신입 부하 " + num + " 명이 때려침.");
        } else {
            String var10001 = this.name;
            System.out.println(var10001 + "의 신입 부하 " + this.servant.size() + " 명이 때려침.");

            for(int i = 0; i < this.servant.size(); ++i) {
                this.servant.pop();
            }
        }

    }
}
