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
		
			System.out.print("제목 \n>");
			String newTitle = input();
			
			System.out.print("내용 \n>");
			String newSub = input();
			
			st.add(messageNum++, new MessageBoard(newTitle, newSub));								
	}
	
	public void showBoard() {
		for(int n=0; n<st.size(); n++) {
			System.out.println("번호: " + n + "내용: " + st.get(n).title);
		}
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
				default :
					System.out.println("[잘못 입력하셨습니다. 다시 입력해주세요]");
					break;
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
			if(m <= st.size()-1) {
			System.out.println("정말 삭제 하시겠습니까?");
			System.out.println("1.삭제 2.돌아가기");
			System.out.print(">");
			}else {
				System.out.println("[존재하지 않는 게시물 번호입니다.]\n");
				return;
			}
			
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
	}
}
