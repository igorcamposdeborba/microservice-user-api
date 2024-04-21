package br.com.igorborba.userapi.entities.dto;

import br.com.igorborba.userapi.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Objects;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //  Em GET do http não mostra, mas em POST ou PUT é liberado para escrita
    private String password;
    private Double hourlyPrice;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.hourlyPrice = user.getHourlyPrice();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getId() == userDTO.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
