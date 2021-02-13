public class Cat {
    private String name;
    private int age;
    private int satiety;
    private int mood;
    private int health;
    private int average;

    public String printCat(int i) {
        return String.format("%-3d|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|",i,name,age,health,satiety,mood,average);
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

        private void checkForException(int n) throws Exception {
            if (n<1||n>18) {
                throw new Exception();
            }
        }


        public Builder setSatiety(int satiety) throws Exception {
            this.satiety = satiety;
            return this;
        }
        public Builder setMood(int mood) throws Exception {
            this.mood = mood;
            return this;
        }
        public Builder setHealth(int health) throws Exception {
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
            return cat;
        }

    }
    private Cat(){

    }


}
