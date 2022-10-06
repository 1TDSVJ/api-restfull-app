package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	private ProdutoDAO pd;
	
	public List<ProdutoTO> listar(){
		pd = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		return pd.select();
	}

	public ProdutoTO listar(int id){
		pd = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		return pd.select(id);
	}
	
	public boolean cadastrar(ProdutoTO pto) {
		pd = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		
		//RN-1 (O produto n�o pode ser null.)
		if(pto != null) {
			return pd.insert(pto);
		}
		return false;
		
	}
	
	public void atualizar(ProdutoTO pto) {
		pd = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		pd.update(pto);
	}
	
	public void remover(int id){
		pd = new ProdutoDAO();
		pd.delete(id);
	}
	
}
