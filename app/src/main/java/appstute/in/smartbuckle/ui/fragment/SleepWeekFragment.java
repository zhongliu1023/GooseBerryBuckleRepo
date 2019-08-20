package appstute.in.smartbuckle.ui.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.appstute.smartbuckle.R;


public class SleepWeekFragment extends BaseFragment {

    private Typeface tf2;
    private TextView sleepWeekHeadTxt, sleepWeeklyDate, sleepWeekTxt, sleepDailyAvgTxt;

    public SleepWeekFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sleep_week, container, false);
        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "tt0142m_.ttf");

        sleepWeekHeadTxt = (TextView) rootView.findViewById(R.id.sleepWeekHeadTxt);
        sleepWeekHeadTxt.setTypeface(tf2);

        sleepWeeklyDate = (TextView) rootView.findViewById(R.id.sleepWeeklyDate);
        sleepWeeklyDate.setTypeface(tf2);

        sleepWeekTxt = (TextView) rootView.findViewById(R.id.sleepWeekTxt);
        sleepWeekTxt.setTypeface(tf2);

        sleepDailyAvgTxt = (TextView) rootView.findViewById(R.id.sleepDailyAvgTxt);
        sleepDailyAvgTxt.setTypeface(tf2);

        return  rootView;
    }

}
