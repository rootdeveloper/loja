package br.com.loja.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtil {
	
	private static final Logger LOGGER = Logger.getLogger(TestUtil.class.getName());

	public static boolean verificaMensagemDeSucessoNoLog(String evidencia) throws Exception {
		
		Boolean evidenciaLocalizada = false;
		
		try {
			String serverLogDir = System.getProperty("jboss.server.log.dir");
			String CAMINHO_ARQUIVO_LOG = serverLogDir + "/server.log";
			
			Path path = Paths.get(CAMINHO_ARQUIVO_LOG);
			
			List<String> linhasArquivo = Files.readAllLines(path);
			
			for (String linha : linhasArquivo) {
				if(linha.contains(evidencia)) {
					evidenciaLocalizada = true;
					break;
				}
			}  
			
		} catch (Exception e) {
			String msg = "ERRO AO LOCALIZAR EVIDENCIA ";
			LOGGER.log(Level.SEVERE, msg, e);
			throw e;
		}
		
		return evidenciaLocalizada;
	}
	
}
