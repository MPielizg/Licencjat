package pl.pielizg.messageExchanger.service;

import pl.pielizg.messageExchanger.model.dto.Container;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-21.
 */
public interface ExchangeService {
    Container setMessage(String message);

    List<Container> getUnsendMessages();

    Container getUnsend();
}
