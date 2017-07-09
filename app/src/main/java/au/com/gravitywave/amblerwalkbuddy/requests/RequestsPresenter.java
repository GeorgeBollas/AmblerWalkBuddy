package au.com.gravitywave.amblerwalkbuddy.requests;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.DaggerInteractorComponent;
import au.com.gravitywave.amblerwalkbuddy.InteractorModule;
import au.com.gravitywave.amblerwalkbuddy.Interactors.IRequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.bases.PresenterBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 8/07/2017.
 */

public class RequestsPresenter extends PresenterBase implements IRequestsPresenter {

    private final IRequestsView mView;
    private final int mBuddyId;
    private final IRequestsInteractor interactor;

    public RequestsPresenter(IRequestsView view, int buddyId) {
        mView = view;
        mBuddyId = buddyId;

        interactor = DaggerInteractorComponent
                .builder()
                .interactorModule(new InteractorModule())
                .build()
                .provideRequestInteractor();
    }

    @Override
    public void ShowRequests() {
        List<Request> requests = interactor.GetMyOffers(mBuddyId);
        requests.addAll(interactor.GetWaitingRequests());

        mView.showRequests(requests);
    }
}
