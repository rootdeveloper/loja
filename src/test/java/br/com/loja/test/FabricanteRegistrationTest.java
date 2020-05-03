package br.com.loja.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import org.junit.Test;

import br.com.loja.model.Fabricante;
import br.com.loja.service.FabricanteBusiness;

//@RunWith(Arquillian.class)
public class FabricanteRegistrationTest {

	//@Inject
	FabricanteBusiness fabricanteRegistration;

	//@Inject
	Logger log;

	//@Test
	public void testRegister() {

		try {
			Fabricante newFabricante = new Fabricante();

			newFabricante.setId(1);
			newFabricante.setCodfabricante(12);
			newFabricante.setCnpj("097403030/0001");
			newFabricante.setNomeFantasia("Nome fantasia");
			newFabricante.setRazaoSocial("Razão Social");
			newFabricante.setRazaoSocial("razaão social");
			newFabricante.setCodfabricante(10);

			fabricanteRegistration.cadastrarFabricante(newFabricante);
			assertNotNull(newFabricante.getId());
			log.info(newFabricante.getNomeFantasia() + " was persisted with id " + newFabricante.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
