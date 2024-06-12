/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cashier;

import connection.ConnectionSQL;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import warehouse.WarehouseLoading;

/**
 *
 * @author Fery
 */
public class ABSframe extends javax.swing.JFrame {
    private final ConnectionSQL dbConnection;
    private final Transaction transaction;

    /**
     * Creates new form ABSframe
     */
    public ABSframe() {
        initComponents();
        
        // Initialize database ConnectionSQL
        dbConnection = new ConnectionSQL();
        dbConnection.databaseConnection();
        
        // Initialize method from Transaction.java
        transaction = new Transaction(dbConnection);
        
        // Set window to center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // Set application icon
        URL resource = this.getClass().getResource("/img/logo_app.png");
        if (resource == null) {
            System.err.println("Resource not found");
        } else {
            System.out.println("Resource found: " + resource.toExternalForm());
            Image iconApp = new ImageIcon(resource).getImage();
            this.setIconImage(iconApp);
        }
        
        // Initialize date and time
        showDate();
        showTime();
        
        // Automatically set shift based on the current time
        setShiftBasedOnCurrentTime();
        
        // Show product items
        showStorageItems();
        showCartItems();
        
        double totalPrice = transaction.calculateTotalPrice();
        totalPriceProduct.setText(String.format("Rp %.2f", totalPrice));

        String codeVoucher = discountVoucher.getText();
        double subTotalPrice;
        
        if (codeVoucher == null || codeVoucher.trim().isEmpty()) {
            subTotalPrice = totalPrice;
        } else {
            subTotalPrice = transaction.calculateSubTotal(codeVoucher);
        }

        subtotalPriceProduct.setText(String.format("Rp %.2f", subTotalPrice));
    }
    
