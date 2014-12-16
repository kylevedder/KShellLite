/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.fifo;

import java.util.ArrayList;

/**
 *
 * @author Kyle
 */
public class UIFIFO
{

    private static UIFIFO uififo = null;

    //object internal objects
    private Lock lock = null;
    private ArrayList<String> fifo = null;

    private UIFIFO()
    {
        lock = new Lock();
        fifo = new ArrayList<>();
    }

    /**
     * Returns a singleton instance of the UIFIFO
     *
     * @return
     */
    public static UIFIFO getInstance()
    {
        if (uififo == null)
        {
            uififo = new UIFIFO();
        }
        return uififo;
    }

    /**
     * Adds a line to be added to the UI
     *
     * @param s
     */
    public void addLineUpdate(String s)
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
