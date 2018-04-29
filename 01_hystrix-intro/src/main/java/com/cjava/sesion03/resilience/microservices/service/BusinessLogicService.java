package com.cjava.sesion03.resilience.microservices.service;

import org.springframework.stereotype.Service;

import com.cjava.sesion03.resilience.microservices.hystrix.LatencyCommand;
import com.cjava.sesion03.resilience.microservices.hystrix.MyHytrixCommand;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Service
public class BusinessLogicService {

  public String saludo(String name) throws Exception {
	  
    // Se debe instanciar un comando de Hystrix en cada ejecución
    MyHytrixCommand command = new MyHytrixCommand(name);


    /*
    //Resultado obtenido del comando de forma NO-bloqueante
    java.util.concurrent.Future<String> future = command.queue();

    //Aqui podria poner codigo que hiciera otras cosas, en lo que el Futuro se "resuelve"
    //......
    //.....

    //En algun momento obtengo el valor del futuro (operacion bloqueante)
    String futureResult = future.get();
    */


    //Resultado obtenido del comando de forma bloqueante sincrona
    String result = command.execute();
    return result;
  }


  public String saludoObservable(String name) throws Exception {

    String result = "";
    List<String> buffer = new ArrayList<>();

    LatencyCommand latencyCommand = new LatencyCommand(name, 200l);
    
    Observable<String> observe = latencyCommand.observe();

    observe.subscribe(buffer::add);

    LatencyCommand latencyCommand2 = new LatencyCommand(name, 300l);

    String resultWithMoreLatency = latencyCommand2.toObservable().toBlocking().first();
    buffer.add(resultWithMoreLatency);


    return buffer.stream().collect(joining(", "));
  }
}
