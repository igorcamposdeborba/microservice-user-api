package br.com.igorborba.payrollapi.controller;

import br.com.igorborba.payrollapi.entities.Payroll;
import br.com.igorborba.payrollapi.entities.dto.UserDTO;
import br.com.igorborba.payrollapi.feignClients.UserFeign;
import br.com.igorborba.payrollapi.service.PayrollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PayrollController {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private PayrollServiceImpl payrollServiceImpl;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
         UserDTO userDTO = userFeign.findById(workerId).getBody();

        Double totalPayment = payrollServiceImpl.totalPayment(userDTO.getHourlyPrice(), payment.getWorkedHours()); // user-api guarda dados FIXOS de hora do usuário
                                                                                               // payroll-api guarda dados DINÂMICOS calculados de horas trabalhadas
        return ResponseEntity.ok().body(
                new Payroll(userDTO.getName(),
                            payment.getDescription(),
                            userDTO.getHourlyPrice(),
                            payment.getWorkedHours(),
                            totalPayment));

    }
}
