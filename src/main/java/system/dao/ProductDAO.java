package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Product;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductDAO {
    void Add(Product product) throws SQLException;

    List<Product> getAll() throws SQLException;
    Product getById(long id) throws SQLException;

    void Update(Product product) throws SQLException;

    void Delete(Product product) throws SQLException;



}
