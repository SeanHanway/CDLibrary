package CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class MasterLibrary implements Serializable{

    private Collection<CDLibrary> library = new TreeSet<>();

    //adds a new CDLibrary to the master library collection
    void createLibrary(String name){
        library.add(new CDLibrary(name));
    }

    void removeFromLibrary(CDLibrary cdLibrary){
        library.remove(cdLibrary);
    }

    Collection<CDLibrary> getLibrary(){
        return library;
    }

}
