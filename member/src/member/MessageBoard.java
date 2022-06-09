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
			System.out.println("1.글쓰기 2.게시글 보기 3.삭제");
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
            System.out.println("다시입력하세요.");
            break;
			
		}
	
	}
}
	public void writ() {
			System.out.print("제목 \n>");
			String newTitle = input();
			
			System.out.print("내용 \n>");
			String newSub = input();
			
			st.add(messageNum++, new MessageBoard(newTitle, newSub));
			
			
		
	}
	public void showBoard() {
		for(int n=0; n<st.size(); n++) {			
			System.out.println("번호 " + n + " 제목 : " + st.get(n).title);
			}
		System.out.println("돌아가기 = 00");
		System.out.print("선택 >");
		int num = sc.nextInt();
		if(num != 00) {
			System.out.println("제목 : " + st.get(num).title);
			System.out.println("내용 : " + st.get(num).substance);
		
		}
	}
	
	public void delBoard() {
		System.out.print("삭제 번호 입력 \n>");
		int m = sc.nextInt();
		System.out.println("정말 삭제 하시겠습니까?");
		System.out.println("1.삭제 2.돌아가기");
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
// 테스트