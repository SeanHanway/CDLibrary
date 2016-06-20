package com.yahoo.seanhanway.CDLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class UserInterfaceHelper {

    private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Uses a Buffered Reader to return a String inputted by the user through the console.
     * @return String - returns a String representation of the next input made by the user.
     */
    String readInput(){
        try{
            return scan.readLine();
        } catch(IOException IO){
            System.err.println("Error while reading from Keyboard input");
            System.err.println(IO.getMessage());
            return null;
        }
    }

    /**
     *  Takes the user through the process of creating a CD using console inputs and returns an instantiated CD object.
     * @return CD object - returns a CD object
     */
    CD createCD() {
        String name;
        int released;
        List<Track> trackList = new ArrayList<>();
        boolean valid = true;

        System.out.println("Please enter the CD title:");
        name = readInput();

        System.out.println("Please enter the release year of the CD:");
        released = Integer.parseInt(readInput());

        System.out.println("Please enter each track on the CD separated by a line break. Enter an empty value to finish.");
        while (valid) {
            String in = readInput();
            if (!in.equals("")){
                Track track = new Track(in);
                trackList.add(track);
            } else
                valid = false;
        }

        return new CD(name, released, trackList);
    }

    /**
     * Takes the user through the process of selecting a CDLibrary using console inputs and returns an instantiated CDLibrary object.
     * The object may be new if the user chose to create a new CDLibrary. Otherwise it will come from physical memory and may already contain data.
     * @return CDLibrary object - returns a CDLibrary object
     */
    CDLibrary CDLibrarySelection(){
        int choice;
        MasterLibrary masterLibrary = MasterLibrary.getMasterLibrary();

        ArrayList<CDLibrary> cdLibraryArrayList = new ArrayList<>(masterLibrary.getLibrary());

        System.out.println("please select a library: ");
        System.out.println("Create new : (0)");

        for (int i = 0; i < cdLibraryArrayList.size(); i++) {
            System.out.println(cdLibraryArrayList.get(i) + " : (" + (i + 1) + ")");
        }

        while (true) {
            try {
                choice = Integer.parseInt(readInput());
                if (choice == 0) {
                    System.out.println("Please enter a name for the new library :");
                    while (true) {
                        if (masterLibrary.createLibrary(readInput())) {
                            //Updates cdLibraryArrayList to include the new library
                            cdLibraryArrayList = new ArrayList<>(masterLibrary.getLibrary());
                            return cdLibraryArrayList.get(0);
                        } else {
                            System.out.println("Library already exists. Please enter a different name: ");
                        }
                    }
                } else {
                    return cdLibraryArrayList.get(choice - 1);
                }
            } catch(IndexOutOfBoundsException | NumberFormatException ex){
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Allows the user to select a CD from the collection of stored CDs in the chosen CDLibrary
     * No operations are performed on the chosen CD and it is not removed from the collection.
     * Returns null if the CDLibrary contains no CD objects.
     * @param cdLib CDLibrary object - The CDLibrary you wish to read a CD from.
     * @return CD object - returns a CD object. Null if no CDs found.
     */
    CD CDSelection(CDLibrary cdLib) {
        ArrayList<CD> cds = new ArrayList<>(cdLib.getCDLibrary());
        if (cds.size() != 0) {
            for (int i = 0; i < cds.size(); i++) {
                System.out.println(cds.get(i).getTitle() + " : (" + (i + 1) + ")");
            }
            while (true) {
                try {
                    return cds.get(Integer.parseInt(readInput()) - 1);
                } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                    System.out.println("Please enter a valid input");
                }
            }
        }
        else{
            System.out.println("No CDs found.");
            return null;
        }
    }

    /**
     * Runs the library selection menu after prompting the user to save their current library.
     * @return CDLibrary object - returns the users newly selected library.
     */
    CDLibrary changeLibrary(){
        savePrompt();
        return CDLibrarySelection();
    }

    /**
     *  Lets the user browse and inspect CDs in a library.
     * @param library CDLibrary - Browses CDs from this library.
     */
    void browseCDs(CDLibrary library){
        CD selectedCD = CDSelection(library);
        if (selectedCD != null) {
            System.out.println(selectedCD.toString());
        }
    }

    /**
     * Prompts the user to save their changes.
     */
    void savePrompt(){
        boolean running = true;
        System.out.println("Do you wish to save your changes before continuing? (Y/N)");
        while(running)
        switch (readInput().toUpperCase()){
            case "Y":
                (new Storage()).store(MasterLibrary.getMasterLibrary());
            case "N":
                running = false;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
}