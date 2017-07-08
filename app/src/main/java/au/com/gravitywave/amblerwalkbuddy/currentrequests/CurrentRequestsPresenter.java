package au.com.gravitywave.amblerwalkbuddy.currentrequests;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.Interactors.IRequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.Interactors.RequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.bases.PresenterBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 8/07/2017.
 */

public class CurrentRequestsPresenter extends PresenterBase implements ICurrentRequestsPresenter {

    private final ICurrentRequestsView mView;
    private final IRequestsInteractor interactor;

    public CurrentRequestsPresenter(ICurrentRequestsView view) {
        mView = view;
        interactor = new RequestsInteractor();

    }

    @Override
    public void ShowCurrentRequests() {
        List<Request> currentRequest = interactor.GetWaitingRequests();

        mView.ShowCurrentRequests(currentRequest);
    }
}
