package CDLibrary;

import java.util.Collection;
import java.util.TreeSet;


class CDLibrary {

    CDLibrary(String name){
        this.name=name;
    }

    String name;
    Collection<CD> cdLibrary = new TreeSet<>();

    void addCD(CD cd){
        cdLibrary.add(cd);
    }

    void removeCD(CD cd){
        cdLibrary.remove(cd);
    }

    @Override
    public String toString(){
        return name;
    }

    Collection<CD> getCDLibrary(){
        return cdLibrary;
    }

}
