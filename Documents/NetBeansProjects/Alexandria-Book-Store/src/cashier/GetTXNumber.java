/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cashier;

import connection.ConnectionSQL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author Fery
 */
public class GetTXNumber {
    protected final ConnectionSQL dbConnection;
    
    public GetTXNumber(ConnectionSQL dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    protected String generateTransactionNumber() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 
        String formattedDate = now.format(dateFormatter);

        int leftLimit = 65;
        int rightLimit = 90;
        int targetStringLength = 4;
        Random random = new Random();

        StringBuilder randomString = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = random.nextInt(rightLimit - leftLimit + 1) + leftLimit;
            randomString.append((char) randomLimitedInt);
        }
        return formattedDate + randomString.toString();
    }
}
