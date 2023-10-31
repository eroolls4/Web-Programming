package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.repository.*;
import mk.finki.ukim.mk.lab.service.*;
import org.springframework.stereotype.*;


@Service
public class TicketOrderServiceImpl implements TicketOrderService {


    private final InMemoryTicketOrderRepository inMemoryTicketOrderRepository;

    public TicketOrderServiceImpl(InMemoryTicketOrderRepository inMemoryTicketOrderRepository) {
        this.inMemoryTicketOrderRepository = inMemoryTicketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return inMemoryTicketOrderRepository.createOrder(movieTitle,clientName,address,(long) numberOfTickets);
    }
}
