package com.cjava.sesion03.resilience.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//Habilita el soporte de Spring Cloud en SpringBoot (No es necesario)
@org.springframework.cloud.netflix.hystrix.EnableHystrix
//Habilita una UI con el dashboard para analizar las metricas generadas de Hystrix
@org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
//Exponen las metricas de Hystrix en un flujo para ser consumido
@org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
