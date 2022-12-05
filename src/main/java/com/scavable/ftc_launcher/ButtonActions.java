package com.scavable.ftc_launcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;


public class ButtonActions {
    private static EventHandler<ActionEvent> curseForgeDownloadAction, ftbDownloadAction, extractAction, websiteAction, discordAction, patreonAction, launchAction;

    public static EventHandler<ActionEvent> curseForgeDownloadAction(){
        curseForgeDownloadAction = event -> {
            try {
                Runtime.getRuntime().exec("cmd /c start https://www.curseforge.com/minecraft/modpacks");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return curseForgeDownloadAction;
    }
    public static EventHandler<ActionEvent> ftbDownloadAction(){
        ftbDownloadAction = event -> {
            try {
                Runtime.getRuntime().exec("cmd /c start https://www.feed-the-beast.com/ftb-app");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return ftbDownloadAction;
    }
    public static EventHandler<ActionEvent> websiteAction(){
        websiteAction = event -> {
            try {
                Runtime.getRuntime().exec("cmd /c start https://feedthecraft.com/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return websiteAction;
    }
    public static EventHandler<ActionEvent> discordAction(){
        discordAction = event -> {
            try {
                Runtime.getRuntime().exec("cmd /c start https://discord.gg/FeedTheCraft");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return discordAction;
    }
    public static EventHandler<ActionEvent> patreonAction(){
        patreonAction = event -> {
            try {
                Runtime.getRuntime().exec("cmd /c start https://www.patreon.com/feedthecraft");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return patreonAction;
    }

}
