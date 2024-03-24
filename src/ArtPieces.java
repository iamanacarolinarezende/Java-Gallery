import java.util.ArrayList;
public class ArtPieces extends ArrayList<ArtPiece> {
    public void addArtPiece(ArtPiece artPiece){
        this.add(artPiece);
    }
    public ArtPiece getArtPiece(int index){
        return this.get(index);
    }
    public void setArtPiece(int index, ArtPiece artPiece){
        this.set(index, artPiece);
    }
}
