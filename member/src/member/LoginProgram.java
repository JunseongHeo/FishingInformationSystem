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
    	System.out.println("[원하시는 메뉴를 선택해 주세요]");
        System.out.println("1.로그인   2.회원가입   3.로그아웃   4.검색   5.게시판   9.종료");
        System.out.println("A.아이디 찾기 B.비밀번호 찾기");
        System.out.print(">>");
        return INPUT.input().charAt(0);
    }
    public void Join() {
        if (loginFlag) {
            System.out.println("\n[자동 로그아웃 후 새로운 회원가입을 시작합니다.]\n");
            loginFlag = false;
        }
        while(true) {
            System.out.print("[회원가입] \nid \n>");
            String newId = INPUT.input();
            if(memberTable.containsKey(id)) {
                System.out.println("이미 존재하는 아이디 입니다.");
                continue;
            }
            System.out.print("pw \n>");
            String newPwd = INPUT.input();
            System.out.print("생년월일 \n>");
            String newBir = INPUT.input();
            System.out.print("지역 \n>");
            String newZone = INPUT.input();
            System.out.print("이름 \n>");
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
    			System.out.println("직접 DB로 쿼리 쏘기 성공");
    			
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
        
        System.out.println("[회원가입 완료]");
    }
   
    public void loginVaild() {
        if (loginFlag) {
            System.out.println("[이미 로그인되어 있는 상태입니다]");
            return;
        }
    }    
    public void isMemberCheck(String id, String pw) {    
        if (memberTable.containsKey(id)) {
            if (!memberTable.get(id).equals(pw)) {
                System.out.println("\n비밀번호가 맞지 않습니다. \n다시입력해주세요.\n");
            } else {
                System.out.println("[로그인되었습니다]");
                loginFlag = true;
            }
        } else {
            System.out.println("[존재하지 않는 아이디 입니다]\n");
        }
    }
    
    
    public void logout() {
        if (!loginFlag) {
            System.out.println("[먼저 사용자 로그인이 필요합니다]");
            return;
        }
        System.out.println("[로그아웃 합니다]");
        loginFlag = false;
    }
    public void showMemberInfo() {
    	try {
	    	Class.forName(driver);
	    	conn = DriverManager.getConnection(url, user, pwd);
	    	System.out.print("아이디를 입력하세요 \n> ");
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
    	    	
    	    	System.out.println("아이디 : "+searchId);
    	    	System.out.println("이름 : "+searchPwd);
    	    	System.out.println("생년월일 : "+searchBirth);
    	    	System.out.println("핸드폰 번호 : "+searchZone);
    	    	System.out.println("지역 : "+searchName);
       	    }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
     }
        public void findId() {
        	System.out.println("[아이디 찾기]");
        	System.out.print("이름 \n>");
        	String findName = INPUT.input();
        	System.out.print("생년월일 \n>");
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
           	    	System.out.println("[확인 후 입력해주세요]");
           	    }
         	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        public void findPw() {
        	System.out.println("[비밀번호 찾기]");
        	System.out.print("아이디 \n>");
        	String findId = INPUT.input();
        	System.out.print("이름 \n>");
        	String findName = INPUT.input();
        	System.out.print("생년월일 \n>");
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
           	    	System.out.println("[확인 후 입력해주세요]");
           	    }
    	    	
         	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
 }