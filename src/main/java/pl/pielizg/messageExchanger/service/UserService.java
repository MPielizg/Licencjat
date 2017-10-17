package pl.pielizg.messageExchanger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pielizg.messageExchanger.model.dto.UserDTO;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-21.
 */
public interface UserService {
    Page<UserDTO> printUsers(Pageable pageable);

    UserDTO findById(int id);

    UserDTO insertUser(UserDTO userDTO);

    UserDTO findByLogin(String login);

    UserDTO findByPhoneNumber(Long phoneNumber);

    void deleteUser(Long phoneNumber);

    String getPassword(String login);

    List<UserDTO> findByCreatedBy(String login);

    List<UserDTO> findByFraze(String fraze);
}
