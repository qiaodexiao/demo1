package com.at.ct.web.test;

import com.at.ct.web.bean.ClyxMppResourceDO;
import com.at.ct.web.dao.ModelCenterMapper;
import com.alibaba.fastjson.JSON;
import com.at.ct.web.dao.ModelCenterMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component // 把普通类实例化到spring容器中
public class JDBCUtil {

	private static ModelCenterMapper smapper;

	@Autowired
	private ModelCenterMapper mapper;

	private static Integer count;
	private static Integer total = 0;

	private static ClyxMppResourceDO clyxMppResourceDO;

	/**
	 * 属性文件辅助类型
	 */
	//private static PropertiesHelper helper;

	//private static PropertiesHelper helperOracle;

	/**
	 * 日志管理对象
	 */
	private final static Logger log = LoggerFactory.getLogger(JDBCUtil.class);

	@PostConstruct
	public void init() {
		smapper = mapper;
	}

	// 加载配置
	//static {
//		helper = new PropertiesHelper("/xcloud-config.properties");
//		helperOracle = new PropertiesHelper("/application.yml");
//	}

	/**
	 * 获取sql执行对象
	 *
	 * @return sql执行对象
	 */
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		//TODO 目前写死总部"uni99",后续集成单点获取
		clyxMppResourceDO = smapper.queryDBConnParams("uni099");
//		clyxMppResourceDO = sModelDao.queryDBConnParams("uni076");
		Connection conDB = null;
		try {
//			Class.forName(helperOracle.getValue("spring.datasource.xcloud.driver-class-name"));
			Class.forName(clyxMppResourceDO.getDriver());
			// 创建连接
//			conDB = DriverManager.getConnection(helperOracle.getValue("spring.datasource.xcloud.url"), helperOracle.getValue("spring.datasource.xcloud.username"), helperOracle.getValue("spring.datasource.xcloud.password"));
			conDB = DriverManager.getConnection(clyxMppResourceDO.getUrl(),clyxMppResourceDO.getUserName(), clyxMppResourceDO.getPassword());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return conDB;
	}

