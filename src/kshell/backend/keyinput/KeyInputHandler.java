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

    public UserLine userLine = null;
    private OpMode opMode = null;
    private static KeyInputHandler keyInputHandler = null;

    private KeyInputHandler()
    {
        userLine = new UserLine();
        opMode = OpMode.MAIN;
    }

    /**
     * Returns a singleton instance of this class.
     * @return 
     */
    public static KeyInputHandler getInstance()
    {
        if (keyInputHandler == null)
        {
            keyInputHandler = new KeyInputHandler();
        }
        return keyInputHandler;
    }

    /**
     * Takes the key input from the UI and handles it.
     *
     * @param e
     */
    public void handleKeyInput(KeyEvent e)
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
     * Sets the mode which the KeyHandler is operating in.
     *
     * @param opMode
     */
    public void setOpMode(OpMode opMode)
    {
        this.opMode = opMode;
    }

    /**
     * Returns if the specified value is the key pressed.
     *
     * @param e Key Event
     * @param code int value to compare against.
     * @return if key is he one specified.
     */
    private boolean isKey(KeyEvent e, int code)
    {
        return (e.getKeyChar() == code || e.getKeyCode() == code);
    }

    /**
     * Adds the given key to the commandLine.
     *
     * @param e
     */
    private void typeKey(KeyEvent e)
    {
        if (opMode == OpMode.MAIN)
        {
            userLine.append(e.getKeyChar());
        }
        else if (opMode == OpMode.PASS_INPUT)
        {

        }
    }

    private void enter()
    {

    }

    private void backspace()
    {
        userLine.removeLast();
    }

    private void up()
    {

    }

    private void down()
    {

    }

    private void escape()
    {

    }

    private void tab()
    {

    }
}

enum OpMode
{

    MAIN, PASS_INPUT
}
