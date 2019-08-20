package appstute.in.smartbuckle.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import in.appstute.smartbuckle.R;


public class MoveFragment extends Fragment {

    long date = System.currentTimeMillis();
    private Typeface tf1, tf2;

    private TextView moveFragDate, stepTxt, paceTxt, paceSubTxt, caloryTxt, timeTxt, distanceTxt;




    public MoveFragment() {
        // Required empty public constructor
    }

    public static MoveFragment newInstance() {
        MoveFragment fragment2 = new MoveFragment();
        return fragment2;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_move, container, false);
        tf1 = Typeface.createFromAsset(getActivity().getAssets(), "chunkfive.otf");
        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "tt0142m_.ttf");
       // initViewPager();

        moveFragDate = (TextView) rootView.findViewById(R.id.moveFragDate);
        stepTxt = (TextView) rootView.findViewById(R.id.stepTxt);
        paceTxt = (TextView) rootView.findViewById(R.id.paceTxt);
        paceSubTxt = (TextView) rootView.findViewById(R.id.paceSubTxt);
        caloryTxt = (TextView) rootView.findViewById(R.id.caloryTxt);
        timeTxt = (TextView) rootView.findViewById(R.id.timeTxt);
        distanceTxt = (TextView) rootView.findViewById(R.id.distanceTxt);

        moveFragDate.setTypeface(tf2);
        moveFragDate.setText("" + DateFormat.format("MMM dd, yyyy", System.currentTimeMillis()));

        stepTxt.setTypeface(tf2);  paceTxt.setTypeface(tf2); paceSubTxt.setTypeface(tf2);
        caloryTxt.setTypeface(tf2); timeTxt.setTypeface(tf2); distanceTxt.setTypeface(tf2);
        return  rootView;
    }

    /*private void initViewPager()
    {
        VerticalViewPager viewPager = (VerticalViewPager) getActivity().findViewById(R.id.viewPager);
        String title = "ContentFragment";
        viewPager.setAdapter(new ContentFragmentAdapter.Holder(getActivity().getSupportFragmentManager()).add(new MoveWeekFragment()));
    }*/

}