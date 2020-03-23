package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.bl.Util;
import system.model.Product;
import system.service.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String sayHelloFromProductController(){
        return "Hello from Product!";
    }


    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAll() throws SQLException {
        return productService.getAll();
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public @ResponseBody Product getByID(@RequestParam int id) throws SQLException {
        return productService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void Add(@RequestParam long prod_id,
                    @RequestParam String name,
                    @RequestParam long type_id) throws SQLException {
        Product product = new Product();
        product.setProd_id(prod_id);
        product.setName(name);
        product.setType_id(type_id);
        productService.Add(product);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void Update(@RequestParam long prod_id,
                       @RequestParam String name,
                       @RequestParam long type_id) throws SQLException {
        Product product = new Product();
        product.setProd_id(prod_id);
        product.setName(name);
        product.setType_id(type_id);
        productService.Update(product);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public  void Delete(@RequestParam long id) throws SQLException {
        Product product = new Product();
        product.setProd_id(id);
        productService.Delete(product);
    }
}
