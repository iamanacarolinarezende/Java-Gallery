public class Artist extends Person {
    private String ArtistID;
    private String CuratorID;
    public Artist(String ArtistID, String CuratorID,
                  String FirstName, String LastName){
        super(FirstName, LastName); //initialized at Person class
        this.ArtistID = ArtistID;
        this.CuratorID = CuratorID;
    }
    public String getArtistID(){
        return ArtistID;
    }
    public void setArtistID(String ID){
        this.ArtistID = ID;
    }
    public String getCuratorID(){
        return CuratorID;
    }
    public void setCuratorID(String cID){
        CuratorID = cID;
    }
    @Override
    public String ToString(){
        return ArtistID + " " + super.ToString() + " " + CuratorID + "\n";
    }
}
