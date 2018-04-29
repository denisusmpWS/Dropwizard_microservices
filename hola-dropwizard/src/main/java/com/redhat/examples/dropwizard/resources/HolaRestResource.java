package com.redhat.examples.dropwizard.resources;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;

@Path("/api")
public class HolaRestResource {
	//Jetty por defecto te brinda el puerto 8080
	
	
	//se añade para poder recoger los valores del properties
	private String saying;
	
	public HolaRestResource(final String saying) {
		this.saying = saying;
	}
	
	
	
	@Path("/hola")
	@GET
	@Timed //habilita las metricas
	public String hola() throws UnknownHostException {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();
		}catch(UnknownHostException e) {
			hostname = "unknown";
		}
		
		//return "Hello Dropwizard from " + hostname;--> utilizado en el api inicial
		return saying + hostname;
	}
	
	

}
