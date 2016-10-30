package dao;

import java.sql.*;
import javax.sql.DataSource;

public class BaseDAO implements DAO {

	public Connection getConnection() throws DAOException{
		DataSource dataSource = DataSourceCache.getInstance().getDataSource();
		try{
			System.out.println("!!!!dataSource" +dataSource);
			return dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException();
		}
	}

	protected void closeDBObjects (ResultSet resultSet, Statement statement, Connection connection){
		
		if(resultSet != null){
			try{
				resultSet.close();
			}catch(Exception e){
				
			}
		}
		if(statement != null){
			try{
				statement.close();
			}catch(Exception e){
				
			}
		}
		if(connection != null){
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
	}
}
