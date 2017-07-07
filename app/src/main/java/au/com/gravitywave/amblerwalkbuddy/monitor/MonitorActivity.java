package au.com.gravitywave.amblerwalkbuddy.monitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.bases.ActivityBase;

public class MonitorActivity
        extends ActivityBase
        implements IMonitorView
{

    private IMonitorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        presenter = new MonitorPresenter();

    }
}
