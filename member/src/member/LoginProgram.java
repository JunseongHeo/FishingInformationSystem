package member;

import java.util.HashMap;
import java.util.Scanner;

public class LoginProgram {
	LoginProgram[] info = new LoginProgram[100];
	private String id, password, zone, birth, name, boatTime, boat, phone;
    
	int i=0;
    String boatNum = "1";
    static boolean loginFlag = false;
    HashMap<String,String> memberTable = new HashMap<String,String>();
   public LoginProgram(String newId, String newPwd, String newBir, String newZone, String newName, String boatTime, String newboat, String newPhone) {
		this.id = newId;
		this.password = newPwd;
		this.birth = newBir;
		this.zone = newZone;
		this.name = newName;
		this.boatTime = boatTime;
		this.boat = newboat;
		this.phone = newPhone;
	}
public LoginProgram() {
	
}
public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
       return name;
    }
    public void setName(String name) {
       this.name = name;
    }
    public void setZone(String zone) {
       this.zone = zone;
    }
    public String getZone() {
       return zone;
    }
    public void setBirth(String birth) {
       this.birth = birth;
    }
    public String getBirth() {
      return birth;
    }
    public void setBoat(String boat) {
       this.boat = boat;
    }
    public String getBoat() {
       return boat;
    }
    public String getPhone() {
    	return phone;
    }
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    //�޴� ��� �޼ҵ�
    public char display() {
    	System.out.println("�����ϼ���.");
        System.out.println("1.�α���   2.ȸ������   3.�α׾ƿ�   4.�˻�   5.�Խ���   9.����");
        System.out.println("A.���̵�ã�� B.���ã��");
        System.out.print(">>>");
        return input().charAt(0);
    }
    
    
    //�Է� �޼ҵ�
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    //ȸ������ �޼ҵ�
    public void Join() {
        if (loginFlag) {
            System.out.println("�ڵ��α׾ƿ��ϰ� ���ο� ȸ�������� �����մϴ�.");
            loginFlag = false;
        }
        while(true) {
           
            System.out.print("���� id \n>");
            String newId = input();
            if(memberTable.containsKey(newId)) {
                System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
                continue;
            }
            System.out.print("���� pw \n>");
            String newPwd = input();
            System.out.print("�̸� \n>");
            String newName = input();
            System.out.print("������� \n>");
            String newBir = input();
            System.out.print("�ڵ�����ȣ \n>");
            String newPhone = input();
            System.out.print("���� \n>");
            String newZone = input();
            System.out.print("��? \n1.�������ִ�. 2.����\n" );
            String newBoat = input();
            if(newBoat.equals(boatNum)) {
               System.out.print("�� ��밡���� �ð��� �����ּ���. \n>");
               boatTime = input();
            }
            info[i++] =new LoginProgram(newId, newPwd, newBir, newZone, newName, boatTime, newBoat, newPhone); 
            memberTable.put(newId, newPwd);
            break;
        }
        
        System.out.println("ȸ������ �Ϸ�");
    }
    //�α��� �޼ҵ�
    public void loginVaild() {
        if (loginFlag) {
            System.out.println("�̹� �α��εǾ� �ִ� �����Դϴ�.");
            return;
        }
    }    
        
        
    public void isMemberCheck(String id, String pw) {    
        if (memberTable.containsKey(id)) {
            if (!memberTable.get(id).equals(pw)) {
                System.out.println("��й�ȣ�� ���� �ʽ��ϴ�. \n�ٽ��Է����ּ���.");
            } else {
                System.out.println("�α��εǾ����ϴ�.");
                loginFlag = true;
            }
        } else {
            System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
        }
    }
    
    //�α׾ƿ� �޼ҵ�
    public void logout() {
        if (!loginFlag) {
            System.out.println("���� ����� �α����� �ʿ��մϴ�.");
            return;
        }
        System.out.println("�α׾ƿ� �մϴ�.");
        loginFlag = false;
    }
    public void showMemberInfo() {
    	System.out.println("���̵� : "+id);
        System.out.println("�̸� : "+name);
        System.out.println("������� : "+birth);
        System.out.println("�ڵ��� ��ȣ : "+phone);
        System.out.println("���� : "+zone);
        if(boat.equals(boatNum)) {
           System.out.println("�� �̿밡�� �ð� : "+ boatTime );
        }
     }
     public void searchData() {
        System.out.print("���̵� �Է��ϼ��� \n> ");
        String id = input();
        int dataIdx = search(id);
        if(dataIdx<0) {
           System.out.println("�ش� ���̵�� �������� �ʽ��ϴ�.");
        }else {
        	info[dataIdx].showMemberInfo();
           System.out.println("�����˻��� �Ϸ�Ǿ����ϴ�.");
        }
     }
        private int search(String id) {
           for(int idx=0; idx<i; idx++) {
        	   LoginProgram i = info[idx];
        	   if(id.compareTo(i.id)==0)
        		   return idx;
           }
           return -1;
        }
        public void findId() {
        	System.out.println("���̵� ã��");
        	System.out.print("�̸� \n>");
        	String findName = input();
        	System.out.print("������� \n>");
        	String findBir = input();
        	System.out.print("�޴��� ��ȣ \n>");
        	String findPhone = input();
        	for(int x=0; x<i; x++) {
        	LoginProgram i =info[x];
	        	if(i.name.compareTo(findName)==0 && i.birth.compareTo(findBir)==0 && i.phone.compareTo(findPhone)==0) {
	        		System.out.println("ã�� ���̵� : "+i.id);
	        		break;
	        	}
        	}
        	System.out.println("Ȯ�� �� �Է����ּ���"); // ��¹��� �ѹ��� ��� �ֵ��� ����
        
      }
        public void findPw() {
        	System.out.println("��� ã��");
        	System.out.print("���̵� \n>");
        	String findId = input();
        	System.out.print("�̸� \n>");
        	String findName = input();
        	System.out.print("������� \n>");
        	String findBir = input();
        	System.out.print("�޴��� ��ȣ \n>");
        	String findPhone = input();
        	for(int x=0; x<i; x++) {
        	LoginProgram i =info[x];
        	if(i.id.compareTo(findId)==0 && i.name.compareTo(findName)==0 && i.birth.compareTo(findBir)==0 && i.phone.compareTo(findPhone)==0) {
        		System.out.println("ã�� ��й�ȣ : "+i.password);
        	}else {System.out.println("Ȯ�� �� �ٽ� �Է����ּ���.");
        }
       } 
     }
        

 }
   


