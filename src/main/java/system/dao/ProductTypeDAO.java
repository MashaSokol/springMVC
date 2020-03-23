package system.dao;

import org.springframework.stereotype.Repository;
import system.model.ProductType;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductTypeDAO {
    void Add(ProductType productType) throws SQLException;

    List<ProductType> getAll() throws SQLException;
    ProductType getById(long id) throws SQLException;

    void Update(ProductType productType) throws SQLException;

    void Delete(ProductType productType) throws SQLException;

}
