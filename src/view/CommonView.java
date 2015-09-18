package view;

import java.util.HashMap;

import controller.Command;
import controller.Controller;

/**
 * 
 * @author Yuval Admi & Afek Ben Simon
 * @since 01.09.2015 An abstract class which implements View.
 */
public abstract class CommonView implements View {

    public Controller c;

    public abstract void setHashMap(HashMap<String, Command> hm);

    public abstract void start();

    public abstract void displayString(String arr);

    public abstract void displayByte(byte[] arr);

    public abstract void displayInt(int[][] arr);

    public abstract void exit();
}
