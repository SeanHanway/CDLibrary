package com.yahoo.seanhanway.CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class MasterLibrary implements Serializable{

    private final Collection<CDLibrary> library = new TreeSet<>();
    private static MasterLibrary masterLibrary;

    /**
     * Use this method whenever looking to create a MasterLibrary object to ensure the same one is used every time.
     * @return MasterLibrary object - the same instance should be returned every time.
     */
    static MasterLibrary getMasterLibrary(){
        if (masterLibrary == null)
            masterLibrary = (new Storage()).retrieve();
        return masterLibrary;
    }

    /**
     * creates a new CDLibrary object in the library Collection located in the MasterLibrary object used to call this method.
     * This does NOT create a new MasterLibrary.
     * @param name String - This will be the name of the CDLibrary object that is going to be created.
     * @return boolean - returns true if a new library was successfully created. Otherwise returns false.
     */
    boolean createLibrary(String name){
        return library.add(new CDLibrary(name));
    }

    /**
     * Removes the cdLibrary parameter from the library.
     * @param cdLibrary CDLibrary object - the cdLibrary you wish to have removed from the library.
     * @return boolean - returns true if the library exists and was successfully removed from the library. Otherwise returns false.
     */
    boolean removeFromLibrary(CDLibrary cdLibrary){
        return library.remove(cdLibrary);
    }

    /**
     * @return Collection - Returns the library containing cdLibrary objects.
     */
    Collection<CDLibrary> getLibrary(){
        return library;
    }

    /**
     * Retrieves the library with name matching the String parameter.
     * @param name - The name of the library to be returned.
     * @return CDLibrary - will return null if no library matching the String parameter was found.
     */
    CDLibrary getLibrary(String name){
        for(CDLibrary lib : library){
            if (lib.toString().equals(name)){
                return lib;
            }
        }
        return null;
    }

}