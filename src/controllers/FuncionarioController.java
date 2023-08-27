package controllers;

import java.util.Scanner;

import entities.Empresa;
import entities.Funcionario;
import interfaces.IController;
import repositories.FuncionarioRepository;

public class FuncionarioController implements IController {

	// atributo
	private Scanner scanner;

	// m�todo construtor
	public FuncionarioController() {

		scanner = new Scanner(System.in);

	}

	@Override
	public void cadastrar() {

		try {

			System.out.println("\nCADASTRO DE FUNCION�RIO\n");
			
			Funcionario funcionario = new Funcionario();
			funcionario.setEmpresa(new Empresa());
			
			System.out.print("Informe o nome do funcion�rio.: ");
			funcionario.setNome(scanner.nextLine());

			System.out.print("Informe o cpf do funcion�rio..: ");
			funcionario.setCpf(scanner.nextLine());
			
			System.out.print("Informe a matr�cula...........: ");
			funcionario.setMatricula(scanner.nextLine());
			
			System.out.print("Informe o id da empresa.......: ");
			funcionario.getEmpresa()	.setIdEmpresa(Integer.parseInt(scanner.nextLine()));
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.inserir(funcionario);
			
			System.out.println("\nFuncion�rio cadastrado com sucesso.");

		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

	@Override
	public void atualizar() {

		try {
			System.out.println("\nATUALIZA��O DE FUNCION�RIO\n");

			Funcionario funcionario = new Funcionario();

			funcionario.setEmpresa(new Empresa());

			System.out.print("Informe o id do funcion�rio...: ");
			funcionario.setIdFuncionario(Integer.parseInt(scanner.nextLine()));

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

			// verificar se existe um funcion�rio
			// no banco de dados com o id informado
			if (funcionarioRepository.obterPorId(funcionario.getIdFuncionario()) != null) {

				System.out.print("Informe o nome do funcion�rio.: ");
				funcionario.setNome(scanner.nextLine());

				System.out.print("Informe o cpf do funcion�rio..: ");
				funcionario.setCpf(scanner.nextLine());

				System.out.print("Informe a matr�cula...........: ");
				funcionario.setMatricula(scanner.nextLine());

				System.out.print("Informe o id da empresa.......: ");
				funcionario.getEmpresa().setIdEmpresa(Integer.parseInt(scanner.nextLine()));

				// atualizando no banco de dados
				funcionarioRepository.alterar(funcionario);
				System.out.println("\nFuncion�rio atualizado com sucesso.");
			}

			else {
				System.out.println("\nFuncion�rio n�o encontrada,	verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}

	}

	@Override
	public void excluir() {

		try {
			System.out.println("\nEXCLUS�O DE FUNCION�RIO\n");

			Funcionario funcionario = new Funcionario();

			System.out.print("Informe o id do funcion�rio...: ");
			funcionario.setIdFuncionario(Integer.parseInt(scanner.nextLine()));

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

			// verificar se existe um funcion�rio
			// no banco de dados com o id informado
			if (funcionarioRepository.obterPorId(funcionario.getIdFuncionario()) != null) {

				// excuindo no banco de dados
				funcionarioRepository.excluir(funcionario);

				System.out.println("\nFuncion�rio exclu�do com sucesso.");

			} else {

				System.out.println("\nFuncion�rio n�o encontrado. Verifique o ID informado!");

			}
		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

	@Override
	public void consultar() {
		try {
			
			System.out.println("\nCONSULTA DE FUNCION�RIO\n");
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			
			for (Funcionario funcionario : funcionarioRepository.obterTodos()) {
				
				//retornando os dados do funcionario
				System.out.println("Id do funcion�rio.........: " + funcionario.getIdFuncionario());
				System.out.println("Nome do funcion�rio.......: " + funcionario.getNome());
				System.out.println("CPF.......................: " + funcionario.getCpf());
				System.out.println("Matr�cula.................: " + funcionario.getMatricula());
				
				//retornando os dados da Empresa do Funcionario
				System.out.println("Id da empresa.............: " + funcionario.getEmpresa().getIdEmpresa());
				System.out.println("Nome fantasia.............: " + funcionario.getEmpresa().getNomeFantasia());
				System.out.println("Raz�o social..............: " + funcionario.getEmpresa().getRazaoSocial());
				System.out.println("CNPJ......................: " + funcionario.getEmpresa().getCnpj());
				System.out.println("---");
			}
		} catch (Exception e) {
			
			System.out.println("\nOcorreu um erro: " + e.getMessage());
			
		}

	}

}
