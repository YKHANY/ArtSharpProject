package dao;

import model.Estimate;

import java.util.List;

/**
 * Created by younghan on 2016. 9. 21..
 */
public interface EstimateDAO extends DAO {
    int insert(Estimate estimate) throws DAOException;
    int delete(String estimateCode) throws DAOException;
    int update(String estimateCode, Estimate estimate) throws DAOException;
    Estimate select(String estimateCode) throws DAOException;
    List<Estimate> selectAll() throws DAOException;


    String estimatecodeGenerate() throws DAOException;
}
