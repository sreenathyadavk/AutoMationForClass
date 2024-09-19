
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AutomateK {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            String path = new File("data.txt").getAbsolutePath();
            System.out.println("Reading from: " + path);

            System.out.println("You have 5 seconds to switch to the target application...");
            robot.delay(5000);

            // Read from the file
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    typeString(robot, line);
                    robot.delay(500); // Delay between lines
                }
            }
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    private static void typeString(Robot robot, String text) {
        System.out.println("Typing: " + text);
        for (char c : text.toCharArray()) {
            typeChar(robot, c);
            robot.delay(100); // Delay between each keystroke
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private static void typeChar(Robot robot, char c) {
        if (Character.isUpperCase(c)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            pressKey(robot, c);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            pressKey(robot, c);
        }
    }

    private static void pressKey(Robot robot, char c) {
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        if (keyCode != KeyEvent.VK_UNDEFINED) {
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        } else {
            // Handle specific special characters
            switch (c) {
                case ' ':
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                    break;
                case '!':
                    pressShiftKey(robot, KeyEvent.VK_1);
                    break;
                case '@':
                    pressShiftKey(robot, KeyEvent.VK_2);
                    break;
                case '#':
                    pressShiftKey(robot, KeyEvent.VK_3);
                    break;
                case '$':
                    pressShiftKey(robot, KeyEvent.VK_4);
                    break;
                case '%':
                    pressShiftKey(robot, KeyEvent.VK_5);
                    break;
                case '^':
                    pressShiftKey(robot, KeyEvent.VK_6);
                    break;
                case '&':
                    pressShiftKey(robot, KeyEvent.VK_7);
                    break;
                case '*':
                    pressShiftKey(robot, KeyEvent.VK_8);
                    break;
                case '(':
                    pressShiftKey(robot, KeyEvent.VK_9);
                    break;
                case ')':
                    pressShiftKey(robot, KeyEvent.VK_0);
                    break;
                case '{':
                    pressShiftKey(robot, KeyEvent.VK_BRACELEFT);
                    break;
                case '}':
                    pressShiftKey(robot, KeyEvent.VK_BRACERIGHT);
                    break;
                case ':':
                    pressShiftKey(robot, KeyEvent.VK_SEMICOLON);
                    break;
                case '"':
                    pressShiftKey(robot, KeyEvent.VK_QUOTE);
                    break;
                case '<':
                    pressShiftKey(robot, KeyEvent.VK_COMMA);
                    break;
                case '>':
                    pressShiftKey(robot, KeyEvent.VK_PERIOD);
                    break;
                case '?':
                    pressShiftKey(robot, KeyEvent.VK_SLASH);
                    break;
                case ';':
                    robot.keyPress(KeyEvent.VK_SEMICOLON);
                    robot.keyRelease(KeyEvent.VK_SEMICOLON);
                    break;
                case ',':
                    robot.keyPress(KeyEvent.VK_COMMA);
                    robot.keyRelease(KeyEvent.VK_COMMA);
                    break;
                case '.':
                    robot.keyPress(KeyEvent.VK_PERIOD);
                    robot.keyRelease(KeyEvent.VK_PERIOD);
                    break;
                case '\n':
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    break;
                default:
                    System.out.println("Unrecognized character: " + c);
            }
        }
    }

    private static void pressShiftKey(Robot robot, int key) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(key);
        robot.keyRelease(key);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }
}
