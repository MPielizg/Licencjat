package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.HistoryRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.HistoryItem;
import pl.pielizg.messageExchanger.model.dto.HistoryItemDTO;

/**
 * Created by Pielizg on 2017-09-19.
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository repository;
    @Autowired
    private Mapper mapper;

    @Override
    public Page<HistoryItemDTO> getHistory(String login, Pageable pageable) {
        Page<HistoryItem> historyItems = repository.findAll(pageable);

        return mapper.mapHistoryItemPage(historyItems);
    }
}
