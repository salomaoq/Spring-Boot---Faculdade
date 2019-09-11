//package br.com.unifacef.api;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import br.com.unifacef.api.utils.SenhaUtils;
//
//@SpringBootApplication
//public class MeuPrimeiroProjetoSpringApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MeuPrimeiroProjetoSpringApplication.class, args);
//		System.out.println("Alteramos o aqruivo");
//		System.out.println("de mode que não precisemos configurar agora a fonte de dados");
//	}
//
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded: " + senhaEncoded);
//			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded novamente:" + senhaEncoded);
//			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
//		};
//	}
//}

package br.com.unifacef.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.com.unifacef.api.entities.Empresa;

@SpringBootApplication
public class MeuPrimeiroProjetoSpringApplication {
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			this.empresaRepository.save(empresa);
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = empresaRepository.findById(1L).orElse(null);
			System.out.println("Empresa por ID: " + empresaDb);
			
			empresaDb.setRazaoSocial("Kazale IT Web");
			this.empresaRepository.save(empresaDb);
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.delete(empresaCnpj);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
		};
	}
}
