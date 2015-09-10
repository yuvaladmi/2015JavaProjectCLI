package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.CommonSearcher;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattenDistance;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel extends CommonModel {

	public MyModel(Controller c) {
		super(c);
		hMaze = new HashMap<String, Maze3d>();
		sb = new StringBuilder();
	}

	@Override
	public void dirToPath(String[] arr) {

		for (int i = 1; i < arr.length - 1; i++) {
			sb.append(arr[i] + " ");

		}
		sb.append(arr[arr.length - 1]);
		File f = null;
		String s = sb.toString();
		try {
			f = new File(s);
			c.display(f.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.toString();
			String[] error = "Folder does not exist".split(" ");
			c.display(error);
		}
	}

	@Override
	public void generateMaze(String[] arr) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 1;
				if (arr[i].equals("3d") || arr[i].equals("3D")) {
					i++;
					;
					if (arr[i].equals("maze")) {
						i++;
					}
				}
				while (i < arr.length) {
					sb.append(arr[i]);
					i++;
				}
				String name = sb.substring(0, sb.length() - 3);
				int x = (int) sb.charAt(sb.length() - 3) - 48;
				int y = (int) sb.charAt(sb.length() - 2) - 48;
				int z = (int) sb.charAt(sb.length() - 1) - 48;
				MyMaze3dGenerator mg = new MyMaze3dGenerator(x, y, z);
				Maze3d m = mg.generate(x, y, z);
				hMaze.put(name, m);
				// String[] error = "Folder does not exist".split(" ");
				c.display(("maze " + name + " is ready").split(" "));
			}
		}).start();
	}

	@Override
	public void sendMaze(String[] arr) {
		sb = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		String name = sb.toString();
		byte[] byteArr;
		try {
			Maze3d temp = hMaze.get(name);
			byteArr = temp.toByteArray();
			c.displayMaze(byteArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void crossSection(String[] arr) {
		sb = new StringBuilder();
		int i = arr.length - 2;
		if (arr[i].equals("for")) {
			for (int j = i+1; j < arr.length; j++) {
				sb.append(arr[j]);
			}
		}
		String name = sb.toString();
		int index = (arr[--i].charAt(0)) - 48;
		char crossBy = arr[--i].charAt(0);
		Maze3d maze=hMaze.get(name);
		int[][] myMaze=null;
		switch (crossBy) {
		case 'x':
			myMaze= maze.getCrossSectionByX(index);

			break;
		case 'X':
			myMaze= maze.getCrossSectionByX(index);

			break;
		case 'y':
			myMaze= maze.getCrossSectionByY(index);
			break;
		case 'Y':
			myMaze= maze.getCrossSectionByY(index);
			break;
		case 'z':
			myMaze= maze.getCrossSectionByZ(index);
			break;
		case 'Z':
			myMaze= maze.getCrossSectionByZ(index);
			break;

		default:
			System.out.println("undefined letter ");
			break;
		}
		c.displayCross(myMaze);

	}

	@Override
	public void saveMaze(String[] arr) {
		String name=new String ();
		String fileName= new String();
		Maze3d m =hMaze.get(name);
		try {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
			out.write(m.toByteArray());
			out.close();
			c.display("The maze is saved".split(" "));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	@Override
	public void loadMaze(String[] arr) {
		String name=new String ();
		String fileName= new String();
		byte[] b=null;
		try {
			InputStream in =new MyDecompressorInputStream(new FileInputStream(fileName));
			in.read(b);
			in.close();
			Maze3d maze = new Maze3d(b);
			hMaze.put(name, maze);
			c.display("The maze is loaded".split(" "));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void solve(String[] arr) {
		String nameAlg=arr[arr.length-1];
		sb=new StringBuilder();
		for (int i = 1; i < arr.length-1; i++) {
			sb.append(arr[i]);
		}
		String name=sb.toString();
	
		if((hSol.get(name))!=null){
			c.display(("solution for "+name+" is ready").split(" "));
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Solution<Position> sol;
				Maze3d m=hMaze.get(name);
				SearchableMaze sMaze = new SearchableMaze(m);
				CommonSearcher<Position> cs;
				switch (nameAlg) {
				case "Astar":
					cs=new AStar<Position>(new MazeAirDistance());
					cs=new AStar<Position>(new MazeManhattenDistance());
					hSol.put(name, cs.search(sMaze));
					break;
				case "A*":
					cs=new AStar<Position>(new MazeAirDistance());
					cs=new AStar<Position>(new MazeManhattenDistance());
					hSol.put(name, cs.search(sMaze));
					break;
				case "BFS":
					cs=new BFS<Position>();
					hSol.put(name, cs.search(sMaze));
					break;
				default:
					c.display(("The algorithm was not found").split(" "));
					break;
				}
				
				c.display(("solution for "+name+" is ready").split(" "));
				
			}
		}).start();
		
	}
	

}
