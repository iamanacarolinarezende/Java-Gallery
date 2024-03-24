public abstract class Person {
    String FirstName;
    String LastName;

    //Constructor to be initialized in others classes
    public Person(String FirstName, String LastName){
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    public String ToString(){
        return this.FirstName + " " + this.LastName;
    }
}
