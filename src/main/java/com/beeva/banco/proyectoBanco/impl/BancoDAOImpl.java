package com.beeva.banco.proyectoBanco.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.banco.proyectoBanco.dao.BancoDAO;
import com.beeva.banco.proyectoBanco.model.Banco;

@Repository
public class BancoDAOImpl extends BancoDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Banco save(Banco banco) {
		em.persist(banco);
		return banco;
	}

}
