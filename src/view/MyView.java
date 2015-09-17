package view;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

/**
 * 
 * @author Yuval Admi & Afek Ben Simon
 * @since 01.09.2015 This class extends the abstract class - CommonView. It
 *        should get an information from the client, send it to the Controller,
 *        get an answer and present it to client.
 *
 */
public class MyView extends CommonView {

    public CLI cli;
    public HashMap<String, Command> hm;
/**
 * CTOR
 * @param c
 */
    public MyView(Controller c) {
	this.c = c;
    }
/**
 * Starting the program
 */
    @Override
    public void start() {
	cli = new CLI(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out), hm);
	cli.start();
    }
/**
 * Set the HashMap and create it 
 */
    @Override
    public void setHashMap(HashMap<String, Command> hm) {
	this.hm = hm;
	c.createHashMap();
    }
/**
 * Display an array of Strings
 */
    @Override
    public void displayString(String[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + " ");
	}
    }
/**
 * Display an array of bytes
 */
    @Override
    public void displayByte(byte[] arr) {
	ByteArrayInputStream bArr = new ByteArrayInputStream(arr);
	DataInputStream data = new DataInputStream(bArr);
	try {
	    int x = data.readInt();
	    int y = data.readInt();
	    int z = data.readInt();
	    System.out.println("Start Position: " + data.readInt() + "," + data.readInt() + "," + data.readInt());
	    System.out.println("Goal Position: " + data.readInt() + "," + data.readInt() + "," + data.readInt());

	    System.out.println("Maze size: " + x + "," + y + "," + z);
	    System.out.println();
	    for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
		    for (int k = 0; k < z; k++) {
			System.out.print(data.read());
		    }
		    System.out.println();
		}
		System.out.println();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
/**
 * Display a 2D array of integer
 */
    @Override
    public void displayInt(int[][] arr) {
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
		System.out.print(arr[i][j]);
	    }
	    System.out.println();
	}
    }
/**
 * This method should close the threads that remain open
 */
    @Override
    public void exit() {
	System.out.println("Server is safely closed");
    }
}
