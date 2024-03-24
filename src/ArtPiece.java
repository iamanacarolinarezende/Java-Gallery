import java.time.Year;
import java.util.SplittableRandom;

public class ArtPiece {
    private String PieceID;
    private String Title;
    private int Year;
    private double Price;
    private double Estimate;
    private String ArtistID;
    private String CuratorID;
    private char Status;


    public ArtPiece(String PieceID, String Title, int Year,
                    double Estimate, double Price, String ArtistID,
                    String CuratorID, char Status){
        this.PieceID = PieceID;
        this.Title = Title;
        this.Year = Year;
        this.Estimate = Estimate;
        this.Price = Price;
        this.ArtistID = ArtistID;
        this.CuratorID = CuratorID;
        this.Status = Status;
    }
    public String getPieceID(){
        return this.PieceID;
    }
    public void setPieceID(String pID){
        this.PieceID = pID;
    }

    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String title){
        this.Title = title;
    }

    public int getYear(){
        return this.Year;
    }
    public void setYear(int year){
        this.Year = year;
    }

    public double getPrice(){
        return this.Price;
    }
    public void setPrice(double price){
        this.Price = price;
    }

    public double getEstimate(){
        return this.Estimate;
    }
    public void setEstimate(double estimate)
    {
        this.Estimate = estimate;
    }

    public String getArtistID(){
        return this.ArtistID;
    }
    public void setArtistID(String aID){
        this.ArtistID = aID;
    }

    public String getCuratorID(){
        return this.CuratorID;
    }
    public void setCuratorID(String cID){
        this.CuratorID = cID;
    }

    public char getStatus(){
        return this.Status;
    }
    public void setStatus(char status){
        this.Status = status;
    }


    public String ToString(){
        return this.PieceID + " " + this.Title + " " + this.Year +
                " " + this.Estimate + " " + this.ArtistID + " " +
                this.CuratorID + " " + this.Status + "\n";
    }
    public void ChangeStatus(char status){
        this.Status = status;
    }
    public void PricePaid(double price){
        this.Price = price;
    }
    public double calculateCommission(double price){
        this.Price = price;
        return price * 0.25;
    }
}
