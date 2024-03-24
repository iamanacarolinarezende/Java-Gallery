import java.util.ArrayList;
public class Artists extends ArrayList<Artist> {
    public void addArtist(Artist artist){
        this.add(artist);
    }
    public Artist getArtist(int index){
        return this.get(index);
    }
    public void setArtist(int index, Artist artist){
        this.set(index, artist);
    }
}
