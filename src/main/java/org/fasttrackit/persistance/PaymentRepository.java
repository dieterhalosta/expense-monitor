package org.fasttrackit.persistance;

import org.fasttrackit.domain.Payments;
import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.CreatePaymentRequest;
import org.fasttrackit.transfer.UpdateIncomeRequest;
import org.fasttrackit.transfer.UpdatePaymentRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    public void createTask(CreatePaymentRequest request) throws IOException, SQLException, ClassNotFoundException {
        String sql ="INSERT INTO payments (date, description, amount) VALUES (?, ?, ?)";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, Date.valueOf(request.getDate()));
            preparedStatement.setString(2,request.getDescription());
            preparedStatement.setDouble(3, request.getAmount());

            preparedStatement.executeUpdate();
        }
    }

    public void updateTask(long id, UpdatePaymentRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE payments SET date = ?, description = ?, amount = ? WHERE id = ?";

        try(Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, Date.valueOf(request.getDate()));
            preparedStatement.setString(2, request.getDescription());
            preparedStatement.setDouble(3, request.getAmount());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteTask(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM payments WHERE id=?";

        try(Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }

    public List<Payments> getTask() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, date, description, amount FROM payments";

        List<Payments> tasks = new ArrayList<>();

        try(Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Payments task = new Payments();

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
