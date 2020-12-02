public class Eagle extends Bird implements Flyable {
    Eagle() {
    }

    Eagle(int age, String name) {
        super(age, name);
    }

    Eagle(String name, int age) {
        super(name, age);
    }

    public void fly() {
        System.out.println(this.name + " 날아오름.");
    }
}
