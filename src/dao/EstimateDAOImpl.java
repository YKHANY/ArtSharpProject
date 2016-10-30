package dao;

import com.mysql.jdbc.*;
import model.Estimate;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by younghan on 2016. 9. 21..
 */
public class EstimateDAOImpl extends BaseDAO implements EstimateDAO {

    private static final String INSERT = "INSERT INTO ESTIMATE_TB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_FILE_PATH = "INSERT INTO FILE_TB (FILE_CODE, PATH, ESTIMATE_TB_ESTIMATE_CODE) VALUES(?,?,?)";
    private static final String DELETE = "DELETE FROM ESTIMATE_TB WHERE estimate_code = ?";
    private static final String UPDATE = "UPDATE estimate_tb SET kind=?, name=?, password=?, phone=?, email=?, postcode=?, address=?, " +
            "address_detail=?, size=?, price=?, floor=?, date=?, text=? WHERE estimate_code=?";
    private static final String SELECT = "SELECT * FROM ESTIMATE_TB WHERE ESTIMATE_CODE=?";
    private static final String SELECT_FILEPATH = "SELECT PATH FROM FILE_TB WHERE ESTIMATE_TB_ESTIMATE_CODE=?";
    private static final String SELECT_ALL = "SELECT * FROM ESTIMATE_TB ORDER BY INSERT_DATE ASC";


    @Override
    public int insert(Estimate estimate) throws DAOException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        String estimateCode = estimatecodeGenerate();
        int rowNum = 0;
        try {

            conn = getConnection();
            pStatement = conn.prepareStatement(INSERT);
            pStatement.setString(1, estimateCode);
            pStatement.setString(2, estimate.getKind());
            pStatement.setString(3, estimate.getName());
            pStatement.setString(4, estimate.getPassword());
            pStatement.setString(5, estimate.getPhone());
            pStatement.setString(6, estimate.getEmail());
            pStatement.setString(7, estimate.getPostcode());
            pStatement.setString(8, estimate.getAddress());
            pStatement.setString(9, estimate.getAddressDetail());
            pStatement.setString(10, estimate.getSize());
            pStatement.setString(11, estimate.getPrice());
            pStatement.setString(12, estimate.getFloor());
            if(estimate.getDate() != null){
                pStatement.setDate(13, new Date(estimate.getDate().getTimeInMillis()));
            }else{
                pStatement.setDate(13, null);
            }
            pStatement.setString(14, estimate.getText());
            pStatement.setLong(15, new GregorianCalendar().getTimeInMillis());
            rowNum = pStatement.executeUpdate();

            pStatement = conn.prepareStatement(INSERT_FILE_PATH);
            for(String path : estimate.getFilePath()){
                pStatement.setString(1,fileCodeGenerate());
                pStatement.setString(2,path);
                pStatement.setString(3,estimateCode);
                pStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException("Error inserting. " + e.getMessage());
        }finally{
            closeDBObjects(null, pStatement, conn);
        }
        return rowNum;
    }

    @Override
    public int delete(String estimateCode) throws DAOException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        int rowNum = 0;
        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(DELETE);
            pStatement.setString(1,estimateCode);
            rowNum = pStatement.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Error delete. " + e.getMessage());
        }finally{
            closeDBObjects(null, pStatement, conn);
        }
        return rowNum;
    }

    @Override
    public int update(String estimateCode, Estimate estimate) throws DAOException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        int rowNum = 0;
        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(UPDATE);
            pStatement.setString(1, estimate.getKind());
            pStatement.setString(2, estimate.getName());
            pStatement.setString(3, estimate.getPassword());
            pStatement.setString(4, estimate.getPhone());
            pStatement.setString(5, estimate.getEmail());
            pStatement.setString(6, estimate.getPostcode());
            pStatement.setString(7, estimate.getAddress());
            pStatement.setString(8, estimate.getAddressDetail());
            pStatement.setString(9, estimate.getSize());
            pStatement.setString(10, estimate.getPrice());
            pStatement.setString(11, estimate.getFloor());
            pStatement.setDate(12, new Date(estimate.getDate().getTimeInMillis()));
            pStatement.setString(13, estimate.getText());
            pStatement.setString(14, estimateCode);
            rowNum = pStatement.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Error update. " + e.getMessage());
        }finally{
            closeDBObjects(null, pStatement, conn);
        }
        return rowNum;
    }

    @Override
    public Estimate select(String estimateCode) throws DAOException {
        Estimate estimate = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        GregorianCalendar gc = null;

        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(SELECT);
            pStatement.setString(1,estimateCode);
            rs = pStatement.executeQuery();
            while(rs.next()){
                if(rs.getDate("date") != null){
                    gc = new GregorianCalendar();
                    gc.setTimeInMillis(rs.getDate("date").getTime());
                }
                estimate = new Estimate(rs.getString("kind"), rs.getString("name"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("postcode"), rs.getString("address"),
                        rs.getString("address_detail"), rs.getString("size"), rs.getString("price"), rs.getString("floor"),
                        gc, null, rs.getString("text"));
                estimate.setCode(rs.getString("estimate_code"));
            }

            List<String> files = new ArrayList<>();
            pStatement = conn.prepareStatement(SELECT_FILEPATH);
            pStatement.setString(1,estimateCode);
            rs = pStatement.executeQuery();
            while(rs.next()) {
                files.add(rs.getString("PATH"));
            }
            if(files != null){
                estimate.setFilePath(files);
            }


        }catch(SQLException e){
            throw new DAOException("Error select. " + e.getMessage());
        }finally{
            closeDBObjects(rs, pStatement, conn);
        }
        return estimate;
    }

    @Override
    public List<Estimate> selectAll() throws DAOException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        List<Estimate> list = new ArrayList<>();
        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(SELECT_ALL);
            rs = pStatement.executeQuery();

            while(rs.next())
            {
                Estimate estimate = new Estimate();
                estimate.setName(rs.getString("name"));

                if(rs.getDate("date") != null){
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.setTimeInMillis(rs.getDate("date").getTime());
                    estimate.setDate(gc);
                }
                estimate.setCode(rs.getString("estimate_code"));
                list.add(estimate);
            }
        }catch(SQLException e){
            throw new DAOException("Error select all. " + e.getMessage());
        }finally{
            closeDBObjects(rs, pStatement, conn);
        }
        return list;
    }

    @Override
    public String estimatecodeGenerate(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }

    public String fileCodeGenerate(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
