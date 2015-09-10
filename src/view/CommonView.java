package view;

import java.util.HashMap;

import controller.Command;
import controller.Controller;

public abstract class CommonView implements View {

	public Controller c;

	public abstract void display(String[] arr);

	public abstract void setHashMap(HashMap<String, Command> hm);

	public abstract void start();

	public abstract void displayByte(byte[] arr);
	public abstract void displayCross(int[][] arr);
    

}
