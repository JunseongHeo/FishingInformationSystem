package member;

import java.util.HashMap;
import java.util.Scanner;
import java.sql.*;

public class LoginProgram {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="hr";
	String pwd="hr";
	
	Connection conn = null;
	Statement stmt;
	PreparedStatement ppst = null;
	ResultSet rs = null; 
	
	LoginProgram[] info = new LoginProgram[100];
	static private String id, password, zone, birth, name, boatTime, boat, phone;
    
	int i=0;
    String boatNum = "1";
    static boolean loginFlag = false;
    HashMap<String,String> memberTable = new HashMap<String,String>();
    public LoginProgram(String newId, String newPwd,  String newBir, String newZone, String newName) {
		this.id = newId;
		this.password = newPwd;
		this.birth = newBir;
		this.zone = newZone;
		this.name = newName;
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

    public char display() {
    	System.out.println("[���Ͻô� �޴��� ������ �ּ���]");
        System.out.println("1.�α���   2.ȸ������   3.�α׾ƿ�   4.�˻�   5.�Խ���   9.����");
        System.out.println("A.���̵� ã�� B.��й�ȣ ã��");
        System.out.print(">>");
        return INPUT.input().charAt(0);
    }
    public void Join() {
        if (loginFlag) {
            System.out.println("\n[�ڵ� �α׾ƿ� �� ���ο� ȸ�������� �����մϴ�.]\n");
            loginFlag = false;
        }
        while(true) {
            System.out.print("[ȸ������] \nid \n>");
            String newId = INPUT.input();
            if(memberTable.containsKey(id)) {
                System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
                continue;
            }
            System.out.print("pw \n>");
            String newPwd = INPUT.input();
            System.out.print("������� \n>");
            String newBir = INPUT.input();
            System.out.print("���� \n>");
            String newZone = INPUT.input();
            System.out.print("�̸� \n>");
            String newName = INPUT.input();

            info[i++] = new LoginProgram(newId, newPwd, newBir, newZone, newName);
            
            
            try {
    			Class.forName(driver);
    		
    			conn = DriverManager.getConnection(url, user, pwd);
    			
    			String query="insert into BOARD VALUES(?, ?, ?, ?, ?)";
    			
    			ppst=conn.prepareStatement(query);
    			
    			ppst.setString(1, getId());
    			ppst.setString(2, getPassword());
    			ppst.setString(3, getBirth());
    			ppst.setString(4, getZone());
    			ppst.setString(5, getName());
 			
    			ppst.executeUpdate();
    			System.out.println("���� DB�� ���� ��� ����");
    			
    			ppst.close();
    			conn.close();
   			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            memberTable.put(id, password);
            break;
        }
        
        System.out.println("[ȸ������ �Ϸ�]");
    }
   
    public void loginVaild() {
        if (loginFlag) {
            System.out.println("[�̹� �α��εǾ� �ִ� �����Դϴ�]");
            return;
        }
    }    
    public void isMemberCheck(String id, String pw) {    
        if (memberTable.containsKey(id)) {
            if (!memberTable.get(id).equals(pw)) {
                System.out.println("\n��й�ȣ�� ���� �ʽ��ϴ�. \n�ٽ��Է����ּ���.\n");
            } else {
                System.out.println("[�α��εǾ����ϴ�]");
                loginFlag = true;
            }
        } else {
            System.out.println("[�������� �ʴ� ���̵� �Դϴ�]\n");
        }
    }
    
    
    public void logout() {
        if (!loginFlag) {
            System.out.println("[���� ����� �α����� �ʿ��մϴ�]");
            return;
        }
        System.out.println("[�α׾ƿ� �մϴ�]");
        loginFlag = false;
    }
    public void showMemberInfo() {
    	try {
	    	Class.forName(driver);
	    	conn = DriverManager.getConnection(url, user, pwd);
	    	System.out.print("���̵� �Է��ϼ��� \n> ");
       	    String id = INPUT.input();
	    	
	    	String sql = ("select * from board where id=?");
	    	ppst = conn.prepareStatement(sql);

	    	ppst.setString(1, id);
	    	
       	    rs = ppst.executeQuery();
       	           	    
       	    while(rs.next()) {
    	    	String searchId = rs.getString("id");
    	    	String searchPwd = rs.getString("password");
    	    	String searchBirth = rs.getString("birth");
    	    	String searchZone = rs.getString("zone");
    	    	String searchName = rs.getString("name");
    	    	
    	    	System.out.println("���̵� : "+searchId);
    	    	System.out.println("�̸� : "+searchPwd);
    	    	System.out.println("������� : "+searchBirth);
    	    	System.out.println("�ڵ��� ��ȣ : "+searchZone);
    	    	System.out.println("���� : "+searchName);
       	    }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
     }
        public void findId() {
        	System.out.println("[���̵� ã��]");
        	System.out.print("�̸� \n>");
        	String findName = INPUT.input();
        	System.out.print("������� \n>");
        	String findBir = INPUT.input();
        	
          	try {
    	    	Class.forName(driver);
    	    	conn = DriverManager.getConnection(url, user, pwd);
    	    	
    	    	String sql = ("select * from board where name=? and birth=?");
    	    	ppst = conn.prepareStatement(sql);

    	    	ppst.setString(1, findName);
    	    	ppst.setString(2, findBir);
           	    rs = ppst.executeQuery();
           	    
           	    rs.next();
           	    
           	    String DbName = rs.getString("name");
           	    String DbBir = rs.getString("birth");
           	    
           	    if(findName.compareTo(DbName)==0 && findBir.compareTo(DbBir)==0) {
           	    	System.out.println(rs.getString("id"));
           	    }else {
           	    	System.out.println("[Ȯ�� �� �Է����ּ���]");
           	    }
         	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        public void findPw() {
        	System.out.println("[��й�ȣ ã��]");
        	System.out.print("���̵� \n>");
        	String findId = INPUT.input();
        	System.out.print("�̸� \n>");
        	String findName = INPUT.input();
        	System.out.print("������� \n>");
        	String findBir = INPUT.input();
        	
          	try {
    	    	Class.forName(driver);
    	    	conn = DriverManager.getConnection(url, user, pwd);
    	    	
    	    	String sql = ("select * from board where id=? and name=? and birth=?");
    	    	ppst = conn.prepareStatement(sql);

    	    	ppst.setString(1, findId);
    	    	ppst.setString(2, findName);
    	    	ppst.setString(3, findBir);
           	    rs = ppst.executeQuery();
           	    
           	    rs.next();
           	    
           	    String DbId = rs.getString("id");
           	    String DbName = rs.getString("name");
           	    String DbBir = rs.getString("birth");
           	    
           	    if(findId.compareTo(DbId)==0 && findName.compareTo(DbName)==0 && findBir.compareTo(DbBir)==0) {
           	    	System.out.println(rs.getString("password"));
           	    }else {
           	    	System.out.println("[Ȯ�� �� �Է����ּ���]");
           	    }
    	    	
         	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
 }