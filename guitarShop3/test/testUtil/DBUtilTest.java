package testUtil;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import db.DBUtil;

public class DBUtilTest {

	@Test
	public void test(){		
		try {
			Connection Conn = DBUtil.open();		
			String sql = "select count(*) from Guitar";
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			assertEquals(13,rs.getInt(1));
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
