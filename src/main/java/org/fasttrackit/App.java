package org.fasttrackit;


import org.fasttrackit.persistance.IncomeRepository;
import org.fasttrackit.persistance.PaymentRepository;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.CreatePaymentRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException {

//        CreateIncomeRequest request = new CreateIncomeRequest();
//        request.setDate(LocalDate.now());
//        request.setDescription("Test income");
//        request.setAmount(111.44);
//
//        IncomeRepository incomeRepository = new IncomeRepository();
//        incomeRepository.createTask(request);

        CreatePaymentRequest pRequest = new CreatePaymentRequest();
        pRequest.setDate(LocalDate.now());
        pRequest.setDescription("Test payment");
        pRequest.setAmount(10.55);

        PaymentRepository paymentRepository = new PaymentRepository();
        paymentRepository.createTask(pRequest);


    }
}
