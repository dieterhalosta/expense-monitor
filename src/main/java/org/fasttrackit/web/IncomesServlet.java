package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.Incomes;
import org.fasttrackit.service.IncomesService;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.UpdateIncomeRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/incomes")
public class IncomesServlet extends HttpServlet {

    private IncomesService incomesService = new IncomesService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreateIncomeRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), CreateIncomeRequest.class);

        try {
            incomesService.createIncome(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error and couldn't reach the server. " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UpdateIncomeRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), UpdateIncomeRequest.class);

        try {
            incomesService.updateIncome(Long.parseLong(id), request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error and couldn't reach the server. " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            incomesService.deleteIncome(Long.parseLong(id));
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error and couldn't reach the server. " + e.getMessage());
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Incomes> incomes = incomesService.getIncomes();

            ObjectMapperConfiguration.OBJECT_MAPPER.writeValue(resp.getWriter(), incomes);

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error and couldn't reach the server. " + e.getMessage());
        }
    }
}

