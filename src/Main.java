import Game.GameManager;
import Util.Helpers;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        String windowsLookAndFeel = Helpers.getLookAndFeelClassName("Windows");
        if (windowsLookAndFeel != null) {
            UIManager.setLookAndFeel(windowsLookAndFeel);
        }
        new GameManager().run();
    }
}