package com.beeva.banco.proyectoBanco.dao;

import com.beeva.banco.proyectoBanco.model.Cuenta;


public abstract class CuentaDAO {
	
	public abstract Cuenta save(Cuenta cuenta);
	public abstract Cuenta deposito(Cuenta cuenta,double deposito);
	public abstract Cuenta retiro(Cuenta cuenta,double retiro, int dia);

}
