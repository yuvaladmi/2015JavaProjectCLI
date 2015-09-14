package controller;

/**
 * 
 * @author Yuval Admi & Afek Ben Simon
 * @since 01.09.2015 This class extends the abstract class - CommonController.
 *        It should get an information what we want to do from the View,
 *        send it to the Model, wait for an answer and send to the View back.
 *
 */
public class MyController extends CommonController {

    public MyController() {
	createHashMap();
    }
/**
 * This method create new Commands in the HashMap
 */
    @Override
    public void createHashMap() {
	hm.put("dir", new Command() {

	    @Override
	    public void doCommand(String[] arr) {

		m.dirToPath(arr);
	    }
	});
	hm.put("generate", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.generateMaze(arr);
	    }
	});
	hm.put("display", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		switch (arr[1]) {
		case "cross":
		    m.crossSection(arr);
		    break;
		case "solution":
		    m.bringSolution(arr);
		    break;
		default:
		    m.sendGame(arr);
		    break;
		}

	    }
	});
	hm.put("save", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.save(arr);

	    }
	});
	hm.put("load", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.load(arr);

	    }
	});
	hm.put("solve", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.solve(arr);

	    }
	});
	hm.put("maze", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.gameSize(arr);

	    }
	});
	hm.put("file", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.fileSize(arr);
	    }
	});
	hm.put("exit", new Command() {

	    @Override
	    public void doCommand(String[] arr) {
		m.close();

	    }
	});
    }

    @Override
    public void displayString(String[] arr) {
	v.displayString(arr);
    }

    @Override
    public void displayByte(byte[] arr) {
	v.displayByte(arr);

    }

    @Override
    public void displayInt(int[][] arr) {
	v.displayInt(arr);

    }

    @Override
    public void exit() {
	v.exit();
    }

}
