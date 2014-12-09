/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.keyinput;

import java.awt.event.KeyEvent;

/**
 *
 * @author Kyle
 */
public class KeyInputHandler
{
    public static UserLine userLine = new UserLine();
    public static void handleKeyInput(KeyEvent e)
    {
        if (isKey(e, KeyEvent.VK_ENTER))
        {
            enter();
        }
        else if (isKey(e, KeyEvent.VK_UP))
        {
            up(); 
        }
        else if (isKey(e, KeyEvent.VK_DOWN))
        {
            down();
        }
        else if (isKey(e, KeyEvent.VK_ESCAPE))
        {
            escape();
        }
        else if (isKey(e, KeyEvent.VK_TAB))
        {
            tab();
        }
        else if (isKey(e, KeyEvent.VK_BACK_SPACE))
        {
            backspace();
        }
        else if (isKey(e, KeyEvent.VK_SPACE) || !e.isActionKey() && !isKey(e, KeyEvent.VK_ALT) && !isKey(e, KeyEvent.VK_CONTROL) && !isKey(e, KeyEvent.VK_SHIFT))
        {
            typeKey(e);
        }
        System.out.println(userLine);
    }
    
    /**
     * Returns if the specified value is the key pressed.
     *
     * @param e Key Event
     * @param code int value to compare against.
     * @return if key is he one specified.
     */
    private static boolean isKey(KeyEvent e, int code)
    {
        return (e.getKeyChar() == code || e.getKeyCode() == code);
    }
    
    /**
     * Adds the given key to the commandLine.
     *
     * @param e
     */
    private static void typeKey(KeyEvent e)
    {
        userLine.append(e.getKeyChar());        
    }

    private static void enter()
    {
        
    }

    private static void backspace()
    {
        userLine.removeLast();        
    }

    private static void up()
    {

    }

    private static void down()
    {

    }

    private static void escape()
    {

    }

    private static void tab()
    {

    }
}
