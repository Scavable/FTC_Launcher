package com.scavable.ftc_launcher;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LauncherFrame extends Application {
    static Stage primaryStage;
    BorderPane borderPane, webBorderPane;
    ButtonsBar buttonsBar;
    Scene scene;
    WebView webView;
    StackPane webPaneStack;
    Button settingsButton;
    VBox launcherSettingsPanel;
    ModpacksList modpacksList;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        borderPane = new BorderPane();
        buttonsBar = new ButtonsBar();
        webView = new WebView();
        webPaneStack = new StackPane();
        webBorderPane = new BorderPane();
        settingsButton = new Button();
        //launcherSettingsPanel = new LauncherSettingsPanel().LauncherSettingsPanel();
        modpacksList = new ModpacksList();

        webPaneStackBehavior();
        webBorderPaneBehavior();
        webViewButton();

        webView.getEngine().load("https://www.feedthecraft.com");

        borderPane.setCenter(webPaneStack);
        borderPane.setLeft(modpacksList.ModpacksList());
        borderPane.setBottom(buttonsBar.ButtonsBar());

        scene = new Scene(borderPane);

        stage.setTitle("FTC Launcher");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResource("/com/scavable/ftc_launcher/ftc_icon.png").toString()));
        stage.show();
    }

    //Main Web View Pane Container
    private void webPaneStackBehavior() {
        webPaneStack.getChildren().add(0, webView);
        webPaneStack.getChildren().add(1, webBorderPane);

        webPaneStack.getChildren().get(1).setTranslateX(-15);
        webPaneStack.getChildren().get(1).setTranslateY(2);

        webPaneStack.setAlignment(Pos.TOP_RIGHT);
    }

    //Settings icon alignment
    private void webBorderPaneBehavior() {
        webBorderPane.setMaxWidth(settingsButton.getWidth());
        webBorderPane.setMaxHeight(settingsButton.getHeight());
        webBorderPane.setRight(settingsButton);
    }

    private void webViewButton() {
        Image img = new Image(getClass().getResource("/com/scavable/ftc_launcher/hamburger_menu_icon.png").toString());
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        settingsButton.setGraphic(imageView);

        settingsButton.setOnAction(event -> {
            if(borderPane.getChildren().contains(launcherSettingsPanel)){
                borderPane.getChildren().remove(launcherSettingsPanel);
            }else{
                borderPane.setRight(launcherSettingsPanel);
                launcherSettingsPanel.setVisible(true);
            }
        });
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}

