package au.com.gravitywave.amblerwalkbuddy.monitor;

import au.com.gravitywave.amblerwalkbuddy.Interactors.RequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.bases.PresenterBase;

/**
 * Created by georg on 7/07/2017.
 */

public class MonitorPresenter
        extends PresenterBase
        implements IMonitorPresenter {

    private final IMonitorView view;

    public MonitorPresenter(IMonitorView view) {
        this.view = view;
    }

    @Override
    public void InitList() {
        view.Show(100);
    }

}