	/**
	 * 获取sql执行对象
	 *
	 * @return sql执行对象
	 */
	private static Connection getConnection(String provinceCode) throws ClassNotFoundException, SQLException {
		System.out.println("**********************************");
//		System.out.println(ClyxUtils.findCurrentTenantId());
		System.out.println("**********************************");
//		clyxMppResourceDO = sModelDao.queryDBConnParams(ClyxUtils.findCurrentTenantId());
		clyxMppResourceDO = smapper.queryDBConnParams(provinceCode);
		//clyxMppResourceDO = sModelDao.queryDBConnParams("uni076");
		Connection conDB = null;
		try {
//			Class.forName(helperOracle.getValue("spring.datasource.xcloud.driver-class-name"));
			Class.forName(clyxMppResourceDO.getDriver());
			// 创建连接
//			conDB = DriverManager.getConnection(helperOracle.getValue("spring.datasource.xcloud.url"), helperOracle.getValue("spring.datasource.xcloud.username"), helperOracle.getValue("spring.datasource.xcloud.password"));
			conDB = DriverManager.getConnection(clyxMppResourceDO.getUrl(),clyxMppResourceDO.getUserName(), clyxMppResourceDO.getPassword());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return conDB;
	}

	/**
	 * 获取sql执行对象
	 *
	 * @return sql执行对象
	 */
	private static Connection getConnection1(String orderUrl,String orderUserName,String orderPassword) throws ClassNotFoundException, SQLException {
		Connection conDB = null;
		try {
//			Class.forName(helperOracle.getValue("spring.datasource.xcloud.driver-class-name"));
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接
//			conDB = DriverManager.getConnection(helperOracle.getValue("spring.datasource.xcloud.url"), helperOracle.getValue("spring.datasource.xcloud.username"), helperOracle.getValue("spring.datasource.xcloud.password"));
			conDB = DriverManager.getConnection(orderUrl,orderUserName,orderPassword);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return conDB;
	}

	/**
	 * 获取行云驱动版本
	 */
	public static String getDriverVersion(String provinceCode){
		Connection conn = null;
		String version = "";
		try {
			conn = JDBCUtil.getConnection(provinceCode);
			version = conn.getMetaData().getDriverVersion();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(conn);
		}
		return version;
	}

	/**
	 * 获取sql执行对象
	 *
	 * @return sql执行对象
	 */
	//private static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
	//	Connection conDB = null;
	//	try {
	//		Class.forName("oracle.jdbc.driver.OracleDriver");
	//
	//		// 创建连接
	//		conDB = DriverManager.getConnection(helperOracle.getValue("spring.datasource.oracle.url"), helperOracle.getValue("spring.datasource.oracle.username"), helperOracle.getValue("spring.datasource.oracle.password"));
	//
	//	} catch (Exception e) {
	//
	//		e.printStackTrace();
	//	}
	//
	//	return conDB;
	//}

	// flag 1代表去重 0代表不去冲
	//public static Map<String, Object> saveBatch(String sql, List<String> list, int flag) {
	//	count = 0;
	//	total = list.size();
	//	Connection conn = null;
	//	PreparedStatement pstmt = null;
	//	long start = System.currentTimeMillis();
	//	try {
	//		conn = getOracleConnection();
	//		conn.setAutoCommit(false);
	//		pstmt = conn.prepareStatement(sql);
	//		Collection<String> coll = null;
	//		if (flag == 1) {
	//			Set<String> set = new HashSet<String>();
	//			set.addAll(list);
	//			coll = set;
	//		} else {
	//			coll = list;
	//		}
	//		if (list != null) {
	//			for (String str : coll) {
	//				if (StringUtils.isNotEmpty(str)) {
	//					String[] split = str.split(",");
	//					if (split != null) {
	//						for (String string : split) {
	//							pstmt.setString(1, string.trim());
	//							pstmt.addBatch();
	//							count++;
	//						}
	//					}
	//				}
	//				if (count % 10000 == 0) {
	//					pstmt.executeBatch();
	//					conn.commit();
	//				}
	//			}
	//		}
	//		pstmt.executeBatch();
	//		conn.commit();
	//		System.err.println(System.currentTimeMillis() - start);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	} finally {
	//		closeStmt(pstmt);
	//		closeConn(conn);
	//	}
	//	Map<String, Object> map = new HashMap<String, Object>();
	//	return map;
	//}

	public static Map<String, Object> saveBatch(Connection conn, String sql, List<String> list) {
		total = 0;
		count = list.size();
		Map<String, Object> map = new HashMap<String, Object>();
		PreparedStatement pstmt = null;
		int total = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if (list != null) {

				for (String str : list) {
					if (StringUtils.isNotEmpty(str)) {
						String[] split = str.split(",");
						if (split != null) {
							for (String string : split) {
								pstmt.setString(1, string.trim());
							}
						}
					}
				}
				pstmt.executeUpdate();
				total++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		map.put("total", total);
		return map;
	}

	public static Map<String, Object> saveBatch(String sql, List<String> list, String provinceCode) {
		total = 0;
		count = list.size();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection(provinceCode);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			if (list != null) {
				for (String str : list) {
					if (StringUtils.isNotEmpty(str)) {
						String[] split = str.split(",");
						if (split != null) {
							for (String string : split) {
								pstmt.setString(1, string.trim());
								pstmt.executeUpdate();
								total++;
							}
						}
					}
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return map;
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStmt(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static float getInsertPercent() {
		if (count != null) {
			return (float) total / count;
		} else {
			return 0;
		}
	}

	/**
	 * 执行xcloud中的查询数量sql
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> queryExecuteCountSQL(String noTransactionSQL, String provinceCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		String errorCode = "0";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long total = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				total = (Long) rs.getObject(1);
				map.put("total", total);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode = "1";
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		map.put("errorCode", errorCode);
		return map;
	};

	/**
	 * 批量插入
	 *
	 * @param transactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static String saveExecuteSQL(String transactionSQL, String provinceCode) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = getConnection(provinceCode);
			statement = conn.createStatement();
			statement.execute(transactionSQL);
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		} finally {
			closeStmt(statement);
			closeConn(conn);
		}
		return "0";
	};

	/**
	 * 建表
	 *
	 * @param tableName
	 *            表名
	 * @param columns
	 *            列名，格式如(fieldName varchar(500))
	 * @return
	 */
	public static String createTable(String tableName, String columns, String provinceCode) {
		String sql = "CREATE table " + tableName + "  " + columns;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("建表成功");
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return "0";
	}

	/**
	 * 建表
	 * @return
	 */
	public static String insertCodeTable(String tableName, String codeValue,String codeName, String provinceCode) {
		String sql = "INSERT into " + tableName + " select '"+codeValue+"','"+codeName+"' from dual";
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("成功插入码表数据");
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return "0";
	}

	/**
	 * 清空表
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static void truncateTable(String tableName, String provinceCode) {
		String sql = "truncate table " + tableName;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("清空表成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
	}

	/**
	 * 删表
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static void deleteTable(String tableName, String provinceCode) {
		String sql = "drop table " + tableName;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("删表成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
	}

	/**
	 * 表是否存在
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static boolean existTable(String tableName, String provinceCode) {
		String sql = "select 1 from " + tableName + " limit (0, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean exist;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			exist = true;
//			log.info("该表存在");
		} catch (Exception e) {
			exist = false;
//			e.printStackTrace();
//			return false;
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return exist;
	}

	/**
	 * 导出表数据到文件
	 *
	 * @param sqlText
	 *            sql语句
	 * @param filePath
	 *            文件存放路径
	 * @param fileName
	 *            文件名
	 * @param fileSuf
	 *            文件后缀
	 * @param fileSep
	 *            列分割符
	 * @return
	 */
	public static boolean exportTable(String sqlText, String filePath, String fileName, String fileSuf, String fileSep, String provinceCode) {
		String sql = "export " + sqlText + " attribute(location('" + filePath + fileName + fileSuf + "') separator('" + fileSep + "'))";
		Connection conn = null;
		Statement pstmt = null;
		boolean ret = false;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("从行云数据表导出文件" + fileName + fileSuf + "成功");
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("从行云数据表导出文件" + fileName + fileSuf + "失败");
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return ret;
	}
	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static Map queryOne(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new HashMap<>();
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return map;
	};

	/**
	 * 查询工单库
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static Map queryOneOrder(String noTransactionSQL,String url,String userName,String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new HashMap<>();
		try {
			conn = getConnection1(url,userName,password);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return map;
	};

	public static List<String> queryForListStringOrder(String noTransactionSQL,String url,String userName,String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String>  list = new ArrayList<>();
		String s = "";
		try {
			conn = getConnection1(url,userName,password);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				s = rs.getString(1);
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<String> queryForListString(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String>  list = new ArrayList<>();
        String s = "";
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				s = rs.getString(1);
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};


	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List queryForList(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List  list = new ArrayList<>();

		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static String upateForData(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String flag="0";
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			flag="1";
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return flag;
	};

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public static Integer queryByLimitAndWriteCSV(String noTransactionSQL, String path, String csvName, String provinceCode) {
		BufferedWriter bw = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer total = 0; // 导出总记录数
		try {
			File file = new File(path, csvName);
			// 父目录不存在则循环创建
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(file));
			// bw.write(ConstantData.EXPORT_TABLE_TITLE); //写入文件标题
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL + " limit(?,?)"); // xcloud分页查询.行云索引从1开始，且Limit
			// (startNum,endNum)后面数字大于前面数字
			int pageSize = 100000; // 每页记录数
			int pageId = 1; // 分页数，，每页100,0000记录
			while (true) {
				int endNum = (pageId + 1) * pageSize;
				int startNum = pageId * pageSize + 1;
				System.err.println("第" + pageId + "页" + "开始索引:" + startNum + ",结束索引:" + endNum);
				pstmt.setInt(2, endNum);
				pstmt.setInt(1, startNum);
				ResultSet rs = pstmt.executeQuery();
				ResultSetMetaData metaData = rs.getMetaData();
				boolean flag = true; // 判断时候有数据，无数据则跳出循环
				while (rs.next()) {
					total++;
					flag = false;
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						// 最后一列
						if (i == metaData.getColumnCount()) {
							bw.write(String.valueOf(rs.getObject(i)));
							bw.newLine();
						} else {
							bw.write(String.valueOf(rs.getObject(i)) + ",");
						}
					}
				}
				rs.close();
				pageId++;
				if (flag) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
			CloseUtil.closeWriter(bw);
		}
		return total;
	};

	public static String query(String sql, String provinceCode) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			// 获取数据连接
			conn = getConnection(provinceCode);
			statement = conn.prepareStatement(sql);

			rs = statement.executeQuery(sql);
			if (rs.next()) {
				String xc = rs.getString(1);
				return xc;
			}
		} catch (Exception ex) {
		} finally {
			closeResultSet(rs);
			closeStmt(statement);
			closeConn(conn);
		}
		return null;
	}

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryExecuteSQL(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i).toLowerCase(), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 * 不转小写
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryExecuteSQL2(String noTransactionSQL, String provinceCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnLabel(i), rs.getObject(i));
//					System.out.println("---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n");
//					System.out.println("ColumnName:" + metaData.getColumnName(i)+"\n");
//					System.out.println("CatalogName:" + metaData.getCatalogName(i)+"\n");
//					System.out.println("ColumnClassName:" + metaData.getColumnClassName(i)+"\n");
//					System.out.println("ColumnLabel:" + metaData.getColumnLabel(i)+"\n");
//					System.out.println("ColumnTypeName" + metaData.getColumnTypeName(i)+"\n");
//					System.out.println("---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n---$$$$$$----\n");
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	}

	/**
	 * 执行xcloud中的查询数量sql
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryExecuteListSQL(String noTransactionSQL, String provinceCode) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(provinceCode);
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customNum", rs.getObject(1));
				map.put("areaNoDesc", rs.getObject(3));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		// map.put("errorCode",errorCode);
		return list;
	};

	public static Map<String, Object> saveBatch(String sql, List<String> list) {
		total = 0;
		count = list.size();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			if (list != null) {
				for (String str : list) {
					if (StringUtils.isNotEmpty(str)) {
						String[] split = str.split(",");
						if (split != null) {
							for (String string : split) {
								pstmt.setString(1, string.trim());
								pstmt.executeUpdate();
								total++;
							}
						}
					}
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return map;
	}

	/**
	 * 执行xcloud中的查询数量sql
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> queryExecuteCountSQL(String noTransactionSQL) {
		Map<String, Object> map = new HashMap<String, Object>();
		String errorCode = "0";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long total = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				total = (Long) rs.getObject(1);
				map.put("total", total);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode = "1";
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		map.put("errorCode", errorCode);
		return map;
	};

	/**
	 * 批量插入
	 *
	 * @param transactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static String saveExecuteSQL(String transactionSQL) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = getConnection();
			statement = conn.createStatement();
			statement.execute(transactionSQL);
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		} finally {
			closeStmt(statement);
			closeConn(conn);
		}
		return "0";
	};

	/**
	 * 建表
	 *
	 * @param tableName
	 *            表名
	 * @param columns
	 *            列名，格式如(fieldName varchar(500))
	 * @return
	 */
	public static String createTable(String tableName, String columns) {
		String sql = "CREATE table " + tableName + "  " + columns;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("建表成功");
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return "0";
	}

	/**
	 * 清空表
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static void truncateTable(String tableName) {
		String sql = "truncate table " + tableName;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("清空表成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
	}

	/**
	 * 删表
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static void deleteTable(String tableName) {
		String sql = "drop table " + tableName;
		Connection conn = null;
		Statement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("删表成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
	}

	/**
	 * 表是否存在
	 *
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static boolean existTable(String tableName) {
		String sql = "select 1 from " + tableName + " limit (0, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			log.info("该表存在");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return true;
	}

	/**
	 * 导出表数据到文件
	 *
	 * @param sqlText
	 *            sql语句
	 * @param filePath
	 *            文件存放路径
	 * @param fileName
	 *            文件名
	 * @param fileSuf
	 *            文件后缀
	 * @param fileSep
	 *            列分割符
	 * @return
	 */
	public static boolean exportTable(String sqlText, String filePath, String fileName, String fileSuf, String fileSep) {
		String sql = "export " + sqlText + " attribute(location('" + filePath + fileName + fileSuf + "') separator('" + fileSep + "'))";
		Connection conn = null;
		Statement pstmt = null;
		boolean ret = false;
		try {
			conn = getConnection();
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
			log.info("从行云数据表导出文件" + fileName + fileSuf + "成功");
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("从行云数据表导出文件" + fileName + fileSuf + "失败");
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
		}
		return ret;
	}
	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static Map queryOne(String noTransactionSQL) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new HashMap<>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return map;
	};
	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List queryForList(String noTransactionSQL) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List  list = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public static Integer queryByLimitAndWriteCSV(String noTransactionSQL, String path, String csvName) {
		BufferedWriter bw = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer total = 0; // 导出总记录数
		try {
			File file = new File(path, csvName);
			// 父目录不存在则循环创建
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(file));
			// bw.write(ConstantData.EXPORT_TABLE_TITLE); //写入文件标题
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL + " limit(?,?)"); // xcloud分页查询.行云索引从1开始，且Limit
			// (startNum,endNum)后面数字大于前面数字
			int pageSize = 100000; // 每页记录数
			int pageId = 1; // 分页数，，每页100,0000记录
			while (true) {
				int endNum = (pageId + 1) * pageSize;
				int startNum = pageId * pageSize + 1;
				System.err.println("第" + pageId + "页" + "开始索引:" + startNum + ",结束索引:" + endNum);
				pstmt.setInt(2, endNum);
				pstmt.setInt(1, startNum);
				ResultSet rs = pstmt.executeQuery();
				ResultSetMetaData metaData = rs.getMetaData();
				boolean flag = true; // 判断时候有数据，无数据则跳出循环
				while (rs.next()) {
					total++;
					flag = false;
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						// 最后一列
						if (i == metaData.getColumnCount()) {
							bw.write(String.valueOf(rs.getObject(i)));
							bw.newLine();
						} else {
							bw.write(String.valueOf(rs.getObject(i)) + ",");
						}
					}
				}
				rs.close();
				pageId++;
				if (flag) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
			closeConn(conn);
			CloseUtil.closeWriter(bw);
		}
		return total;
	};

	public static String query(String sql) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			// 获取数据连接
			conn = getConnection();
			statement = conn.prepareStatement(sql);

			rs = statement.executeQuery(sql);
			if (rs.next()) {
				String xc = rs.getString(1);
				return xc;
			}
		} catch (Exception ex) {
		} finally {
			closeResultSet(rs);
			closeStmt(statement);
			closeConn(conn);
		}
		return null;
	}

	/**
	 * 执行xcloud中的sql查询语句(不包含事务)
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryExecuteSQL(String noTransactionSQL) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i).toLowerCase(), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	};

	/**
	 * 执行xcloud中的查询数量sql
	 *
	 * @param noTransactionSQL
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryExecuteListSQL(String noTransactionSQL) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(noTransactionSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customNum", rs.getObject(1));
				map.put("areaNoDesc", rs.getObject(3));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		// map.put("errorCode",errorCode);
		return list;
	};

	/**
	 * 执行行云语句
	 * @param sql
	 */
	public static boolean execute(String sql, String provinceCode){
		boolean flag = true;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection(provinceCode);
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			log.info("执行SQL成功: {}", sql);
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("execute执行SQL失败: {}", sql);
			flag = false;
		} finally {
			closeStmt(statement);
			closeConn(conn);
		}

		return flag;
	}
}
