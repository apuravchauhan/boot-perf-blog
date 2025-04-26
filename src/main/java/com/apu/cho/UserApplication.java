package com.apu.cho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {

  public static void main(String[] args) {

    SpringApplication.run(UserApplication.class, args);
  }
  @GetMapping(value="/hello-cpu",produces = "text/plain")
  public String hellocpu() {
    long result = fibonacciRecursive(25);
    return "hello"+result;
  }
  @GetMapping(value="/hello-io",produces = "text/plain")
  public String helloio() throws InterruptedException {
    Thread.sleep(300);
    return "helloio";
  }
  @GetMapping(value="/hello-both",produces = "text/plain")
  public String helloboth() throws InterruptedException {
    Thread.sleep(300);
    long result = fibonacciRecursive(20);
    return "helloboth"+result;
  }
  @GetMapping(value="/hello-both-r",produces = "text/plain")
  public String hellobothr() throws InterruptedException {
    
    long result = fibonacciRecursive(20);
    Thread.sleep(300);
    return "helloboth"+result;
  }
  public static int fibonacciRecursive(int n) {
      if (n <= 1) return n;
      return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  }
}