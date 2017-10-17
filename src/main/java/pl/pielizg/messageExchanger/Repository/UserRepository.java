package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.pielizg.messageExchanger.model.dao.User;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findByLogin(String login);

    User findByPhoneNumber(Long phoneNumber);

    void deleteByPhoneNumber(Long phoneNumber);

    List<User> findByCreatedBy(String createdBy);

    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :fraze, '%')) " +
            "OR LOWER(u.surname) LIKE LOWER(CONCAT('%', :fraze, '%'))" +
            "OR LOWER(u.login) LIKE LOWER(CONCAT('%', :fraze, '%'))")
    List<User> findByFraze(@Param("fraze") String fraze);
}
