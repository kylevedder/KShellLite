/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.fifo;

import java.util.ArrayList;
import kshell.backend.file.FileWrapper;
import kshell.backend.functionlookup.LookupList;
import kshell.backend.keyinput.OpMode;

/**
 *
 * @author Kyle
 */
public class ExecuteFIFO
{

    private static ExecuteFIFO executeFifo = null;


    //object internal objects
    private Lock lock = null;
    private String function = null;
    private ArrayList<String> fifo = null;
    private LookupList lookupList = null;

    private ExecuteFIFO()
    {
        lock = new Lock();
        fifo = new ArrayList<>();
        function = null;   
        lookupList = new LookupList();
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

    /**
     * Sets the function name from the given String.
     *
     * @param s
     */
    public OpMode setFunction(String s)
    {

        this.function = s;
        return null;
    }

    /**
     * Returns if the function is set.
     *
     * @return
     */
    public boolean isFunctionSet()
    {
        return (this.function != null);
    }

    /**
     * Adds the user input to the FIFO.
     *
     * @param s
     */
    public void addUserInput(String s)
    {
        if (s != null)
        {
            fifo.add(s);
            lock.unlock();
        }
    }

    /**
     * Pops the first item out of the FIFO and returns it.
     *
     * @return first item in the FIFO, or null if empty.
     */
    public String popFirst()
    {
        String item = null;
        //checks to see if element avalible to pop
        if (fifo.size() > 0)
        {
            item = fifo.remove(0);
        }
        //if fifo empty, lock the FIFO
        if (fifo.size() <= 0)
        {
            lock.lock();
        }
        return item;
    }

    /**
     * Returns the number of items in the FIFO.
     *
     * @return
     */
    public int getNumItems()
    {
        return fifo.size();
    }

    /**
     * Awaits the unlock of the lock.<b>This is blocking!</b>
     */
    public void await()
    {
        lock.await();
    }
}
