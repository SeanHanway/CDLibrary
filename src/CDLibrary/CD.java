package CDLibrary;

import java.io.Serializable;
import java.util.List;


class CD implements Comparable, Serializable{

    CD(String title, int released, List<Track> trackList){
        this.title=title;
        this.released=released;
        tracks = trackList;
    }

    private final String title;
    private final int released;
    private List tracks;


    @Override
    public int compareTo(Object o) {
        return ((CD)o).getTitle().compareTo(this.getTitle());
    }

    @Override
    public String toString(){
        return title;
    }

    String getTitle(){
        return title;
    }

}
