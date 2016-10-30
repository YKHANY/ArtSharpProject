package dao;

/**
 * Created by younghan on 2016. 9. 22..
 */
public interface AdminDAO extends DAO{

    String select(String id) throws DAOException;

}
