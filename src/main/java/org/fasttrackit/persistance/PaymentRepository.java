package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreateIncomeRequest;
import org.fasttrackit.transfer.CreatePaymentRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentRepository {

    public void createTask(CreatePaymentRequest request) throws IOException, SQLException {
        String sql ="INSERT INTO payments (date, description, amount) VALUES (?, ?, ?)";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, Date.valueOf(request.getDate()));
            preparedStatement.setString(2,request.getDescription());
            preparedStatement.setDouble(3, request.getAmount());

            preparedStatement.executeUpdate();
        }



    }
}
