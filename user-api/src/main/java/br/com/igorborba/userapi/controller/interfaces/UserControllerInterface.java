package br.com.igorborba.userapi.controller.interfaces;

import br.com.igorborba.userapi.entities.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping(value = "/user")
public interface UserControllerInterface {
    @GetMapping(value = "/{id}")
    ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/")
    ResponseEntity<List<UserDTO>> findAll();
}
