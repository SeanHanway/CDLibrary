package CDLibrary;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;


class MasterLibrary implements Serializable{

    private final Collection<CDLibrary> library = new TreeSet<>();
    private static MasterLibrary masterLibrary;

    /**
     * Use this method whenever looking to create a MasterLibrary object to ensure the same one is used every time.
     * @return returns a MasterLibrary object - the same instance should be returned every time.
     */
    static MasterLibrary getMasterLibrary(){
        if (masterLibrary == null)
            masterLibrary = (new Storage()).retrieve();
        return masterLibrary;
    }

    /**
     * creates a new CDLibrary object in the library Collection located in the MasterLibrary object used to call this method.
     * This does NOT create a new MasterLibrary.
     * @param name This will be the name of the CDLibrary object that is going to be created.
     */
    void createLibrary(String name){
        library.add(new CDLibrary(name));
    }

    /**
     * Removes the cdLibrary parameter from the library.
     * @param cdLibrary the cdLibrary you wish to have removed from the library.
     */
    void removeFromLibrary(CDLibrary cdLibrary){
        library.remove(cdLibrary);
    }

    /**
     * @return Returns the library containing cdLibrary objects.
     */
    Collection<CDLibrary> getLibrary(){
        return library;
    }

}
