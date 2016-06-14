package CDLibrary;


class UserInterface {

    //@TODO introduce option to select a different library. Fix 'browse' option.
    private final String menu = "Insert New CD (1)\nBrowse CDS (2)\nRemove CD(3)\nCreate new Library (4)\nSave current Library (5)\nQuit (q)";
    private boolean running = true;

    private UserInterfaceHelper helper = new UserInterfaceHelper();
    private CDLibrary chosenLibrary;

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
                    System.out.println(chosenLibrary.getCDLibrary().toString());
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
                    (new Storage()).store(helper.getMasterLibrary());
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