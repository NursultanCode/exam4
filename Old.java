public class Old implements Actionable{
    @Override
    public void eat(Cat cat) {
        cat.setSatiety(cat.getSatiety()+4);
        cat.setMood(cat.getMood()+4);
        cat.setAverage();
    }

    @Override
    public void play(Cat cat) {
        cat.setSatiety(cat.getSatiety()-6);
        cat.setMood(cat.getMood()+4);
        cat.setHealth(cat.getHealth()+4);
        cat.setAverage();
    }

    @Override
    public void heal(Cat cat) {
        cat.setSatiety(cat.getSatiety()-6);
        cat.setMood(cat.getMood()-6);
        cat.setHealth(cat.getHealth()+4);
        cat.setAverage();
    }
}
