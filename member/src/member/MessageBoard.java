package member;

import java.util.Scanner;

public class MessageBoard extends LoginProgram {
	Scanner a = new Scanner(System.in);
	MessageBoard[] board = new MessageBoard[1000];
	boolean run = true;
	private String title, substance;
	int messageNum=0;
	public MessageBoard(String newTitle, String newSub) {
		this.title = newTitle;
		this.substance = newSub;
	}
	public MessageBoard() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubstance() {
		return substance;
	}
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	public void MessagerBoard() {
	}
	
	public void displayBoard() {
		System.out.println("1.�۾��� 2.����");
		int k = a.nextInt();
		switch(k) {
		case 1:
			while(true) {
				if(loginFlag!=true) {
					System.out.println("�α��� �� �̿��ϼ���.");
					continue;
				}
					System.out.print("���� : ");
					String newTitle = input();
					System.out.print("���� : ");
					String newSub = input();
					board[messageNum++] = new MessageBoard(newTitle, newSub);
					showBoard();
					break;
			}			
		/*case 2:
			();
			break;*/
		}
	}
	/*public void writ() {
		if(loginFlag!=true) {
			System.out.println("�α��� �� �̿��ϼ���.");
		}else {
			System.out.print("���� : ");
			String newTitle = input();
			System.out.print("���� : ");
			String newSub = input();
			board[messageNum++] = new MessageBoard(newTitle, newSub);
		}
		
	}*/
	public void showBoard() {
		for(messageNum=0; messageNum<board.length; messageNum++) {
			System.out.println("��ȣ"+messageNum+"���� : "+board[messageNum].title);
		}
		System.out.println("���� > ");
		int num = a.nextInt();
			System.out.println("���� : " + board[num].title);
			System.out.println("���� : " + board[num].substance);
	}
	
}
