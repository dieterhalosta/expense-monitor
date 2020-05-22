package org.fasttrackit.persistance;

import org.fasttrackit.domain.Incomes;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.UpdateIncomeRequest;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeRepository {

    public void createTask(CreateIncomeRequest request) throws IOException, SQLException, ClassNotFoundException {
        String sql ="INSERT INTO incomes (date, description, amount) VALUES (?, ?, ?)";

        try(Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, Date.valueOf(request.getDate()));
            preparedStatement.setString(2,request.getDescription());
            preparedStatement.setDouble(3, request.getAmount());

            preparedStatement.executeUpdate();
        }

    }

    public void updateTask(long id, UpdateIncomeRequest request) throws IOException, SQLException, ClassNotFoundException {
        String sql = "UPDATE incomes SET date = ?, description = ?, amount = ? WHERE id = ?";

        try(Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(request.getDate()));
            preparedStatement.setString(2, request.getDescription());
            preparedStatement.setDouble(3, request.getAmount());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();
        }

    }

    public void deleteTask (long id) throws IOException, SQLException, ClassNotFoundException {
        String sql = "DELETE FROM incomes WHERE id = ?";

        try(Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }

    public List<Incomes> getTasks() throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT id, date, description, amount FROM incomes";

        List<Incomes> tasks = new ArrayList<>();

        try(Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Incomes task = new Incomes();
                task.setId(resultSet.getLong("id"));
                Date dateAsSqlDate = resultSet.getDate("date");
                task.setDate(dateAsSqlDate.toLocalDate());
                task.setDescription(resultSet.getString("description"));
                task.setAmount(resultSet.getDouble("amount"));

                tasks.add(task);
            }
        }

        return tasks;
    }
}
