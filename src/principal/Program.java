package principal;

import java.util.Scanner;

import controllers.EmpresaController;
import controllers.FuncionarioController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int opcao;		
		
		EmpresaController empresaController = new EmpresaController();
		FuncionarioController funcionarioController = new FuncionarioController();
		
		try {
			
			do {
				
				System.out.println("(1) Cadastrar empresas");
				System.out.println("(2) Atualizar empresas");
				System.out.println("(3) Excluir empresas");
				System.out.println("(4) Consultar empresas");				
				System.out.println("(5) Cadastrar funcionários");
				System.out.println("(6) Atualizar funcionários");
				System.out.println("(7) Excluir funcionários");
				System.out.println("(8) Consultar funcionários");
	            System.out.println("(9) Encerrar Programa.");
	            System.out.print("\nEscolha a opção desejada...: ");
	            
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.println("Opção: Cadastrar Empresa");
	                    empresaController.cadastrar();
	                    
	                    break;
	                    
	                case 2:
	                    System.out.println("Opção: Atualizar Empresa");
	                    empresaController.atualizar();
	                    
	                    break;
	                    
	                case 3:
	                    System.out.println("Opção: Excluir Empresa");
	                    empresaController.excluir();
	                    
	                    break;
	                    
	                case 4:
	                    System.out.println("Opção: Consultar todas as Empresas");
	                    empresaController.consultar();
	                    
	                    break;
	                
	                case 5:	                	
	                	System.out.println("Opção: Cadastrar funcionários");
	                	funcionarioController.cadastrar();
	                	
	                	break;
	                	
	                case 6:	                	
	                	System.out.println("Opção: Atualizar funcionários");
	                	funcionarioController.atualizar();
	                	
	                	break;
	                
	                case 7:	                	
	                	System.out.println("Opção: Excluir funcionários");
	                	funcionarioController.excluir();
	                	
	                	break;
	                
	                case 8:	                	
	                	System.out.println("Opção: Consultar funcionários");
	                	funcionarioController.consultar();
	                	
	                	break;
	                	
	                case 9:
	                    System.out.println("Encerrando o programa...");
	                    break;
	                
	                default:
	                    System.out.println("Opção inválida. Escolha novamente.");
	            }

	            System.out.println(); // Linha em branco para separar as iterações
	        } while (opcao != 9);

	        System.out.println("Programa encerrado.");
			
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
