package com.cjava.sesion03.resilience.microservices.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import static java.lang.String.format;

public class LatencyCommand extends HystrixObservableCommand<String> {

  private final Long latency;
  private final String name;

  public LatencyCommand(String name, Long latency) {
    super(HystrixCommandGroupKey.Factory.asKey("GroupComandoLatencia"));
    this.latency = latency;
    this.name = name;
  }

  @Override
  protected Observable<String> construct() {
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> observer) {
        try {
          if (!observer.isUnsubscribed()) {
            
        	  //Simulamos latencia o proceso tardado
            Thread.sleep(latency);

            //Se generan los valores y se emiten al Observer  - OnNext
            observer.onNext(format("Hola %s, Me tarde %d milisegundos", name, latency));

            //Se termina de ejecutar el proceso -OnComplete
            observer.onCompleted();
          }
        } catch (Exception e) {
          //Se informa del error al Observer
          observer.onError(e);
        }
      }
    }).subscribeOn(Schedulers.io());
  }

  //Implemantar aqui que hacer si el comando falla
  @Override
  protected Observable<String> resumeWithFallback() {
    return Observable.just(format("No se pudo ejecutar el saludo para %s", name));
  }
}
