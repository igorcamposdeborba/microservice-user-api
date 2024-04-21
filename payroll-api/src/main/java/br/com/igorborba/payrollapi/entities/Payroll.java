package br.com.igorborba.payrollapi.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
    private String workerName;
    private String description;
    private double hourlyPrice;
    private double workedHours;
    private double totalPayment;

}
