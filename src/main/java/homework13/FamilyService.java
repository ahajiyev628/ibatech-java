package homework13;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private final CollectionFamilyDao fams;
    // public static String path = "/home/ufaz/Downloads/test.txt";
    public static String path = FamilyService.class.getClassLoader().getResource("test.txt").getFile();

    public FamilyService(CollectionFamilyDao fams) {
        this.fams = fams;
    }

    public List<Family> getAllFamilies(){
        return fams.getAllFamilies();
    }
    public String displayAllFamilies(){
        return Arrays.toString(fams.getAllFamilies().toArray());
    }

    public Collection<Family> getFamiliesBiggerThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()>n)
                .collect(Collectors.toList());
    }
    public Collection<Family> getFamiliesLessThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()<n)
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(Family f){
        if(f.countFamily()==4) { // initial is 2 (mother and father). 4 means that the family has 2 children
            return f.countFamily();
        }
        return 0;
    }

    public Family createNewFamily(Human father, Human mother){
        fams.families.add(new Family(father,mother));
        System.out.println("new Family is created and added to database");
        return new Family(father,mother);
    }

    public void deleteFamilyByIndex(int index){
        fams.deleteFamily(index);
        System.out.println(index + "th family was removed from DAO");
    }

    public void bornChild(Family family, Human child, String gender){
        List<Human> hm = fams.getAllFamilies()
                .stream().filter(f->f.equals(family))
                .iterator().next()
                .getChildren();
        hm.add(child);
    }

    public Family adoptChild(Family f, Human child) {
        f.addChild(child);
        return f;
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return getAllFamilies().get(id);
    }

    public List<Pet> getPets(int index) {
        return getFamilyById(index).getPet().stream().collect(Collectors.toList());
    }

    public void addPet(int index, Pet p) {
        getFamilyById(index).getPet().add(p);
        System.out.println("a new pet is added to the specified family");
    }

//    public void loadData(List<Family> families) throws IOException {
//        Iterator<Family> iter = families.iterator();
//
//        FileWriter fw = new FileWriter(path, false);
//        PrintWriter out = new PrintWriter(fw);
//        out.println(iter.next().prettyFormat());
//        out.close();
//
//        File file = new File(path);
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//    }

    public void loadData(List<Family> families) throws IOException {
        Iterator<Family> iter = families.iterator();

        FileWriter fw = new FileWriter(path, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(iter.next().prettyFormat());
        out.close();
    }
    public void readData() throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }


}
