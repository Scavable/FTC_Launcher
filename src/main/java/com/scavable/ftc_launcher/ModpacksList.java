package com.scavable.ftc_launcher;

import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ModpacksList {
    VBox modpacksList;
    VBox ModpacksList(){
        modpacksList = new VBox();
        modpacksList.setBorder(Border.stroke(null));
        modpacksList.setPrefSize(200, 500);

        File file = new File(System.getProperty("user.dir").concat("/instances"));
        if(file.exists()){
            System.out.println("Modpack List: Instances folder found");
            readModpacks(file);
        }

        modpacksList.setVisible(true);
        return modpacksList;
    }

    private void readModpacks(File file) {
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
