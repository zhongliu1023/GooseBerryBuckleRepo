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


public class MoveWeekFragment extends BaseFragment {

   private TextView weekHeadTxt,weeklyDate,stepsTxt,dailyAvgTxt,textViewMove,dispSteps,totalTxt,
           sleepTotalDisp, totalmonthDistTxt,dispDistance,totalCaloryMonthTxt,caloryDisp,averageMonthPaceTxt,totalPaceMonthDisp,stepsMonthMinTxt;
   private Typeface tf1, tf2;

    public MoveWeekFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        MoveWeekFragment fragment = new MoveWeekFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_move_week, container, false);
        tf1 = Typeface.createFromAsset(getActivity().getAssets(), "chunkfive.otf");
        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "tt0142m_.ttf");

        weekHeadTxt = (TextView) rootView.findViewById(R.id.weekHeadTxt);
        weekHeadTxt.setTypeface(tf2);

        weeklyDate = (TextView) rootView.findViewById(R.id.weeklyDate);
        weeklyDate.setTypeface(tf2);

        stepsTxt = (TextView) rootView.findViewById(R.id.stepsTxt);
        stepsTxt.setTypeface(tf2);

        dailyAvgTxt = (TextView) rootView.findViewById(R.id.dailyAvgTxt);
        dailyAvgTxt.setTypeface(tf2);

        textViewMove = (TextView) rootView.findViewById(R.id.textViewMove);
        textViewMove.setTypeface(tf2);

        dispSteps = (TextView) rootView.findViewById(R.id.dispSteps);
        dispSteps.setTypeface(tf2);

        totalTxt = (TextView) rootView.findViewById(R.id.totalTxt);
        totalTxt.setTypeface(tf2);

        sleepTotalDisp = (TextView) rootView.findViewById(R.id.sleepTotalDisp);
        sleepTotalDisp.setTypeface(tf2);

        totalmonthDistTxt = (TextView) rootView.findViewById(R.id.totalmonthDistTxt);
        totalmonthDistTxt.setTypeface(tf2);

        dispDistance = (TextView) rootView.findViewById(R.id.dispDistance);
        dispDistance.setTypeface(tf2);

        totalCaloryMonthTxt = (TextView) rootView.findViewById(R.id.totalCaloryMonthTxt);
        totalCaloryMonthTxt.setTypeface(tf2);

        caloryDisp = (TextView) rootView.findViewById(R.id.caloryDisp);
        caloryDisp.setTypeface(tf2);

        averageMonthPaceTxt = (TextView) rootView.findViewById(R.id.averageMonthPaceTxt);
        averageMonthPaceTxt.setTypeface(tf2);

        totalPaceMonthDisp = (TextView) rootView.findViewById(R.id.totalPaceMonthDisp);
        totalPaceMonthDisp.setTypeface(tf2);

        stepsMonthMinTxt = (TextView) rootView.findViewById(R.id.stepsMonthMinTxt);
        stepsMonthMinTxt.setTypeface(tf2);

        return  rootView;
    }
}
