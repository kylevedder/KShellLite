/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.executor;

/**
 *
 * @author kyle
 */
public class InputStorage
{
    private static InputStorage inputStorage = null;

    private InputStorage()
    {
    }    
    
    /**
     * Returns a singleton instance of this class.
     * @return 
     */
    public static InputStorage getInstance()
    {
        if(inputStorage == null)inputStorage = new InputStorage();
        return inputStorage;
    }
}
