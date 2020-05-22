package org.fasttrackit.service;

import org.fasttrackit.domain.Incomes;
import org.fasttrackit.persistance.IncomeRepository;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.UpdateIncomeRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class IncomesService {

    private IncomeRepository incomeRepository = new IncomeRepository();

    public void createIncome(CreateIncomeRequest request) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Creating income: " + request);

        incomeRepository.createTask(request);
    }

    public void updateIncome (long id, UpdateIncomeRequest request) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Updating income: " + id);
        incomeRepository.updateTask(id, request);
    }

    public void deleteIncome (long id) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Deleting income: " + id);
        incomeRepository.deleteTask(id);
    }

    public List<Incomes> getIncomes() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Retrieving tasks");
        return incomeRepository.getTasks();
    }
}
