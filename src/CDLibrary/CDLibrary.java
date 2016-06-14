package CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class CDLibrary implements Comparable, Serializable{

    CDLibrary(String name){
        this.name=name;
    }

    private String name;
    private Collection<CD> cdLibrary = new TreeSet<>();

    void addCD(CD cd){
        cdLibrary.add(cd);
    }

    void removeCD(CD cd){
        cdLibrary.remove(cd);
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public String toString(){
        return name;
    }

    Collection<CD> getCDLibrary(){
        return cdLibrary;
    }

}
