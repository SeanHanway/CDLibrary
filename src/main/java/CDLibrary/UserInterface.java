package CDLibrary;

class UserInterface {

    private boolean running = true;

    private final UserInterfaceHelper helper = new UserInterfaceHelper();

    /**
     * Handles User Interface using the console.
     */
    void runConsoleInterface() {
        final String lineBreak = "\n-----------------------------\n";
        final String menu = (lineBreak + "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)\nSave changes (5)\nDelete current Library (6)\nSelect new Library (7)\nQuit (q)" + lineBreak);
        CDLibrary chosenLibrary = helper.CDLibrarySelection();

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
                    chosenLibrary.removeCD(helper.CDSelection(chosenLibrary));
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
                    chosenLibrary = helper.changeLibrary();
                    break;
                case "q":
                    helper.savePrompt();
                    running = false;
                    break;
                default:
                    System.out.println("Bad argument received.");
            }
        }
    }

    //Code for running the program using a JavaFX UI will go here.
    //A call will be made to a separate UI package.
    void runJavaFXInterface(){}

}