package sample;

public class Prisoner {
    int prisonerID;     // randomly generated
    int jailCell;       // randomly chosen
    int age;            // user entered
    int sentenceYears;  // user entered
    int points;         // computer calculated && user entered
    String crime;       // user entered
    String name;        // user entered
    String surname;     // user entered
    boolean toBeExecuted;// user entered
    boolean isMale;     // user entered

    public Prisoner(int prisonerID, int jailCell, int age, int sentenceYears, int points, String crime, String name, String surname, boolean toBeExecuted, boolean isMale) {
        this.prisonerID = prisonerID;
        this.jailCell = jailCell;
        this.age = age;
        this.sentenceYears = sentenceYears;
        this.points = points;
        this.crime = crime;
        this.name = name;
        this.surname = surname;
        this.toBeExecuted = toBeExecuted;
        this.isMale = isMale;
    }

    public int getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(int prisonerID) {
        this.prisonerID = prisonerID;
    }

    public int getJailCell() {
        return jailCell;
    }

    public void setJailCell(int jailCell) {
        this.jailCell = jailCell;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSentenceYears() {
        return sentenceYears;
    }

    public void setSentenceYears(int sentenceYears) {
        this.sentenceYears = sentenceYears;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
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

    public boolean isToBeExecuted() {
        return toBeExecuted;
    }

    public void setToBeExecuted(boolean toBeExecuted) {
        this.toBeExecuted = toBeExecuted;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
