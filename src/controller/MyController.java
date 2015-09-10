package controller;

public class MyController extends CommonController {

	private StringBuilder sb;

	public MyController() {
		sb = new StringBuilder();
		createHashMap();
	}

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
					break;
				default:
					m.sendMaze(arr);
					break;
				}

			}
		});
		hm.put("save", new Command() {

			@Override
			public void doCommand(String[] arr) {
				m.saveMaze(arr);

			}
		});
		hm.put("load", new Command() {

			@Override
			public void doCommand(String[] arr) {
				m.loadMaze(arr);

			}
		});
		hm.put("solve", new Command() {
			
			@Override
			public void doCommand(String[] arr) {
				m.solve(arr);
				
			}
		};
	}

	@Override
	public void display(String[] arr) {
		v.display(arr);
	}

	@Override
	public void displayMaze(byte[] arr) {
		v.displayByte(arr);

	}

	@Override
	public void displayCross(int[][] arr) {
		v.displayCross(arr);

	}

}
