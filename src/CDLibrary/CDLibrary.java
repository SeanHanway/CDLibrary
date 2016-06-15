package CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class CDLibrary implements Comparable, Serializable{
    /**
     * @param name identifies the CDLibrary
     */
    CDLibrary(String name){
        this.name=name;
    }

    private String name;
    private Collection<CD> cdLibrary = new TreeSet<>();

    /**
     * @param cd adds the CD parameter to the cdLibrary collection.
     */
    void addCD(CD cd){
        cdLibrary.add(cd);
    }

    /**
     * @param cd removes the CD parameter from the cdLibrary collection.
     */
    void removeCD(CD cd){
        cdLibrary.remove(cd);
    }

    /**
     * Uses the toString method for comparison.
     * @param o the object you wish to compare this object to.
     * @return int representing if this object is considered greater or less than the Object parameter.
     */
    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

    /**
     * @return returns the name of this CDLibrary
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     * @return Returns the cdLibrary collection stored in this cdLibrary collection.
     */
    Collection<CD> getCDLibrary(){
        return cdLibrary;
    }

}
