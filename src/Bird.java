public class Bird extends Animal {
    Bird() {
        this(0, "");
    }

    Bird(int age, String name) {
        this.age = age;
        this.name = name;
    }

    Bird(String name, int age) {
        this.age = age;
        this.name = name;
    }

    void eat() {
        System.out.println("부리로 먹는다.");
    }

    void run() {
        System.out.println("뒤뚱뒤뚱 달린다");
    }
}
