package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Mcode;

public class McodeDAO {
	public static Mcode findBygender(String gender) throws SQLException {
		 Mcode mcode = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("select detail_name From m_code where divide_code = 'gender' AND detail_code = ?");
	        preparedStatement.setString(1, gender);
	        

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	mcode = new Mcode();
	        	mcode.setGender(rs.getString("detail_name"));
	        	
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return mcode;
	        
	    }
	
	public static Mcode findByrquest_course(String rquestcourse) throws SQLException {
		 Mcode mcode = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("select detail_name From m_code where divide_code = 'request_course' AND detail_code = ?");
	        preparedStatement.setString(1, rquestcourse);
	        

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	mcode = new Mcode();
	        	mcode.setRequestCource(rs.getString("detail_name"));
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return mcode;
	        
	    }
	public static Mcode findByavailable(int rquestcourse) throws SQLException {
		 Mcode mcode = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("select detail_name From m_code where divide_code = 'available' AND detail_code = ?");
	        preparedStatement.setInt(1, rquestcourse);
	        

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	mcode = new Mcode();
	        	mcode.setAvailable(rs.getString("detail_name"));
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return mcode;
	        
	    }
	
	
	

}
