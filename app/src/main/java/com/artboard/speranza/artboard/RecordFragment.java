package com.artboard.speranza.artboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {


    public RecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TextView title = (TextView) getActivity().findViewById(R.id.textview_title);
        title.setText(getResources().getString(R.string.record));
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

}
