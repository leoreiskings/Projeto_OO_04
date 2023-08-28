package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Empresa;
import entities.Funcionario;
import factories.ConnectionFactory;
import interfaces.IRepository;

public class FuncionarioRepository implements IRepository<Funcionario> {

	@Override
	public void inserir(Funcionario obj) throws Exception {

		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo uma sentença SQL para cadastrar um funcionário
		PreparedStatement statement = connection.prepareStatement("insert into funcionario(nome, cpf, matricula, idempresa) "
				+ "values(?, ?, ?, ?)");

		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCpf());
		statement.setString(3, obj.getMatricula());
		statement.setInt(4, obj.getEmpresa().getIdEmpresa());
		statement.execute();
		
		//fechando a conexão
		connection.close();		
		
	}

	@Override
	public void alterar(Funcionario obj) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//Executando uma sentença SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("update funcionario "
				+ "set nome=?, cpf=?, matricula=?, idempresa=? " + "where idfuncionario=?");
				statement.setString(1, obj.getNome());
				statement.setString(2, obj.getCpf());
				statement.setString(3, obj.getMatricula());
				statement.setInt(4, obj.getEmpresa().getIdEmpresa());
				statement.setInt(5, obj.getIdFuncionario());
				statement.execute();
				
				//fechando a conexão
				connection.close();
		
	}

	@Override
	public void excluir(Funcionario obj) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		// executando uma sentença SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from funcionario "
				+ "where idfuncionario = ?");
		
		statement.setInt(1, obj.getIdFuncionario());
		
		statement.execute();
		
		// fechando a conexão
		connection.close();

	}

	@Override
	public List<Funcionario> obterTodos() throws Exception {

		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//executando uma sentença SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("select f.idfuncionario, f.nome, f.cpf, f.matricula, " + 
				" e.idempresa, e.nomefantasia, e.razaosocial, e.cnpj " +	
				" from funcionario f inner join empresa " +
				" e on e.idempresa = f.idempresa ");
		
				//executando a consulta e lendo o resultado
				ResultSet resultSet = statement.executeQuery();
				
				//declarando uma lista de funcionários
				List<Funcionario> lista = new ArrayList<Funcionario>();
				
				//percorrendo cada registro obtido na consulta
				
				while(resultSet.next()) { //enquanto houver registros
				
					Funcionario funcionario = new Funcionario();
					
						funcionario.setEmpresa(new Empresa());
						
						//recuperando dados do Funcionario.
						funcionario.setIdFuncionario(resultSet.getInt("idfuncionario"));
						funcionario.setNome(resultSet.getString("nome"));
						funcionario.setCpf(resultSet.getString("cpf"));
						funcionario.setMatricula(resultSet.getString("matricula"));
						
						//recuperando dados da Empresa em que está cadastrado aquele Funcionario.
						funcionario.getEmpresa().setIdEmpresa(resultSet.getInt("idempresa"));
						funcionario.getEmpresa().setNomeFantasia(resultSet.getString("nomefantasia"));
						funcionario.getEmpresa().setRazaoSocial(resultSet.getString("razaosocial"));
						funcionario.getEmpresa().setCnpj(resultSet.getString("cnpj"));
						
						lista.add(funcionario);
						}
				
						//fechando a conexão
						connection.close();
		
						return lista;
	}

	@Override
	public Funcionario obterPorId(Integer id) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from funcionario "
				+ "where idfuncionario = ?");
		
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		Funcionario funcionario = null;
		
		if (resultSet.next()) {
			funcionario = new Funcionario();
			funcionario.setIdFuncionario(resultSet.getInt("idfuncionario"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
		}
		
		// fechando a conexão
		connection.close();
		return funcionario;

	}

}
