package util;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.net.URL;

public class Helpers {
    public static @Nullable String getLookAndFeelClassName(String nameSnippet) {
        UIManager.LookAndFeelInfo[] platforms = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : platforms) {
            if (info.getName().contains(nameSnippet)) {
                return info.getClassName();
            }
        }
        return null;
    }

    public static String pascalCaseToSpacedString(String pascalCase) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pascalCase.length(); i++) {
            char c = pascalCase.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                result.append(" ");
            }
            result.append(c);
        }
        return result.toString();
    }

    public static @Nullable ImageIcon createImageIcon(String name) {
        @Nullable URL url = ClassLoader.getSystemResource(name);
        return url == null ? null : new ImageIcon(url);
    }

    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
}
