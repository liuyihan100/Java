package com.gui.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.gui.util.JDBCUtil;

public class Update {
	
	@Test
	public void update(){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			//1、建立连接
			conn = JDBCUtil.getConnection();
			//2、预编译sql语句，返回preparedStatement实例
			String sql = "update employees set last_name = ? where last_name = ?";
			state = conn.prepareStatement(sql);
			//3、填充占位符
			state.setString(1, "帅");
			state.setString(2, "刘");
			//4、执行语句
			state.execute();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			//5、关闭资源
			JDBCUtil.closeSource(conn, state);
		}
	}
}
