/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kshell.backend.executor.ExecutorThread;
import kshell.backend.fifo.ExecuteFIFO;
import kshell.backend.fifo.UIFIFO;
import kshell.backend.ui.UI;

/**
 *
 * @author Kyle
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        UIFIFO uiFifo = UIFIFO.getInstance();
        ExecuteFIFO executeFifo = ExecuteFIFO.getInstance();
        UI ui = new UI();
        ExecutorThread ex = new ExecutorThread();          
        while (true)
        {                      
            //block for UI input
            uiFifo.await();            
            //get item
            String fifoItem = uiFifo.popFirst();
            System.out.println("Line: " + fifoItem);
            ui.updateLine(fifoItem);
        }
    }

}
