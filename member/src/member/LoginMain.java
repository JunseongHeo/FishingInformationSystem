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
            	while(true) {
            		if (!program.loginFlag) {
                        System.out.println("���� ����� �α����� �ʿ��մϴ�.");
                        main(args);
                        return;
                    }
            			
            			System.out.println("1.�۾��� 2.�Խñ� ���� 3.���� 4.���ư���");
            			int k = input.nextInt();
            		switch(k) {
            		case 1:
            			message.writ();
            			break;				
            		case 2:
            			message.showBoard();
            			break;
            		case 3:
            			message.delBoard();
            			break;
            		case 4:
            			main(args);
            			break;
            		default:
                        System.out.println("�ٽ��Է��ϼ���.");
                        break;	
            		}
            	}
            	
            case '9':    
                System.exit(0);
            default:
                System.out.println("�ٽ��Է��ϼ���.");
                break;
            }
        }
 
    }

}


