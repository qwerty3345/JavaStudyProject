import java.util.Stack;

public class Villain extends Human {
    Stack<Human> servant;
    private int power;

    Villain() {
        this("기본빌런", 100, 10);
    }

    Villain(String name, int power, int healthPoint) {
        this.servant = new Stack();
        this.name = name;
        this.power = power;
        this.healthPoint = healthPoint;
    }

    public int getPower() {
        return this.power + this.servant.size() * 10;
    }

    void makeServant(int num) {
        for(int i = 0; i < num; ++i) {
            this.servant.add(new Human());
        }

        System.out.println(this.name + ": 부하 " + num + "명을 영입했다.");
    }

    void makeServant() {
        this.servant.add(new Human());
        System.out.println(this.name + ": 부하 1명을 영입했다.");
    }

    void loseServant(int num) {
        int i;
        if (this.servant.size() > num) {
            for(i = 0; i < num; ++i) {
                this.servant.pop();
            }

            System.out.println(this.name + "의 신입 부하 " + num + " 명이 때려침.");
        } else {
            String var10001 = this.name;
            System.out.println(var10001 + "의 신입 부하 " + this.servant.size() + " 명이 때려침.");

            for(i = 0; i < this.servant.size(); ++i) {
                this.servant.pop();
            }
        }

    }
}
