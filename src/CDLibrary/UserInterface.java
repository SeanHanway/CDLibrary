package CDLibrary;

import java.util.*;


class UserInterface {

    private final String menu = "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)";
    private boolean running = true;

    private Scanner scan = new Scanner(System.in);
    Storage store = new Storage();

    void runConsoleInterface(){
        Library library = store.retrieve();
        System.out.println("Please select a library");
        library.getLibrary();
        //@TODO Display the CDLibrary and let the user select one. If none exist give the option to create one.

        while (running) {
            System.out.println(menu);
            if (scan.hasNextInt())
                switch (scan.nextInt()) {
                    //@TODO Switch statement currently only contains PLACEMENT CODE. Needs to be redone before the program will run.
                    case 1:
                        //this is done through the CDLibrary class now.
                        library.insertCD(createCD());
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

    private CD createCD() {
        String name = "";
        int released = 0;
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

        return new CD(name, released, trackList);
    }
}
