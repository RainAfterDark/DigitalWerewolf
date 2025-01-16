import Game.GameManager;
import Util.Helpers;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        String windowsLookAndFeel = Helpers.getLookAndFeelClassName("Windows");
        UIManager.setLookAndFeel(windowsLookAndFeel);
        new GameManager().run();
    }
}