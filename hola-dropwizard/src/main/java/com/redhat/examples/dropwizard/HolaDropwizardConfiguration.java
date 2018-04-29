package com.redhat.examples.dropwizard;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.examples.dropwizard.resources.HelloSayingFactory;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
/**
 * Clase de enlace con archivos de configuracion externa o interna
 * @author MICROSERVICIOS
 *
 */

public class HolaDropwizardConfiguration extends Configuration {
    // TODO: implement service configuration
	
	private HelloSayingFactory factory;

	@JsonProperty("helloapp")
	public HelloSayingFactory getFactory() {
		return factory;
	}

	@JsonProperty("helloapp")
	public void setFactory(HelloSayingFactory factory) {
		this.factory = factory;
	}
	
	
	
	
	
	
	
	
}
