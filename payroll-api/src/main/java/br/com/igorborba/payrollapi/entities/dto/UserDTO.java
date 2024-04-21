package br.com.igorborba.payrollapi.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private Double hourlyPrice;
}
