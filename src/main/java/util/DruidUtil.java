package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/*
 * 数据库连接池工具
 * @author SHE
 */
public class DruidUtil {
	private static DataSource ds;
	static {
		// 1  --加载配置文件信息
		Properties ps = new Properties();   //  Map<Object,Object>
		// 2  --建立到配置文件的流
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		// 3  --读取配置文件这个数据
		try {
			ps.load(in);  // --简单的读取配置文件的信息
			
			// 4  -- 通过配置信息建立数据源对象DataSource(其实就是连接池对象)
			ds = DruidDataSourceFactory.createDataSource(ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * 获取连接的方法
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} // 通过连接池获取连接对象
		return con;
	}
	public static void close(Statement stat,Connection con) {
		if(stat!=null)
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void close(ResultSet rs,Statement stat,Connection con) {
		if(stat!=null)
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
