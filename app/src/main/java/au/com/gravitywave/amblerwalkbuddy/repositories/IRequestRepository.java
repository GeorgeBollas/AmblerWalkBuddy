package au.com.gravitywave.amblerwalkbuddy.repositories;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 7/07/2017.
 */

public interface IRequestRepository {

    Request GetRequest(int id);
    List<Request> GetRequests();
    List<Request> GetWaitingRequests();
    List<Request> GetMyOffers(int myId);
}
