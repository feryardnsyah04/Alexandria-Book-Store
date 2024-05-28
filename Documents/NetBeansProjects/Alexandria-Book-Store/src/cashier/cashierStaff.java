/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cashier;

/**
 *
 * @author Fery
 */
public enum cashierStaff {
    Fery (114, "Fery Ardiansyah"),
    Nando (123, "Cahya Fernando"),
    Nopal (345, "Noval Aditya");
	
    private int id;
    private String nama;
    
    cashierStaff(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
}

