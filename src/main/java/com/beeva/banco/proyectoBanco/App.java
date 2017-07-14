package com.beeva.banco.proyectoBanco;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.banco.proyectoBanco.dao.BancoDAO;
import com.beeva.banco.proyectoBanco.dao.BancosclienteDAO;
import com.beeva.banco.proyectoBanco.dao.ClienteDAO;
import com.beeva.banco.proyectoBanco.dao.CuentaDAO;
import com.beeva.banco.proyectoBanco.dao.TipoCuentaDAO;
import com.beeva.banco.proyectoBanco.impl.BancoDAOImpl;
import com.beeva.banco.proyectoBanco.impl.BancosclienteDAOImpl;
import com.beeva.banco.proyectoBanco.impl.ClienteDAOImpl;
import com.beeva.banco.proyectoBanco.impl.CuentaDAOImpl;
import com.beeva.banco.proyectoBanco.impl.TipoCuentaDAOImpl;
import com.beeva.banco.proyectoBanco.model.Banco;
import com.beeva.banco.proyectoBanco.model.Bancoscliente;
import com.beeva.banco.proyectoBanco.model.Cliente;
import com.beeva.banco.proyectoBanco.model.Cuenta;
import com.beeva.banco.proyectoBanco.model.Tipocuenta;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");

		BancoDAO bancodao = (BancoDAO) context.getBean(BancoDAOImpl.class);
		BancosclienteDAO bcdao = (BancosclienteDAO) context
				.getBean(BancosclienteDAOImpl.class);
		ClienteDAO clientedao = (ClienteDAO) context
				.getBean(ClienteDAOImpl.class);
		CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAOImpl.class);
		TipoCuentaDAO tcdao = (TipoCuentaDAO) context
				.getBean(TipoCuentaDAOImpl.class);

		// ***CREAR CUENTA AHORRO***
		Tipocuenta cuentaAhorro = new Tipocuenta();
		cuentaAhorro.setNombre("Ahorro");
		tcdao.save(cuentaAhorro);

		// ***CREAR CUENTA CHEQUES***
		Tipocuenta cuentaCheques = new Tipocuenta();
		cuentaCheques.setNombre("Cheques");
		tcdao.save(cuentaCheques);

		// ***CREAR BANCOS***
		Banco banco = new Banco();
		banco.setNombre("BBVA Bancomer");
		bancodao.save(banco);

		// -------------------------------------PRUEBA 1---------------------------------
		// ----------------------------------CREAR CLIENTE----------------------------
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Karen");
		cliente1.setApellido("Esteban");
		clientedao.save(cliente1);

		// ***CREAR Y ASIGNAR CUENTA A CLIENTE 1***
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setCliente(cliente1);

		// ***ASIGNAR EL TIPO DE CUENTA AL CLIENTE 1***
		cuenta1.setTipocuenta(cuentaAhorro);
		;
		cuentadao.save(cuenta1);

		// --------------------------------------PRUEBA 2-------------------------------------
		// ------------------------------------CREAR CLIENTE--------------------------------
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Yael");
		cliente2.setApellido("Ortiz");
		clientedao.save(cliente2);

		// ***ASIGNAR CUENTA AL CLIENTE 2***
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setCliente(cliente2);

		// ***ASIGNAR TIPO DE CUENTA AL CLIENTE 2***
		cuenta2.setTipocuenta(cuentaCheques);
		cuentadao.save(cuenta2);

		// ***INFORMACION CLIENTE 1
		System.out.println("\n ***CLIENTE 1*** 	\n ID: "
				+ cuenta1.getCliente().getIdcliente() + "\n Nombre: "
				+ cuenta1.getCliente().getNombre() + "\n Tipo cuenta: "
				+ cuenta1.getTipocuenta().getNombre() + "\n Balance actual: "
				+ cuenta1.getBalance());
		
		//Dia entre semana
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		
		// ------------------------------------PRUEBA 3-------------------------------------
		// Depositar $500 al CLIENTE 1
		cuentadao.deposito(cuenta1, 500);

		// ------------------------------------PRUEBA 4---------------------------------------
		// Retirar $100 al CLIENTE 1
		cuentadao.retiro(cuenta1, 100,dia);
		

		// ------------------------------------PRUEBA 5----------------------------------------
		// Depositar $50000 al CLIENTE 1
		
		cuentadao.deposito(cuenta1, 5000);
	
		// ------------------------------------PRUEBA 6----------------------------------------
		// Retiro de $100 al CLIENTE 1
		cuentadao.retiro(cuenta1, 100,dia);

		// ****INFORMACION CLIENTE 2****
		System.out.println("\n\n ***CLIENTE 2*** 	\n ID: "
				+ cuenta2.getCliente().getIdcliente() + "\n Nombre: "
				+ cuenta2.getCliente().getNombre() + "\n Tipo cuenta: "
				+ cuenta2.getTipocuenta().getNombre() + "\n Balance actual: "
				+ cuenta2.getBalance());
		// ------------------------------------PRUEBA 7----------------------------------------
		// Deposito de $1000 al CLIENTE 2 
		cuentadao.deposito(cuenta2, 1000);

		// ------------------------------------PRUEBA 8----------------------------------------
		// Retiro de $100 al CLIENTE 2 con fecha entre semana
		cuentadao.retiro(cuenta2, 100,dia);
		// ------------------------------------PRUEBA 9----------------------------------------
		//Dia fin de semana
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		int dia2 = cal.get(Calendar.DAY_OF_WEEK);
		// Retiro de $100 al CLIENTE 2 con en fin de semana
		cuentadao.retiro(cuenta2, 100,dia2);

		// ------------------------------------PRUEBA 10----------------------------------------
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Juan");
		cliente3.setApellido("Torres");
		clientedao.save(cliente3);

		// ***CREAR Y ASIGNAR CUENTA AL CLIENTE 3
		Cuenta cuenta3 = new Cuenta();
		cuenta3.setCliente(cliente3);

		// ****ASIGNAR TIPO DE CUENTA AHORRO***
		cuenta3.setTipocuenta(cuentaAhorro);
		cuentadao.save(cuenta3);

		// *****INFORMACION CLIENTE 3*******
		System.out.println("\n ***CLIENTE 3*** 	\n ID: "
				+ cuenta3.getCliente().getIdcliente() + "\n Nombre: "
				+ cuenta3.getCliente().getNombre() + "\n Tipo cuenta: "
				+ cuenta3.getTipocuenta().getNombre() + "\n Balance actual: "
				+ cuenta3.getBalance());

		// --------------------------------ASIGNAR BANCO Y CLIENTES-------------------------------
		Bancoscliente banclient = new Bancoscliente();
		banclient.setBanco(banco);
		banclient.setCliente(cliente1);
		banclient.setCliente(cliente2);
		banclient.setCliente(cliente3);
		bcdao.save(banclient);


	}
}
