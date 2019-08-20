package appstute.in.smartbuckle.ui.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.appstute.smartbuckle.R;


public class SleepFragment extends Fragment {

    long date = System.currentTimeMillis();
    TextView sleepFragDate, lightSleepTxt, deepSleepTxt, sleepAtTxt, wakeUpTxt, totalsleepTxt;
    Typeface tf1;

    public SleepFragment() {
        // Required empty public constructor
    }

    public static SleepFragment newInstance() {
        SleepFragment fragment2 = new SleepFragment();
        return fragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sleep, container, false);
        tf1 = Typeface.createFromAsset(getActivity().getAssets(), "tt0142m_.ttf");

        sleepFragDate = (TextView) rootView.findViewById(R.id.sleepFragDate);
        lightSleepTxt = (TextView) rootView.findViewById(R.id.lightSleepTxt);
        deepSleepTxt = (TextView) rootView.findViewById(R.id.deepSleepTxt);
        sleepAtTxt = (TextView) rootView.findViewById(R.id.sleepAtTxt);
        wakeUpTxt = (TextView) rootView.findViewById(R.id.wakeUpTxt);
        totalsleepTxt = (TextView) rootView.findViewById(R.id.totalsleepTxt);

        sleepFragDate.setText("" + DateFormat.format("MMM dd, yyyy", System.currentTimeMillis()));
        sleepFragDate.setTypeface(tf1); lightSleepTxt.setTypeface(tf1); deepSleepTxt.setTypeface(tf1);
        sleepAtTxt.setTypeface(tf1); wakeUpTxt.setTypeface(tf1); totalsleepTxt.setTypeface(tf1);

        return rootView;
    }

}
