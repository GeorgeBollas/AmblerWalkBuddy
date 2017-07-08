package au.com.gravitywave.amblerwalkbuddy.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import au.com.gravitywave.amblerwalkbuddy.R;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;
import au.com.gravitywave.amblerwalkbuddy.myoffers.IMyOffersPresenter;
import au.com.gravitywave.amblerwalkbuddy.myoffers.IMyOffersView;
import au.com.gravitywave.amblerwalkbuddy.myoffers.MyOffersPresenter;
import au.com.gravitywave.amblerwalkbuddy.ui.MyOffersRecyclerViewAdapter;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MyOffersFragment extends Fragment implements IMyOffersView {

    private OnListFragmentInteractionListener mListener;

    private static final String ARG_BUDDY_ID = "buddyId";

    private int mBuddyId;

    IMyOffersPresenter mPresenter;
    View mOffersListView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyOffersFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyOffersFragment newInstance(int buddyId) {
        MyOffersFragment fragment = new MyOffersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BUDDY_ID, buddyId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new MyOffersPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mOffersListView = inflater.inflate(R.layout.fragment_my_offers_list, container, false);

        if (getArguments() != null) {
            mBuddyId = getArguments().getInt(ARG_BUDDY_ID);
        }

        mPresenter.ShowOffers(mBuddyId);
        return mOffersListView;
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
    public void ShowOffers(List<Request> offers) {
        Context context = mOffersListView.getContext();
        RecyclerView recyclerView = (RecyclerView) mOffersListView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new MyOffersRecyclerViewAdapter(offers, mListener));
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
        void onListFragmentInteraction(Request offer);
    }
}
