package CDLibrary;


import java.io.Serializable;

class Track implements Serializable{

    Track(String name){
        this.name=name;
    }

    private final String name;
}
