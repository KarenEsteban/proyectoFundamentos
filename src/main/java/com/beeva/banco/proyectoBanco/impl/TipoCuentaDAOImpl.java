package com.beeva.banco.proyectoBanco.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.banco.proyectoBanco.dao.TipoCuentaDAO;
import com.beeva.banco.proyectoBanco.model.Tipocuenta;

@Repository
public class TipoCuentaDAOImpl extends TipoCuentaDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Tipocuenta getTipocuenta(int id) {
		return em.find(Tipocuenta.class, id);
	}

	@Override
	@Transactional
	public Tipocuenta save(Tipocuenta tipocuenta) {
		em.persist(tipocuenta);
		return tipocuenta;
	}

}
