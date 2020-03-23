package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.Product;
import system.model.ProductType;
import system.service.ProductService;
import system.service.ProductTypeService;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String sayHelloFromProductTypeController(){return "Hello from ProductType!";}

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductType> getAll() throws SQLException {
        return productTypeService.getAll();
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public @ResponseBody ProductType getByID(@RequestParam int id) throws SQLException {
        return productTypeService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void Add(@RequestParam long id,
                    @RequestParam String name) throws SQLException {
        ProductType productType = new ProductType();
        productType.setType_id(id);
        productType.setName(name);

        productTypeService.Add(productType);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void Update(@RequestParam long id,
                       @RequestParam String name) throws SQLException {
        ProductType productType = new ProductType();
        productType.setName(name);
        productType.setType_id(id);
        productTypeService.Update(productType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public  void Delete(@RequestParam long id) throws SQLException {
        ProductType productType = new ProductType();
        productType.setType_id(id);
        productTypeService.Delete(productType);
    }
}
