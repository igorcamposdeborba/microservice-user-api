package br.com.igorborba.payrollapi.feignClients;
import org.springframework.cloud.openfeign.FeignClient;
import br.com.igorborba.payrollapi.entities.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "user-api", url = "http://localhost:8000/") // ! Se conecta com outra API
public interface UserFeign {

    @GetMapping(value = "/user/{id}")
    ResponseEntity<UserDTO> findById(@PathVariable Long id);

    @GetMapping(value = "/user/")
    ResponseEntity<List<UserDTO>> findAll();

}
