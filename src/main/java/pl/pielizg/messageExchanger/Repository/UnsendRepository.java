package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.pielizg.messageExchanger.model.dao.Unsend;

/**
 * Created by Pielizg on 2017-10-23.
 */
public interface UnsendRepository extends CrudRepository<Unsend, Integer> {
}
