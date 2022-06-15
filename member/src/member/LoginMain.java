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
	            	case '1': //<�α���>
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
	            	case '2': // <ȸ������>
	            		program.Join();
	            		break;
	            	case '3': // <�α׾ƿ�>
	            		program.logout();
	            		break;
	            	case '4': // <�����˻�>
	            		program.searchData();
	            		break;
	            	case 'a': case 'A': // <IDã��>
	            		program.findId();
	            		break;
	            	case 'b': case 'B': // <PWã��>
		            	program.findPw();
		            	break;
	            	case '5': //<�Խ���>
	            		while(true) {
	            			if (!program.loginFlag) {
		                        System.out.println("[���� ����� �α����� �ʿ��մϴ�]\n");
		                        main(args);
//		                        return;
	            			}
	            		try {	
	            			System.out.println("1.�۾���  2.�Խñ� ����  3.����  4.���ư���");
	            			int k = input.nextInt();
	            			switch(k) { // <k = �Խ��� ���� ����>
	            				case 1: // <�۾���>
			            			message.writ();
			            			break;				
	            				case 2: // <�Խñ� ����>
			            			if(message.st.size()!=0) {
			            			message.showBoard();
			            			break;
			            			}else {
			            				System.out.println("[�Խù��� �����ϴ�]");
			            				break;
			            			}
	            				case 3: // <����>
			            			message.delBoard();
			            			break;
	            				case 4:	// <���ư���>
			            			main(args);
			            			break;
	            				default: 
			                        System.out.println("[�ٽ��Է��ϼ���]\n");
			                        break;	
			            		}
		            		}catch(InputMismatchException e) {
		            			input = new Scanner(System.in);
		        				System.out.println("[���ڸ� �Է� �����մϴ�] ");
		            		}catch (Exception e) {
		            			e.printStackTrace();
		            		}
	            		}
            	
		            case '9': //<���α׷� ����>
		                System.out.println(">>> ���α׷��� ����Ǿ����ϴ�.");
		                System.exit(0);
		            default:
		                System.out.println("[�ٽ��Է��ϼ���]");
		                break;
		            	}
			       } catch (StringIndexOutOfBoundsException e) {
			        	if(e instanceof StringIndexOutOfBoundsException)
			        		input = new Scanner(System.in);
			        			System.out.println("[���� �� ���͸� �����ּ���]");
			       } catch (Exception e) {
			        	e.printStackTrace();
			       }
       
		        }
			}
		}