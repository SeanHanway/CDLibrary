package com.yahoo.seanhanway.CDLibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FXHelper {

    /**
     * @param name - The name you wish to use for the CDLibrary
     * @return boolean - True if CDLibrary was successfully added, otherwise false.
     */
    public boolean addCDLibrary(String name){
        return MasterLibrary.getMasterLibrary().createLibrary(name);
    }

    /**
     * Saves all changes made to all CDLibraries throughout the users current session
     * @return boolean - True if MasterLibrary was successfully saved, otherwise false.
     */
    public boolean saveCDLibrary(){
        return new Storage().store(MasterLibrary.getMasterLibrary());
    }

    /**
     * @param name - The name of the CDLibrary to be retrieved
     * @return Collection(CD) - a collection containing all CDS found in the requested CDLibrary.
     */
    private Collection<CD> getCDLibrary(String name){
        return MasterLibrary.getMasterLibrary().getLibrary(name).getCDLibrary();
    }

    /**
     * Returns the Library containing all CDLibrary objects.
     * @return Collection(CDLibrary)
     */
    public Collection<CDLibrary> getLibrary(){
        return MasterLibrary.getMasterLibrary().getLibrary();
    }

    /**
     * returns a collection containing the String representation (name) of every CDLibrary stored within the Library.
     * @return Collection(String)
     */
    public Collection<String> getLibraryAsString(){
        List<CDLibrary> library = new ArrayList<>(MasterLibrary.getMasterLibrary().getLibrary());
        ArrayList<String> ret = new ArrayList<>();
        for(CDLibrary lib : library){
            ret.add(lib.toString());
        }
        return ret;
    }

    /**
     * Returns the title of each CD within the CDLibrary, with name matching the String parameter, as an ArrayList.
     * @param cdLibraryName String - name of the CDLibrary to be used.
     * @return Collection(String) - An ArrayList containing the title of each CD within the given CDLibrary
     */
    public Collection<String> getCDLibraryAsString(String cdLibraryName) {
        List<CD> library = new ArrayList<>(getCDLibrary(cdLibraryName));
        ArrayList<String> ret = new ArrayList<>();
        for(CD lib : library){
            ret.add(lib.getTitle());
        }
        return ret;
    }

    public Collection<Track> getCDTracks(String CDLibraryName, String CDName){
        return MasterLibrary.getMasterLibrary()
                .getLibrary(CDLibraryName)
                .findCD(CDName)
                .getTracks();
    }
}