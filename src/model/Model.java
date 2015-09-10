package model;


public interface Model {
	public void dirToPath(String[] arr);
	public void generateMaze(String[] arr);
	public void sendMaze(String[] arr);
	public void crossSection (String [] arr);
	public void saveMaze (String[] arr);
	public void loadMaze (String[] arr);
	public void solve(String[] arr);
}
