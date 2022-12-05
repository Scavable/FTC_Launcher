package com.scavable.ftc_launcher;

import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

public class ModpacksList {
    VBox modpacksList;
    VBox ModpacksList(){
        modpacksList = new VBox();
        modpacksList.setBorder(Border.stroke(null));
        modpacksList.setPrefSize(200, 500);
        modpacksList.setVisible(true);
        return modpacksList;
    }
}
