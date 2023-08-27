package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Empresa;
import factories.ConnectionFactory;
import interfaces.IRepository;

public class EmpresaRepository implements IRepository<Empresa>{

	@Override
	public void inserir(Empresa obj) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into empresa(nomefantasia,	 razaosocial, cnpj) "
				+ "values(?,?,?)");
		
		statement.setString(1, obj.getNomeFantasia());
		statement.setString(2, obj.getRazaoSocial());
		statement.setString(3, obj.getCnpj());
		statement.execute();
		
		//fechando a conexão
		connection.close();
		
	}

	@Override
	public void alterar(Empresa obj) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update empresa set nomefantasia=?,	razaosocial=?, cnpj=? where idempresa=?");
		
		statement.setString(1, obj.getNomeFantasia());
		statement.setString(2, obj.getRazaoSocial());
		statement.setString(3, obj.getCnpj());
		statement.setInt(4, obj.getIdEmpresa());
		statement.execute();

		//fechando a conexão
		connection.close();
		
	}

	@Override
	public void excluir(Empresa obj) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("delete from empresa where idempresa = ?");
		statement.setInt(1, obj.getIdEmpresa());
		statement.execute();
		
		//fechando a conecão
		connection.close();
		
	}

	@Override
	public List<Empresa> obterTodos() throws Exception {

		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from empresa	order by nomefantasia");
		
				//capturar os registros obtidos do banco de dados
				ResultSet resultSet = statement.executeQuery();
				
				//declarando uma lista vazia
				List<Empresa> lista = new ArrayList<Empresa>();
				
				//lendo cada registro obtido do banco de dados
				while(resultSet.next()) {
					
				//enquanto houver registros, leia..
				Empresa empresa = new Empresa();
				empresa.setIdEmpresa(resultSet.getInt("idempresa"));
				empresa.setNomeFantasia(resultSet.getString("nomefantasia"));
				empresa.setRazaoSocial(resultSet.getString("razaosocial"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				
				lista.add(empresa); //adicionando empresa na lista
				}
				
				//fechando a conexão com o banco de dados
				
				connection.close();
				//retorando a lista
		
				return lista;
	}

	@Override
	public Empresa obterPorId(Integer id) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//executando o comando SQL
		//para consultar 1 empresa baseado no id
		PreparedStatement statement = connection.prepareStatement("select * from empresa where idempresa = ?");
		
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		//criando um objeto empresa, sem inicializa-lo -> null
		Empresa empresa = null;
		
		//verificando se alguma empresa foi encontrada
		if(resultSet.next()) { //se houver registro, leia.. // "se condicao  = true entao entra"
			
			empresa = new Empresa(); //instanciando a variável
			empresa.setIdEmpresa(resultSet.getInt("idempresa"));
			empresa.setNomeFantasia(resultSet.getString("nomefantasia"));
			empresa.setRazaoSocial(resultSet.getString("razaosocial"));
			empresa.setCnpj(resultSet.getString("cnpj"));
			
		}
		
		//fechando a conexão com o banco de dados
		connection.close();
		
		return empresa;
	}

	

}
