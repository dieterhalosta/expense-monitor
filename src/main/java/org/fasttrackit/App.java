package org.fasttrackit;


import org.fasttrackit.domain.Incomes;
import org.fasttrackit.persistance.IncomeRepository;
import org.fasttrackit.persistance.PaymentRepository;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.CreatePaymentRequest;
import org.fasttrackit.transfer.UpdateIncomeRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException {

//        CreateIncomeRequest request = new CreateIncomeRequest();
//        request.setDate(LocalDate.now());
//        request.setDescription("Test income");
//        request.setAmount(111.44);
////

//        UpdateIncomeRequest updateIncomeRequest = new UpdateIncomeRequest();
//        updateIncomeRequest.setAmount(3123.44);
//        updateIncomeRequest.setDescription("Just for the test of it.");
//        updateIncomeRequest.setDate(LocalDate.now());

        IncomeRepository incomeRepository = new IncomeRepository();
//        incomeRepository.createTask(request);
//        incomeRepository.updateTask(1, updateIncomeRequest);
//        incomeRepository.deleteTask(3);

        List<Incomes> tasks = incomeRepository.getTasks();
        System.out.println(tasks);

//        CreatePaymentRequest pRequest = new CreatePaymentRequest();
//        pRequest.setDate(LocalDate.now());
//        pRequest.setDescription("Test payment");
//        pRequest.setAmount(10.55);
//
//        PaymentRepository paymentRepository = new PaymentRepository();
//        paymentRepository.createTask(pRequest);




    }
}
