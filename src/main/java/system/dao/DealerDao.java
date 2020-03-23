package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Dealer;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface DealerDao {
    void Add(Dealer dealer) throws SQLException;

    List<Dealer> getAll() throws SQLException;
    Dealer getById(long id) throws SQLException;

    void Update(Dealer dealer) throws SQLException;

    void Delete(Dealer dealer) throws SQLException;



}
