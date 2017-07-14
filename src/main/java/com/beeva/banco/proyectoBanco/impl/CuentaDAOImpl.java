package com.beeva.banco.proyectoBanco.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.banco.proyectoBanco.dao.CuentaDAO;
import com.beeva.banco.proyectoBanco.model.Cuenta;
import com.beeva.banco.proyectoBanco.model.MongoDB;

@Repository
public class CuentaDAOImpl extends CuentaDAO {
	
	@PersistenceContext
	EntityManager em;
	

	@Override
	@Transactional
	public Cuenta save(Cuenta cuenta) {
		cuenta.setBalance(0);
		em.persist(cuenta);
		MongoDB mongoDB=new MongoDB();
		mongoDB.cuentaLog(cuenta);
		return cuenta;
	}

	@Override
	@Transactional
	public Cuenta deposito(Cuenta cuenta, double deposito) {

		String cu = cuenta.getTipocuenta().getNombre();
		double depBalance = cuenta.getBalance();
		if (cu != null) {
			depBalance = depBalance + deposito;
			cuenta.setBalance(depBalance);
			System.out.print("\n Deposito: " + deposito
					+ " Balance con deposito:" + cuenta.getBalance());

		} else {
			System.out.println("No se puede realizar el deposito");
		}
		em.merge(cuenta);
		return cuenta;
	}

	@Override
	@Transactional
	public Cuenta retiro(Cuenta cuenta, double retiro,int dia) {

		String cu = cuenta.getTipocuenta().getNombre();
		double retBalance = cuenta.getBalance();

		if (cu.equals("Ahorro")) {
			if (retBalance > 5000) {
				retBalance = retBalance - retiro;
				cuenta.setBalance(retBalance);
				System.out.print("\n Retiro: " + retiro
						+ " Balance con retiro:" + cuenta.getBalance());
			} else {
				System.out
						.println("\n No se realizo el retiro!! Debes tener más de $5000.00 para realizar esta operación");
			}
		} else if (cu.equals("Cheques")) {
			if (dia > 1 && dia < 7) {
				retBalance = retBalance - retiro;
				cuenta.setBalance(retBalance);
				System.out.print("\n Retiro: " + retiro
						+ " Balance con retiro:" + cuenta.getBalance());
			} else {
				System.out
						.println("\n No se puede realizar retiros los fines de semana.");
			}
		} else {
			System.out.println("\n No se puede realizar el retiro");
		}
		
		em.merge(cuenta);
		return cuenta;
	}

}
