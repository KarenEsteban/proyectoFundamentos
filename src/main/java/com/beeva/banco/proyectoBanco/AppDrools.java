package com.beeva.banco.proyectoBanco;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.beeva.banco.proyectoBanco.model.Cuenta;
import com.beeva.banco.proyectoBanco.model.CuentaDrools;



public class AppDrools {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			CuentaDrools cuenta=new CuentaDrools();
			cuenta.getTipocuenta().setNombre("Ahorro");
			cuenta.setBalance(1000);
			cuenta.setDeposito(60000);
			
			FactHandle fact1;
		
			fact1 = kSession.insert(cuenta);
			kSession.fireAllRules();

			System.out.println("Resultado: " + cuenta.getResultado());

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
