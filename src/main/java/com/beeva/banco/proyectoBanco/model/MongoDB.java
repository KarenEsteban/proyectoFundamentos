package com.beeva.banco.proyectoBanco.model;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDB {
    
	// ------------------------------------PRUEBA 11----------------------------------------
	    ConexionMongo conexion;
	
	// Fecha del sistema
		Date fecha = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

	public MongoDB() {
		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
		conexion = (ConexionMongo) context.getBean("mongocl");
	}

	public void cuentaLog(Cuenta cuenta) {

		MongoClient mc;
		try {
			mc = conexion.conectarse();
			DB db = mc.getDB("BancoLog");
			DBCollection table = db.getCollection("LogCollection");		

			BasicDBObject document = new BasicDBObject();
			document.put("fecha", formatoFecha.format(fecha));
			document.put("mensaje","Se inserto un registro de cuenta");
			document.put("cuenta", cuenta.getIdcuenta());
			document.put("tipoCuenta", cuenta.getTipocuenta().getNombre());
			document.put("cliente", cuenta.getCliente().getIdcliente());

			table.insert(document);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void clienteLog(Cliente cliente) {
		
		MongoClient mc;
		try {
			mc = conexion.conectarse();
			DB db = mc.getDB("BancoLog");
			DBCollection table = db.getCollection("LogCollection");

			BasicDBObject document = new BasicDBObject();
			document.put("fecha", formatoFecha.format(fecha));
			document.put("mensaje","Se inserto un registro de cliente");
			document.put("cliente", cliente.getIdcliente());
			document.put("nombre", cliente.getNombre());
			document.put("apellido", cliente.getApellido());

			table.insert(document);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
