package org.fasttrackit.web;


import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.Payments;
import org.fasttrackit.service.PaymentsService;
import org.fasttrackit.transfer.CreatePaymentRequest;

import org.fasttrackit.transfer.UpdatePaymentRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {

    private PaymentsService paymentsService = new PaymentsService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreatePaymentRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), CreatePaymentRequest.class);

        try {
            paymentsService.createPayment(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while trying to reach the server." + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UpdatePaymentRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), UpdatePaymentRequest.class);

        try {
            paymentsService.updatePayment(Long.parseLong(id), request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while trying to reach the server." + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            paymentsService.deletePayment(Long.parseLong(id));
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while trying to reach the server." + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Payments> payments = paymentsService.getPayments();

            ObjectMapperConfiguration.OBJECT_MAPPER.writeValue(resp.getWriter(), payments);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while trying to reach the server." + e.getMessage());
        }
    }
}
