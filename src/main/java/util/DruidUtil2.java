package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 利用线程池来实现连接池的连接
 */
public class DruidUtil2 {
	//  创建一个线程池的属性，其实他就是一个Map，Key存储线程ID。value放连接对象
	private static ThreadLocal<Connection> threadPool = new ThreadLocal<>();
	
	private static DataSource ds;  //  数据源对象（连接池）
	
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
	
	
	public static Connection getConnection() {
		//  如果线程池中拿不到连接，就新创建一个连接，从线程池中取连接
		if(threadPool.get()==null) {
			
			try {
				Connection con = ds.getConnection();
				con.setAutoCommit(false);
				threadPool.set(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return threadPool.get();
	}
	
	public static void close(Statement stmt,Connection con) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			threadPool.remove();
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close() {
		if(threadPool.get()!=null) {
			try {
				threadPool.get().commit();
				threadPool.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadPool.remove();
		}
	}
	
	
}
