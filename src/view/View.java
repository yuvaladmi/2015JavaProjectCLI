package view;

import java.util.HashMap;

import controller.Command;

public interface View {

   
    public void setHashMap(HashMap<String, Command> hm);
    
    public void start();
    public void display(String [] arr);
    public void displayByte (byte[] arr);
    public void displayCross(int[][] arr);
    
}
