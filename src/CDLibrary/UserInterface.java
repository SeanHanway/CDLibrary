package CDLibrary;


class UserInterface {
    
    private final String lineBreak = "\n-----------------------------\n";
    private final String menu = (lineBreak + "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)\nSave current Library (5)\nDelete current Library (6)\nSelect new Library (7)\nQuit (q)" + lineBreak);
    private boolean running = true;

    private UserInterfaceHelper helper = new UserInterfaceHelper();
    private CDLibrary chosenLibrary;

    /**
     * Handles User Interface using the console.
     */
    void runConsoleInterface(){
        chosenLibrary = helper.CDLibrarySelection();

        while (running) {
            System.out.println(menu);
            String read = helper.readInput();
            switch (read) {
                case "1":
                    chosenLibrary.addCD(helper.createCD());
                    break;
                case "2":
                    helper.browseCDs(chosenLibrary);
                    break;
                case "3":
                    System.out.println("Please select a cd to remove: ");
                    chosenLibrary.removeCD(helper.cdSelection(chosenLibrary));
                    break;
                case "4":
                    System.out.println("Please enter a name for the new library :");
                    (new Storage().retrieve()).createLibrary(helper.readInput());
                    break;
                case "5":
                    (new Storage()).store(MasterLibrary.getMasterLibrary());
                    break;
                case "6":
                    MasterLibrary.getMasterLibrary().removeFromLibrary(chosenLibrary);
                    chosenLibrary = helper.CDLibrarySelection();
                    break;
                case "7":
                    chosenLibrary = helper.changeLibrary(chosenLibrary);
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    System.out.println("Bad argument received.");
            }
        }
    }

}