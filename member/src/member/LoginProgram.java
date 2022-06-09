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
    
    //메뉴 출력 메소드
    public char display() {
    	System.out.println("선택하세요.");
        System.out.println("1.로그인   2.회원가입   3.로그아웃   4.검색   5.게시판   9.종료");
        System.out.println("A.아이디찾기 B.비번찾기");
        System.out.print(">>>");
        return input().charAt(0);
    }
    
    
    //입력 메소드
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    //회원가입 메소드
    public void Join() {
        if (loginFlag) {
            System.out.println("자동로그아웃하고 새로운 회원가입을 시작합니다.");
            loginFlag = false;
        }
        while(true) {
           
            System.out.print("가입 id \n>");
            String newId = input();
            if(memberTable.containsKey(newId)) {
                System.out.println("이미 존재하는 아이디 입니다.");
                continue;
            }
            System.out.print("가입 pw \n>");
            String newPwd = input();
            System.out.print("이름 \n>");
            String newName = input();
            System.out.print("생년월일 \n>");
            String newBir = input();
            System.out.print("핸드폰번호 \n>");
            String newPhone = input();
            System.out.print("지역 \n>");
            String newZone = input();
            System.out.print("배? \n1.가지고있다. 2.없다\n" );
            String newBoat = input();
            if(newBoat.equals(boatNum)) {
               System.out.print("배 사용가능한 시간을 적어주세요. \n>");
               boatTime = input();
            }
            info[i++] =new LoginProgram(newId, newPwd, newBir, newZone, newName, boatTime, newBoat, newPhone); 
            memberTable.put(newId, newPwd);
            break;
        }
        
        System.out.println("회원가입 완료");
    }
    //로그인 메소드
    public void loginVaild() {
        if (loginFlag) {
            System.out.println("이미 로그인되어 있는 상태입니다.");
            return;
        }
    }    
        
        
    public void isMemberCheck(String id, String pw) {    
        if (memberTable.containsKey(id)) {
            if (!memberTable.get(id).equals(pw)) {
                System.out.println("비밀번호가 맞지 않습니다. \n다시입력해주세요.");
            } else {
                System.out.println("로그인되었습니다.");
                loginFlag = true;
            }
        } else {
            System.out.println("존재하지 않는 아이디 입니다.");
        }
    }
    
    //로그아웃 메소드
    public void logout() {
        if (!loginFlag) {
            System.out.println("먼저 사용자 로그인이 필요합니다.");
            return;
        }
        System.out.println("로그아웃 합니다.");
        loginFlag = false;
    }
    public void showMemberInfo() {
    	System.out.println("아이디 : "+id);
        System.out.println("이름 : "+name);
        System.out.println("생년월일 : "+birth);
        System.out.println("핸드폰 번호 : "+phone);
        System.out.println("지역 : "+zone);
        if(boat.equals(boatNum)) {
           System.out.println("배 이용가능 시간 : "+ boatTime );
        }
     }
     public void searchData() {
        System.out.print("아이디를 입력하세요 \n> ");
        String id = input();
        int dataIdx = search(id);
        if(dataIdx<0) {
           System.out.println("해당 아이디는 존재하지 않습니다.");
        }else {
        	info[dataIdx].showMemberInfo();
           System.out.println("정보검색이 완료되었습니다.");
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
        	System.out.println("아이디 찾기");
        	System.out.print("이름 \n>");
        	String findName = input();
        	System.out.print("생년월일 \n>");
        	String findBir = input();
        	System.out.print("휴대폰 번호 \n>");
        	String findPhone = input();
        	for(int x=0; x<i; x++) {
        	LoginProgram i =info[x];
	        	if(i.name.compareTo(findName)==0 && i.birth.compareTo(findBir)==0 && i.phone.compareTo(findPhone)==0) {
	        		System.out.println("찾은 아이디 : "+i.id);
	        		break;
	        	}
        	}
        	System.out.println("확인 후 입력해주세요"); // 출력문구 한번만 뜰수 있도록 개선
        
      }
        public void findPw() {
        	System.out.println("비번 찾기");
        	System.out.print("아이디 \n>");
        	String findId = input();
        	System.out.print("이름 \n>");
        	String findName = input();
        	System.out.print("생년월일 \n>");
        	String findBir = input();
        	System.out.print("휴대폰 번호 \n>");
        	String findPhone = input();
        	for(int x=0; x<i; x++) {
        	LoginProgram i =info[x];
        	if(i.id.compareTo(findId)==0 && i.name.compareTo(findName)==0 && i.birth.compareTo(findBir)==0 && i.phone.compareTo(findPhone)==0) {
        		System.out.println("찾은 비밀번호 : "+i.password);
        	}else {System.out.println("확인 후 다시 입력해주세요.");
        }
       } 
     }
        

 }
   


