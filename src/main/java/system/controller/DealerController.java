package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.Dealer;
import system.service.DealerService;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    DealerService dealerService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String sayHelloFromProductTypeController(){return "Hello from Dealer!";}

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Dealer> getAll() throws SQLException {
        return dealerService.getAll();
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public @ResponseBody Dealer getByID(@RequestParam int id) throws SQLException {
        return dealerService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void Add(@RequestParam long id,
                    @RequestParam String fName,
                    @RequestParam String sName,
                    @RequestParam String lName,
                    @RequestParam long phone,
                    @RequestParam String addr,
                    @RequestParam String descr) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setDealer_id(id);
        dealer.setfName(fName);
        dealer.setsName(sName);
        dealer.setlName(lName);
        dealer.setPhone_number(phone);
        dealer.setAddress(addr);
        dealer.setDescription(descr);
        dealerService.Add(dealer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void Update(@RequestParam long id,
                       @RequestParam String fName,
                       @RequestParam String sName,
                       @RequestParam String lName,
                       @RequestParam long phone,
                       @RequestParam String addr,
                       @RequestParam String descr) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setDealer_id(id);
        dealer.setfName(fName);
        dealer.setsName(sName);
        dealer.setlName(lName);
        dealer.setPhone_number(phone);
        dealer.setAddress(addr);
        dealer.setDescription(descr);
        dealerService.Update(dealer);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public  void Delete(@RequestParam long id) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setDealer_id(id);
        dealerService.Delete(dealer);
    }
}
