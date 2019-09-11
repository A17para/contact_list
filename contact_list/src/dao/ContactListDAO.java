package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contract;
public class ContactListDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/contact";
	private final String DB_USER = "root";
	private final String DB_PASS = "test0716";

	public List<Contract> findAll(){
		Connection conn = null;
		List<Contract> list = new ArrayList<Contract>();
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//SELECT文の準備
			String sql = "SELECT * FROM contact_list";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String companyName = rs.getString("company_name");
				String tel = rs.getString("tel");
				String mailAddress = rs.getString("mail_address");
				Contract listDate = new Contract(id,firstName,lastName,companyName,tel,mailAddress);
				list.add(listDate);
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			//db切断
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}

	public boolean create (Contract contactList){
		Connection conn = null;
		try{
			//db接続
			conn = DriverManager.getConnection(
					JDBC_URL,DB_USER,DB_PASS);

			//INSERT文の準備(idは自動連番なので指定しなくていい）
			String sql = "INSERT INTO contact_list(first_name,last_name,company_name,tel,mail_address) VALUE (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文中の「？」に使用する値を設定してSQlを完成
			pStmt.setString(1, contactList.getFirst_name());
			pStmt.setString(2, contactList.getLast_name());
			pStmt.setString(3, contactList.getCompany_name());
			pStmt.setString(4, contactList.getTel());
			pStmt.setString(5, contactList.getMail_address());

			//INSERT文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
		//DB切断
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		}
		return true;
	}



	public List<Contract> findCheckedDate(int key){
		Connection conn = null;
		List<Contract> list = new ArrayList<Contract>();
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//SELECT文の準備
			String sql = "SELECT * FROM contact_list WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, key);
			//SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String companyName = rs.getString("company_name");
				String tel = rs.getString("tel");
				String mailAddress = rs.getString("mail_address");
				Contract listDate = new Contract(id,firstName,lastName,companyName,tel,mailAddress);
				list.add(listDate);
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			//db切断
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}

	public boolean update (Contract contactList){
		Connection conn = null;
		try{
			//db接続
			conn = DriverManager.getConnection(
					JDBC_URL,DB_USER,DB_PASS);

			//UPDATE文の準備(idは自動連番なので指定しなくていい）
			String sql =  "UPDATE contact_list SET first_name = ? ,last_name = ? ,company_name = ? , tel = ? , mail_address = ? WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文中の「？」に使用する値を設定してSQlを完成
			pStmt.setString(1, contactList.getFirst_name());
			pStmt.setString(2, contactList.getLast_name());
			pStmt.setString(3, contactList.getCompany_name());
			pStmt.setString(4, contactList.getTel());
			pStmt.setString(5, contactList.getMail_address());
			pStmt.setInt(6, contactList.getId());

			//UPDATE文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
		//DB切断
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		}
		return true;
	}



public boolean delete (int[] id){
	Connection conn = null;
	try{
		//db接続
		conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS);

		//DELETE文の準備(idは自動連番なので指定しなくていい）
		String sql = "DELETE FROM contact_list WHERE id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

//		拡張forで要素ごとにsql文を実行する。
		for (int id_val :id){
			//DELETE文中の「？」に使用する値を設定してSQlを完成
			pStmt.setInt(1, id_val);
			//DELETE文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}finally{
	//DB切断
	if(conn != null) {
		try {
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	}
	return true;
}



}