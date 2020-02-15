package sample;

public class Prisoner {
    private long prisonerID;     // randomly generated
    private int age;            // user entered
    private int sentenceYears;  // user entered
    private int points;         // computer calculated && user entered
    private String crime;       // user entered
    private String name;        // user entered
    private String surname;     // user entered
    private boolean toBeExecuted;// user entered
    private boolean isMale;     // user entered
    private String jailCell;    // computer generated


    public Prisoner(long prisonerID, int age, int sentenceYears, int points, String crime, String name, String surname, boolean toBeExecuted, boolean isMale, String jailCell) {
        this.prisonerID = prisonerID;
        this.age = age;
        this.sentenceYears = sentenceYears;
        this.points = points;
        this.crime = crime;
        this.name = name;
        this.surname = surname;
        this.toBeExecuted = toBeExecuted;
        this.isMale = isMale;
        this.jailCell = jailCell;
    }

    public Prisoner(long prisonerID, int age, int sentenceYears, int points, String crime, String name, String surname, boolean toBeExecuted, boolean isMale) {
        this.prisonerID = prisonerID;
        this.age = age;
        this.sentenceYears = sentenceYears;
        this.points = points;
        this.crime = crime;
        this.name = name;
        this.surname = surname;
        this.toBeExecuted = toBeExecuted;
        this.isMale = isMale;
    }

    public Prisoner(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Prisoner(long prisonerID) {
        this.prisonerID = prisonerID;
    }

    public long getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(int prisonerID) {
        this.prisonerID = prisonerID;
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

    public void addPoints(int pointsTObeAdded) {
        points = points + pointsTObeAdded;
    }

    public String getJailCell() {
        return jailCell;
    }

    public void setJailCell(String jailCell) {
        this.jailCell = jailCell;
    }

    public String getNameAndSurname() {
        return name + " " + surname;
    }


    @Override
    public String toString() {
        return name + " " + surname + ", Is Male: (" + isMale + ")" + ". Prisoner ID is: " + prisonerID + " Prisoner is Being Held in Jail Cell: " + jailCell + " Is to be Executed: " + toBeExecuted;
    }
}
