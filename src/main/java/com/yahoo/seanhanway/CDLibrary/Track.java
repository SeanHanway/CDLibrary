package com.yahoo.seanhanway.CDLibrary;

import java.io.Serializable;


class Track implements Serializable{

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
    String getName(){
        return name;
    }

    /**
     * @return String - album name
     */
    String getAlbum(){
        return album;
    }

    @Override
    public String toString(){
        return name;
    }
}