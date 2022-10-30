package homework10;

import java.text.ParseException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyService fs = new FamilyService(new CollectionFamilyDao());

        fs.createNewFamily(new Human("father","father"),new Human("mother","mother"), null);

        System.out.println(fs.count());

        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        fs.adoptChild(fs.getFamilyById(0), new Human("Allahverdi2","Hajiyev2", "23/11/2011", 100));
//        fs.getFamilyById(0).getChildren().get(0).setAdopted(true);
        fs.getFamilyById(0).getChildren().get(0).setBirthDate("24/11/2011");
        System.out.println("after a child is adopted: ");
        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        System.out.println("Another child:");
        Human h1 = new Human("Allahverdi1","Hajiyev1", "11/23/2011", 10);
        System.out.println(h1.isAdopted());
        System.out.println(h1.toString());
    }
}
