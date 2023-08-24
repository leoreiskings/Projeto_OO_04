package interfaces;

import java.util.List;

public interface IRepository<T> {

	
	void inserir(T obj) throws Exception;	
	
	void alterar(T obj) throws Exception;
	
	void excluir(T obj) throws Exception;
	
	List<T> obterTodos() throws Exception;
	
	T obterPorId(Integer id) throws Exception;
	
	
	
	
}
