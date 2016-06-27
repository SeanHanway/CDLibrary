package com.yahoo.seanhanway.CDLibrary;

import java.io.*;


class Storage {

    private String file = "StoredObjects.ser";

    /**
     * Stores the MasterLibrary parameter in memory on a file created in the project folder
     * @param lib MasterLibrary object - A MasterLibrary you wish to store in memory on the hard disk.
     * @return boolean - Returns true if the library was successfully saved, otherwise returns false.
     */
    boolean store(MasterLibrary lib){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(lib);
            System.out.println("Library successfully saved.");
            return true;
        } catch(IOException ex){
            System.err.println("Unable to write to disk.");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Retrieves the MasterLibrary previously stored on the disk using the store() method.
     * Will notify via the console if no libraries are found.
     * Will print a System.err message if the file exists but no MasterLibrary objects are found. This shouldn't happen.
     * @return MasterLibrary object - returns a MasterLibrary object.
     */
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