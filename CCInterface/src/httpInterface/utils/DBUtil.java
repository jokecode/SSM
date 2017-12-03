package httpInterface.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// sqlserver 驱动  
    private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
      
    // 数据库地址url 前面的为固定写法，后面的分别为ip地址：端口号,数据库名  
    //  private static final String SQLSERVER_URL = "jdbc:microsoft:sqlserver://localhost:1433;databaseName=WM";  //用微软的jar包（3个）的情况  
    private static final String SQLSERVER_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=NewMedicineDatabase";  //用普通jar包（1个）的时候  
      
    private static final String SQLSERVER_USERNAME = "sa";// sqlserver 数据库用户名  
    private static final String SQLSERVER_PASSWORD = "1qazxsw2";// sqlserver 数据库密码  
  
    /** 
     * 获取SQLSERVER数据库连接 
     * @return 数据库的连接 
     */  
    public static Connection getSQLSERVERConnection() {  
  
        Connection conn = null;  
        try {  
            //自动创建驱动程序的实例且自动调用DriverManager来注册它  
            Class.forName(SQLSERVER_DRIVER);  
            conn = DriverManager.getConnection(SQLSERVER_URL, SQLSERVER_USERNAME, SQLSERVER_PASSWORD);  
            System.out.println(conn);  
        } catch (ClassNotFoundException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        return conn;  
    }  
	
}
