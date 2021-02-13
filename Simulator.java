import java.util.Random;
import java.util.Scanner;

public class Simulator {
    public static AllCats cats;
    public void start(){
        cats = AllCats.read();
        cats.printAllCats();
        askOperation();
    }

    private  void askOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which operation you want?(Enter the number)");
        System.out.println("1 - Add cat");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                addCat();
                cats.printAllCats();
                break;
        }
    }

    private static void addCat() {
        Random random = new Random();
        System.out.println("You want to add Cat");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the Name of cat:");
        String name = scanner.next();
        System.out.println("Write the age of cat:");
        int age = scanner.nextInt();
        try {
            Cat cat  = new Cat.Builder()
                    .setName(name)
                    .setAge(age)
                    .setSatiety(random.nextInt(100))
                    .setMood(random.nextInt(100))
                    .setHealth(random.nextInt(100))
                    .setAverage()
                    .build();
            cats.addCat(cat);
        } catch (Exception e) {
            System.out.println("Wrong input of Age!");
            addCat();
        }
    }
}
