package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI extends Thread {

	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> hm;

	public HashMap<String, Command> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, Command> hm) {
		this.hm = hm;
	}

	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> hm) {
		this.in = in;
		this.out = out;
		this.hm = hm;
	}

	public void start() {
		new Thread(new Runnable() {
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
						System.out.println("enter new command:");
					}
					System.out.println("bye bye");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}).start();

	}
}
