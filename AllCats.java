import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class AllCats {
    ArrayList <Cat> cats;
    public List<Cat> formCats;

    public AllCats() {
        var filePath = Path.of("src", "cats.json");
        Gson gson = new Gson();
        try {
            cats = new ArrayList<>();
            formCats = List.of(gson.fromJson(Files.readString(filePath), Cat[].class));
            cats.addAll(formCats);
            cats.forEach(Cat::setActionable);
            cats.forEach(Cat::setAverage);
            makeSort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static AllCats read() {
        return new AllCats();
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void addCat(Cat cat){
        cats.add(cat);
        makeSort();
    }
    public void makeSort(){
        cats.sort(comparing(Cat::getAverage).reversed());
    }
    public void sortByHealth(){
        cats.sort(comparing(Cat::getHealth).reversed());
    }
    public void sortByMood(){
        cats.sort(comparing(Cat::getMood).reversed());
    }
    public void sortBySatiety(){
        cats.sort(comparing(Cat::getSatiety).reversed());
    }
    public void sortByName(){
        cats.sort(comparing(Cat::getName));
    }
    public void sortByAge(){
        cats.sort(comparing(Cat::getAge).reversed());
    }

    public  void printAllCats(){
        System.out.println(String.format("%-3s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|","#","name","age","health","satiety","mood","average"));
        System.out.println("-".repeat(70));
        int count=1;
        for (Cat c:cats
             ) {
            System.out.println(c.printCat(count));
            count++;
        }
    }
}
