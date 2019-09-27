package br.com.unifacef.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.unifacef.api.entities.Empresa;
import br.com.unifacef.api.entities.Funcionario;
import br.com.unifacef.api.repositories.EmpresaRepository;
import br.com.unifacef.api.repositories.FuncionarioRepository;

@SpringBootApplication
public class MeuPrimeiroProjeto {

	// Instanciação da classe - Injeção de dependência
	@Autowired
	private EmpresaRepository empresaRepository;
	private FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjeto.class, args);
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
			
			Funcionario funcionario = new Funcionario();
			funcionario.setNome("Joao P");
			funcionario.setCpf("000111222-33");
			funcionario.setEmail("teste@email.com");
			funcionario.setSenha("12345");
			funcionario.setValorHora(100);
			this.funcionarioRepository.save(funcionario);
			
			List<Funcionario> funcionarios = funcionarioRepository.findAll();
			funcionarios.forEach(System.out::println);
			
			Funcionario funcionarioDb = funcionarioRepository.findById(1L).orElse(null);
			System.out.println("Funcionario por ID: " + funcionarioDb);
			funcionarioDb.setNome("JP");
			this.funcionarioRepository.save(funcionarioDb);
			
			Funcionario funcionariocpf = funcionarioRepository.findByCpf("000111222-33");
			System.out.println("Funcionario por CPF: " + funcionariocpf);
			this.funcionarioRepository.delete(funcionariocpf);
			
			funcionarios = funcionarioRepository.findAll();
			System.out.println("Funcionarios: " + funcionarios.size());
			
		};
	}

	
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded: " + senhaEncoded);
//			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded novamente:" + senhaEncoded);
//			System.out.println("Senha vÃ¡lida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
//		};
//	}

	
}
