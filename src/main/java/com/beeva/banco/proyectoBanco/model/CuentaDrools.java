package com.beeva.banco.proyectoBanco.model;

public class CuentaDrools {
	private Tipocuenta tipocuenta;
	private double deposito;
	private double balance;
	private String resultado;
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Tipocuenta getTipocuenta() {
		return tipocuenta;
	}
	public void setTipocuenta(Tipocuenta tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public double getDeposito() {
		return deposito;
	}
	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
