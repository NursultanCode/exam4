import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCats {
    public List<Cat> cats;

    public AllCats() {
        var filePath = Path.of("src", "cats.json");
        Gson gson = new Gson();
        try {
            cats = List.of(gson.fromJson(Files.readString(filePath), Cat[].class));
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
        //sorting
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
