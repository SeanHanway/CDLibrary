package CDLibrary;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Created by Seán Hanway on 13/06/2016.
 */

class UserInterface {

    private final String menu = "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)";
    private boolean running = true;

    Scanner scan = new Scanner(System.in);
    CDLibrary library = new CDLibrary();


    void runConsoleInterface(){
        while (running) {
            System.out.println(menu);
            if (scan.hasNextInt())
                switch (scan.nextInt()) {
                    case 1:
                        createCD();
                        break;
                    case 2:
                        library.readLibrary();
                        break;
                    case 3:
                        library.deleteLibrary();
                        break;
                    case 4:
                        library.createLibrary();
                    default:
                        System.out.println("Bad argument received.");
                }
            else if (scan.next().equals("q"))
                running = false;
        }
    }

    private void createCD() {
        String name;
        int released;
        List<Track> trackList = new ArrayList<Track>();
        boolean valid;

        while (valid = true) {
            System.out.println("Please enter the CD title:");
            if (scan.hasNext()) {
                name = scan.next();
                valid = false;
            } else
                System.out.println("Invalid title");
        }

        while (valid = true) {
            System.out.println("Please enter the release year of the CD:");
            if (scan.hasNextInt()) {
                released = scan.nextInt();
                valid = false;
            } else
                System.out.println("invalid release year");
        }

        System.out.println("Please enter the tracks on the CD. Input an empty value to finish entering tracks");
        while (valid = true) {
            if (scan.hasNext()){
                Track track = new Track(scan.next());
                trackList.add(track);
            } else
                valid = false;
        }
    }
}
