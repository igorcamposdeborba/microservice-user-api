package br.com.igorborba.userapi.services;

import br.com.igorborba.userapi.entities.User;
import br.com.igorborba.userapi.entities.dto.UserDTO;
import br.com.igorborba.userapi.exceptions.ObjectNotFoundException;
import br.com.igorborba.userapi.repositories.UserRepository;
import br.com.igorborba.userapi.services.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // construtor para atributos final e @NotNull
@Slf4j
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;

    private final Environment env;
    @Override
    @Transactional(readOnly = true) // ReadOnly true não trava o banco (boa prática em operações de leitura). Transação sempre executa esta operação no banco de dados se for 100% de sucesso.
    public UserDTO findById(Long id) {
        log.info("LOG http get for user_service on port: " + env.getProperty("local.server.port"));

        Optional<User> userDatabase = userRepository.findById(id);

        User user = userDatabase.orElseThrow(() -> new ObjectNotFoundException("User not found"));
        return new UserDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> usersDatabase = userRepository.findAll();

        return usersDatabase.stream().map((User user) -> new UserDTO(user)).collect(Collectors.toList());
    }
}
