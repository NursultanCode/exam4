public class Middle implements Actionable{
    @Override
    public void eat(Cat cat) {
        cat.setSatiety(cat.getSatiety()+5);
        cat.setMood(cat.getMood()+5);
        cat.setAverage();
    }

    @Override
    public void play(Cat cat) {
        cat.setSatiety(cat.getSatiety()-5);
        cat.setMood(cat.getMood()+5);
        cat.setHealth(cat.getHealth()+5);
        cat.setAverage();
    }

    @Override
    public void heal(Cat cat) {
        cat.setSatiety(cat.getSatiety()-5);
        cat.setMood(cat.getMood()-5);
        cat.setHealth(cat.getHealth()+5);
        cat.setAverage();
    }
}
