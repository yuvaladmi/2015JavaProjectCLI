package controller;

import java.util.HashMap;

import model.Model;
import view.View;

/**
 * 
 * @author Yuval Admi & Afek Ben simon
 * @since 01.09.2015 
 * An abstract class which implements Controller
 *
 */
public abstract class CommonController implements Controller {
    protected Model m;
    protected View v;
    public HashMap<String, Command> hm;

    public abstract void createHashMap();

    public abstract void displayString(String[] arr);

    public abstract void displayByte(byte[] arr);

    public abstract void displayInt(int[][] arr);

    public abstract void exit();

    public HashMap<String, Command> getHm() {
	return hm;
    }

    public CommonController() {
	hm = new HashMap<String, Command>();

    }

    public void setModel(Model m) {
	this.m = m;
    }

    public void setView(View v) {
	this.v = v;
	v.setHashMap(hm);
    }

}
