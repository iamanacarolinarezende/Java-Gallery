public class Curator extends Person{
    //Variables
    String CuratorID;
    double Commission;
    final double CommissionRate; //add final turn this always constance. Can't be changed while the program is running.

    //Constructor
    public Curator(String CuratorID, double Commission,
                   double CommissionRate, String FirstName,
                   String LastName){
        super(FirstName, LastName); //initialized at Person class
        /*
        In the two lines above, we have used the keyword of super which directly
        refers to the base class where FirstName and LastName are defined. However,
        it is recommended to replace super with this in the current context.

        We are aware that, this refers to the variables of the current class, but
        if we replace super with this in line 7 and 8 above, we force the compiler
        to define a temporary variable with the same name inside of the current class
        and avoid reaching to the same variables inside of the base class. This protects
        the data inside of the base or super class.
        * */
        this.CuratorID = CuratorID;
        this.Commission = Commission;
        this.CommissionRate = CommissionRate;
    }
    @Override
    public String ToString(){
        return super.ToString() + " " + CuratorID + " " +
                Commission + " " + CommissionRate + "\n";
    }
    /*
    The explanations above regarding the super and this does apply only on variables.
    Thus, if you want to access the methods inside of the based class which are
    overriden inside of the child class, you should use the super keyword.
    * */

    public String getCuratorID(){
        return this.CuratorID;
    }
    public void setCuratorID(String CuratorID){
        this.CuratorID = CuratorID;
    }
    public double getCommission(){
        return this.Commission;
    }
    public void setCommission(double Commission){
        this.Commission = Commission;
    }
    public double getCommissionRate(){
        return this.CommissionRate;
    } //just get because it can't be changed
}

