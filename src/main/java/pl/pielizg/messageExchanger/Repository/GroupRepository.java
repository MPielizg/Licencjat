package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pielizg.messageExchanger.model.dao.Group;

/**
 * Created by Pielizg on 2017-08-25.
 */
public interface GroupRepository extends PagingAndSortingRepository<Group, Integer> {
    Group findByLogin(String login);
}
