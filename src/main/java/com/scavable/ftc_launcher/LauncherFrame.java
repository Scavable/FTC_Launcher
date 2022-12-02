package com.scavable.ftc_launcher;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage primaryStage;
    BorderPane borderPane, webBorderPane;
    ButtonBar buttonsBar;
    Scene scene;
    VBox modpacksList;
    WebView webView;
    StackPane webPaneStack;
    Button settingsButton;
    VBox launcherSettingsPanel;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        borderPane = new BorderPane();
        buttonsBar = new ButtonBar();
        modpacksList = new VBox();
        webView = new WebView();
        webPaneStack = new StackPane();
        webBorderPane = new BorderPane();
        settingsButton = new Button();
        launcherSettingsPanel = new LauncherSettingsPanel().LauncherSettingsPanel();

        webPaneStackBehavior();
        webBorderPaneBehavior();
        webViewButton();
        buttonsBoxBehavior();
        modpacksListBehavior();
        webViewBehavior();
        borderPaneBehavior();
        sceneBehavior();

        webPaneStack.getChildren().get(1).setTranslateX(-15);
        webPaneStack.getChildren().get(1).setTranslateY(2);

        stage.setTitle("FTC Launcher");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResource("/com/scavable/ftc_launcher/ftc_icon.png").toString()));
        stage.show();

    }

    //Main Web View Pane Container
    private void webPaneStackBehavior() {
        webPaneStack.getChildren().add(0, webView);
        webPaneStack.getChildren().add(1, webBorderPane);

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

    private void buttonsBoxBehavior() {
        ButtonsBar buttons = new ButtonsBar();
        buttonsBar.getButtons().addAll(buttons.getDownloadModpacks(), buttons.getExtractModpack(),
                buttons.getFtcWebsite(), buttons.getFtcDiscord(), buttons.getFtcPatreon(), buttons.getLaunch());

        ButtonBar.setButtonUniformSize(buttons.getLaunch(), false);
        ButtonBar.setButtonUniformSize(buttons.getDownloadModpacks(), false);
        ButtonBar.setButtonUniformSize(buttons.getExtractModpack(), false);

        buttonsBar.setPadding(new Insets(0, 20, 0, 20));
        buttons.getLaunch().setPrefSize(100, 30);
        buttonsBar.buttonMinWidthProperty().set(0);

        ButtonBar.setButtonData(buttons.getDownloadModpacks(), ButtonBar.ButtonData.LEFT);
        ButtonBar.setButtonData(buttons.getExtractModpack(), ButtonBar.ButtonData.LEFT);

        buttonsBar.setBorder(Border.stroke(null));
        buttonsBar.setPrefSize(700, 50);
        buttonsBar.setVisible(true);
    }

    private void sceneBehavior() {
        scene = new Scene(borderPane);
    }

    private void borderPaneBehavior() {
        borderPane.setLeft(modpacksList);
        borderPane.setCenter(webPaneStack);
        borderPane.setBottom(buttonsBar);
    }

    private void webViewBehavior() {
        webView.getEngine().load("https://www.feedthecraft.com");
    }

    private void modpacksListBehavior() {
        modpacksList.setBorder(Border.stroke(null));
        modpacksList.setPrefSize(200, 500);
        modpacksList.setVisible(true);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
