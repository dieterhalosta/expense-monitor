package org.fasttrackit.service;

import org.fasttrackit.domain.Payments;
import org.fasttrackit.persistance.PaymentRepository;
import org.fasttrackit.transfer.CreatePaymentRequest;
import org.fasttrackit.transfer.UpdatePaymentRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PaymentsService {

    private PaymentRepository paymentRepository = new PaymentRepository();

    public void createPayment(CreatePaymentRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating payment: " + request);

        paymentRepository.createTask(request);
    }

    public void updatePayment(long id, UpdatePaymentRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating payment: " + request);

        paymentRepository.updateTask(id, request);
    }

    public void deletePayment(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting payment: " + id);

        paymentRepository.deleteTask(id);
    }

    public List<Payments> getPayments() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving tasks");
        return paymentRepository.getTask();
    }
}
