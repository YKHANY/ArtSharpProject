package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by younghan on 2016. 9. 22..
 */
public class AdminDAOImpl extends BaseDAO implements AdminDAO {
    private static final String SELECT = "SELECT PASSWORD FROM ADMIN_TB WHERE ID=?";
    @Override
    public String select(String id) throws DAOException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SELECT);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                password = rs.getString("password");
            }
        }catch(SQLException e)
        {
            throw new DAOException("Error select. " + e.getMessage());
        }finally {
            closeDBObjects(null,ps,conn);
        }
        return password;
    }
}
