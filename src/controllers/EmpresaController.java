package controllers;

import java.util.Scanner;

import entities.Empresa;
import interfaces.IController;
import repositories.EmpresaRepository;

public class EmpresaController implements IController {

	// atributo
	private Scanner scanner;

	// método construtor
	public EmpresaController() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void cadastrar() {

		try {

			System.out.println("\nCADASTRO DE EMPRESA\n");

			Empresa empresa = new Empresa();
			
			System.out.print("Informe o nome fantasia.......: ");
			empresa.setNomeFantasia(scanner.nextLine());

			System.out.print("Informe a razão social........: ");
			empresa.setRazaoSocial(scanner.nextLine());

			System.out.print("Informe o CNPJ................: ");
			empresa.setCnpj(scanner.nextLine());

			EmpresaRepository empresaRepository = new EmpresaRepository();

			empresaRepository.inserir(empresa);

			System.out.println("\nEmpresa cadastrada com sucesso!");

		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

	@Override
	public void atualizar() {
		try {

			System.out.println("\nATUALIZAÇÃO DE EMPRESA\n");

			Empresa empresa = new Empresa();

			System.out.print("Informe o id da empresa.......: ");

			empresa.setIdEmpresa(Integer.parseInt(scanner.nextLine()));

			EmpresaRepository empresaRepository = new EmpresaRepository();

			// verificar se existe no banco de dados uma empresa com o id informado
			if (empresaRepository.obterPorId(empresa.getIdEmpresa()) != null) {

				System.out.print("Informe o nome fantasia.......: ");
				empresa.setNomeFantasia(scanner.nextLine());

				System.out.print("Informe a razão social........: ");
				empresa.setRazaoSocial(scanner.nextLine());

				System.out.print("Informe o CNPJ................: ");
				empresa.setCnpj(scanner.nextLine());

				// atualizando os dados da empresa no banco de dados
				empresaRepository.alterar(empresa);
				System.out.println("\nEmpresa atualizada com sucesso.");

			} else {
				System.out.println("\nEmpresa não encontrada. Verifique o ID informado!");
			}

		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}

	}

	@Override
	public void excluir() {

		try {
			System.out.println("\nEXCLUSÃO DE EMPRESA\n");

			Empresa empresa = new Empresa();

			System.out.print("Informe o id da empresa.......: ");
			empresa.setIdEmpresa(Integer.parseInt(scanner.nextLine()));

			EmpresaRepository empresaRepository = new EmpresaRepository();

			// verificar se existe no banco de dados uma empresa com o id informado
			if (empresaRepository.obterPorId(empresa.getIdEmpresa()) != null) {

				// excluindo a empresa no banco de dados
				empresaRepository.excluir(empresa);
				System.out.println("\nEmpresa excluída com sucesso.");
				
			} else {
				System.out.println("\nEmpresa não encontrada,	verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}

	@Override
	public void consultar() {

		try {

			System.out.println("\nCONSULTA DE EMPRESAS\n");

			EmpresaRepository empresaRepository = new EmpresaRepository();

			for (Empresa empresa : empresaRepository.obterTodos()) {
				
				System.out.println("Id da empresa.......: " + empresa.getIdEmpresa());
				System.out.println("Nome Fantasia.......: " + empresa.getNomeFantasia());
				System.out.println("Razão Social........: " + empresa.getRazaoSocial());
				System.out.println("CNPJ................: " + empresa.getCnpj());
				 System.out.println("---");
				
			}

		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

}
