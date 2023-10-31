package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class InMemoryTicketOrderRepository {

    public TicketOrder createOrder(String movieTitle, String clientName, String clientAddress, Long numberOfTickets){
          return new TicketOrder(movieTitle, clientName, clientAddress, numberOfTickets);
    }

}
