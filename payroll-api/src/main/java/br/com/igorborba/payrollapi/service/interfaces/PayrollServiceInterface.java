package br.com.igorborba.payrollapi.service.interfaces;
import br.com.igorborba.payrollapi.entities.Payroll;
import org.springframework.stereotype.Service;

public interface PayrollServiceInterface {

    Payroll getPayment(Long workerId, Payroll payment);

    }
