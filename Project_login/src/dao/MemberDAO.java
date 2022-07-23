package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Context context;
	private ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
	
	public MemberDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + "jdbc/dbconn");
			conn = dataSource.getConnection();
			System.out.println("DBCP에 있는 커넥션 겍체 얻어오기 성공");
			System.out.println("스레드 명 : " + Thread.currentThread().getName());
		} catch (Exception e) {e.printStackTrace();}
	}
	public ArrayList<MemberDTO> memberList(){
		
		try {
			String sql = "select * from MemberDTO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("userName");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String email = rs.getNString("email");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(username, id, pw, phone1, phone2, phone3, email, address, gender);
				dtos.add(dto);
		}

		System.out.println("DB에 있는 데이터 가져오기 성공");
		System.out.println("스레드 명 : " + Thread.currentThread().getName());
		} catch (Exception e) { e.printStackTrace(); }

		return dtos;
	}
	public void addMember(MemberDTO dto) {
		
		int n = 0;
		try {
		String sql = "insert into MemberDTO values (?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPw());
		pstmt.setString(4, dto.getPhone1());    
		pstmt.setString(5, dto.getPhone2());
		pstmt.setString(6, dto.getPhone3());
		pstmt.setString(7, dto.getEmail());
		pstmt.setString(8, dto.getAddress());
		pstmt.setString(9, dto.getGender());
		
		n = pstmt.executeUpdate();
		System.out.println("삽입 갯수 : " + n);
		
		dtos.add(dto);
		
		}catch (Exception e) {e.printStackTrace();}
		
		System.out.println("addMember OK");
	}
	
	public int login(String id, String pw) {
		String sql = "SELECT * from MemberDTO where id=? and pw =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.getString("username");
				if(rs.getString(1).equals(rs.getString(2))) { 
					return 1 ;
					}
				else { 
					return 0;}
			}
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	public MemberDTO getMember(String id) {
		MemberDTO dto = null;
		try {
			String sql = "SELECT * from MemberDTO where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setUsername("username");
				dto.setId("id");
				dto.setPw("pw");
				dto.setPhone1("phone1");
				dto.setPhone2("phone2");
				dto.setPhone3("phone3");
				dto.setEmail("email");
				dto.setAddress("address");
				dto.setGender("gender");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
			}catch (Exception e) { e.printStackTrace();		}
		}
		return dto;
	}
	
}
