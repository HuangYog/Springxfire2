package com.fsnip.platform.core;

import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;
import com.fsnip.platform.global.Page;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseDao extends JdbcTemplate {
	
	private String db = JdbcConfig.db.toLowerCase();

	@Autowired
	private void setDataSource(ComboPooledDataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * 返回分页列表，Map结构=>{total=>记录总数，rows=>Map结构的list}
	 * 
	 * @param sql
	 *            sql语句
	 * @param args
	 *            参数对象
	 * @param start
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getPage(String sql, Object[] args, int start,
			int limit) {
		
		int count = 0;
		String countSql = getCountSql(sql);
		count = this.queryForInt(countSql, args);
		
		
		sql = getQuerySql(sql, start, limit);
		
		List<Map<String, Object>> list = this.queryForList(sql, args);

		Page page = new Page();
		page.getUrl(count, start, limit, "");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		map.put("page_num", start);
		map.put("page_size", limit);
		map.put("page_bar", page.getPageBar());
		return map;
	}
	
	/**
	 * 返回分页列表，Map结构=>{total=>记录总数，rows=>Map结构的list}
	 * 
	 * @param sql sql语句
	 * @param args 参数对象
	 * @param queryString 查询参数
	 * @param start
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getPage(String sql, Object[] args, String queryString, int start,
			int limit) {
		
		int count = 0;
		String countSql = getCountSql(sql);
		count = this.queryForInt(countSql, args);
		
		
		sql = getQuerySql(sql, start, limit);
		
		List<Map<String, Object>> list = this.queryForList(sql, args);

		Page page = new Page();
		page.getUrl(count, start, limit, queryString);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		map.put("page_num", start);
		map.put("page_size", limit);
		map.put("page_bar", page.getPageBar());
		return map;
	}
	

	/**
	 * 返回分页列表，Map结构=>{total=>记录总数，rows=>实体结构的list}
	 * 
	 * @param sql
	 * @param args
	 * @param cls
	 *            实体类
	 * @param start
	 * @param limit
	 * @return
	 */
	public <T> Map<String, Object> getPage(String sql, Object[] args,
			Class<T> cls, int start, int limit) {
		String countSql = getCountSql(sql);
		int count = this.queryForInt(countSql, args);

		//sql += " limit " + (start * limit) + ", " + limit;
		sql = getQuerySql(sql, start, limit);
		
		List<T> list = this.query(sql, args, new TMapper<T>(cls));

		Page page = new Page();
		page.getUrl(count, start, limit, "");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		map.put("page_num", start);
		map.put("page_size", limit);
		map.put("page_bar", page.getPageBar());

		return map;
	}
	
	/**
	 * 返回分页列表，Map结构=>{total=>记录总数，rows=>实体结构的list}
	 * 
	 * @param sql
	 * @param args
	 * @param cls
	 *            实体类
	 * @param start
	 * @param limit
	 * @return
	 */
	public <T> Map<String, Object> getPage(String sql, Object[] args, String queryString,
			Class<T> cls, int start, int limit) {
		String countSql = getCountSql(sql);
		int count = this.queryForInt(countSql, args);

		//sql += " limit " + (start * limit) + ", " + limit;
		sql = getQuerySql(sql, start, limit);
		
		List<T> list = this.query(sql, args, new TMapper<T>(cls));

		Page page = new Page();
		page.getUrl(count, start, limit, queryString);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		map.put("page_num", start);
		map.put("page_size", limit);
		map.put("page_bar", page.getPageBar());

		return map;
	}

	/**
	 * 返回单个实体
	 * 
	 * @param sql
	 * @param args
	 * @return 无记录返回null
	 */
	public <T> T get(String sql, Object[] args, Class<T> cls) {
		try {
			return this.queryForObject(sql, args, new TMapper<T>(cls));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/**
	 * 获取单个实体
	 * @param id
	 * @param cls
	 * @return 无记录返回null
	 */
	public <T> Object get(String id, Class<T> cls) {
		try {
			String sql = this.getSelectSql(cls);
			return this.queryForObject(sql, new Object[]{id}, new TMapper<T>(cls));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 返回实体对像集合
	 * 
	 * @param sql
	 * @param cls
	 * @return
	 */
	public <T> List<T> getList(String sql, Class<T> cls) {
		return this.query(sql, new TMapper<T>(cls));
	}
	
	
	/**
	 * 返回实体对像集合
	 * 
	 * @param sql
	 * @param args
	 * @param cls
	 * @return
	 */
	public <T> List<T> getList(String sql, Object[] args, Class<T> cls) {
		return this.query(sql, args, new TMapper<T>(cls));
	}

	/**
	 * 返回实体对像集合
	 * 
	 * @param sql
	 * @param args
	 * @param cls
	 * @param start
	 * @param limit
	 * @return
	 */
	public <T> List<T> getList(String sql, Object[] args, Class<T> cls,
			int start, int limit) {
		//sql += " limit " + (start * limit) + ", " + limit;
		sql = getQuerySql(sql, start, limit);
		return this.query(sql, args, new TMapper<T>(cls));
	}

	/**
	 * 添加数据
	 * @return
	 */
	public int insert(Object o) {
		Map<String, Object> map = this.getInsertSql(o, false);
		return this.update((String) map.get("sql"), (Object[]) map.get("args"));
	}
	
	
	String insSql = "";
	Object insObj[] = new Object[]{};
	/**
	 * 返回插入自增长ID
	 * @param o
	 * @param isReturnID 是否返回
	 * @return
	 */
	public int insert(Object o, boolean isReturnID) {
		Map<String, Object> map = this.getInsertSql(o, true);
		insSql = (String) map.get("sql");
		insObj = (Object[]) map.get("args");
		KeyHolder holder = new GeneratedKeyHolder() ;  
	    super.update(new PreparedStatementCreator() {  
	         public PreparedStatement createPreparedStatement(Connection conn)  throws SQLException {  
	                PreparedStatement ps = conn.prepareStatement(insSql, Statement.RETURN_GENERATED_KEYS) ;   
	           
	                for(int x=1; x <= insObj.length; x++){  
	                    ps.setObject(x, insObj[x-1]);   
	                }  
	                return ps ;  
	            }  
	    } , holder) ;   
	     
		return holder.getKey().intValue() ;
	}
	
	/**
	 * 保存多条数据，不支持oracle
	 * @param ObjectList 实体对象集合
	 * @return
	 */
	public int insertAll(List<Object> ObjectList) {
		if(ObjectList.size() == 0){
			throw new RuntimeException(AppUtil.getExMsg("实体对象集合为空！"));
		}
		Map<String, Object> map = this.getInsertAllSql(ObjectList);
		return this.update((String) map.get("sql"), (Object[]) map.get("args"));
	}

	/**
	 * 更新数据，默认只更新不为null的字段
	 * @param o 实体对象
	 * @return
	 */
	public int update(Object o) {
		Map<String, Object> map = this.getUpdateSql(o, false);
		return this.update((String) map.get("sql"), (Object[]) map.get("args"));
	}
	
	
	/**
	 * 更新数据
	 * @param o 实体对象
	 * @param isAllUpdate 是否更新所有字段
	 * @return
	 */
	public int update(Object o, boolean isAllUpdate) {
		
		Map<String, Object> map = this.getUpdateSql(o, isAllUpdate);
		return this.update((String) map.get("sql"), (Object[]) map.get("args"));
	}
	
	
	public <T> String getSelectSql(Class<T> cls) {
		StringBuffer sbSql = new StringBuffer();
		Field[] fields = cls.getDeclaredFields();
		Table table = cls.getAnnotation(Table.class);
		StringBuffer sbField = new StringBuffer();
		StringBuffer sbWhere = new StringBuffer();

		for (Field field : fields) {
			field.setAccessible(true);
			Id id = field.getAnnotation(Id.class);
			Column column = field.getAnnotation(Column.class);
			if (id != null) {
				sbField.append(",");
				if("oracle".equals(db)){
					sbField.append(field.getName()).append(" \"").append(field.getName()).append("\"");
				}else{
					sbField.append(field.getName());
				}
				
				sbWhere.append(" where ");
				sbWhere.append(field.getName());
				sbWhere.append("=?");
			} else if(column != null){
				sbField.append(",");
				if("oracle".equals(db)){
					sbField.append(field.getName()).append(" \"").append(field.getName()).append("\"");
				}else{
					sbField.append(field.getName());
				}
			}
		}
		sbSql.append("select ");
		sbSql.append(sbField.substring(1, sbField.length()));
		sbSql.append(" from ");
		sbSql.append(table.value());
		sbSql.append(sbWhere);
		
		return sbSql.toString();
	}
	
	/**
	 * 获取查询字段字符串id,name,age
	 * @param cls
	 * @return
	 */
	public <T> String getSelectField(Class<T> cls) {
		Field[] fields = cls.getDeclaredFields();
		StringBuffer sbField = new StringBuffer();

		for (Field field : fields) {
			field.setAccessible(true);
			Id id = field.getAnnotation(Id.class);
			Column column = field.getAnnotation(Column.class);
			if (id != null || column != null) {
				sbField.append(",");
				sbField.append(field.getName());
			} 
		}
		return sbField.substring(1, sbField.length());
	}

	/**
	 * 获取插入SQL
	 * @param o
	 * @return
	 */
	public Map<String, Object> getInsertSql(Object o, boolean isReturnId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = o.getClass().getDeclaredFields();

			Table table = o.getClass().getAnnotation(Table.class);
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("insert into ");
			sbSql.append(table.value());
			sbSql.append(" (");

			StringBuffer sbField = new StringBuffer();
			StringBuffer sbValue = new StringBuffer();

			List<Object> list = new ArrayList<Object>();
			for (Field field : fields) {
				field.setAccessible(true);
				Column column = field.getAnnotation(Column.class);
				Id id = field.getAnnotation(Id.class);
				
				if(isReturnId && id != null){
					continue;
				}
				
				if (column != null || id != null) {
					sbField.append(",");
					sbField.append(field.getName());
					
					sbValue.append(",?");
					
					list.add(field.get(o));
				}
			}

			sbSql.append(sbField.substring(1, sbField.length()));
			sbSql.append(")");
			sbSql.append(" values(");
			sbSql.append(sbValue.substring(1, sbValue.length()));
			sbSql.append(")");

			map.put("sql", sbSql.toString());
			map.put("args", list.toArray());
		} catch (Exception e) {
			throw new RuntimeException(AppUtil.getExMsg("实体属性构建SQL失败！"));
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param o
	 * @return
	 */
	public int delete(Object o){
		Map<String, Object> map = this.getDeleteSql(o);
		return this.update((String) map.get("sql"), (Object[]) map.get("args"));
	}
	
	/**
	 * 获取删除SQL
	 * @param o
	 * @return
	 */
	public Map<String, Object> getDeleteSql(Object o) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = o.getClass().getDeclaredFields();

			Table table = o.getClass().getAnnotation(Table.class);
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("delete from ");
			sbSql.append(table.value());
			sbSql.append(" where ");

			StringBuffer sbWhere = new StringBuffer();

			List<Object> list = new ArrayList<Object>();
			for (Field field : fields) {
				field.setAccessible(true);
				Id id = field.getAnnotation(Id.class);
				if (id != null) {
					sbWhere.append(field.getName());
					sbWhere.append("=?");
					list.add(field.get(o));
					break;
				}
			}

			sbSql.append(sbWhere);
			
			map.put("sql", sbSql.toString());
			map.put("args", list.toArray());
		} catch (Exception e) {
			throw new RuntimeException(AppUtil.getExMsg("实体属性构建SQL失败！"));
		}
		return map;
	}

	/**
	 * 获取插入多数据SQL
	 * @param listObject
	 * @return
	 */
	public Map<String, Object> getInsertAllSql(List<Object> listObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			StringBuffer sbSql = new StringBuffer();
			StringBuffer sbField = new StringBuffer();
			StringBuffer sbValues = new StringBuffer();
			
			String tableName = "";
			sbSql.append("insert into ");
			
			List<Object> list = new ArrayList<Object>();
			int i = 0;
			for (Object o : listObject) {
				Field[] fields = o.getClass().getDeclaredFields();

				Table table = o.getClass().getAnnotation(Table.class);
				tableName = table.value();

				StringBuffer sbValue = new StringBuffer();
				
				for (Field field : fields) {
					
					field.setAccessible(true);
					Column column = field.getAnnotation(Column.class);
					Id id = field.getAnnotation(Id.class);
					if (column != null || id != null) {
						if(i == 0){
							sbField.append(",");
							sbField.append(field.getName());
						}
						
						sbValue.append(",?");
						list.add(field.get(o));
					}
				}
				
				i++;
				
				sbValues.append(",(");
				sbValues.append(sbValue.substring(1, sbValue.length()));
				sbValues.append(")");
			}
			sbSql.append(tableName);
			sbSql.append("(");
			sbSql.append(sbField.substring(1, sbField.length()));
			sbSql.append(")");
			sbSql.append(" values ");
			sbSql.append(sbValues.substring(1, sbValues.length()));

			map.put("sql", sbSql.toString());
			map.put("args", list.toArray());
		} catch (Exception e) {
			throw new RuntimeException(AppUtil.getExMsg("实体属性构建SQL失败！"));
		}
		return map;
	}

	/**
	 * 获取更新SQL
	 * @param o
	 * @return
	 */
	public Map<String, Object> getUpdateSql(Object o, boolean isAllUpdate) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = o.getClass().getDeclaredFields();

			Table table = o.getClass().getAnnotation(Table.class);
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("update ");
			sbSql.append(table.value());
			sbSql.append(" set ");

			StringBuffer sbField = new StringBuffer();
			StringBuffer sbWhere = new StringBuffer();

			List<Object> list = new ArrayList<Object>();

			// 保存ID值
			Object idValue = null;
			for (Field field : fields) {
				field.setAccessible(true);
				Column column = field.getAnnotation(Column.class);
				Id id = field.getAnnotation(Id.class);
				if (column != null) {
					if(isAllUpdate){
						sbField.append(",");
						sbField.append(field.getName());
						sbField.append("=?");
						
						list.add(field.get(o));
					}
					else{
						if(field.get(o) != null){
							sbField.append(",");
							sbField.append(field.getName());
							sbField.append("=?");
							
							list.add(field.get(o));
						}
					}
					
				} else if (id != null) {
					sbWhere.append(" where ");
					sbWhere.append(field.getName());
					sbWhere.append("=?");
					idValue = field.get(o);
				}
			}

			sbSql.append(sbField.substring(1, sbField.length()));
			sbSql.append(sbWhere);
			list.add(idValue);

			map.put("sql", sbSql.toString());
			map.put("args", list.toArray());
		} catch (Exception e) {
			throw new RuntimeException(AppUtil.getExMsg("实体属性构建SQL失败！"));
		}
		return map;
	}

	private String removeSelect(String sql) {
		int beginPos = sql.toLowerCase().lastIndexOf(" from ");
		return sql.substring(beginPos);
	}

	private String removeOrder(String sql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
//	private String removeGroup(String sql) {
//		Pattern p = Pattern.compile("group\\s*by[\\w|\\W|\\s|\\S]*",
//				Pattern.CASE_INSENSITIVE);
//		Matcher m = p.matcher(sql);
//		StringBuffer sb = new StringBuffer();
//		while (m.find()) {
//			m.appendReplacement(sb, "");
//		}
//		m.appendTail(sb);
//		return sb.toString();
//	}
	
	private String getQuerySql(String sql, int start, int limit){
		if("mysql".equals(db)){
			sql += " limit " + (start * limit) + ", " + limit;
		}
		else if("sqlserver".equals(db)){
			sql = getSQLServerSql(sql, start, limit);
		}
		else if("oracle".equals(db)){
			sql = getOracleSql(sql, start, limit);
		}
		
		
		return sql;
	}

	private String getSql(String sql) {
		return removeSelect(removeOrder(sql));
	}
	
	private String getCountSql(String sql){
		//是否有group by 分页的情况。
		Pattern p = Pattern.compile("group\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		if(m.find()){
			return "select count(0) from (" + "select count(0) count" + getSql(sql) + ") ss";
		}
		
		return "select count(0) " + getSql(sql);
	}
	
	private String getSQLServerSql(String sql, int start, int limit){
		
		int beginPos = sql.toLowerCase().lastIndexOf(" order ");
		String order = "";
		String query = "";
		if(beginPos > 0){
			//取出order by排序部分
			order = sql.substring(beginPos);
			//取出查询部分
			query = sql.substring(0, beginPos);
		}
		else{
			query = sql;
		}
		
		if("".equals(order)){
			order = "order by id";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(");
		sb.append(order);
		sb.append(" ) AS ROW_NUMBER, ");
		sb.append(query.replaceFirst("select", ""));
		sb.append(" ) AS t WHERE ROW_NUMBER > ");
		sb.append(start * limit);
		sb.append("  AND ROW_NUMBER <=  ");
		sb.append((start * limit) + limit);
		
		return sb.toString();
	}
	
	private String getOracleSql(String sql, int start, int limit) {

		int beginPos = sql.toLowerCase().lastIndexOf(" order ");
		String order = "";
		String query = "";
		if (beginPos > 0) {
			// 取出order by排序部分
			order = sql.substring(beginPos);
			// 取出查询部分
			query = sql.substring(0, beginPos);
		} else {
			query = sql;
		}


		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT rownum ROW_NUMBER,");
		sb.append(query.replaceFirst("select", ""));
		int beginWhere = query.toLowerCase().lastIndexOf(" where ");
		if(beginWhere > 0){
			sb.append(" and rownum <= ");
		}else{
			sb.append(" WHERE rownum <= ");
		}

		sb.append((start * limit) + limit);
		sb.append(order);
		sb.append(") where ROW_NUMBER > ");
		sb.append(start * limit);
		
		return sb.toString();
	}
	
	/**
	 * 自动为字段字符串添加别名，主要应用于oracle数据库，如：name,age，自动转换为name \"name\",age \"age\"的格式
	 * 传入的字段串可以为已添加过别名的如： name name,age age或者name \"name\", age \"age\"
	 * @param fields  如：name,age
	 * @return
	 */
	public String getAsFields(String fields){
		if(!"oracle".equals(db)){
			return fields;
		}
		
		String arr[] = fields.split(",");
		Pattern p = Pattern.compile("[\\s]+"); 

		StringBuffer sb = new StringBuffer();
		for (String s : arr) {
			s = s.trim();
			Matcher m = p.matcher(s); 
			if(s.indexOf("\"") > 0){
				sb.append(",").append(s.replace("\"", "\""));
			}else if(s.indexOf(".") > 0 && m.find()){
				String[] ss = s.split("[\\s]+");
				sb.append(",").append(ss[0]).append(" \"").append(ss[1]).append("\"");
			}else if(s.indexOf(".") > 0){
				String[] ss = s.split("\\.");
				sb.append(",").append(s).append(" \"").append(ss[1]).append("\"");
			}else if(m.find()){
				String[] ss = s.split("[\\s]+");
				sb.append(",").append(ss[0]).append(" \"").append(ss[1]).append("\"");
			}
			else{
				sb.append(",").append(s).append(" \"").append(s).append("\"");
			}
		}
		
		return sb.substring(1, sb.length());
	}
}
