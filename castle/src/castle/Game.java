package castle;

import java.util.Scanner;

public class Game {
	
	private Room currentRoom;
	
	public Game() {
		createRoom();
	}
	
	private void createRoom() {
		// 制造房间
		Room outside = new Room("城堡外");
		Room lorry = new Room("大堂");
		Room study = new Room("书房");
		Room pub = new Room("酒吧");
		Room bedroom = new Room("卧室");
		Room dining = new Room("餐厅");
		Room storage = new Room("储物室");
		Room platform = new Room("观景台");
		
		// 初始化房间出入口
		outside.setExits("north", lorry);
		lorry.setExits("south", outside);
		lorry.setExits("west", dining);
		lorry.setExits("east", pub);
		lorry.setExits("up", platform);
		platform.setExits("down", lorry);
		dining.setExits("north", study);
		dining.setExits("east", lorry);
		study.setExits("south", dining);
		study.setExits("east", storage);
		storage.setExits("west", study);
		pub.setExits("west", lorry);
		pub.setExits("north", bedroom);
		bedroom.setExits("south", pub);
		
		// 当前房间
		currentRoom = outside;
	}

	private void printWelcome(){
		System.out.println();
		System.out.println("欢迎来到城堡!");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入'help'");
		System.out.println();
		System.out.println("现在你在:" + currentRoom);
		System.out.println("欢迎来到城堡");
		System.out.print("出口有：");
		System.out.println(currentRoom.getExitsDesc());
	}
	
	public void printHelp()
	{
		System.out.println("迷路了吗？你可以做的命令有：go bye help");
		System.out.println("如：go east");
	}
	
	public void goRoom(String direction) {
		Room nextRoom = currentRoom.getExit(direction);
		if(nextRoom == null) {
			System.out.println("那里没有门！");
		}
		else {
			currentRoom = nextRoom;
			showPrompt();
		}
	}
	
	private void showPrompt() {
		System.out.println("现在你在:" + currentRoom);
		System.out.print("出口有：");
		System.out.println(currentRoom.getExitsDesc());
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();
		
		while(true) {
			String line = in.nextLine();
			String[] word = line.split(" ");
			if(word[0].equals("help")) {
				game.printHelp();
			}
			else if(word[0].equals("go")) {
				game.goRoom(word[1]);
			}
			else if(word[0].equals("bye")) {
				break;
			}
		}
	}

}