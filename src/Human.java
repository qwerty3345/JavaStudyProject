public class Human extends Animal {
    int healthPoint = 5; // 기본 체력

    public Human() { }

    // 먹으면 체력 ++
    void eat() {
        this.healthPoint ++ ;
    }

    void run() {
        System.out.println("두 발로 힘차게 달린다");
    }

    void cry() {
        System.out.println(this.name + ": 흑흑..");
    }
}
