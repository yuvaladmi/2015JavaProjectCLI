package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

/**
 * 
 * @author Yuval Admi & Afek Ben Simon
 * @since 01.09.2015 An abstract class which implements Model.
 */
public abstract class CommonModel implements Model {
    public HashMap<String, Maze3d> hMaze;
    public HashMap<String, Solution<Position>> hSol;
    public Controller c;
    public StringBuilder sb;
    // This parameter tells us how many threads we want in the threadPool
    public int numOfThread;
    public ExecutorService threadpool;

    public abstract void save(String[] arr);

    public abstract void load(String[] arr);

    public abstract void solve(String[] arr);

    public abstract void bringSolution(String[] arr);

    public abstract void gameSize(String[] arr);

    public abstract void fileSize(String[] arr);

    public abstract void close();

}
