package br.com.igorborba.payrollapi.service;
import br.com.igorborba.payrollapi.entities.Payroll;
import br.com.igorborba.payrollapi.entities.dto.UserDTO;
import br.com.igorborba.payrollapi.exceptions.ObjectNotFoundException;
import br.com.igorborba.payrollapi.feignClients.UserFeign;
import br.com.igorborba.payrollapi.service.interfaces.PayrollServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollServiceInterface {
    private final Environment env;
    private final UserFeign userFeign;
    @Override
    public Payroll getPayment(Long workerId, Payroll payment) { // mostrar porta está chamando o user-api para o load balancer
        log.info("LOG payroll_service: " + env.getProperty("local.server.port"));

        Optional<UserDTO> userDTO = Optional.ofNullable(userFeign.findById(workerId).getBody());
        if(userDTO.isEmpty()) {
            throw new ObjectNotFoundException("User not found");
        }
        return  new Payroll(userDTO.get().getName(),
                payment.getDescription(),
                userDTO.get().getHourlyPrice(),
                payment.getWorkedHours(),
                totalPayment(userDTO.get().getHourlyPrice(), payment.getWorkedHours())) ;
    }

    private double totalPayment(Double hourlyPrice, Double workedHours) {
        if (hourlyPrice <= 0.0 || workedHours <= 0.0){
            throw new IllegalArgumentException("Hourly price and worked hours must be greater than zero");
        }
        return hourlyPrice * workedHours;
    }

}
