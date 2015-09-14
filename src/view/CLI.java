package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
/**
 * 
 * @author Yuval Admi & Afek Ben Simon
 * @since 01.09.2015
 * This class is responsible to start the all system.
 * It gets a command, checks if it exists and sends an order to do it.
 *
 */
public class CLI extends Thread {

    private BufferedReader in;
    private PrintWriter out;
    private HashMap<String, Command> hm;
    Thread mainThread;
/**
 * 
 * @return this HashMap
 */
    public HashMap<String, Command> getHm() {
	return hm;
    }
/**
 * Sets this HashMap
 * @param hm
 */
    public void setHm(HashMap<String, Command> hm) {
	this.hm = hm;
    }
/**
 * CTOR
 * @param in
 * @param out
 * @param hm
 */
    public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> hm) {
	this.in = in;
	this.out = out;
	this.hm = hm;
    }
/**
 * This method starts the whole project.
 */
    public void start() {
	//the main thread, asking the client what does he want to do next.
	mainThread = new Thread(new Runnable() {
	    
	    @Override
	    public void run() {
		Command command;
		String line;
		try {
		    System.out.println("enter new command:");
		    while ((line = in.readLine().intern()) != "exit") {
			String[] temp = line.split(" ");
			if ((command = hm.get(temp[0])) != null) {
			    command.doCommand(temp);
			} else {
			    System.out.println("Command does not exist, please try again");
			}
		    }
		    System.out.println("bye bye");
		    command = hm.get("exit");
		    command.doCommand(line.split(" "));
		} catch (IOException e) {
		    e.printStackTrace();
		}

	    }
	});
	mainThread.start();
    }
    /**
     * This method waiting for the main thread to end his activities.
     */
    public void exit(){
	try {
	    mainThread.join();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
