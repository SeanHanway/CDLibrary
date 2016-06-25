package com.yahoo.seanhanway.CDLibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CD implements Comparable, Serializable{

    /**
     * @param title String - title of the CD
     * @param released Int - year of release
     * @param trackList List(Track) - a list of track objects stored in the CD.
     */
    CD(String title, int released, List<Track> trackList){
        this.title=title;
        this.released=released;
        tracks = trackList;
    }

    private final String title;
    private final int released;
    private List<Track> tracks;

    /**
     *
     * @param cdObject will only function if a cdObject is recieved
     * @return int representing if this cdObject is considered greater or less than the Object parameter.
     */
    @Override
    public int compareTo(Object cdObject) {
        return ((CD)cdObject).getTitle().compareTo(title);
    }

    /**
     * @return String - returns all information about the CD Object, including the tracks stored on it.
     */
    @Override
    public String toString(){
        List<Track> trackArrayList = new ArrayList<>(tracks);
        String trackString = "";

        for(int i = 0; i < trackArrayList.size(); i++){
            trackString += ((i + 1) + ": " + trackArrayList.get(i) + "\n");
        }

        return ("Title: " + title + "\nRelease Year: " + released + "\n" + trackString);
    }

    /**
     * @return String - Returns the title of the CD object
     */
    String getTitle(){
        return title;
    }

}