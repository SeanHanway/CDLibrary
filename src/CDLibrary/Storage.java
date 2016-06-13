package CDLibrary;

import java.io.*;


class Storage {


    private String file = "StoredObjects.txt";


    void store(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(Library.getLibraryInstance());
            System.out.println("Writing successful.");
        } catch(IOException ex){
            System.err.println("Error writing to disk");
            System.err.println(ex.getMessage());
        }
    }

    Library retrieve(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Library library = (Library)ois.readObject();
            return library;
        } catch(IOException ex){
            System.err.println("Error reading from disk");
            System.err.println(ex.getMessage());
        } catch(ClassNotFoundException cnf){
            System.err.println("Could not find Library Class");
            System.err.println(cnf.getMessage());
        }

        return Library.getLibraryInstance();
    }

}
