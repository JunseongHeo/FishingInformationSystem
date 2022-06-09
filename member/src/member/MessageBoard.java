package member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MessageBoard extends LoginProgram {
	Scanner sc = new Scanner(System.in);
	ArrayList<MessageBoard> st = new ArrayList<MessageBoard>();
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
		case 3:
			delBoard();
		break;
		default:
            System.out.println("�ٽ��Է��ϼ���.");
            break;
			
		}
	
	}
}
	public void writ() {
			System.out.print("���� \n>");
			String newTitle = input();
			
			System.out.print("���� \n>");
			String newSub = input();
			
			st.add(messageNum++, new MessageBoard(newTitle, newSub));
			
			
		
	}
	public void showBoard() {
		for(int n=0; n<st.size(); n++) {			
			System.out.println("��ȣ " + n + " ���� : " + st.get(n).title);
			}
		System.out.println("���ư��� = 00");
		System.out.print("���� >");
		int num = sc.nextInt();
		if(num != 00) {
			System.out.println("���� : " + st.get(num).title);
			System.out.println("���� : " + st.get(num).substance);
		
		}
	}
	
	public void delBoard() {
		System.out.print("���� ��ȣ �Է� \n>");
		int m = sc.nextInt();
		System.out.println("���� ���� �Ͻðڽ��ϱ�?");
		System.out.println("1.���� 2.���ư���");
		System.out.print(">");
		int del = sc.nextInt();
		if(del == 1) {
		MessageBoard ab = st.remove(m); 
		return;
		}else if(del ==2) {
		return ;
		}
	}
	
}
// �׽�Ʈ