//ArrayList all the object have the same type. Ex. FirstName String, all will be String.
import java.util.ArrayList;

//Data structure charged to save temporary data of Curator. Local Data Structure
public class Curators extends ArrayList<Curator>{
    public void addCurator(Curator curator){
        this.add(curator);
    } //this add build in method, so add a NEW item
    public Curator getCurator(int index){
        return this.get(index);
    } //index because is arraylist. Will return
    public void setCurator(int index, Curator curator){
        this.set(index, curator);
    } // to change the Curator
}
