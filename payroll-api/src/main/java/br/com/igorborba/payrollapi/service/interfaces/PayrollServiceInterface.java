package br.com.igorborba.payrollapi.service.interfaces;
import org.springframework.stereotype.Service;

public interface PayrollServiceInterface {
    double totalPayment(Double hourlyPrice, Double workedHours);

    }
