package br.com.igorborba.userapi.services.interfaces;

import br.com.igorborba.userapi.entities.dto.UserDTO;
import java.util.List;

public interface UserServiceInterface {

    UserDTO findById(Long id);
    List<UserDTO> findAll();
}
