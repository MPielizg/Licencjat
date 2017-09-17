package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pielizg.messageExchanger.model.dao.User;

/**
 * Created by Pielizg on 2017-08-18.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findByLogin(String login);

    User findByPhoneNumber(Long phoneNumber);

    void deleteByPhoneNumber(Long phoneNumber);
}
