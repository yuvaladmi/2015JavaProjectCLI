package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView extends CommonView {

    public CLI cli;
    public HashMap<String, Command> hm;
    
    public MyView(Controller c) {
	this.c = c;
	
    }

    @Override
    public void start() {
	
	cli = new CLI(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out), hm);
	cli.start();
	
    }

    @Override
    public void setHashMap(HashMap<String, Command> hm) {
	this.hm = hm;
	
    }

   

   

    
}
