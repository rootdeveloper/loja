package br.com.loja.business;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.loja.model.Entregador;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class EntregadorRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Entregador> entregadorEventSrc;

    public void register(Entregador entregador) throws Exception {
    	//a linha abaixo foi comentada, pois o método getNomeFantasia() está sendo implementado em outra classe, por outra pessoa, e, no momento, ainda não existe.
        //log.info("Registering " + entregador.getNomeFantasia());
        em.persist(entregador);
        entregadorEventSrc.fire(entregador);
    }
}
