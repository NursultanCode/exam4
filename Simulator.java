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
            System.out.println("5 - Next Day");
            System.out.println("6 - sort");
            System.out.println("7-exit");
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
                    cats.printAllCats();
                    int a = askTheCat();
                    cats.getCats().get(a-1).play();
                    cats.printAllCats();
                    askOperation();
                    break;
                case 3:
                    System.out.println("You selected Feed the cat!");
                    cats.printAllCats();
                    a = askTheCat();
                    cats.getCats().get(a-1).eat();
                    cats.printAllCats();
                    askOperation();
                    break;
                case 4:
                    System.out.println("You selected Tread the cat!");
                    cats.printAllCats();
                    a = askTheCat();
                    cats.getCats().get(a-1).heal();
                    cats.printAllCats();
                    askOperation();
                    break;
                case 5:
                    System.out.println("You selected next day!");
                    cats.getCats().forEach(Cat::nextDay);
                    System.out.println("Next day operation completed Successfully");
                    cats.printAllCats();
                    askOperation();
                    break;
                case 6:
                    askForSort();
                    cats.printAllCats();
                    askOperation();
                    break;
                case 7:
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

    private void askForSort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - By Name");
        System.out.println("2 - By Age");
        System.out.println("3 - By Mood");
        System.out.println("4 - By Health");
        System.out.println("5 - By Satiety");
        System.out.println("Enter the Number:");
        try{
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    System.out.println("Sorted by Name");
                    cats.sortByName();
                    break;
                case 2:
                    System.out.println("Sorted by Age");
                    cats.sortByAge();
                    break;
                case 3:
                    System.out.println("Sorted by Mood");
                    cats.sortByMood();
                    break;
                case 4:
                    System.out.println("Sorted by Health");
                    cats.sortByHealth();
                    break;
                case 5:
                    System.out.println("Sorted by Satiety");
                    cats.sortBySatiety();
                    break;
                default:
                    System.out.println("Wrong input");
                    askForSort();
            }
        }catch (Exception e){
            System.out.println("Wrong input!");
            askForSort();
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
                    .setSatiety(random.nextInt(80)+20)
                    .setMood(random.nextInt(80)+20)
                    .setHealth(random.nextInt(80)+20)
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
