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
		for(int n=0; n<messageNum; n++) {
			System.out.println("번호 " + n + " 제목 : " + board[n].title);
			}
		System.out.print("선택 > ");
		int num = sc.nextInt();
			System.out.println("제목 : " + board[num].title);
			System.out.println("내용 : " + board[num].substance);
	}
	
}
// 테스트
// 테스트2