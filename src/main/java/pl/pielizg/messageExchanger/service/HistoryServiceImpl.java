package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.HistoryRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.HistoryItem;
import pl.pielizg.messageExchanger.model.dto.HistoryItemDTO;
import java.util.Date;

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
        Page<HistoryItem> historyItems = repository.findByDestinationOrOrigin(login, login, pageable);

        return mapper.mapHistoryItemPage(historyItems);
    }

    @Override
    public HistoryItemDTO newHistoryItem(String originLogin, String destinationLogin, String text) {
        Date now = new Date();
        HistoryItem historyItem = new HistoryItem(originLogin, destinationLogin, text, now);

        int id = repository.save(historyItem).getId();
        historyItem = repository.findOne(id);

        return mapper.map(historyItem);
    }

    @Override
    public HistoryItemDTO deleteHistoryItem(int id) {
        HistoryItem historyItem = repository.findOne(id);
        if(historyItem == null){
            return null;
        }
        repository.delete(id);
        return mapper.map(historyItem);
    }


}
