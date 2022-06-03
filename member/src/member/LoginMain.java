package member;

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
            	message.displayBoard();
            case '9':    
                System.exit(0);
            default:
                System.out.println("다시입력하세요.");
                break;
            }
        }
 
    }

	}


