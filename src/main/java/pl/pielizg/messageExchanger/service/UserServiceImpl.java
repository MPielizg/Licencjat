package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pielizg.messageExchanger.Repository.UserRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.User;
import pl.pielizg.messageExchanger.model.dto.UserDTO;

/**
 * Created by Pielizg on 2017-08-18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private Mapper mapper;

    @Override
    public Page<UserDTO> printUsers(Pageable pageable){
        Page<User> users = repository.findAll(pageable);
        Page<UserDTO> page = mapper.map(users);
        return page;
    }

    @Override
    public UserDTO findById(int id) {
        User user = repository.findOne(id);
        return mapper.map(user);
    }

    @Override
    @Transactional
    public UserDTO insertUser(UserDTO userDTO) {
        int id = repository.save(mapper.map(userDTO)).getId();

        return findById(id);
    }

    @Override
    public UserDTO findByLogin(String login) {
        User user = repository.findByLogin(login);

        return user != null ? mapper.map(user) : null;
    }

    @Override
    @Transactional
    public void deleteUser(Long phoneNumber) {
        repository.deleteByPhoneNumber(phoneNumber);
    }

    @Override
    public String getPassword(String login) {

        User user =  repository.findByLogin(login);

        return user != null ? user.getPassword() : "###";
    }

}
