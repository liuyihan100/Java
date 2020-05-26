package castle;

import java.util.Scanner;

public class Game {
	
	private Room currentRoom;
	
	public Game() {
		createRoom();
	}
	
	private void createRoom() {
		// ���췿��
		Room outside = new Room("�Ǳ���");
		Room lorry = new Room("����");
		Room study = new Room("�鷿");
		Room pub = new Room("�ư�");
		Room bedroom = new Room("����");
		Room dining = new Room("����");
		Room storage = new Room("������");
		Room platform = new Room("�۾�̨");
		
		// ��ʼ����������
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
		
		// ��ǰ����
		currentRoom = outside;
	}

	private void printWelcome(){
		System.out.println();
		System.out.println("��ӭ�����Ǳ�!");
		System.out.println("����һ���������ĵ���Ϸ��");
		System.out.println("�����Ҫ������������'help'");
		System.out.println();
		System.out.println("��������:" + currentRoom);
		System.out.println("��ӭ�����Ǳ�");
		System.out.print("�����У�");
		System.out.println(currentRoom.getExitsDesc());
	}
	
	public void printHelp()
	{
		System.out.println("��·������������������У�go bye help");
		System.out.println("�磺go east");
	}
	
	public void goRoom(String direction) {
		Room nextRoom = currentRoom.getExit(direction);
		if(nextRoom == null) {
			System.out.println("����û���ţ�");
		}
		else {
			currentRoom = nextRoom;
			showPrompt();
		}
	}
	
	private void showPrompt() {
		System.out.println("��������:" + currentRoom);
		System.out.print("�����У�");
		System.out.println(currentRoom.getExitsDesc());
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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