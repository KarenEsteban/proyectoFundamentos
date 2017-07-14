package com.beeva.banco.proyectoBanco.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.banco.proyectoBanco.dao.ClienteDAO;
import com.beeva.banco.proyectoBanco.model.Cliente;
import com.beeva.banco.proyectoBanco.model.MongoDB;

@Repository
public class ClienteDAOImpl extends ClienteDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		em.persist(cliente);
		MongoDB mongoDB=new MongoDB();
		mongoDB.clienteLog(cliente);
		
		return cliente;
	}
	
	
}
