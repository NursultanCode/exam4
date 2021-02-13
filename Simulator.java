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
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which operation you want?(Enter the number)");
            System.out.println("1 - Add cat");
            System.out.println("2 - Play with Cat");
            System.out.println("3 - Feed the cat");
            System.out.println("4 - Tread the cat");
            System.out.println();
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    addCat();
                    System.out.println("You have successfully added Cat!");
                    cats.printAllCats();
                    askOperation();
                    break;
                case 2:
                    System.out.println("You selected Play with cat!");
                    int a = askTheCat();
                    cats.getCats().get(a-1).play();
                    System.out.println("You have successfully played with "+cats.getCats().get(a-1).getName());
                    cats.printAllCats();
                    askOperation();
                    break;
                case 3:
                    System.out.println("You selected Feed the cat!");
                    a = askTheCat();
                    cats.getCats().get(a-1).eat();
                    System.out.println("You have successfully Feed with "+ cats.getCats().get(a-1).getName());
                    cats.printAllCats();
                    askOperation();
                    break;
                case 4:
                    System.out.println("You selected Tread the cat!");
                    a = askTheCat();
                    cats.getCats().get(a-1).heal();
                    System.out.println("You have successfully Tread with "+ cats.getCats().get(a-1).getName());
                    cats.printAllCats();
                    askOperation();
                    break;

                default:
                    System.out.println("wrong input!");
                    askOperation();
            }
        }catch (Exception e){
            System.out.println("Wrong input");
            askOperation();
        }

    }

    private  int askTheCat() {
        try {
            System.out.println("Enter the number of cat!");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println("Wrong input!");
        }
        return 100;
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
        } catch (Cat.WrongInputException e) {
            System.out.println("Wrong input of Age!");
            addCat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
