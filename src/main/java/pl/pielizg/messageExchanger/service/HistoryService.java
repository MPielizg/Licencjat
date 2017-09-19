package pl.pielizg.messageExchanger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pielizg.messageExchanger.model.dto.HistoryItemDTO;

/**
 * Created by Pielizg on 2017-09-19.
 */
public interface HistoryService {
    Page<HistoryItemDTO> getHistory(String login, Pageable pageable);
}