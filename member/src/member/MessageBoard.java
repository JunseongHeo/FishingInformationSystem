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
<<<<<<< HEAD
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
<<<<<<< HEAD
				default :
					System.out.println("[�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���]");
					break;
=======
>>>>>>> parent of 7070b75 (000)
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
			System.out.println("���� ���� �Ͻðڽ��ϱ�?");
			System.out.println("1.���� 2.���ư���");
			System.out.print(">");
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
=======
		for(int n=0; n<messageNum; n++) {
			System.out.println("��ȣ " + n + " ���� : " + board[n].title);
			}
		System.out.print("���� > ");
		int num = sc.nextInt();
			System.out.println("���� : " + board[num].title);
			System.out.println("���� : " + board[num].substance);
>>>>>>> parent of 653c658 (123)
	}
	
}
// �׽�Ʈ
// �׽�Ʈ2