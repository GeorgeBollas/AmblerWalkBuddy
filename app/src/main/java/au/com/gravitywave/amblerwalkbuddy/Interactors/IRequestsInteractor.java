package au.com.gravitywave.amblerwalkbuddy.Interactors;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 7/07/2017.
 */

public interface IRequestsInteractor {
    List<Request> GetMyOffers(int personId);
    List<Request> GetWaitingRequests();
}
