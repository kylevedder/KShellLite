/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.executor;

/**
 *
 * @author Kyle
 */
public class ExecutorThread extends Thread
{

    public ExecutorThread()
    {
        this.start();
    }

    
    
    private volatile boolean isRunning = true;

    @Override
    public void run()
    {
        System.out.println("Executor Thread Initialized...");
        init();
        while (isRunning)
        {
            execute();
        }        
    }

    private void init()
    {

    }

    private void execute()
    {

    }

    /**
     * Ends the thread.
     */
    public void kill()
    {
        this.isRunning = false;
    }
}
