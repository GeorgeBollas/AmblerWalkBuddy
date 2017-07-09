package au.com.gravitywave.amblerwalkbuddy.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.bases.ActivityBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.monitor.IMonitorPresenter;
import au.com.gravitywave.amblerwalkbuddy.monitor.IMonitorView;
import au.com.gravitywave.amblerwalkbuddy.monitor.MonitorPresenter;
import au.com.gravitywave.amblerwalkbuddy.ui.fragments.RequestsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MonitorActivity
        extends ActivityBase
        implements IMonitorView, RequestsFragment.OnListFragmentInteractionListener
{

    private IMonitorPresenter mPresenter;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_request_list:
                    mPresenter.InitList();
                    return true;
                case R.id.navigation_request_map:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        mPresenter = new MonitorPresenter(this);
        mPresenter.InitList();

        ButterKnife.bind(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void Show(int buddyId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, RequestsFragment.newInstance(buddyId));
        fragmentTransaction.commit();

    }

    @Override
    public void onListFragmentInteraction(Request offer) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.item_switch);
        menuItem.setActionView(R.layout.action_menu);
        Switch sw = (Switch)menuItem.getActionView().findViewById(R.id.switch_action_online);

        return super.onCreateOptionsMenu(menu);
    }
}
