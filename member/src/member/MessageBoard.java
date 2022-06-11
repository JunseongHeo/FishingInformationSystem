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
			System.out.println("1.글쓰기 2.게시글 보기 3.삭제");
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
            System.out.println("다시입력하세요.");
            break;
			
		}
	
	}
}
	public void writ() {
		while(true) {
			System.out.print("제목 \n>");
			String newTitle = input();
			
			System.out.print("내용 \n>");
			String newSub = input();
			
			board[messageNum++] = new MessageBoard(newTitle, newSub);
			break;
		}
	}
	public void showBoard() {
<<<<<<< HEAD
		while(true) {
			try {
		System.out.println("1.게시물 선택  2.돌아가기");
		System.out.print("선택 >");
		int ba = sc.nextInt();
			switch(ba) {
				case 1:
					System.out.print("보고싶은 번호 선택 \n>");
					int num = sc.nextInt();
					if(num != 'b') {
						System.out.println("제목 : " + st.get(num).title);
						System.out.println("내용 : " + st.get(num).substance);
					}
				case 2:
					return;
<<<<<<< HEAD
				default :
					System.out.println("[잘못 입력하셨습니다. 다시 입력해주세요]");
					break;
=======
>>>>>>> parent of 7070b75 (000)
			} break;
		} catch (InputMismatchException e) {
			if(e instanceof InputMismatchException)
				sc=new Scanner(System.in);
			System.out.println("[숫자만 입력 가능합니다] \n");
		} catch (IndexOutOfBoundsException e) {
			if(e instanceof IndexOutOfBoundsException)
				sc=new Scanner(System.in);
			System.out.println("[존재하지 않는 게시물 번호입니다.]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	}

	public void delBoard() {
			System.out.print("삭제 번호 입력 \n>");
			try {
			int m = sc.nextInt();
			System.out.println("정말 삭제 하시겠습니까?");
			System.out.println("1.삭제 2.돌아가기");
			System.out.print(">");
			int del = sc.nextInt();
			if(del == 1) {
			MessageBoard ab = st.remove(m); 
			System.out.println("\n[삭제되었습니다]\n");
			return;
			}else if(del ==2) {
			return ;
			}
		} catch (IndexOutOfBoundsException e) {
			if(e instanceof IndexOutOfBoundsException)
				sc = new Scanner(System.in);
				System.out.println("[존재하지 않는 게시물 번호입니다.]\n");
		} catch (InputMismatchException e) {
			if(e instanceof InputMismatchException)
				sc = new Scanner(System.in);
				System.out.println("[숫자만 입력 가능합니다] \n");
		} catch (Exception e) {
			e.printStackTrace();
		}
=======
		for(int n=0; n<messageNum; n++) {
			System.out.println("번호 " + n + " 제목 : " + board[n].title);
			}
		System.out.print("선택 > ");
		int num = sc.nextInt();
			System.out.println("제목 : " + board[num].title);
			System.out.println("내용 : " + board[num].substance);
>>>>>>> parent of 653c658 (123)
	}
	
}
// 테스트
// 테스트2