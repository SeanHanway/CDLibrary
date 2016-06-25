package com.yahoo.seanhanway.CDLibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public Collection<CD> getCDLibrary(String name){
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
        return library.stream().map(lib -> library.toString()).collect(Collectors.toList());
    }
}
