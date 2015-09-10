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
		c.createHashMap();

	}

	@Override
	public void display(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}

	}

	@Override
	public void displayByte(byte[] arr) {
		ByteArrayInputStream bArr = new ByteArrayInputStream(arr);
		DataInputStream data = new DataInputStream(bArr);
		try {
			System.out.println("Start Position: "+data.readInt()+","+data.readInt()+","+data.readInt());
			System.out.println("Goal Position: "+data.readInt()+","+data.readInt()+","+data.readInt());
			int x=data.readInt();
			int y=data.readInt();
			int z=data.readInt();
			
			System.out.println("Maze size: "+x+","+y+","+z);
			System.out.println();
			for (int i=0;i<x;i++){
				for (int j=0;j<y;j++){
					for (int k=0;k<z;k++){
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

	@Override
	public void displayCross(int[][] arr) {
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}

}
