/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cashier;

import connection.ConnectionSQL;
import java.awt.HeadlessException;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;

/**
 *
 * @author Fery
 */
public class Transaction extends GetTXNumber implements Discountable {
        
    public Transaction(ConnectionSQL dbConnection) {
        super(dbConnection);
    }

    @Override
    public double applyVoucherDiscount(String codeVoucher) {
        double discountPercentage = 0.0;

        try {
            Connection con = dbConnection.getConnection();
            String sqlFetchDiscount = "SELECT discount FROM voucher WHERE code_voucher = ?";
            PreparedStatement pstFetchDiscount = con.prepareStatement(sqlFetchDiscount);
            pstFetchDiscount.setString(1, codeVoucher);
            ResultSet rsDiscount = pstFetchDiscount.executeQuery();

            if (rsDiscount.next()) {
                discountPercentage = rsDiscount.getDouble("discount");
            } else {
                JOptionPane.showMessageDialog(null, "Voucher tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rsDiscount.close();
            pstFetchDiscount.close();
        } catch (HeadlessException | SQLException ex) {
            System.err.println("Error applying voucher discount: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menerapkan voucher diskon", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return discountPercentage;
    }

    public String findVoucherCode() {
        String fetchedCodeVoucher = null;
        String sqlFetchVoucher = "SELECT code_voucher FROM cart ORDER BY id DESC LIMIT 1";

        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement pstFetchVoucher = con.prepareStatement(sqlFetchVoucher);
            ResultSet rsVoucher = pstFetchVoucher.executeQuery();

            if (rsVoucher.next()) {
                fetchedCodeVoucher = rsVoucher.getString("code_voucher");
            }

            rsVoucher.close();
            pstFetchVoucher.close();
        } catch (SQLException e) {
            System.err.println("Error fetching voucher code from cart: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mencari kode promo", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return fetchedCodeVoucher;
    }

    public String extractNumbers(String str) {
        StringBuilder numberBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuilder.append(c);
            }
        }
        return numberBuilder.length() > 0 ? numberBuilder.toString() : null;
    }
    
    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        try {
            Connection con = dbConnection.getConnection();
            String sqlFetchCart = "SELECT price FROM cart";
            PreparedStatement pstFetchCart = con.prepareStatement(sqlFetchCart);
            ResultSet rsCart = pstFetchCart.executeQuery();

            while (rsCart.next()) {
                double price = rsCart.getDouble("price");
                totalPrice += price ;
            }

            rsCart.close();
            pstFetchCart.close();
        } catch (SQLException ex) {
            System.err.println("Error calculating total price: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghitung total harga", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return totalPrice;
    }

    public double calculateSubTotal(String codeVoucher) {
        double totalPrice = 0.0;
        double discountPercentage = 0.0;

        if (codeVoucher != null && !codeVoucher.isEmpty()) {
            discountPercentage = applyVoucherDiscount(codeVoucher);
        }

        try {
            Connection con = dbConnection.getConnection();
            String sqlFetchCart = "SELECT price FROM cart";
            PreparedStatement pstFetchCart = con.prepareStatement(sqlFetchCart);
            ResultSet rsCart = pstFetchCart.executeQuery();

            while (rsCart.next()) {
                double price = rsCart.getDouble("price");
                totalPrice += price;
            }

            rsCart.close();
            pstFetchCart.close();
        } catch (SQLException ex) {
            System.err.println("Error calculating subtotal: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghitung subtotal", "Error", JOptionPane.ERROR_MESSAGE);
        }

        double discountAmount = totalPrice * (discountPercentage / 100);
        double finalPrice = totalPrice - discountAmount;

        return finalPrice;
    }
}