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
import kshell.backend.executor.ExecutorThread;
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
        UI ui = new UI();
        ExecutorThread ex = new ExecutorThread();
        ex.start();
        int i = 0;
        while (true)
        {
            i++;
        }
    }

}
