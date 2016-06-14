package CDLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class UserInterface {

    private final String menu = "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)\nSave current Library (5)";
    private boolean running = true;


    Storage store = new Storage();
    CDLibrary chosenLibrary;
    Library library;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    void runConsoleInterface(){
        librarySelection();

        while (running) {
            System.out.println(menu);
            String read = readInput();
            switch (read) {
                case "1":
                    chosenLibrary.addCD(createCD());
                    break;
                case "2":
                    chosenLibrary.getCDLibrary().toString();
                    break;
                case "3":
                    System.out.println("Please select a cd to remove: ");
                    chosenLibrary.removeCD(cdSelection());
                    break;
                case "4":
                    System.out.println("Please enter a name for the new library :");
                    library.createLibrary(readInput());
                    break;
                case "5":
                    store.store();
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    System.out.println("Bad argument received.");
            }
        }
    }

    private CD createCD() {
        String name = "";
        int released = 0;
        List<Track> trackList = new ArrayList<>();
        boolean valid = true;

        System.out.println("Please enter the CD title:");
        name = readInput();

        System.out.println("Please enter the release year of the CD:");
        released = Integer.parseInt(readInput());

        System.out.println("Please enter the tracks on the CD. Input an empty value to finish entering tracks");
        while (valid) {
            String in = readInput();
            if (in != null){
                Track track = new Track(in);
                trackList.add(track);
            } else
                valid = false;
        }

        return new CD(name, released, trackList);
    }

    private void librarySelection(){
        library = store.retrieve();
        ArrayList<CDLibrary> cdArray = new ArrayList<CDLibrary>(library.getLibrary());

        if (library == null) {
            System.out.println("No saved libraries found, please enter a name for your new library :");
                library = Library.getLibraryInstance();
                library.createLibrary(readInput());
        }

        else {
            System.out.println("please select a library: ");
            for (int i = 0; i < cdArray.size(); i++) {
                System.out.println(cdArray.get(i) + " : (" + (i + 1) + ")");
            }
                chosenLibrary = cdArray.get((Integer.parseInt(readInput())) - 1);
        }
    }

    private CD cdSelection() {
        ArrayList<CD> cds = new ArrayList<CD>(chosenLibrary.getCDLibrary());
        System.out.println("Please select a CD : ");
        for (int i = 0; i < cds.size(); i++) {
            System.out.println(cds.get(i) + " : (" + i + ")");
        }
        return cds.get(Integer.parseInt(readInput()));
    }

    private String readInput(){

        try{
            String read = scan.readLine();
            return read;
        } catch(IOException IO){
            System.err.println("Error while reading from Keyboard input");
            System.err.println(IO.getMessage());
            return null;
        }
    }
}
