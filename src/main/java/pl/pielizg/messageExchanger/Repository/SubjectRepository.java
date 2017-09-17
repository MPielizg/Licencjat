package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pielizg.messageExchanger.model.dao.Subject;

/**
 * Created by Pielizg on 2017-08-21.
 */
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> {
    Subject findByName(String name);
}
