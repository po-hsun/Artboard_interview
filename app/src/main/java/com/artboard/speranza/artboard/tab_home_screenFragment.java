package com.artboard.speranza.artboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab_home_screenFragment extends Fragment {


    public tab_home_screenFragment() {
        // Required empty public constructor
    }

    private FragmentTabHost tabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView title = (TextView) getActivity().findViewById(R.id.textview_title);
        title.setText(getResources().getString(R.string.home_screen));
        tabHost = new FragmentTabHost(getActivity());
        //tabHost = (FragmentTabHost) getActivity().findViewById(android.R.id.tabhost);
        tabHost.setup(getActivity(),getChildFragmentManager(),R.id.fragment_frame);
        tabHost.addTab(tabHost.newTabSpec("Tab1")
                        .setIndicator("Tab1"),
                home_screenFragment.class,
                null);
        tabHost.addTab(tabHost.newTabSpec("Tab2")
                        .setIndicator("Tab2"),
                twoFragment.class,
                null);
        tabHost.addTab(tabHost.newTabSpec("Tab3")
                        .setIndicator("Tab3"),
                threeFragment.class,
                null);
        TabWidget widget = tabHost.getTabWidget();
        for(int i = 0; i < widget.getChildCount(); i++) {
            View v = widget.getChildAt(i);

            // Look for the title view to ensure this is an indicator and not a divider.
            TextView tv = (TextView)v.findViewById(android.R.id.title);
            if(tv == null) {
                continue;
            }
            v.setBackgroundResource(R.drawable.tab_pink);
        }
        widget.setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        return tabHost;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabHost = null;
    }

}
