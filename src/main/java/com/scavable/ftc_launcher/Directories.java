package com.scavable.ftc_launcher;

import java.io.File;

public class Directories {
    String jarLocation;
    File instances;
    Directories(){
        jarLocation = System.getProperty("user.dir");
        boolean exists = new File(jarLocation + "/instances").exists();
        if(!exists){
            instancesFolderSetup();
        }else{
            System.out.println("Instances Folder Already Exists");
            instances = new File(jarLocation + "/instances");
            System.out.println(instances.getAbsolutePath());
        }

    }

    private void instancesFolderSetup() {
        instances = new File(jarLocation + "/instances");
        if(instances.mkdir()){
            System.out.println("Instances Folder Created");
        }
        System.out.println(instances.getAbsolutePath());
    }
}
