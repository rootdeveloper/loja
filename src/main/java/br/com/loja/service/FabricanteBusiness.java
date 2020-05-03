package br.com.loja.service;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.loja.model.Fabricante;

public class FabricanteBusiness {

	//@Inject
	private Logger log;

	//@Inject
	private EntityManager em;

	//@Inject
	private Event<Fabricante> fabricanteEventSrc;

	public void cadastrarFabricante(Fabricante fabricante) {
		try {
		    log.info("Registering " + fabricante.getNomeFantasia());
			em.persist(fabricante);
			fabricanteEventSrc.fire(fabricante);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
