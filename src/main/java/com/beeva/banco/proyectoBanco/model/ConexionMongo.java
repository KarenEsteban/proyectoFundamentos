package com.beeva.banco.proyectoBanco.model;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class ConexionMongo {
	
	private String serv;
	private int port;
	
	public MongoClient conectarse() throws UnknownHostException{
		MongoClient mongo=null;
		mongo = new MongoClient(serv,port);
		return  mongo;
	}
	
	public String getServ() {
		return serv;
	}

	public void setServ(String serv) {
		this.serv = serv;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
