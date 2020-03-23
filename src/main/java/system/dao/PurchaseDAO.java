package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Purchase;

import java.util.List;

@Repository
public interface PurchaseDAO {
    void Add(Purchase purchase);

    List<Purchase> getAll();
    Purchase getById(long id);

    void Update(Purchase purchase);

    void Delete(Purchase purchase);



}
