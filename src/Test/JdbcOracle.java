package Test;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class JdbcOracle {
	public static void main(String[] args) throws ParseException {
		Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			connect = DriverManager.getConnection("jdbc:oracle:thin:@10.39.101.174:1521:EEDB", "EXIMSYS", "EXIMSYS");
			
//			System.out.println(connect);
			
//			statement = connect.createStatement();
			
			PreparedStatement preState = connect.prepareStatement("SELECT *" + 
					"  FROM EXIMTRX.IAAC_ACCMASTERLAY" + 
					" WHERE C_UNIT_CODE = ?" + 
					"   AND (IA_D_LAST_ACCDATE = ? OR IA_D_LAST_ACCDATE < ?)" + 
					"   AND IA_C_STATUS_FLG <> ?" + 
					"   AND IA_C_STATUS_FLG <> ?" + 
					"   AND IA_C_STATUS_FLG <> ?" + 
					"   AND IA_C_STATUS_FLG <> ?" + 
					"   AND IA_C_POST_ARD_FLG <> ?" + 
					"   AND IA_C_STATUS_FLG <> ?");
			
//			preState.setObject(new java.sql.Date(((Date) param).getTime()));
			
			String string = "2009-01-15";
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date d = (Date) sdf.parse(string);
	        Date d2 = new java.sql.Date(((Date) d).getTime());
	        
	        System.out.println(d2);
	        
			preState.setObject(1, "CSBANK");
			preState.setObject(2, null);
			preState.setObject(3, new java.sql.Date(((Date) d).getTime()));
			preState.setObject(4, "F");
			preState.setObject(5, "C");
			preState.setObject(6, "S");
			preState.setObject(7, "R");
			preState.setObject(8, "A");
			preState.setObject(9, "V");
			
			resultSet = preState.executeQuery();
			while (resultSet.next())
            {
                String id = resultSet.getString("C_BK_GROUP_ID");
                String name = resultSet.getString("C_CNTY_CODE");
                String city = resultSet.getString("IA_C_ACCOUNT_TYPE");
                System.out.println(id+"   "+name+"   "+city);  //打印输出结果集
            }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if (resultSet!=null) resultSet.close();
                if (statement!=null) statement.close();
                if (connect!=null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
	}

}
