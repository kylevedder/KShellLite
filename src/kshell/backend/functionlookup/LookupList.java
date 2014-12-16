/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kshell.backend.functionlookup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kshell.backend.file.FileUtils;
import kshell.backend.file.FileWrapper;

/**
 *
 * @author Kyle
 */
public class LookupList
{
    
    private static String LOOKUP_FILE_LOCATION = "./lookupFile.txt";

    FileWrapper lookupFile = null;
    boolean fileParsed = false;
    public static String FUNCTION_KEY = "command_name";
    public static String PATH_KEY = "jar_path";
    private HashMap<String, FileWrapper> commandMap = null;

    /**
     * Accepts a File as a file to parse for commands.
     *
     * @param lookupFile File to parse
     */
    public LookupList()
    {
        this.lookupFile = new FileWrapper(LOOKUP_FILE_LOCATION);
        if (this.lookupFile != null)
        {            
            //if file exists, parse
            if (this.lookupFile.exists())
            {
                System.out.println("Parsing Lookup File...");
                commandMap = parseFileNew(lookupFile);
            }
            //file does not exist
            else
            {
                System.out.println("Generating Lookup File...");
                commandMap = new HashMap<String, FileWrapper>();
                //make a new lookup file
                generateLookupFile(lookupFile);
            }
        }
        else
        {
            System.out.println("File Lookup Wrapper Null...");
            fileParsed = false;
        }
        
        
    }

    /**
     * Gets the File from the function name.
     *
     * @return
     */
    public FileWrapper getJarFromFunctionName(String name)
    {
        return commandMap.get(name);
    }

    /**
     * Gets the String of the path to the file from the function name.
     *
     * @return
     */
    public String getJarStringFromFunctionName(String name)
    {
        return getJarFromFunctionName(name).getCanonicalPath();
    }

    /**
     * Parse the file and generate a map of all commands
     *
     * @param f
     * @return
     */
    private HashMap<String, FileWrapper> parseFileNew(FileWrapper f)
    {
        HashMap<String, FileWrapper> commandMap = null;
        //if file exists, parse
        if (f.exists())
        {
            BufferedReader br = null;
            commandMap = new HashMap<String, FileWrapper>();
            ArrayList<String> lines = FileUtils.readCommandFile(f.getCanonicalPath());
            lineLoop:
            for (String line : lines)
            {
                line = line.trim();
                int splitPoint = line.indexOf(" ");
                if ((splitPoint) < 0)//space not found, invalid index
                {
                    break lineLoop;
                }
                //set function and path
                String function = line.substring(0, splitPoint);
                String path = line.substring(splitPoint, line.length());

                //convert to file
                FileWrapper pathFile = new FileWrapper(path);
                //check file exists
                if (pathFile.exists())
                {
                    //add file
                    commandMap.put(function, pathFile);
                }
            }
        }
        return commandMap;
    }

    /**
     * Creates a new file with a header and general information.
     *
     * @param f
     */
    private void generateLookupFile(FileWrapper f)
    {

        String contents
                = FileUtils.FILE_COMMENT_STARTER + "This is a command lookup file. All commands must be entered below in the proper format:\n\r"
                + FileUtils.FILE_COMMENT_STARTER + "Examples:\n\r"
                + FileUtils.FILE_COMMENT_STARTER + "functionName C:/path/to/function.jar\n\r"
                + FileUtils.FILE_COMMENT_STARTER + "functionName ./relative/path/to/function.jar";
        FileUtils.createFile(f, contents);
    }

}
