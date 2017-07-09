package au.com.gravitywave.amblerwalkbuddy.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.requests.RequestsPresenter;
import au.com.gravitywave.amblerwalkbuddy.requests.IRequestsPresenter;
import au.com.gravitywave.amblerwalkbuddy.requests.IRequestsView;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.ui.RequestRecyclerViewAdapter;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RequestsFragment extends Fragment implements IRequestsView {

    private static int mBuddyId;
    private OnListFragmentInteractionListener mListener;

    private List<Request> mCurrentRequests;
    private View mCurrentRequestsView;
    IRequestsPresenter mPresenter;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RequestsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RequestsFragment newInstance(int buddyId) {
        mBuddyId = buddyId;
        RequestsFragment fragment = new RequestsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new RequestsPresenter(this,mBuddyId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mCurrentRequestsView = inflater.inflate(R.layout.fragment_requests_list, container, false);

        mPresenter.ShowRequests();

        return mCurrentRequestsView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showRequests(List<Request> currentRequests) {
        // Set the adapter
            Context context = mCurrentRequestsView.getContext();
            RecyclerView recyclerView = (RecyclerView) mCurrentRequestsView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new RequestRecyclerViewAdapter(currentRequests, mListener));
        }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Request currentRequest);
    }
}
