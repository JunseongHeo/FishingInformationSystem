package member;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class MessageBoard extends LoginProgram {

	static private String title, substance;
	static private int col_num;
	ArrayList<MessageBoard> st = new ArrayList<MessageBoard>();
	int messageNum=0;
	
	public MessageBoard(int col_num, String newTitle, String newSub) {
		this.col_num = col_num;
		this.title = newTitle;
		this.substance = newSub;
	}
	public MessageBoard() {
	}
	public int getCol_num() {
		return col_num;
	}
	public int setCol_num(int col_num) {
		return this.col_num = col_num;
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
			System.out.print("번호 \n>");
			int newCol_num = INPUT.inputInt();
			System.out.print("제목 \n>");
			String newTitle = INPUT.input();
			System.out.print("내용 \n>");
			String newSub = INPUT.input();
			
			st.add(messageNum++, new MessageBoard(newCol_num, newTitle, newSub));	
			
		   try {
    			Class.forName(driver);
    		
    			conn = DriverManager.getConnection(url, user, pwd);
    			
    			String query="insert into mboard VALUES(?, ?, ?)";
    			
    			ppst=conn.prepareStatement(query);
    			
    			ppst.setInt(1, getCol_num());
    			ppst.setString(2, getTitle());
    			ppst.setString(3, getSubstance());
 			
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
			
	}
	public void showBoard() {
		while(true) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, pwd);
				
				String sql = "select * from mboard";
				ppst = conn.prepareStatement(sql);
				rs = ppst.executeQuery();
				
				while(rs.next()) {
					System.out.println("----------------------");
					System.out.println("게시글 번호 : "+rs.getString("col_num"));
					System.out.println("게시글 제목 : "+rs.getString("title"));
					System.out.println("게시글 내용 : "+rs.getString("substance"));
				} break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void delBoard() {
		try {
			showBoard();
			
			int resultCnt = 0;
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			String sql = "delete from mboard where col_num=?";
			ppst = conn.prepareStatement(sql);
			
			System.out.print("삭제할 게시글 번호 입력 >");
			String string = INPUT.input();
			ppst.setString(1, string);
			resultCnt = ppst.executeUpdate();
			
			System.out.println("삭제가 완료되었습니다.");
			
			ppst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
