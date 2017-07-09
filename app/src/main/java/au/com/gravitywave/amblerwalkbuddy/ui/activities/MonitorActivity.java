package au.com.gravitywave.amblerwalkbuddy.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.bases.ActivityBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.monitor.IMonitorPresenter;
import au.com.gravitywave.amblerwalkbuddy.monitor.IMonitorView;
import au.com.gravitywave.amblerwalkbuddy.monitor.MonitorPresenter;
import au.com.gravitywave.amblerwalkbuddy.ui.fragments.RequestsFragment;

public class MonitorActivity
        extends ActivityBase
        implements IMonitorView, RequestsFragment.OnListFragmentInteractionListener
{

    private IMonitorPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        mPresenter = new MonitorPresenter(this);
        mPresenter.InitBuddy();

    }

    @Override
    public void Show(int buddyId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_offers_container, RequestsFragment.newInstance(buddyId));
        fragmentTransaction.commit();

    }

    @Override
    public void onListFragmentInteraction(Request offer) {

    }
}
