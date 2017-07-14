package com.beeva.banco.proyectoBanco.dao;

import com.beeva.banco.proyectoBanco.model.Tipocuenta;

public abstract class TipoCuentaDAO {
	
	public abstract Tipocuenta getTipocuenta(int id);
	public abstract Tipocuenta save(Tipocuenta tipocuenta);
}
