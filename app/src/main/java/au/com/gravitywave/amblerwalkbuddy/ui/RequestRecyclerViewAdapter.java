package au.com.gravitywave.amblerwalkbuddy.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.ui.fragments.RequestsFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Request} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RequestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Request> mCurrentRequests;
    private final OnListFragmentInteractionListener mListener;

    public RequestRecyclerViewAdapter(List<Request> currentRequests, OnListFragmentInteractionListener listener) {
        mCurrentRequests = currentRequests;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 1:
                View oView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_current_requests, parent, false);

                viewHolder= new OfferedViewHolder(oView);
                break;
            case 2:
                View rView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_my_offers, parent, false);
                viewHolder=  new RequestedViewHolder(rView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        Request request = mCurrentRequests.get(position);

        switch (request.getStatus()){
            case offered:
                createOfferedViewHolder((OfferedViewHolder) holder, position);
                break;
            case requested:
                createRequestedViewHolder((RequestedViewHolder) holder, position);
                break;
        }

    }

    private void createRequestedViewHolder(RequestedViewHolder holder, int position) {
        final RequestedViewHolder requestedViewHolder = holder;
        requestedViewHolder.mCurrentRequest = mCurrentRequests.get(position);
        requestedViewHolder.mIdView.setText(String.valueOf(mCurrentRequests.get(position).getRequestId()));
        requestedViewHolder.mContentView.setText(mCurrentRequests.get(position).getRequesterName());

        requestedViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(requestedViewHolder.mCurrentRequest);
                }
            }
        });
    }

    private void createOfferedViewHolder(OfferedViewHolder holder, int position) {
        final OfferedViewHolder offeredViewHolder = holder;
        offeredViewHolder.mCurrentRequest = mCurrentRequests.get(position);
        offeredViewHolder.mIdView.setText(String.valueOf(mCurrentRequests.get(position).getRequestId()));
        offeredViewHolder.mContentView.setText(mCurrentRequests.get(position).getRequesterName());

        offeredViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(offeredViewHolder.mCurrentRequest);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {

        switch (mCurrentRequests.get(position).getStatus())
        {
            case offered:
                return 1;
            default:
                return 2;
        }

//        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mCurrentRequests.size();
    }

    public class OfferedViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Request mCurrentRequest;

        public OfferedViewHolder(View view) {
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

    public class RequestedViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Request mCurrentRequest;

        public RequestedViewHolder(View view) {
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
