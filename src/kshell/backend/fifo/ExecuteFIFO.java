/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.fifo;

/**
 *
 * @author Kyle
 */
public class ExecuteFIFO
{
    private static ExecuteFIFO executeFifo = null;

    private ExecuteFIFO()
    {
    }

    /**
     * Returns a singleton instance of the UIFIFO
     *
     * @return
     */
    public static ExecuteFIFO getInstance()
    {
        if (executeFifo == null)
        {
            executeFifo = new ExecuteFIFO();
        }
        return executeFifo;
    }
}
