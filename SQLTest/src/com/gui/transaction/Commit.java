package com.gui.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.gui.util.JDBCUtil;

public class Commit {
	
	@Test
	public void updateWithTx(){
		
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			conn.setAutoCommit(false);
			
			String sql1 = "update salary set count = count - 100 where name = ?";
			Update.update(conn, sql1, "������");
			
			//System.out.println(10 / 0);
			
			String sql2 = "update salary set count = count + 100 where name = ?";
			Update.update(conn, sql2, "���˺�");
			
			System.out.println("ת�˳ɹ���");
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("�ع�");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.closeSource(conn, null);
		}
	}
}
