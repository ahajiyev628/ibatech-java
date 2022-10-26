package homework10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
    private String name;
    private String surname;
    private long birth_date;
    //1322018752992l
    // private String birthDate;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;

    private Family family;
    Calendar cal = Calendar.getInstance();

    public Human(){}


    public Human(String name, String surname, long birth_date, int iq) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.iq = iq;
    }

   // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
     //   return df.format(new Date(date));
    //parse(date).getTime();

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(long birth_date) {
        this.birth_date = birth_date;
    }

    public void setIq(int iq) {
        if (iq > 100 || iq < 0) {
            this.iq = Integer.parseInt("");
            return;
        }
        this.iq=iq;
    }
    public int getIq() {
        return iq;
    }


    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean isAdopted;

    @Override
    public String toString() {
        SimpleDateFormat sd;
        if(isAdopted) {
            sd = new SimpleDateFormat("MM/dd/yyyy");
        } else {
            sd = new SimpleDateFormat("dd/MM/yyyy");
        }
        cal.setTimeInMillis(birth_date);
        cal.add(Calendar.DATE,0);
        Date date = cal.getTime();
        String dt = sd.format(date);
        return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", birthdate=" + dt +
                    ", iq=" + iq +
                    '}';
    }

    public String describeAge(long timestamp) {
        cal.setTimeInMillis(timestamp);
        return "year: " + cal.get(Calendar.YEAR) + ". month: " + cal.get(Calendar.MONTH) + ". day: " + cal.get(Calendar.DAY_OF_MONTH);
    }
}
