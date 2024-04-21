package br.com.igorborba.payrollapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // habilitar comunicação entre APIs
public class PayrollApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApiApplication.class, args);
    }

}
