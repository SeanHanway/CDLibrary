package com.yahoo.seanhanway.CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class CDLibrary implements Comparable, Serializable{
    /**
     * @param name String - identifies the CDLibrary
     */
    CDLibrary(String name){
        this.name=name;
    }

    private String name;
    private Collection<CD> cdLibrary = new TreeSet<>();

    /**
     * @param cd CD object - adds the CD parameter to the cdLibrary collection.
     */
    void addCD(CD cd){
        cdLibrary.add(cd);
    }

    /**
     * @param cd CD object - removes the CD parameter from the cdLibrary collection.
     */
    void removeCD(CD cd){
        try{
            cdLibrary.remove(cd);
            System.out.println(cd.getTitle() + " successfully removed.");
        } catch(NullPointerException ex){
            //May need to rethink the CDLibrarySelection() method. It's the reason this method is throwing null pointers during standard operation
            //and I'd rather not display them to the user when they "should" be happening.
        }
    }

    CD findCD(String name){
        for (CD current : cdLibrary){
            if(current.getTitle().equals(name)){
                return current;
            }
        }
        return null;
    }

    /**
     * Uses the toString method for comparison.
     * @param o Object - the object you wish to compare this object to.
     * @return Int - representing if this object is considered greater or less than the Object parameter.
     */
    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

    /**
     * @return String - returns the name of this CDLibrary
     */
    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass()) && this.compareTo(o) == 0;
    }

    /**
     * @return Collection - Returns the cdLibrary collection stored in this cdLibrary class.
     */
    Collection<CD> getCDLibrary(){
        return cdLibrary;
    }
}