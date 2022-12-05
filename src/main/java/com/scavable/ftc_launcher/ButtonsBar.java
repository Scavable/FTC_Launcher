package com.scavable.ftc_launcher;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;

public class ButtonsBar {
    ButtonBar buttonsBar;
    MenuButton downloadMenuButton;
    MenuItem curseForgeMenuItem, ftbMenuItem;
    Button extractButton, websiteButton, discordButton, patreonButton, launchButton;
    ButtonBar ButtonsBar(){
        buttonsBar = new ButtonBar();
        downloadMenuButton = new MenuButton("Download");
        curseForgeMenuItem = new MenuItem("CurseForge");
        ftbMenuItem = new MenuItem("FTB");
        extractButton = new Button("Extract");
        websiteButton = new Button();
        discordButton = new Button();
        patreonButton = new Button();
        launchButton = new Button("Launch");


        downloadMenuButton.getItems().add(0, curseForgeMenuItem);
        downloadMenuButton.getItems().add(1, ftbMenuItem);

        buttonsBar.getButtons().addAll(downloadMenuButton, extractButton, websiteButton, discordButton, patreonButton, launchButton);
        ButtonBar.setButtonUniformSize(launchButton, false);
        ButtonBar.setButtonUniformSize(downloadMenuButton, false);
        buttonsBar.setPadding(new Insets(0,20,0,20));
        launchButton.setPrefSize(100, 30);
        buttonsBar.buttonMinWidthProperty().set(0);
        ButtonBar.setButtonData(downloadMenuButton, ButtonBar.ButtonData.LEFT);
        ButtonBar.setButtonData(extractButton, ButtonBar.ButtonData.LEFT);
        buttonsBar.setBorder(Border.stroke(null));
        buttonsBar.setPrefSize(700, 50);
        buttonsBar.setVisible(true);

        setActions();
        setIcons();

        return buttonsBar;
    }

    private void setIcons() {
        ImageView view = new ImageView();
        view.setFitHeight(20);
        view.setFitWidth(20);
        view.preserveRatioProperty();

        view.setImage(new Image(getClass().getResource("/com/scavable/ftc_launcher/ftc_icon.png").toString()));
        websiteButton.setGraphic(view);

        view = new ImageView();
        view.setFitHeight(20);
        view.setFitWidth(20);
        view.preserveRatioProperty();
        view.setImage(new Image(getClass().getResource("/com/scavable/ftc_launcher/discord_icon.png").toString()));
        discordButton.setGraphic(view);

        view = new ImageView();
        view.setFitHeight(20);
        view.setFitWidth(20);
        view.preserveRatioProperty();
        view.setImage(new Image(getClass().getResource("/com/scavable/ftc_launcher/patreon_icon.png").toString()));
        patreonButton.setGraphic(view);

    }

    private void setActions() {
        curseForgeMenuItem.setOnAction(ButtonActions.curseForgeDownloadAction());
        ftbMenuItem.setOnAction(ButtonActions.ftbDownloadAction());
        websiteButton.setOnAction(ButtonActions.websiteAction());
        discordButton.setOnAction(ButtonActions.discordAction());
        patreonButton.setOnAction(ButtonActions.patreonAction());
    }
}
