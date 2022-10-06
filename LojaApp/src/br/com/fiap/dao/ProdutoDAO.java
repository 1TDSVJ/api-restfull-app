package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {

	private static List<ProdutoTO> listaDeProdutos;
	
	public ProdutoDAO() {
		
		if(listaDeProdutos == null) {
			listaDeProdutos = new ArrayList<ProdutoTO>();
			
			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setTitulo("Chinelo");
			pto.setPreco(32.90);
			pto.setQuantidade(120);
			listaDeProdutos.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setTitulo("Mouse");
			pto.setQuantidade(100);
			pto.setPreco(99.98);
			listaDeProdutos.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setTitulo("Teclado");
			pto.setQuantidade(67);
			pto.setPreco(110.45);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setTitulo("Alcool Gel");
			pto.setQuantidade(1000);
			pto.setPreco(23.77);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setTitulo("Pilhas AA");
			pto.setQuantidade(2000);
			pto.setPreco(2.98);
			listaDeProdutos.add(pto);
			
		}
		
	}

	//GET-ALL
	public List<ProdutoTO> select(){
		return listaDeProdutos;
	}
	
	//GET-BY_ID
	public ProdutoTO select(int id){
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if(listaDeProdutos.get(i).getCodigo() == id) {
				return listaDeProdutos.get(i) ;
			}
		}
		return null;
	}
	
	public boolean insert(ProdutoTO pto) {
		pto.setCodigo(listaDeProdutos.size() + 1);
		return listaDeProdutos.add(pto);
		
	}
	
	public void update(ProdutoTO pto) {
		
		ProdutoTO produto = select(pto.getCodigo());
		
		produto.setTitulo(pto.getTitulo());
		produto.setPreco(pto.getPreco());
		produto.setQuantidade(pto.getQuantidade());
		
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if(listaDeProdutos.get(i) == produto) {
				listaDeProdutos.set(i, produto);
			}
		}
	}
	
	public void delete(int id) {
		listaDeProdutos.remove(select(id));
	}
	
}

