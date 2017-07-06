package au.com.gravitywave.amblerwalkbuddy.my_status;

import android.content.Context;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import au.com.gravitywave.amblerwalkbuddy.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyStatusFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyStatusFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    LinearLayout mAll;
    ToggleButton mChangeStatusToggleButton;
    TextView mStatusMessageTextView;

    public MyStatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * @return A new instance of fragment MyStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyStatusFragment newInstance() {
        MyStatusFragment fragment = new MyStatusFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_status, container, false);

        mAll = (LinearLayout)v.findViewById(R.id.all);
        mChangeStatusToggleButton = (ToggleButton) v.findViewById(R.id.changeStatusToggleButton);
        mStatusMessageTextView = (TextView)v.findViewById(R.id.statusMessageTextView);


        mChangeStatusToggleButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetStatus(mChangeStatusToggleButton.isChecked());
            }
        });

        return v;
    }

    public void SetStatus(boolean online){
        if (online) {
            mStatusMessageTextView.setVisibility(View.VISIBLE);
            mAll.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else {
            mStatusMessageTextView.setVisibility(View.GONE);
            mAll.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
