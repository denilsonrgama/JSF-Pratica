package br.com.fiapon.imoveis.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory fabrica;

	private EntityManagerFactorySingleton() {
	}

	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("ORACLE_FIAP");
		}

		return fabrica;
	}

}