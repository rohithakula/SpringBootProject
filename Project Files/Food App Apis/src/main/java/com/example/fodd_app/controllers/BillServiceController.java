package com.example.Foodorderapp.controllers;
import com.example.Foodorderapp.exceptions.BillException;
import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Bill;
import com.example.Foodorderapp.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/bill"})
public class BillServiceController {

    BillService billService;

    public BillServiceController(){

    }

    @PostMapping({"/add"})
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws BillException{
        Bill bill1 = this.billService.addBill(bill);
        return new ResponseEntity(bill1, HttpStatus.CREATED);
    }

    @PutMapping({"/update"})
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException{
        Bill bill1 = this.billService.updateBill(bill);
        return new ResponseEntity(bill1,HttpStatus.ACCEPTED);
    }
    @DeleteMapping({"/remove/{billId}"})
    public ResponseEntity<Bill> removeBill(@PathVariable("buildId") Integer billId) throws BillException{
        Bill removebill = this.billService.removeBill(billId);
        return new ResponseEntity(removebill,HttpStatus.OK);
    }

    @GetMapping({"/view/{billId}"})
    public ResponseEntity<Bill> viewBill(@PathVariable("buildId") Integer billId) throws BillException{
        Bill viewBill = this.billService.viewBill(billId);
        return new ResponseEntity(viewBill,HttpStatus.OK);
    }

    @GetMapping({"/viewTotal/{customerId}"})
    public ResponseEntity<Bill> getTotalByCustomerId(@PathVariable("customerId") Integer customerId) throws ItemException, CustomerException {
        String totalBill = this.billService.generateTotalBillById(customerId);
        return new ResponseEntity(totalBill,HttpStatus.OK);

    }

}
