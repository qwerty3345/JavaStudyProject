import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class Main {
    //로그메세지 저장할 로거 생성
    private static final Logger LOG = Logger.getGlobal();

    public static void main(String[] args) {
        Villain joker = new Villain("조커", 100, 10);
        Hero batman = new Hero("배트맨", 200, 20);

        // 날 수 있는 새들 어레이리스트 생성
        ArrayList<Bird> flyingBirds = new ArrayList();
        flyingBirds.add(new Eagle("대머리독수리", 3));
        flyingBirds.add(new Eagle("흰머리독수리", 2));
        flyingBirds.add(new Penguin("황제펭귄", 4)); // 일부러 못나는 새 넣음. 예외발생시키기 위해.


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
            Iterator it = flyingBirds.iterator();

            while(it.hasNext()) {
                Bird elem = (Bird)it.next();
                ((Flyable)elem).fly();
            }
        } catch (ClassCastException cce) {
            LOG.warning("flyingBirds 안에 fly할 수 없는 새가 있습니다.");  // 로그 작성.
            flyingBirds.removeIf((e) -> { // 못나는 새 지워줌. 람다식 활용.
                return !(e instanceof Flyable);
            });
        } finally {
            // 최종 몇마리가 남아있는지 출력
            System.out.println("flyingBirds" + flyingBirds.size());
        }

    }

    // 히어로와 빌런이 싸우는 메서드
    static void fight(Hero hero, Villain villain) {
        System.out.println("-----" + hero.name + " vs " + villain.name + " 싸움 -----");

        // 빌런이 더 강할 때.
        if (villain.getPower() > hero.getPower()) {
            hero.exposedState = Hero.ExposedState.EXPOSED; //히어로는 약점노출
            --hero.healthPoint;
            System.out.println(villain.name + "이(가) " + hero.name + "을(를) 이겼습니다.");
        } else if (villain.getPower() < hero.getPower()) { // 히어로가 더 강할 때
            --villain.healthPoint;
            System.out.println(hero.name + "이(가) " + villain.name + "을(를) 이겼습니다.");
            villain.loseServant(1); // 빌런은 하수인 1명 잃음.
        } else { // 무승부
            --hero.healthPoint;
            --villain.healthPoint; // 둘 다 체력 떨어짐
            System.out.println("승부가 나지 않았고, 둘 다 힘들어 합니다.");
        }

    }
}
