/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.keyinput;

/**
 *
 * @author Kyle
 */
public class UserLine
{
    private StringBuilder stringBuilder = null;

    public UserLine()
    {
        stringBuilder = new StringBuilder();
    }
    
    
    
    /**
     * Add a String to the current line.
     * @param s 
     */
    public void append(String s)
    {
        stringBuilder.append(s);
    }
    
    /**
     * Add a char to the current line.
     * @param c 
     */
    public void append(char c)
    {
        stringBuilder.append(c);
    }
    
    
    /**
     * Removes the last letter from the StringBuilder
     */
    public void removeLast()
    {
        if(stringBuilder.length() > 0)
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
    }

    /**
     * Outputs the String value of the given line.
     * @return 
     */
    @Override    
    public String toString()
    {
        return stringBuilder.toString();
    }
    
    
}
