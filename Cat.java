import java.util.Random;

public class Cat{
    private String name;
    private int age;
    private int satiety;
    private int mood;
    private int health;
    private int average;
    private Actionable actionable;

    public Actionable getActionable() {
        return actionable;
    }

    public String getName() {
        return name;
    }

    public void setActionable(Actionable actionable) {
        this.actionable = actionable;
    }



    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String printCat(int i) {
        return String.format("%-3d|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|",i,name,age,health,satiety,mood,average);
    }

    public int getAverage() {
        return average;
    }

    public void setAverage() {
        average = (health+mood+satiety)/3;
    }
    public void setActionable(){
        if (age<=5) actionable = new Young();
        else if (age<=10) actionable = new Middle();
        else actionable = new Old();
    }

    public void eat() {
        actionable.eat(this);
    }

    public void play() {
        actionable.play(this);
    }

    public void heal() {
        actionable.heal(this);
    }
    public void nextDay(){
        Random random = new Random();
        setSatiety(getSatiety()-(random.nextInt(5)+1));
        setMood(getMood()+(random.nextInt(4)-3));
        setHealth(getHealth()+(random.nextInt(4)-3));
        setAverage();
    }

    public static class Builder{
        private String name;
        private int age;
        private int satiety;
        private int mood;
        private int health;
        private int average;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(int age) throws Exception {
            checkForException(age);
            this.age = age;
            return this;
        }

        private void checkForException(int n) throws WrongInputException {
            if (n<1||n>18) {
                throw new WrongInputException();
            }
        }


        public Builder setSatiety(int satiety){
            this.satiety = satiety;
            return this;
        }
        public Builder setMood(int mood){
            this.mood = mood;
            return this;
        }
        public Builder setHealth(int health){
            this.health = health;
            return this;
        }
        public Builder setAverage(){
            this.average = (health+satiety+mood)/3;
            return this;
        }
        public Cat build(){
            Cat cat = new Cat();
            cat.name = this.name;
            cat.age = this.age;
            cat.health = this.health;
            cat.mood = this.mood;
            cat.satiety = this.satiety;
            cat.average = this.average;
            cat.setActionable();
            return cat;
        }

    }

    public static class WrongInputException extends Exception{

    }


}
