package au.com.gravitywave.amblerwalkbuddy.myoffers;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.Interactors.IRequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.Interactors.RequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.bases.PresenterBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.myoffers.IMyOffersPresenter;
import au.com.gravitywave.amblerwalkbuddy.myoffers.IMyOffersView;

/**
 * Created by georg on 8/07/2017.
 */

public class MyOffersPresenter extends PresenterBase implements IMyOffersPresenter {

    private final IMyOffersView mView;
    private final IRequestsInteractor interactor;

    public MyOffersPresenter(IMyOffersView view) {
        mView = view;

        interactor = new RequestsInteractor();
    }

    @Override
    public void ShowOffers(int buddyId) {
        List<Request> myOffers = interactor.GetMyOffers(buddyId);
        mView.ShowOffers(myOffers);
    }
}
