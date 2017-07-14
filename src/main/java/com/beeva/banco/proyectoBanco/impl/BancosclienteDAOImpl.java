package com.beeva.banco.proyectoBanco.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.banco.proyectoBanco.dao.BancosclienteDAO;
import com.beeva.banco.proyectoBanco.model.Bancoscliente;

@Repository
public class BancosclienteDAOImpl extends BancosclienteDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Bancoscliente save(Bancoscliente bancoscliente) {
		em.persist(bancoscliente);
		return bancoscliente;
	}

}
