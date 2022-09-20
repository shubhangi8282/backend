package com.quinnox.productwebservice;

import java.sql.SQLException;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/product")
public class ProductResource {
	
	ProductRepository repo = new ProductRepository();
	
	@GET
	@Path("Products")
	@Produces(MediaType.APPLICATION_JSON )
	public List<Product>getProducts() throws ClassNotFoundException, SQLException
	{
		for(Product product: repo.getProducts())
	        System.out.println(product.toString());
		return repo.getProducts();
	}
	
	//INSERT
    @POST
    @Path("insert")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Product insertProduct(Product product) throws ClassNotFoundException, SQLException {
//        System.out.println(bike);
        repo.insertProduct(product);
        return product;
    }



   
    //Update
    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product updateProduct(Product product) throws Exception {
        repo.updateProduct(product);
//        System.out.println(bike.toString());
//        List<Bike> bothData = new ArrayList<Bike>();
//        bothData.addAll(repo.GetBikeonid(id));
//        repo.updateBike(id, bike);
//        bothData.addAll(repo.GetBikeonid(id));



       return product;    
        }

 //DELETE
  
    
    
      @DELETE      
      @Path("delete/{id}")
      @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
      public void deleteproduct(@PathParam ("id")int id) throws Exception {
        repo.deleteproduct(id);
        }
}
