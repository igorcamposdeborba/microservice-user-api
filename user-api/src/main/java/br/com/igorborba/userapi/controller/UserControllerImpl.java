package br.com.igorborba.userapi.controller;

import br.com.igorborba.userapi.controller.interfaces.UserControllerInterface;
import br.com.igorborba.userapi.entities.dto.UserDTO;
import br.com.igorborba.userapi.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor // construtor para final e @NotNull
public class UserControllerImpl implements UserControllerInterface {
    private final UserServiceImpl userService;
    @Override
    public ResponseEntity<UserDTO> findById(Long id) {
        UserDTO userDTO = userService.findById(id);

        return ResponseEntity.ok().body(userDTO);
    }
    @Override
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> userDTO = userService.findAll();

        return ResponseEntity.ok().body(userDTO);
    }
}
