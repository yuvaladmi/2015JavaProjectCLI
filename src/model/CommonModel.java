package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

public abstract class CommonModel implements Model {
	public HashMap<String, Maze3d> hMaze;
	public HashMap<String, Solution<Position>> hSol;
	public Controller c;
	public StringBuilder sb;

	public abstract void dirToPath(String[] arr);

	public abstract void generateMaze(String[] arr);

	public abstract void sendMaze(String[] arr);

	public CommonModel(Controller c) {
		this.c = c;
	}

	public abstract void crossSection(String[] arr);

	public abstract void saveMaze(String[] arr);

	public abstract void loadMaze(String[] arr);
	public abstract void solve(String[] arr);

}
