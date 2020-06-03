package com.gui.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gui.util.JDBCUtil;

public class Update {
	
	public static void update(Connection conn,String sql,Object...args){
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			
			for(int i = 0;i < args.length;i++) {
				state.setObject(i + 1, args[i]);
			}
			
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(null, state);
		}
	}

}
