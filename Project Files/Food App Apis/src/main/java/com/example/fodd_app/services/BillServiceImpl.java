package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.BillException;
import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Bill;
import com.example.Foodorderapp.model.Customer;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.repositories.BillDAO;
import com.example.Foodorderapp.repositories.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class BillServiceImpl implements BillService {

    BillDAO billDAO;
    CustomerDAO customerDAO;

    public BillServiceImpl(){

    }


    @Override
    public Bill addBill(Bill bill) throws BillException {
        Optional<Bill> optionalBill = this.billDAO.findById(bill.getBillId());
        if(optionalBill.isPresent()){
            throw new BillException("Bill already exists..");
        }else{
            return(Bill)this.billDAO.save(bill);
        }
    }

    @Override
    public Bill updateBill(Bill bill) throws BillException {
        Optional<Bill> optionalBill = this.billDAO.findById(bill.getBillId());
        if (optionalBill.isPresent()){
            return(Bill)this.billDAO.save(bill);

        }else{
            throw new BillException("Bill doesn't exists..");

        }
    }

    @Override
    public Bill removeBill(Integer billId) throws BillException {
        Optional<Bill> optionalBill = this.billDAO.findById(billId);
        if (optionalBill.isPresent()){
            Bill bill = optionalBill.get();
            this.billDAO.delete(bill);
            return bill;
        }else{
            throw new BillException("Bill doesn't exists.."+billId);
        }

    }

    @Override
    public Bill viewBill(Integer billId) throws BillException {
        Optional<Bill> optionalBill = this.billDAO.findById(billId);
        if (optionalBill.isPresent()){
            return optionalBill.get();
        }else{
            throw new BillException("Bill is not found by Id"+ billId);
        }

    }

    @Override
    public String generateTotalBillById(Integer customerId) throws ItemException, CustomerException {

        Optional<Customer> cOpt = customerDAO.findById(customerId);
        if(cOpt.isPresent()) {
            Customer customer = cOpt.get();
            List<Item> items = customer.getFoodCart().getItemList();

            if(items.size() > 0) {


                Double total  = 0.0;
                for(Item item : items) {
                    total += item.getCost();

                }

                return "The total bill for "+customer.getFullName()+" is "+total;

            }else {
                throw new ItemException("No order items found for "+customer.getFullName());
            }

        }else {
            throw new CustomerException("No Customer found with ID: "+customerId);
        }

    }


}
