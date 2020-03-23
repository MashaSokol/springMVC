package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bl.Util;
import system.dao.DealerDao;
import system.model.Dealer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DealerService implements DealerDao {
    @Autowired
    Util util;

    @Override
    public void Add(Dealer dealer) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO DEALERS " +
                "(DEALER_ID, FNAME, SNAME, LNAME, PHONE_NUMBER, ADDRESS, DESCRIPTION)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, dealer.getDealer_id());
            preparedStatement.setString(2, dealer.getfName());
            preparedStatement.setString(3, dealer.getsName());
            preparedStatement.setString(4, dealer.getlName());
            preparedStatement.setLong(5, dealer.getPhone_number());
            preparedStatement.setString(6, dealer.getAddress());
            preparedStatement.setString(7, dealer.getDescription());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Dealer> getAll() throws SQLException {
        Connection connection = util.getConnection();

        List<Dealer> dealerList = new ArrayList<>();
        Statement statement = null;
        String sqlQuery = "SELECT DEALER_ID, FNAME, SNAME, LNAME, PHONE_NUMBER, ADDRESS, DESCRIPTION" +
                "FROM DEALERS";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                Dealer dealer = new Dealer(); //тут надо делать через аннотации скорее всего

                dealer.setDealer_id(resultSet.getLong("DEALER_ID"));
                dealer.setfName(resultSet.getString("FNAME"));
                dealer.setsName(resultSet.getString("SNAME"));
                dealer.setlName(resultSet.getString("LNAME"));
                dealer.setPhone_number(resultSet.getLong("PHONE_NUMBER"));
                dealer.setAddress(resultSet.getString("ADDRESS"));
                dealer.setDescription(resultSet.getString("DESCRIPTION"));

                dealerList.add(dealer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return dealerList;
    }

    @Override
    public Dealer getById(long id) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT DEALER_ID, FNAME, SNAME, LNAME, PHONE_NUMBER, ADDRESS, DESCRIPTION" +
                " FROM DEALERS" +
                " WHERE DEALER_ID=?";
        Dealer dealer = new Dealer();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); //переходим на первую строку полученного значения, тут все работает так же как было в Oracle

            dealer.setDealer_id(resultSet.getLong("DEALER_ID"));
            dealer.setfName(resultSet.getString("FNAME"));
            dealer.setsName(resultSet.getString("SNAME"));
            dealer.setlName(resultSet.getString("LNAME"));
            dealer.setPhone_number(resultSet.getLong("PHONE_NUMBER"));
            dealer.setAddress(resultSet.getString("ADDRESS"));
            dealer.setDescription(resultSet.getString("DESCRIPTION"));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return dealer;
    }

    @Override
    public void Update(Dealer dealer) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE DEALERS" +
                " SET FNAME=?, SNAME=?, LNAME=?, PHONE_NUMBER=?, ADDRESS=?, DESCRIPTION=? " +
                "WHERE DEALER_ID=?";
        // в трггере проверка на пустое значение
        // означающее, что это значение не нужно менять, чтобы данные не замывались по случайности

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, dealer.getfName());
            preparedStatement.setString(2, dealer.getsName());
            preparedStatement.setString(3, dealer.getlName());
            preparedStatement.setLong(4, dealer.getPhone_number());
            preparedStatement.setString(5, dealer.getAddress());
            preparedStatement.setString(6, dealer.getDescription());
            preparedStatement.setLong(7, dealer.getDealer_id());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void Delete(Dealer dealer) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "DELETE FROM DEALERS WHERE DEALER_ID=?";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, dealer.getDealer_id());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
    }
}
