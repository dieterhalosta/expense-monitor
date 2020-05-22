package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fasttrackit.service.IncomesService;
import org.fasttrackit.transfer.CreateIncomeRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/incomes")
public class IncomesServlet extends HttpServlet {

    private IncomesService incomesService = new IncomesService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        CreateIncomeRequest request = objectMapper.readValue(req.getReader(), CreateIncomeRequest.class);

        try {
            incomesService.createIncome(request);
        } catch (SQLException e) {
            resp.sendError(500, "There was an error and couldn't reach the server. " + e.getMessage());
        }

    }
}

