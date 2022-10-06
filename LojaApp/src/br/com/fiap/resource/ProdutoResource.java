package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {
	
	ProdutoBO pb = new ProdutoBO();
	
	//GET-ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar(){
		return pb.listar();
	}
	
	//GET-BY_ID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO buscar(@PathParam("id") int id){
		return pb.listar(id);
	}
	
	//CADASTRAR
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		
		//CADASTRAR O PRODUTO
		pb.cadastrar(produto);
		
		//CONSTRUINDO O PATH
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		//PARSEANDO O CÓDIGO E CONCATENANDO COM O PATH
		builder.path(Integer.toString(produto.getCodigo()));
		
		//RETORNANDO O STATUS CODE DO HTTP ATRAVÉS DO BUILDER
		return Response.created(builder.build()).build();
		
	} 
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProdutoTO produto, @PathParam("id") int id) {
		
		//SETAR O CÓDIGO NO PRODUTO!
		produto.setCodigo(id);
		
		//ATUALIZANDO O PRODUTO
		pb.atualizar(produto);
		
		//RETORNANDO O STATUS 200
		return	Response.ok().build();	
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pb.remover(id);
	}
	
}

//VAMOS CRIAR UM MÉTODO PARA RESPONDER
//REQUISIÇÕES DO TIPO GET

//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String buscar() {
//		return "Valor retornado!";
//	}