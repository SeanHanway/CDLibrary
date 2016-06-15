package CDLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class UserInterfaceHelper {

    private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    private static MasterLibrary masterLibrary;

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
        masterLibrary = MasterLibrary.getMasterLibrary();

        ArrayList<CDLibrary> cdArray = new ArrayList<CDLibrary>(masterLibrary.getLibrary());

        System.out.println("please select a library: ");
        System.out.println("Create new : (0)");

        for (int i = 0; i < cdArray.size(); i++) {
            System.out.println(cdArray.get(i) + " : (" + (i + 1) + ")");
        }
        int choice = Integer.parseInt(readInput());

        if (choice == 0) {
            System.out.println("Please enter a name for the new library :");
            masterLibrary.createLibrary(readInput());
            cdArray = new ArrayList<CDLibrary>(masterLibrary.getLibrary());
            return cdArray.get(cdArray.size() - 1);
        } else
            return cdArray.get(choice - 1);
    }

    /**
     * Allows the user to select a CD from the collection of stored CDs in the chosen CDLibrary
     * No operations are performed on the chosen CD and it is not removed from the collection.
     * @param cdLib CDLibrary object - The CDLibrary you wish to read a CD from.
     * @return CD object - returns a CD object.
     */
    CD cdSelection(CDLibrary cdLib) {
        ArrayList<CD> cds = new ArrayList<CD>(cdLib.getCDLibrary());
        for (int i = 0; i < cds.size(); i++) {
            System.out.println(cds.get(i).getTitle() + " : (" + (i + 1) + ")");
        }
        return cds.get(Integer.parseInt(readInput()) - 1);
    }

    /**
     * Runs the library selection menu after prompting the user to save their current library.
     * The library will remain unchanged if an invalid input is detected during the save prompt.
     * @param initialLibrary CDLibrary object - The currently selected CDLibrary
     * @return CDLibrary object - returns the users newly selected library or the one currently in use should they enter an invalid input.
     */
    CDLibrary changeLibrary(CDLibrary initialLibrary){
        System.out.println("Do you wish to save your current Library before continuing? (Y/N)");
        switch (readInput().toUpperCase()){
            case "Y":
                (new Storage()).store(MasterLibrary.getMasterLibrary());
            case "N":
                return CDLibrarySelection();
            default:
                System.out.println("Invalid input");
                return initialLibrary;
        }
    }

    void browseCDs(CDLibrary library){
        CD selectedCD = cdSelection(library);
        System.out.println(selectedCD.toString());
    }

}
