package com.yahoo.seanhanway.CDLibrary;

import java.io.Serializable;


public class Track implements Serializable{

    /**
     * @param name String - the name of the track.
     */
    Track(String name, String album){
        this.name = name;
        this.album = album;
    }

    private final String name;
    private final String album;

    /**
     * @return String - track name
     */
    public String getName(){
        return name;
    }

    /**
     * @return String - album name
     */
    public String getAlbum(){
        return album;
    }

    @Override
    public String toString(){
        return name;
    }
}