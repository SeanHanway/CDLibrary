package CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class Library implements Serializable{

    private Library(){}

    //'constructor' method
    static Library getLibraryInstance(){
        if(singletonLibrary == null)
            singletonLibrary = new Library();
        return singletonLibrary;
    }

    private static Library singletonLibrary;
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

    static boolean libraryExists(){
        return singletonLibrary != null;
    }
}
