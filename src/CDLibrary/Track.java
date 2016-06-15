package CDLibrary;

import java.io.Serializable;


class Track implements Serializable{

    /**
     * @param name String - the name of the track.
     */
    Track(String name){
        this.name=name;
    }

    private final String name;

    /**
     * @return String - track name
     */
    String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
