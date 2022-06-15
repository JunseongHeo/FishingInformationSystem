package member;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        LoginProgram program = new LoginProgram();
        MessageBoard message = new MessageBoard();
        while (true) {
        	try {
	            char select = program.display();
	            switch (select) {
	            	case '1': //<로그인>
	            		program.loginVaild();
	            		if (LoginProgram.loginFlag) {
	                    break;
	            		}
		                System.out.print("ID :");
		                String myId = input.nextLine();
		                program.setId(myId);
		                System.out.print("PW : ");
		                String myPw = input.nextLine();
		                program.setPassword(myPw);
		                program.isMemberCheck(program.getId(), program.getPassword());
		                break;
	            	case '2': // <회원가입>
	            		program.Join();
	            		break;
	            	case '3': // <로그아웃>
	            		program.logout();
	            		break;
	            	case '4': // <정보검색>
	            		program.searchData();
	            		break;
	            	case 'a': case 'A': // <ID찾기>
	            		program.findId();
	            		break;
	            	case 'b': case 'B': // <PW찾기>
		            	program.findPw();
		            	break;
	            	case '5': //<게시판>
	            		while(true) {
	            			if (!program.loginFlag) {
		                        System.out.println("[먼저 사용자 로그인이 필요합니다]\n");
		                        main(args);
//		                        return;
	            			}
	            		try {	
	            			System.out.println("1.글쓰기  2.게시글 보기  3.삭제  4.돌아가기");
	            			int k = input.nextInt();
	            			switch(k) { // <k = 게시판 메인 선택>
	            				case 1: // <글쓰기>
			            			message.writ();
			            			break;				
	            				case 2: // <게시글 보기>
			            			if(message.st.size()!=0) {
			            			message.showBoard();
			            			break;
			            			}else {
			            				System.out.println("[게시물이 없습니다]");
			            				break;
			            			}
	            				case 3: // <삭제>
			            			message.delBoard();
			            			break;
	            				case 4:	// <돌아가기>
			            			main(args);
			            			break;
	            				default: 
			                        System.out.println("[다시입력하세요]\n");
			                        break;	
			            		}
		            		}catch(InputMismatchException e) {
		            			input = new Scanner(System.in);
		        				System.out.println("[숫자만 입력 가능합니다] ");
		            		}catch (Exception e) {
		            			e.printStackTrace();
		            		}
	            		}
            	
		            case '9': //<프로그램 종료>
		                System.out.println(">>> 프로그램이 종료되었습니다.");
		                System.exit(0);
		            default:
		                System.out.println("[다시입력하세요]");
		                break;
		            	}
			       } catch (StringIndexOutOfBoundsException e) {
			        	if(e instanceof StringIndexOutOfBoundsException)
			        		input = new Scanner(System.in);
			        			System.out.println("[선택 후 엔터를 눌러주세요]");
			       } catch (Exception e) {
			        	e.printStackTrace();
			       }
       
		        }
			}
		}