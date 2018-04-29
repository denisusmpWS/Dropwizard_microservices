package com.cjava.sesion03.resilience.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjava.sesion03.resilience.microservices.service.BusinessLogicService;

/**
 * Created by domix on 8/27/16.
 */
@RestController
public class MyController {
  @Autowired
  BusinessLogicService businessLogicService;

  @RequestMapping("/hys/{name}")
  public String foo(@PathVariable("name") String name) throws Exception {
    return businessLogicService.saludo(name);
  }

  @RequestMapping("/rx/{name}")
  public String bar(@PathVariable("name") String name) throws Exception {
    StopWatch stopWatch = new StopWatch("conObservable");
    stopWatch.start();
    String result = businessLogicService.saludoObservable(name);
    stopWatch.stop();

    System.out.println(stopWatch.shortSummary());
    return result;
  }
}
