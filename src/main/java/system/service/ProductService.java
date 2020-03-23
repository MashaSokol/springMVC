package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bl.Util;
import system.dao.ProductDAO;
import system.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductDAO {

    @Autowired
    Util util;

    @Override
    public void Add(Product product) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO PRODUCTS (PROD_ID, NAME, TYPE_ID) VALUES (?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, product.getProd_id());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setLong(3, product.getType_id());

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
    public List<Product> getAll() throws SQLException {
        Connection connection = util.getConnection();

        List<Product> productList = new ArrayList<>();
        Statement statement = null;
        String sqlQuery = "SELECT PROD_ID, NAME, TYPE_ID FROM PRODUCTS";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                Product product = new Product(); //тут надо делать через аннотации скорее всего

                product.setProd_id(resultSet.getLong("PROD_ID"));
                product.setName(resultSet.getString("NAME"));
                product.setType_id(resultSet.getLong("TYPE_ID"));

                productList.add(product);
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
        return productList;
    }

    @Override
    public Product getById(long id) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT PROD_ID, NAME, TYPE_ID FROM PRODUCTS WHERE PROD_ID=?";
        Product product = new Product();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); //переходим на первую строку полученного значения, тут все работает так же как было в Oracle

            product.setProd_id(resultSet.getLong("PROD_ID"));
            product.setName(resultSet.getString("NAME"));
            product.setType_id(resultSet.getLong("TYPE_ID"));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return product;
    }

    @Override
    public void Update(Product product) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE PRODUCTS SET NAME=?, TYPE_ID=? WHERE PROD_ID=?";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2,product.getType_id());
            preparedStatement.setLong(3, product.getProd_id());

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
    public void Delete(Product product) throws SQLException {
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = null;
        String sqlQuery = "DELETE FROM PRODUCTS WHERE PROD_ID=?";

        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, product.getProd_id());

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
