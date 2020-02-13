package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import testng.MainClass;


@Path("/json/product")
public class JSONService {

	public static String PRODUCT_NAME = "";
	public static int PRODUCT_QTY ;
	//Product product1 = new Product();
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getProductInJSON() throws Exception{
		MainClass mainClass = new MainClass();
		mainClass.runTestNGTest();
		System.out.println("!!!!!!!!!!!!!!!!!      Automation suite executed          !!!!!!!!!!!!!!!!");
		String result = "!!!!!!!!!!!!!!!!!      Automation suite executed          !!!!!!!!!!!!!!!!";
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/post")
	@Consumes("application/json")
 	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product.getName()+ product.getQty();
		//product1.setName(product.getName());
		//product1.setQty(product.getQty());
		PRODUCT_NAME = product.getName();
		PRODUCT_QTY = product.getQty();
		return Response.status(201).entity(result).build();
		
	}
	
}
