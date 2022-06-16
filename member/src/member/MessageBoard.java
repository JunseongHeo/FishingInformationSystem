package member;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
	
	public void writ() {
			System.out.print("제목 \n>");
			String newTitle = input();
			System.out.print("내용 \n>");
			String newSub = input();
			
			st.add(messageNum++, new MessageBoard(newTitle, newSub));		
	}
	
	public void showBoard() {
		for(int n = 0; n<messageNum; n++) {
			System.out.println(n + "제목: " + st.get(n).title);
		}
		while(true) {
			try {
				System.out.println("1.게시물 선택  2.돌아가기");
				System.out.print("선택 >");
				int ba = sc.nextInt(); //<ba = 1.게시물 선택 2.돌아가기 선택>
				switch(ba) {
					case 1:
						System.out.print("보고싶은 번호 선택 \n>");
						int num = sc.nextInt(); // <num = 사용자가 보고싶은 게시물 번호 선택>
						if(num != 'b') {
							System.out.println("제목 : " + st.get(num).title);
							System.out.println("내용 : " + st.get(num).substance);
						}else {
							return;
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
				System.out.println("[숫자만 입력 가능합니다]");
			} catch (IndexOutOfBoundsException e) {
				if(e instanceof IndexOutOfBoundsException)
					sc=new Scanner(System.in);
				System.out.println("[존재하지 않는 게시물 번호입니다.]");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delBoard() {
			System.out.print("삭제 번호 입력 \n>");
			try {
				int m = sc.nextInt();
				if(m <= st.size()-1) { // <m = 삭제 하고싶은 게시판 번호>
					System.out.println("정말 삭제 하시겠습니까?");
					System.out.println("1.삭제 2.돌아가기");
					System.out.print(">");
				}else {
					System.out.println("[존재하지 않는 게시물 번호입니다.]");
					return;
				}
				int del = sc.nextInt();
				if(del == 1) {	// <del = 1.삭제 2.돌아가기>
					MessageBoard ab = st.remove(m); 
					System.out.println("[삭제되었습니다]");
					return;
				}else if(del ==2) {
					return ;
				}
			} catch (IndexOutOfBoundsException e) {
				if(e instanceof IndexOutOfBoundsException)
					sc = new Scanner(System.in);
					System.out.println("[존재하지 않는 게시물 번호입니다.]");
			} catch (InputMismatchException e) {
				if(e instanceof InputMismatchException)
					sc = new Scanner(System.in);
					System.out.println("[숫자만 입력 가능합니다] ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
