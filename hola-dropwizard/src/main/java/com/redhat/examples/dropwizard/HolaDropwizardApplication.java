package com.redhat.examples.dropwizard;

import com.redhat.examples.dropwizard.resources.HolaRestResource;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;



public class HolaDropwizardApplication extends Application<HolaDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HolaDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "HolaDropwizard";
    }
    
    /**
     * 
     */
    @Override
    public void initialize(final Bootstrap<HolaDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    	//INICIALIZAR CONFIGURACION DEL PROYECTO, esto con "bootstrap".
    	bootstrap.setConfigurationSourceProvider(
    			new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
    													new EnvironmentVariableSubstitutor(false))
    			
    			);
    }

    /**
     * 
     */
    @Override
    public void run(final HolaDropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	//REGISTRA EL DROWIZARD
    	//environment.jersey().register(new HolaRestResource()); --> utilizado para la peticion del api inicial
    	environment.jersey().register(
    				new HolaRestResource(configuration.getFactory().getSaying())
    			
    			);
    }

}
