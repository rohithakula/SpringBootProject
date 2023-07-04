package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.BillException;
import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Bill;

public interface BillService {

    Bill addBill(Bill bill) throws BillException;
    Bill updateBill(Bill bill) throws BillException;

    Bill removeBill(Integer billId) throws BillException;
    Bill viewBill(Integer billId) throws BillException;
    String generateTotalBillById(Integer customerId) throws ItemException,CustomerException;
}
