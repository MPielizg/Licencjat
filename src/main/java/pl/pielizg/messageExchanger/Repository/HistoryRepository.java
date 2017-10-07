package pl.pielizg.messageExchanger.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.pielizg.messageExchanger.model.dao.HistoryItem;

import java.util.Date;
import java.util.List;

/**
 * Created by Pielizg on 2017-09-19.
 */
public interface HistoryRepository extends PagingAndSortingRepository<HistoryItem, Integer> {
    @Query("SELECT h FROM HistoryItem h WHERE (h.origin = :origin OR h.destination = :destination) AND h.date BETWEEN :startDate AND :endDate")
    Page<HistoryItem> findByLoginAndDate(@Param("destination")String destination,
                                         @Param("origin")String origin,
                                         Pageable pageable,
                                         @Param("startDate")Date startDate,
                                         @Param("endDate")Date endDate);

    List<HistoryItem> findByWasSend(boolean wasSend);
}
