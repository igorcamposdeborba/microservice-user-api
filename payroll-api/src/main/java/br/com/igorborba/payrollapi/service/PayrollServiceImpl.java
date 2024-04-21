package br.com.igorborba.payrollapi.service;
import br.com.igorborba.payrollapi.service.interfaces.PayrollServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class PayrollServiceImpl implements PayrollServiceInterface {
    @Override
    public double totalPayment(Double hourlyPrice, Double workedHours) {
        return hourlyPrice * workedHours;
    }
}
