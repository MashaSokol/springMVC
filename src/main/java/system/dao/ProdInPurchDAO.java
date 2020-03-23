package system.dao;

import org.springframework.stereotype.Repository;
import system.model.ProdInPurch;

import java.util.List;

@Repository
public interface ProdInPurchDAO {
    void Add(ProdInPurch prodInPurch);

    List<ProdInPurch> getAll();
    ProdInPurch getById(long prod_id, long purch_id);

    void Update(ProdInPurch prodInPurch);

    void Delete(ProdInPurch prodInPurch);



}
