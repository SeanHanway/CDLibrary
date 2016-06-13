package CDLibrary;

import java.util.List;

/**
 * Created by Seán Hanway on 13/06/2016.
 */

class CD {

    CD(String title, int released, List<Track> trackList){
        this.title=title;
        this.released=released;
        tracks = trackList;
    }

    String title;
    int released;
    List tracks;
}
