package WebDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WebCheck {
	
	public static int check (String name,String pwd){
		int count = -1;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from employees where employee_id = ? and email = ?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setObject(1, name);
			state.setObject(2, pwd);
			ResultSet rs = state.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
