package pl.pielizg.messageExchanger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pielizg.messageExchanger.model.dto.Container;
import pl.pielizg.messageExchanger.model.dto.HistoryItemDTO;
import pl.pielizg.messageExchanger.model.dto.IntervalDTO;

import java.text.ParseException;

/**
 * Created by Pielizg on 2017-09-19.
 */
public interface HistoryService {
    Page<HistoryItemDTO> getHistory(String login, IntervalDTO intervalDTO, Pageable pageable) throws ParseException;

    HistoryItemDTO newHistoryItem(String originLogin, String destinationLogin,  String text, boolean wasSend);

    HistoryItemDTO deleteHistoryItem(int id);
}
