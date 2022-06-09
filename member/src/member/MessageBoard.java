package member;

import java.util.Scanner;

public class MessageBoard extends LoginProgram {
	Scanner sc = new Scanner(System.in);
	MessageBoard[] board = new MessageBoard[1000];
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
	public void displayBoard() {
		while(true) {
			System.out.println("1.�۾��� 2.�Խñ� ���� 3.����");
			int k = sc.nextInt();
		switch(k) {
		case 1:
			
			writ();
			break;				
		case 2:
			showBoard();
			break;
//		case 3:
			
//			break;
		default:
            System.out.println("�ٽ��Է��ϼ���.");
            break;
			
		}
	
	}
}
	public void writ() {
		while(true) {
			System.out.print("���� \n>");
			String newTitle = input();
			
			System.out.print("���� \n>");
			String newSub = input();
			
			board[messageNum++] = new MessageBoard(newTitle, newSub);
			break;
		}
	}
	public void showBoard() {
		for(int n=0; n<messageNum; n++) {
			System.out.println("��ȣ " + n + " ���� : " + board[n].title);
			}
		System.out.print("���� > ");
		int num = sc.nextInt();
			System.out.println("���� : " + board[num].title);
			System.out.println("���� : " + board[num].substance);
	}
	
}
// �׽�Ʈ
// �׽�Ʈ2