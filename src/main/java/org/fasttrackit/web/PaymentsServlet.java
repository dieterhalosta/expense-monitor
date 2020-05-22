package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fasttrackit.service.PaymentsService;
import org.fasttrackit.transfer.CreatePaymentRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {

    private PaymentsService paymentsService = new PaymentsService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        CreatePaymentRequest request = objectMapper.readValue(req.getReader(), CreatePaymentRequest.class);

        try {
            paymentsService.createPayment(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while trying to reach the server." + e.getMessage());
        }

    }
}
