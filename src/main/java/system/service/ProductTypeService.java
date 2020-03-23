package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bl.Util;
import system.dao.ProductTypeDAO;
import system.model.ProductType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeService implements ProductTypeDAO {
    @Autowired
    Util util;

    @Override
    public void Add(ProductType productType) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO PRODUCT_TYPES (TYPE_ID, NAME) VALUES (?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, productType.getType_id());
            preparedStatement.setString(2, productType.getName());

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
    public List<ProductType> getAll() throws SQLException {
        Connection connection = util.getConnection();

        List<ProductType> productTypeList = new ArrayList<>();
        Statement statement = null;
        String sqlQuery = "SELECT TYPE_ID, NAME FROM PRODUCT_TYPES";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                ProductType productType = new ProductType(); //тут надо делать через аннотации скорее всего

                productType.setType_id(resultSet.getLong("TYPE_ID"));
                productType.setName(resultSet.getString("NAME"));

                productTypeList.add(productType);
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
        return productTypeList;
    }

    @Override
    public ProductType getById(long id) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT  TYPE_ID, NAME FROM PRODUCT_TYPES WHERE TYPE_ID=?";
        ProductType productType = new ProductType();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); //переходим на первую строку полученного значения, тут все работает так же как было в Oracle

            productType.setType_id(resultSet.getLong("TYPE_ID"));
            productType.setName(resultSet.getString("NAME"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return productType;
    }

    @Override
    public void Update(ProductType productType) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE PRODUCT_TYPES SET NAME=? WHERE TYPE_ID=?";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, productType.getName());
            preparedStatement.setLong(2, productType.getType_id());

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
    public void Delete(ProductType productType) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "DELETE FROM PRODUCT_TYPES WHERE TYPE_ID=?";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, productType.getType_id());

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
