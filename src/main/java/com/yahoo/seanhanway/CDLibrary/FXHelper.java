package com.yahoo.seanhanway.CDLibrary;

public class FXHelper {

    public boolean addCDLibrary(String name){
        return MasterLibrary.getMasterLibrary().createLibrary(name);
    }

    //public boolean addCD(String name, )

    public boolean saveCDLibrary(){
        return new Storage().store(MasterLibrary.getMasterLibrary());
    }
}
