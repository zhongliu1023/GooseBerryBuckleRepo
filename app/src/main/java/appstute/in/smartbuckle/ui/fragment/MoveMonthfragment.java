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


public class MoveMonthfragment extends BaseFragment {

    private Typeface tf2;
    private TextView monthHeadTxt, monthYear, stepsinMonthTxt, weeklyAvgTxt, moveWeeklyTxt, dispWeekSteps
                     ,totalTxtMonth, totalStepDisp, totalmonthDistTxt, totalDistanceDisp, totalCaloryMonthTxt, totalCaloryMonthDisp, averageMonthPaceTxt, totalPaceMonthDisp, stepsMonthMinTxt;

    public MoveMonthfragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_move_monthfragment, container, false);
        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "tt0142m_.ttf");

        monthHeadTxt = (TextView) rootView.findViewById(R.id.monthHeadTxt);
        monthHeadTxt.setTypeface(tf2);

        monthYear = (TextView) rootView.findViewById(R.id.monthYear);
        monthYear.setTypeface(tf2);

        stepsinMonthTxt = (TextView) rootView.findViewById(R.id.stepsinMonthTxt);
        stepsinMonthTxt.setTypeface(tf2);

        weeklyAvgTxt = (TextView) rootView.findViewById(R.id.weeklyAvgTxt);
        weeklyAvgTxt.setTypeface(tf2);

        moveWeeklyTxt = (TextView) rootView.findViewById(R.id.moveWeeklyTxt);
        moveWeeklyTxt.setTypeface(tf2);

        dispWeekSteps = (TextView) rootView.findViewById(R.id.dispWeekSteps);
        dispWeekSteps.setTypeface(tf2);

        totalTxtMonth = (TextView) rootView.findViewById(R.id.totalTxtMonth);
        totalTxtMonth.setTypeface(tf2);

        totalStepDisp = (TextView) rootView.findViewById(R.id.totalStepDisp);
        totalStepDisp.setTypeface(tf2);

        totalmonthDistTxt = (TextView) rootView.findViewById(R.id.totalmonthDistTxt);
        totalmonthDistTxt.setTypeface(tf2);

        totalDistanceDisp = (TextView) rootView.findViewById(R.id.totalDistanceDisp);
        totalDistanceDisp.setTypeface(tf2);

        totalCaloryMonthTxt = (TextView) rootView.findViewById(R.id.totalCaloryMonthTxt);
        totalCaloryMonthTxt.setTypeface(tf2);

        totalCaloryMonthDisp = (TextView) rootView.findViewById(R.id.totalCaloryMonthDisp);
        totalCaloryMonthDisp.setTypeface(tf2);

        averageMonthPaceTxt = (TextView) rootView.findViewById(R.id.averageMonthPaceTxt);
        averageMonthPaceTxt.setTypeface(tf2);

        totalPaceMonthDisp = (TextView) rootView.findViewById(R.id.totalPaceMonthDisp);
        totalPaceMonthDisp.setTypeface(tf2);

        stepsMonthMinTxt = (TextView) rootView.findViewById(R.id.stepsMonthMinTxt);
        stepsMonthMinTxt.setTypeface(tf2);

        return rootView;
    }




}
