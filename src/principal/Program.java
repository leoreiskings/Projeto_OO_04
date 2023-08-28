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
				System.out.println("(5) Cadastrar funcion�rios");
				System.out.println("(6) Atualizar funcion�rios");
				System.out.println("(7) Excluir funcion�rios");
				System.out.println("(8) Consultar funcion�rios");
	            System.out.println("(9) Encerrar Programa.");
	            System.out.print("\nEscolha a op��o desejada...: ");
	            
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.println("Op��o: Cadastrar Empresa");
	                    empresaController.cadastrar();
	                    
	                    break;
	                    
	                case 2:
	                    System.out.println("Op��o: Atualizar Empresa");
	                    empresaController.atualizar();
	                    
	                    break;
	                    
	                case 3:
	                    System.out.println("Op��o: Excluir Empresa");
	                    empresaController.excluir();
	                    
	                    break;
	                    
	                case 4:
	                    System.out.println("Op��o: Consultar todas as Empresas");
	                    empresaController.consultar();
	                    
	                    break;
	                
	                case 5:	                	
	                	System.out.println("Op��o: Cadastrar funcion�rios");
	                	funcionarioController.cadastrar();
	                	
	                	break;
	                	
	                case 6:	                	
	                	System.out.println("Op��o: Atualizar funcion�rios");
	                	funcionarioController.atualizar();
	                	
	                	break;
	                
	                case 7:	                	
	                	System.out.println("Op��o: Excluir funcion�rios");
	                	funcionarioController.excluir();
	                	
	                	break;
	                
	                case 8:	                	
	                	System.out.println("Op��o: Consultar funcion�rios");
	                	funcionarioController.consultar();
	                	
	                	break;
	                	
	                case 9:
	                    System.out.println("Encerrando o programa...");
	                    break;
	                
	                default:
	                    System.out.println("Op��o inv�lida. Escolha novamente.");
	            }

	            System.out.println(); // Linha em branco para separar as itera��es
	        } while (opcao != 9);

	        System.out.println("Programa encerrado.");
			
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
