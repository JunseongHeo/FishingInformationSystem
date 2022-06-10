package member;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        LoginProgram program = new LoginProgram();
        MessageBoard message = new MessageBoard();
        while (true) {
            char select = program.display();
            
            switch (select) {
            case '1':
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
            case '2':
                program.Join();
                break;
            case '3':
                program.logout();
                break;
            case '4':
            	program.searchData();
            	break;
            case 'a':
            case 'A':
            	program.findId();
            	break;
            case 'b':
            case 'B':
            	program.findPw();
            	break;
            case '5':
            	while(true) {
            		if (!program.loginFlag) {
                        System.out.println("먼저 사용자 로그인이 필요합니다.");
                        main(args);
                        return;
                    }
            		try {	
            			System.out.println("1.글쓰기 2.게시글 보기 3.삭제 4.돌아가기");
            			int k = input.nextInt();
            		switch(k) {
            		case 1:
            			message.writ();
            			break;				
            		case 2:
            			if(message.st.size()!=0) {
            			message.showBoard();
            			break;
            			}else {
            				System.out.println("게시물이 없습니다.");
            				break;
            			}
            		case 3:
            			message.delBoard();
            			break;
            		case 4:
            			main(args);
            			break;
            		default:
                        System.out.println("다시입력하세요.");
                        break;	
            		}
            		}catch(InputMismatchException e) {
            			input = new Scanner(System.in);
        				System.out.println("숫자만 입력 가능합니다 \n");
            		}catch (Exception e) {
            			e.printStackTrace();
            		}
            	}
            	
            case '9':    
                System.exit(0);
            default:
                System.out.println("다시입력하세요.");
                break;
            }
        }
 
    }

}


