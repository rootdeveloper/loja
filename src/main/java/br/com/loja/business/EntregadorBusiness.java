package br.com.loja.business;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.loja.enums.ModalidadeFrete;
import br.com.loja.model.Endereco;
import br.com.loja.model.Entregador;
import br.com.loja.model.Pessoa;

@Stateless
public class EntregadorBusiness {

	@Inject
	private EntityManager em;

	@Inject
	private Logger logger;

	public void criarEntregador(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco, List<Pessoa> responsaveis, ModalidadeFrete modalidadeFrete) {
		try {
			Entregador entregador = new Entregador();
//			entregador.setNomeFantasia(nomeFantasia);
//			entregador.setRazaoSocial(razaoSocial);
//			entregador.setCnpj(cnpj);
//			entregador.setResponsaveis(responsaveis);
			entregador.setModalidadeFrete(modalidadeFrete);
			
			EntregadorRegistration entReg = new EntregadorRegistration();
			entReg.register(entregador);
			
			logger.info("Entregador \"" + nomeFantasia + "\" criado com sucesso");
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void excluirEntregador(Entregador entregador) {
		try {
			String sqlExcluirEntregador = "DELETE FROM entregador WHERE id = :pId";
			TypedQuery<Entregador> query = em.createQuery(sqlExcluirEntregador, Entregador.class);
			query.setParameter("pId", entregador.getId());
			query.executeUpdate();
			logger.info("Entregador \"" + entregador.getId() + "\" excluído com sucesso");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public List<Entregador> obterEntregadores() {
		try {
			String sqlObterEntregadores = "SELECT * FROM entregador";
			Query query = em.createQuery(sqlObterEntregadores);
			List<Entregador> entregadores = query.getResultList();
			logger.info("Lista de entregadores obtida com sucesso");
			return entregadores;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		
	}

	public void atualizarEntregador(Entregador entregador) {
		// Este metodo espera receber o Entregador já atualizado. Ele acha a entrada no BD pelo ID, substitui os valores na entidade e depois persit novamente
		try {
			Entregador ent = em.find(Entregador.class, entregador.getId());
			ent = entregador;
			em.persist(ent);
			logger.info("Entregador \"" + entregador.getId() + "\" atualizado com sucesso");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