    private void setShiftBasedOnCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(8, 0)) && currentTime.isBefore(LocalTime.of(16, 0))) {
            cashierList.setSelectedIndex(0); 
        } else if (currentTime.isAfter(LocalTime.of(16, 0)) && currentTime.isBefore(LocalTime.MIDNIGHT)) {
            cashierList.setSelectedIndex(1);
        } else {
            cashierList.setSelectedIndex(2);
        }
    }
    
    public String getSelectedStaff() {
        String selectedStaff = (String) cashierList.getSelectedItem();
        return selectedStaff;
    }

    
    private void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
        String date = s.format(d);
        dateText.setText(date);
    }
    
    private void showTime() {
        new Timer(0, (ActionEvent ae) -> {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("HH-mm-ss");
            String time = s.format(d);
            timeText.setText(time);
        }).start();
    }
    
    void showStorageItems() {
        try {
            Connection con = dbConnection.getConnection();

            String sqlShowProduct = "SELECT code_products, product_name, category, quantity, price FROM storage_items";
            try (PreparedStatement pst = con.prepareStatement(sqlShowProduct); ResultSet rs = pst.executeQuery()) {
                
                DefaultTableModel model = (DefaultTableModel) tableItem.getModel();
                model.setRowCount(0);
                
                while (rs.next()) {
                    Object[] rowData = new Object[rs.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rowData.length; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    model.addRow(rowData);
                }

            }
        } catch (SQLException ex) {
            System.err.println("Error fetching data: " + ex.getMessage());
        }
    }
    
    void showCartItems() {
        try {
            Connection con = dbConnection.getConnection();

            String sqlShowCart = "SELECT code_products, product_name, category, quantity, price FROM cart";
            try (PreparedStatement pst = con.prepareStatement(sqlShowCart); ResultSet rs = pst.executeQuery()) {
                
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                model.setRowCount(0);
                
                while (rs.next()) {
                    Object[] rowData = new Object[rs.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rowData.length; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    model.addRow(rowData);
                }

            }
        } catch (SQLException ex) {
            System.err.println("Error fetching data: " + ex.getMessage());
        }    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItem = new javax.swing.JTable();
        dateText = new javax.swing.JLabel();
        timeText = new javax.swing.JLabel();
        dateText1 = new javax.swing.JLabel();
        timeText1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cashierList = new javax.swing.JComboBox<>();
        warehouseBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalPriceProduct = new javax.swing.JLabel();
        discountRate = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        subtotalPriceProduct = new javax.swing.JLabel();
        deleteCartBtn = new javax.swing.JButton();
        refreshCartBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idProductField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        quantityProductField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cashMethod = new javax.swing.JRadioButton();
        qrisMethod = new javax.swing.JRadioButton();
        cashoutButton = new javax.swing.JButton();
        addProductBtn = new javax.swing.JButton();
        deleteProductBtn = new javax.swing.JButton();
        discountVoucher = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Kasir - Alexandria Book Store");
        setResizable(false);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 56, 69), 2, true));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("DAFTAR BARANG");

        tableItem.setAutoCreateRowSorter(true);
        tableItem.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori", "Stok", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItem.setShowGrid(true);
        tableItem.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableItem);

        dateText.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateText.setText("Date");

        timeText.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        timeText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeText.setText("Time");

        dateText1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateText1.setText("Tanggal");

        timeText1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        timeText1.setText("Waktu     ");

        jLabel4.setText(":");

        jLabel5.setText(":");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeText1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateText)
                            .addComponent(timeText))
                        .addGap(61, 61, 61))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateText)
                            .addComponent(dateText1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeText)
                            .addComponent(timeText1)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 56, 69), 2, true));

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("KASIR");

        cashierList.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cashierList.setMaximumRowCount(3);
        cashierList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fery", "Nando", "Nopal" }));
        cashierList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashierListActionPerformed(evt);
            }
        });

        warehouseBtn.setBackground(new java.awt.Color(2, 117, 216));
        warehouseBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        warehouseBtn.setForeground(new java.awt.Color(255, 255, 255));
        warehouseBtn.setText("Warehouse");
        warehouseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warehouseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashierList, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(cashierList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(warehouseBtn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 56, 69), 2, true));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("KERANJANG");

        tableCart.setAutoCreateRowSorter(true);
        tableCart.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCart.setShowGrid(true);
        jScrollPane2.setViewportView(tableCart);

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setText("Total :");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setText("Diskon :");

        totalPriceProduct.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        totalPriceProduct.setText("Rp 0,00");

        discountRate.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        discountRate.setText("0");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sub Total :");

        subtotalPriceProduct.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        subtotalPriceProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subtotalPriceProduct.setText("Rp 0,00");

        deleteCartBtn.setBackground(new java.awt.Color(217, 83, 79));
        deleteCartBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        deleteCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteCartBtn.setText("Hapus Keranjang");
        deleteCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCartBtnActionPerformed(evt);
            }
        });

        refreshCartBtn.setBackground(new java.awt.Color(2, 117, 216));
        refreshCartBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        refreshCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshCartBtn.setText("Refresh Keranjang");
        refreshCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(274, 274, 274)
                        .addComponent(refreshCartBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteCartBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalPriceProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(discountRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subtotalPriceProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deleteCartBtn)
                    .addComponent(refreshCartBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPriceProduct)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(discountRate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(subtotalPriceProduct))
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 56, 69), 2, true));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TAMBAH BARANG");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("ID Barang");

        idProductField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idProductField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idProductField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Jumlah");

        quantityProductField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityProductField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        quantityProductField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityProductFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Metode Pembayaran");

        buttonGroup1.add(cashMethod);
        cashMethod.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cashMethod.setText("Tunai");

        buttonGroup1.add(qrisMethod);
        qrisMethod.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        qrisMethod.setText("QRIS");

        cashoutButton.setBackground(new java.awt.Color(92, 184, 92));
        cashoutButton.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cashoutButton.setForeground(new java.awt.Color(255, 255, 255));
        cashoutButton.setText("Lanjut Pembayaran");
        cashoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashoutButtonActionPerformed(evt);
            }
        });

        addProductBtn.setBackground(new java.awt.Color(2, 117, 216));
        addProductBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        addProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        addProductBtn.setText("Tambah");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        deleteProductBtn.setBackground(new java.awt.Color(217, 83, 79));
        deleteProductBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        deleteProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteProductBtn.setText("Hapus");
        deleteProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductBtnActionPerformed(evt);
            }
        });

        discountVoucher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discountVoucher.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        discountVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountVoucherActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Kode Promo (Opsional)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discountVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(deleteProductBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addProductBtn))
                                .addComponent(jLabel9)
                                .addComponent(idProductField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(quantityProductField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cashoutButton)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(cashMethod)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(qrisMethod)))
                                    .addGap(34, 34, 34)))
                            .addComponent(jLabel19))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductBtn)
                    .addComponent(deleteProductBtn))
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discountVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashMethod)
                    .addComponent(qrisMethod))
                .addGap(39, 39, 39)
                .addComponent(cashoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idProductFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductFieldActionPerformed

    private void quantityProductFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityProductFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityProductFieldActionPerformed

    private void cashierListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashierListActionPerformed
        // TODO add your handling code here:
        String selectedShift = (String) cashierList.getSelectedItem();
        String pickCashier = "";

        switch (selectedShift) {
            case "Shift 1" -> pickCashier = "SELECT nickname FROM cashier WHERE nickname = 'Fery'";
            case "Shift 2" -> pickCashier = "SELECT nickname FROM cashier WHERE nickname = 'Nando'";
            case "Shift 3" -> pickCashier = "SELECT nickname FROM cashier WHERE nickname = 'Nopal'";
        }
        
        try (PreparedStatement stmt = dbConnection.getCon().prepareStatement(pickCashier);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                cashierList.addItem(rs.getString("nickname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cashierListActionPerformed

    private void cashoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashoutButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (cashMethod.isSelected()) {
                CashoutCash cash = new CashoutCash();
                cash.setVisible(true);
            } else if (qrisMethod.isSelected()) {
                CashoutQRIS qris = new CashoutQRIS();
                qris.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih salah satu metode pembayaran!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cashoutButtonActionPerformed

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        // TODO add your handling code here:
        String idProduct = idProductField.getText();
        int quantityProduct;

        try {
            quantityProduct = Integer.parseInt(quantityProductField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idProduct.isEmpty() || quantityProduct <= 0) {
            JOptionPane.showMessageDialog(this, "ID Barang dan Jumlah harus diisi dengan benar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection con = dbConnection.getConnection();

            String sqlCheckProduct = "SELECT code_products, product_name, category, quantity, price FROM storage_items WHERE code_products = ?";
            PreparedStatement pstCheckProduct = con.prepareStatement(sqlCheckProduct);
            pstCheckProduct.setString(1, idProduct);
            ResultSet rsProduct = pstCheckProduct.executeQuery();

            if (!rsProduct.next()) {
                JOptionPane.showMessageDialog(this, "Tidak menemukan barang", "Error", JOptionPane.ERROR_MESSAGE);
                rsProduct.close();
                pstCheckProduct.close();
                return;
            }

            int availableQuantity = rsProduct.getInt("quantity");
            if (quantityProduct > availableQuantity) {
                JOptionPane.showMessageDialog(this, "Jumlah lebih dari stok", "Error", JOptionPane.ERROR_MESSAGE);
                rsProduct.close();
                pstCheckProduct.close();
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
            Object[] rowData = new Object[]{
                rsProduct.getString("code_products"),
                rsProduct.getString("product_name"),
                rsProduct.getString("category"),
                quantityProduct,
                rsProduct.getDouble("price") * quantityProduct
            };
            model.addRow(rowData);

            String sqlAddToCart = "INSERT INTO cart (code_products, product_name, category, quantity, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstAddToCart = con.prepareStatement(sqlAddToCart);
            pstAddToCart.setString(1, rsProduct.getString("code_products"));
            pstAddToCart.setString(2, rsProduct.getString("product_name"));
            pstAddToCart.setString(3, rsProduct.getString("category"));
            pstAddToCart.setInt(4, quantityProduct);
            pstAddToCart.setDouble(5, rsProduct.getDouble("price") * quantityProduct);
            pstAddToCart.executeUpdate();

            String sqlUpdateQuantity = "UPDATE storage_items SET quantity = ? WHERE code_products = ?";
            PreparedStatement pstUpdateQuantity = con.prepareStatement(sqlUpdateQuantity);
            pstUpdateQuantity.setInt(1, availableQuantity - quantityProduct);
            pstUpdateQuantity.setString(2, idProduct);
            pstUpdateQuantity.executeUpdate();

            rsProduct.close();
            pstCheckProduct.close();
            pstAddToCart.close();
            pstUpdateQuantity.close();

            JOptionPane.showMessageDialog(this, "Barang berhasil ditambahkan ke keranjang", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | SQLException ex) {
            System.err.println("Error fetching data: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan barang", "Error", JOptionPane.ERROR_MESSAGE);
        }

        double totalPrice = transaction.calculateTotalPrice();
        totalPriceProduct.setText(String.format("Rp %.2f", totalPrice));

        String codeVoucher = discountVoucher.getText();
        double subTotalPrice;
        
        if (codeVoucher == null || codeVoucher.trim().isEmpty()) {
            subTotalPrice = totalPrice;
        } else {
            subTotalPrice = transaction.calculateSubTotal(codeVoucher);
        }

        subtotalPriceProduct.setText(String.format("Rp %.2f", subTotalPrice));

        showStorageItems();
    }//GEN-LAST:event_addProductBtnActionPerformed

    private void deleteProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductBtnActionPerformed
        // TODO add your handling code here:
       String idProduct = idProductField.getText();
       int quantityProduct;

       try {
           quantityProduct = Integer.parseInt(quantityProductField.getText());
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "Jumlah tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       if (idProduct.isEmpty() || quantityProduct <= 0) {
           JOptionPane.showMessageDialog(this, "ID Barang dan Jumlah harus diisi dengan benar", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       try {
           Connection con = dbConnection.getConnection();

           String sqlDeleteProduct = "DELETE FROM cart WHERE code_products = ? AND quantity = ?";
           PreparedStatement pstDeleteProduct = con.prepareStatement(sqlDeleteProduct);
           pstDeleteProduct.setString(1, idProduct);
           pstDeleteProduct.setInt(2, quantityProduct);
           int rowsAffected = pstDeleteProduct.executeUpdate();

           if (rowsAffected > 0) {
               DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
               for (int i = 0; i < model.getRowCount(); i++) {
                   if (model.getValueAt(i, 0).equals(idProduct) && model.getValueAt(i, 3).equals(quantityProduct)) {
                       model.removeRow(i);
                       break;
                   }
               }

               String sqlUpdateStorage = "UPDATE storage_items SET quantity = quantity + ? WHERE code_products = ?";
               PreparedStatement pstUpdateStorage = con.prepareStatement(sqlUpdateStorage);
               pstUpdateStorage.setInt(1, quantityProduct);
               pstUpdateStorage.setString(2, idProduct);
               pstUpdateStorage.executeUpdate();

               pstUpdateStorage.close();
               pstDeleteProduct.close();

               JOptionPane.showMessageDialog(this, "Barang berhasil dihapus dari keranjang", "Success", JOptionPane.INFORMATION_MESSAGE);
           } else {
               JOptionPane.showMessageDialog(this, "Barang tidak ditemukan di keranjang", "Error", JOptionPane.ERROR_MESSAGE);
           }

       } catch (HeadlessException | SQLException ex) {
           System.err.println("Error deleting data: " + ex.getMessage());
           JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus barang", "Error", JOptionPane.ERROR_MESSAGE);
       }
       
       showStorageItems();

       double totalPrice = transaction.calculateTotalPrice();
       totalPriceProduct.setText(String.format("Rp %.2f", totalPrice));

       String codeVoucher = discountVoucher.getText();
       double subTotalPrice;
        
       if (codeVoucher == null || codeVoucher.trim().isEmpty()) {
           subTotalPrice = totalPrice;
       } else {
           subTotalPrice = transaction.calculateSubTotal(codeVoucher);
       }

       subtotalPriceProduct.setText(String.format("Rp %.2f", subTotalPrice));
    }//GEN-LAST:event_deleteProductBtnActionPerformed

    private void discountVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountVoucherActionPerformed
        // TODO add your handling code here:
        String codeVoucher = discountVoucher.getText().trim();

        double discountPercentage = transaction.getVoucherDiscount(codeVoucher);
        discountRate.setText(String.format("%d%%", (int) discountPercentage));

        double finalPrice = transaction.calculateSubTotal(codeVoucher);

        subtotalPriceProduct.setText(String.format("Rp %.2f", finalPrice));
    }//GEN-LAST:event_discountVoucherActionPerformed

    private void deleteCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCartBtnActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = dbConnection.getConnection();

            String sqlFetchCart = "SELECT code_products, quantity FROM cart";
            PreparedStatement pstFetchCart = con.prepareStatement(sqlFetchCart);
            ResultSet rsCart = pstFetchCart.executeQuery();

            while (rsCart.next()) {
                String codeProduct = rsCart.getString("code_products");
                int quantity = rsCart.getInt("quantity");

                String sqlUpdateStorage = "UPDATE storage_items SET quantity = quantity + ? WHERE code_products = ?";
                PreparedStatement pstUpdateStorage = con.prepareStatement(sqlUpdateStorage);
                pstUpdateStorage.setInt(1, quantity);
                pstUpdateStorage.setString(2, codeProduct);
                pstUpdateStorage.executeUpdate();
                pstUpdateStorage.close();
            }

            rsCart.close();
            pstFetchCart.close();

            String sqlDeleteCart = "DELETE FROM cart";
            PreparedStatement pstDeleteCart = con.prepareStatement(sqlDeleteCart);
            pstDeleteCart.executeUpdate();
            pstDeleteCart.close();

            DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
            model.setRowCount(0);

            JOptionPane.showMessageDialog(this, "Keranjang berhasil dikosongkan", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | SQLException ex) {
            System.err.println("Error deleting data: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengosongkan keranjang", "Error", JOptionPane.ERROR_MESSAGE);
        }

        showStorageItems();
        
        // update sub total & total price
        double totalPrice = transaction.calculateTotalPrice();
        totalPriceProduct.setText(String.format(" Rp %.2f", totalPrice));
        double subTotalPrice = transaction.calculateSubTotal(null);
        subtotalPriceProduct.setText(String.format(" Rp %.2f", subTotalPrice));
    }//GEN-LAST:event_deleteCartBtnActionPerformed

    private void refreshCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCartBtnActionPerformed
        // TODO add your handling code here:
        showCartItems();
    }//GEN-LAST:event_refreshCartBtnActionPerformed

    private void warehouseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseBtnActionPerformed
        // TODO add your handling code here:
        new WarehouseLoading().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_warehouseBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ABSframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABSframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABSframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABSframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABSframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cashMethod;
    private javax.swing.JComboBox<String> cashierList;
    private javax.swing.JButton cashoutButton;
    private javax.swing.JLabel dateText;
    private javax.swing.JLabel dateText1;
    private javax.swing.JButton deleteCartBtn;
    private javax.swing.JButton deleteProductBtn;
    private javax.swing.JLabel discountRate;
    private javax.swing.JTextField discountVoucher;
    private javax.swing.JTextField idProductField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton qrisMethod;
    private javax.swing.JTextField quantityProductField;
    private javax.swing.JButton refreshCartBtn;
    private javax.swing.JLabel subtotalPriceProduct;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableItem;
    private javax.swing.JLabel timeText;
    private javax.swing.JLabel timeText1;
    private javax.swing.JLabel totalPriceProduct;
    private javax.swing.JButton warehouseBtn;
    // End of variables declaration//GEN-END:variables
}
