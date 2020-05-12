package br.com.loja.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class AbstractTest {
	
	@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true,
        				"br.com.loja.controller",
 						"br.com.loja.data",
 						"br.com.loja.enums",
 						"br.com.loja.model",
 						"br.com.loja.rest",
 						"br.com.loja.business",
 						"br.com.loja.util",
 						"br.com.loja.test"
						)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
//                .addAsResource("sql/massa_testes.sql", "sql/massa_testes.sql")
                .addAsWebInfResource("test-ds.xml", "test-ds.xml");
    }

}
