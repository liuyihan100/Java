package com.gui.jia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.gui.util.JDBCUtil;

public class Batch {
	
	public static void main(String[] args) {
		play();
	}
	
	public static void play(){
		Connection conn = null;
		PreparedStatement state = null;
		
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into test(name) values(?)";
			state = conn.prepareStatement(sql);
			
			conn.setAutoCommit(false);
			long begin = System.currentTimeMillis();
			for(int i = 1;i <= 20000;i++) {
				state.setObject(1, "name_" + i);
				//state.execute();
				state.addBatch();
				if(i % 500 == 0) {
					state.executeBatch();
					state.clearBatch();
				}
			}
			
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeSource(conn, state);
		}
	}
}
