package appstute.in.smartbuckle.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import appstute.in.smartbuckle.ui.activity.AddBuckleActivity;
import appstute.in.smartbuckle.ui.activity.AssistMeActivity;
import appstute.in.smartbuckle.ui.activity.EditProfileActivity;
import appstute.in.smartbuckle.ui.activity.GoogleFitActivity;
import appstute.in.smartbuckle.ui.activity.PhilosophyActivity;
import in.appstute.smartbuckle.R;



public class SettingFragment extends BaseFragment {

    private Typeface tf1,tf2;
    private TextView settingTxt,collectionTxt,profileTxt,gfitTxt,assistTxt,philosophyTxt;
    ImageView collectionBuckle, profileIcon, gfiticon, assisticon, philosophyIcon;

    public SettingFragment(){
        //Empty consturctor
    }

    public static SettingFragment newInstance() {
        SettingFragment fragment1 = new SettingFragment();
        return fragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListener();

    }
    //goto fragments to activity
    private void setListener()
    {
        collectionBuckle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collection = new Intent(getActivity(), AddBuckleActivity.class);
                startActivity(collection);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        collectionTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collection = new Intent(getActivity(), AddBuckleActivity.class);
                startActivity(collection);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        profileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        gfiticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gfitIntent = new Intent(getActivity(), GoogleFitActivity.class);
                startActivity(gfitIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        gfitTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gfitIntent = new Intent(getActivity(), GoogleFitActivity.class);
                startActivity(gfitIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        assisticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent assistIntent = new Intent(getActivity(), AssistMeActivity.class);
                startActivity(assistIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        assistTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent assistIntent = new Intent(getActivity(), AssistMeActivity.class);
                startActivity(assistIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        philosophyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent philIntent = new Intent(getActivity(), PhilosophyActivity.class);
                startActivity(philIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        philosophyTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent philIntent = new Intent(getActivity(), PhilosophyActivity.class);
                startActivity(philIntent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
        tf1 =Typeface.createFromAsset(getActivity().getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getActivity().getAssets(),"tt0142m_.ttf");

        settingTxt = (TextView) rootView.findViewById(R.id.settingTxt);
        collectionTxt = (TextView) rootView.findViewById(R.id.collectionTxt);
        profileTxt = (TextView) rootView.findViewById(R.id.profileTxt);
        gfiticon = (ImageView) rootView.findViewById(R.id.gfiticon);
        gfitTxt = (TextView) rootView.findViewById(R.id.gfitTxt);
        assistTxt = (TextView) rootView.findViewById(R.id.assistTxt);
        philosophyTxt = (TextView) rootView.findViewById(R.id.philosophyTxt);
        collectionBuckle = (ImageView) rootView.findViewById(R.id.collectionBuckle);
        profileIcon = (ImageView) rootView.findViewById(R.id.profileIcon);
        assisticon = (ImageView) rootView.findViewById(R.id.assisticon);
        philosophyIcon = (ImageView) rootView.findViewById(R.id.philosophyIcon);

        settingTxt.setTypeface(tf1); collectionTxt.setTypeface(tf2); profileTxt.setTypeface(tf2);
        gfitTxt.setTypeface(tf2); assistTxt.setTypeface(tf2); philosophyTxt.setTypeface(tf2);

        return rootView;
    }


}