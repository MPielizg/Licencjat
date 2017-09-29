package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pielizg.messageExchanger.model.dao.HistoryItem;

import java.util.List;

/**
 * Created by Pielizg on 2017-09-19.
 */
public interface HistoryRepository extends PagingAndSortingRepository<HistoryItem, Integer> {
    Page<HistoryItem> findByDestinationOrOrigin(String destination, String origin,  Pageable pageable);

    List<HistoryItem> findByWasSend(boolean wasSend);
}
