package CDLibrary;

import java.io.*;


class Storage {


    private String file = "StoredObjects";


    void store(MasterLibrary lib){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(lib);
            System.out.println("Library successfully saved.");
        } catch(IOException ex){
            System.err.println("Error writing to disk.");
            System.err.println(ex.getMessage());
        }
    }

    MasterLibrary retrieve(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (MasterLibrary)ois.readObject();
        } catch(IOException ex){
            System.out.println("No libraries found.");
        } catch(ClassNotFoundException cnf){
            System.err.println("Could not find MasterLibrary Class.");
            System.err.println(cnf.getMessage());
        }

        return new MasterLibrary();
    }

}
