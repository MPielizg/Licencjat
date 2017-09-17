package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pielizg.messageExchanger.model.dao.GroupCustom;

/**
 * Created by Pielizg on 2017-09-14.
 */
public interface GroupCustomRepository extends PagingAndSortingRepository<GroupCustom, Integer> {
}
