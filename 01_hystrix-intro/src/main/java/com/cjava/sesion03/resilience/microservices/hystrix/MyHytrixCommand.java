package com.cjava.sesion03.resilience.microservices.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import static java.lang.String.format;

public class MyHytrixCommand extends HystrixCommand<String> {
  private final String name;

  public MyHytrixCommand(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("GroupComando"));
    this.name = name;
  }

  @Override
  protected String run() throws Exception {
    return format("Hola %s", name);
  }

  //Implemantar aqui que hacer si el comando falla
  @Override
  protected String getFallback() {
    return format("No se pudo ejecutar el saludo para %s", name);
  }
}
