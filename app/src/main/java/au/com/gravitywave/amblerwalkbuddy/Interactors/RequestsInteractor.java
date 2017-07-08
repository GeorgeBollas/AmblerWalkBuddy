package au.com.gravitywave.amblerwalkbuddy.Interactors;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.Interactors.IRequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.bases.InteractorBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.repositories.IRequestRepository;
import au.com.gravitywave.amblerwalkbuddy.repositories.RequestRepository;

/**
 * Created by georg on 7/07/2017.
 */

public class RequestsInteractor
        extends InteractorBase
        implements IRequestsInteractor
{
    private IRequestRepository requestRepository;

    public RequestsInteractor() {
        requestRepository = new RequestRepository();
    }

    @Override
    public List<Request> GetMyOffers(int personId) {
        return requestRepository.GetMyOffers(personId);
    }

    @Override
    public List<Request> GetWaitingRequests() {
        return requestRepository.GetWaitingRequests();
    }
}
