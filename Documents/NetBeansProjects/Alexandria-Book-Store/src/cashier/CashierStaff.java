/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cashier;

/**
 *
 * @author Fery
 */
public enum CashierStaff {
	Nando (01, "Cahya Fernando V. S."),
	Fery (02, "Fery Ardiansyah D."),
	Nopal (03, "Noval Aditya S.");
	
	private int id;
	private String nama;
	
	CashierStaff(int id, String nama) {
		this.id = id;
		this.nama = nama;
	}
}
