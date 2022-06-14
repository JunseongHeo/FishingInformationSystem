package member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.DefaultTextUI;

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
	
	public void writ() {
		
			System.out.print("���� \n>");
			String newTitle = input();
			
			System.out.print("���� \n>");
			String newSub = input();
			
			st.add(messageNum++, new MessageBoard(newTitle, newSub));								
	}
	
	public void showBoard() {
		for(int n=0; n<st.size(); n++) {
			System.out.println("��ȣ: " + n + "����: " + st.get(n).title);
		}
		while(true) {
			try {
		System.out.println("1.�Խù� ����  2.���ư���");
		System.out.print("���� >");
		int ba = sc.nextInt();
			switch(ba) {
				case 1:
					System.out.print("������� ��ȣ ���� \n>");
					int num = sc.nextInt();
					if(num != 'b') {
						System.out.println("���� : " + st.get(num).title);
						System.out.println("���� : " + st.get(num).substance);
					}
				case 2:
					return;
				default :
					System.out.println("[�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���]");
					break;
			} break;
		} catch (InputMismatchException e) {
			if(e instanceof InputMismatchException)
				sc=new Scanner(System.in);
			System.out.println("[���ڸ� �Է� �����մϴ�] \n");
		} catch (IndexOutOfBoundsException e) {
			if(e instanceof IndexOutOfBoundsException)
				sc=new Scanner(System.in);
			System.out.println("[�������� �ʴ� �Խù� ��ȣ�Դϴ�.]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	public void delBoard() {
			
			System.out.print("���� ��ȣ �Է� \n>");
			try {
			int m = sc.nextInt();
			if(m <= st.size()-1) {
			System.out.println("���� ���� �Ͻðڽ��ϱ�?");
			System.out.println("1.���� 2.���ư���");
			System.out.print(">");
			}else {
				System.out.println("[�������� �ʴ� �Խù� ��ȣ�Դϴ�.]\n");
				return;
			}
			
			int del = sc.nextInt();
			if(del == 1) {
			MessageBoard ab = st.remove(m); 
			System.out.println("\n[�����Ǿ����ϴ�]\n");
			return;
			}else if(del ==2) {
			return ;
			}
			
		} catch (IndexOutOfBoundsException e) {
			if(e instanceof IndexOutOfBoundsException)
				sc = new Scanner(System.in);
				System.out.println("[�������� �ʴ� �Խù� ��ȣ�Դϴ�.]\n");
		} catch (InputMismatchException e) {
			if(e instanceof InputMismatchException)
				sc = new Scanner(System.in);
				System.out.println("[���ڸ� �Է� �����մϴ�] \n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
