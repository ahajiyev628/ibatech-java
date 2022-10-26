package homework13;


import java.util.*;

public class Family {
    private Human father;
    private Human mother;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human father, Human mother, List<Human> children, Set<Pet> pet) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pet = pet;
    }
    public Family(Human father, Human mother, List<Human> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }


    public Family() {
    }

    public Family(Human father, Human mother) {
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public List<Human> addChild(Human child) {
        List<Human> newChildren = new ArrayList<>();
        int i = 0;
        newChildren.add(i, child);
        i++;
        this.children = newChildren;
        return children;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) && Objects.equals(mother, family.mother) && Objects.equals(children, family.children);
    }
    @Override
    public int hashCode() {
        return Objects.hash(father, mother, children);
    }


    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }

//    public Human childToString(List<Human> h) {
//        Iterator<Human> it = children.iterator();
//        if(it.hasNext()) {
//            return it.next();
//        }
//        return null;
//    }

    public String prettyFormat() {
        Iterator<Human> iter = getChildren().iterator();
       // Human first = getChildren().stream().iterator().next();
        return "family: " + '\n' +
                "     mother: " + mother.toString() + '\n' +
                "     father: " + father.toString() + '\n' +
                "     children: " + '\n' +
                "           " + Main.gender_boy + ": " + iter.next().toString() + '\n' +
                "           " + Main.gender_girl + ": "  + iter.next().toString() + '\n' +
                "     pets: " + pet.toString();
    }

}
