package CDLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class UserInterfaceHelper {

    private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    static MasterLibrary masterLibrary;

    String readInput(){

        try{
            String read = scan.readLine();
            return read;
        } catch(IOException IO){
            System.err.println("Error while reading from Keyboard input");
            System.err.println(IO.getMessage());
            return null;
        }
    }

    CD createCD() {
        String name;
        int released = 0;
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

    MasterLibrary getMasterLibrary(){
        if (masterLibrary == null)
            masterLibrary = (new Storage()).retrieve();
        return masterLibrary;
    }

    CDLibrary CDLibrarySelection(){
        getMasterLibrary();

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

    CD cdSelection(CDLibrary cdLib) {
        ArrayList<CD> cds = new ArrayList<CD>(cdLib.getCDLibrary());
        for (int i = 0; i < cds.size(); i++) {
            System.out.println(cds.get(i) + " : (" + i + ")");
        }
        return cds.get(Integer.parseInt(readInput()));
    }

}
