package au.com.gravitywave.amblerwalkbuddy.monitor;

import au.com.gravitywave.amblerwalkbuddy.bases.PresenterBase;

/**
 * Created by georg on 7/07/2017.
 */

public class MonitorPresenter
        extends PresenterBase
        implements IMonitorPresenter {

    private IMonitorView view;

    public MonitorPresenter(IMonitorView view) {
        this.view = view;
    }
}
