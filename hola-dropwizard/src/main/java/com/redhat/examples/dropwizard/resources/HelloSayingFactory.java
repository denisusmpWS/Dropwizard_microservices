package com.redhat.examples.dropwizard.resources;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase pojo de mapeo de vaRIABLES DE PROPERTIES 
 * @author MICROSERVICIOS
 *
 */

public class HelloSayingFactory {
	
	
	@NotEmpty //dropwizard ->  solo usa valiudaciones de hibernate
	private String saying;

	
	@JsonProperty
	public String getSaying() {
		return saying;
	}

	@JsonProperty
	public void setSaying(String saying) {
		this.saying = saying;
	}
	
	
	
	

}
