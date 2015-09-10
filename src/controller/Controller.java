package controller;

import model.Model;
import view.View;

public interface Controller {
	void setModel(Model m);

	void setView(View v);

	public void createHashMap();

	public void display(String[] arr);

	public void displayMaze(byte[] arr);

	public void displayCross(int[][] arr);
	
	

}
