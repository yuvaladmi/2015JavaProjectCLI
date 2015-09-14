package controller;


import model.Model;
import view.View;

public interface Controller {
	void setModel(Model m);

	void setView(View v);

	public void createHashMap();

	public void displayString(String[] arr);

	public void displayByte(byte[] arr);

	public void displayInt(int[][] arr);
	
	public void exit();
	
	

}
