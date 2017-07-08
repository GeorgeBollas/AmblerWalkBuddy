package au.com.gravitywave.amblerwalkbuddy.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.ui.fragments.CurrentRequestsFragment.OnListFragmentInteractionListener;
import au.com.gravitywave.amblerwalkbuddy.currentrequests.dummy.DummyContent.DummyItem;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCurrentRequestRecyclerViewAdapter extends RecyclerView.Adapter<MyCurrentRequestRecyclerViewAdapter.ViewHolder> {

    private final List<Request> mCurrentRequests;
    private final OnListFragmentInteractionListener mListener;

    public MyCurrentRequestRecyclerViewAdapter(List<Request> currentRequests, OnListFragmentInteractionListener listener) {
        mCurrentRequests = currentRequests;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_current_requests, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mCurrentRequest = mCurrentRequests.get(position);
        holder.mIdView.setText(String.valueOf(mCurrentRequests.get(position).getRequestId()));
        holder.mContentView.setText(mCurrentRequests.get(position).getRequesterName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mCurrentRequest);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCurrentRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Request mCurrentRequest;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
