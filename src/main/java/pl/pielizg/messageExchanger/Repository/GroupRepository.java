package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.pielizg.messageExchanger.model.dao.Group;

/**
 * Created by Pielizg on 2017-08-25.
 */
public interface GroupRepository extends CrudRepository<Group, Integer> {
    Group findByLogin(String login);
}
