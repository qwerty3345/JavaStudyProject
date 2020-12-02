import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getGlobal();

    public Main() {
    }

    public static void main(String[] args) {
        Villain joker = new Villain("조커", 100, 10);
        Hero batman = new Hero("배트맨", 200, 20);
        ArrayList<Bird> flyingBirds = new ArrayList();
        flyingBirds.add(new Eagle("대머리독수리", 3));
        flyingBirds.add(new Eagle("흰머리독수리", 2));
        flyingBirds.add(new Penguin("황제펭귄", 4));
        fight(batman, joker);
        joker.makeServant(20);
        fight(batman, joker);
        batman.saveHuman(5);
        batman.fly();
        batman.saveHuman(20);
        joker.makeServant(3);
        joker.loseServant(15);
        System.out.println(batman.getPower());
        System.out.println(joker.getPower());
        fight(batman, joker);

        try {
            Iterator var4 = flyingBirds.iterator();

            while(var4.hasNext()) {
                Bird elem = (Bird)var4.next();
                ((Flyable)elem).fly();
            }
        } catch (ClassCastException var9) {
            LOG.warning("flyingBirds 안에 fly할 수 없는 새가 있습니다.");
            flyingBirds.removeIf((e) -> {
                return !(e instanceof Flyable);
            });
        } finally {
            System.out.println("flyingBirds" + flyingBirds.size());
        }

    }

    static void fight(Hero hero, Villain villain) {
        System.out.println("-----" + hero.name + " vs " + villain.name + " 싸움 -----");
        if (villain.getPower() > hero.getPower()) {
            hero.exposedState = Hero.ExposedState.EXPOSED;
            --hero.healthPoint;
            System.out.println(villain.name + "이(가) " + hero.name + "을(를) 이겼습니다.");
        } else if (villain.getPower() < hero.getPower()) {
            --villain.healthPoint;
            System.out.println(hero.name + "이(가) " + villain.name + "을(를) 이겼습니다.");
            villain.loseServant(1);
        } else {
            --hero.healthPoint;
            --villain.healthPoint;
            System.out.println("승부가 나지 않았고, 둘 다 힘들어 합니다.");
        }

    }
}
