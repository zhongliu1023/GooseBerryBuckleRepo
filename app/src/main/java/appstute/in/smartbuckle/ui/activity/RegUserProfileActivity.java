package appstute.in.smartbuckle.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import appstute.in.smartbuckle.model.UserVo;
import in.appstute.smartbuckle.R;


public class RegUserProfileActivity extends BaseActivity {

    final Context context = this;
    Typeface tf1, tf2, tf3, tf4, tf5;
    TextView regUsrHeader, regUsrSubhead, genderTxt, heightTxt, weightTxt, unitTxt, genderSelect, heightSelect, weightSelect, unitSelect;
    private Dialog dialog, dialog1;
    TextView genMaleBtn, genFemaleBtn, genCancelBtn, unitImperialBtn, unitMetricUs, unitCancelBtn;
    Button regUserNextBtn;
    private int heightFeet;
    private int heightInch;
    private int weightLbs;
    private TextView heightValue;
    private TextView weightValue;
    private UserVo userVo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_user_profile);

        init();
        setListener();
        //  setDialogListener();
        //  setDialogListener1();
        //action();

        /* Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            heightFeet = bundle.getInt("heightFeet");
            heightInch = bundle.getInt("heightInch");
        }

        if(bundle != null)
        {
            weightLbs = bundle.getInt("weightLbs");
        }*/


        if (userVo != null) {
            if (userVo.getHeightFeet() != 0) {
                heightFeet = userVo.getHeightFeet();
                heightInch = userVo.getHeightInch();
            }


            if (userVo.getWeightLbs() != 0) {
                weightLbs = userVo.getHeightFeet();

            }
        }


        tf1 = Typeface.createFromAsset(getAssets(), "tt0205m.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "futuramediumbt.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");
        tf4 = Typeface.createFromAsset(getAssets(), "chunkfive.otf");
        tf5 = Typeface.createFromAsset(getAssets(), "tt0144m_.ttf");

        regUsrHeader.setTypeface(tf3);
        regUsrSubhead.setTypeface(tf3);
        genderTxt.setTypeface(tf3);
        heightTxt.setTypeface(tf3);
        weightTxt.setTypeface(tf3);
        unitTxt.setTypeface(tf3);

        genderSelect.setTypeface(tf3);
        heightSelect.setTypeface(tf3);
        weightSelect.setTypeface(tf3);
        unitSelect.setTypeface(tf3);
        genderSelect.setTypeface(tf5);
        heightSelect.setTypeface(tf5);
        weightSelect.setTypeface(tf5);
        unitSelect.setTypeface(tf5);
        heightValue.setTypeface(tf5);

        if (heightFeet != 0) {
            heightSelect.setVisibility(View.INVISIBLE);
            heightValue.setText(heightFeet + " ft " + heightInch + " in");
            heightValue.setVisibility(View.VISIBLE);
        } else {
            heightSelect.setVisibility(View.VISIBLE);
            heightValue.setVisibility(View.INVISIBLE);
        }

        if (weightLbs != 0) {
            weightSelect.setVisibility(View.INVISIBLE);
            weightValue.setText(weightLbs + " lbs ");
            weightValue.setVisibility(View.VISIBLE);
        } else {
            weightSelect.setVisibility(View.VISIBLE);
            weightValue.setVisibility(View.INVISIBLE);
        }


    }

    private void init() {
        regUsrHeader = (TextView) findViewById(R.id.regUsrHeader);
        regUsrSubhead = (TextView) findViewById(R.id.regUsrSubhead);
        genderTxt = (TextView) findViewById(R.id.genderTxt);
        heightTxt = (TextView) findViewById(R.id.heightTxt);
        weightTxt = (TextView) findViewById(R.id.weightTxt);
        unitTxt = (TextView) findViewById(R.id.unitTxt);

        heightValue = (TextView) findViewById(R.id.heightValue);
        weightValue = (TextView) findViewById(R.id.weightValue);


        genderSelect = (TextView) findViewById(R.id.genderSelect);
        heightSelect = (TextView) findViewById(R.id.heightSelect);
        weightSelect = (TextView) findViewById(R.id.weightSelect);
        unitSelect = (TextView) findViewById(R.id.unitSelect);

        regUserNextBtn = (Button) findViewById(R.id.regUserNextBtn);
    }

    private void setListener() {
        regUserNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegUserProfileActivity.this, DeviceConnectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        heightSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegUserProfileActivity.this, HeightSelectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        heightValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                bundle.putInt("htFeet", heightFeet);
                bundle.putInt("htInches", heightInch);*/

                heightFeet = userVo.getHeightFeet();
                heightInch = userVo.getHeightFeet();

                Intent intent = new Intent(RegUserProfileActivity.this, HeightSelectActivity.class);
                //intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });


        weightSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegUserProfileActivity.this, WeightSelectionActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });


        weightValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                bundle.putInt("wtLbs", weightLbs);*/

                weightLbs = userVo.getWeightLbs();

                Intent intent = new Intent(RegUserProfileActivity.this, HeightSelectActivity.class);
                //intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });


        genderSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(context);
                Window window = dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                window.setAttributes(wlp);
                dialog.setContentView(R.layout.gender_custom_dialog);

                genMaleBtn = (TextView) dialog.findViewById(R.id.genMaleBtn);
                genFemaleBtn = (TextView) dialog.findViewById(R.id.genFemaleBtn);
                genCancelBtn = (TextView) dialog.findViewById(R.id.genCancelBtn);
                dialog.show();
                setDialogListener();
            }
        });

        unitSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1 = new Dialog(context);
                Window window = dialog1.getWindow();
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                window.setAttributes(wlp);
                dialog1.setContentView(R.layout.unit_custom_dialog);

                unitImperialBtn = (TextView) dialog1.findViewById(R.id.unitImperialBtn);
                unitMetricUs = (TextView) dialog1.findViewById(R.id.unitMetricUs);
                unitCancelBtn = (TextView) dialog1.findViewById(R.id.unitCancelBtn);
                dialog1.show();
                setDialogListener1();
            }
        });
    }


    private void setDialogListener() {
        genMaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Male selected", Toast.LENGTH_SHORT).show();
                genderSelect.setText("Male");
                dialog.dismiss();
            }
        });

        genFemaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, "Female selected", Toast.LENGTH_SHORT).show();
                genderSelect.setText("Female");
                dialog.dismiss();
            }
        });

        genCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /*private void setDialogListener1()
    {
        unitSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1 = new Dialog(context);
                Window window = dialog1.getWindow();
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                window.setAttributes(wlp);
                dialog1.setContentView(R.layout.unit_custom_dialog);

                unitImperialBtn = (TextView) dialog1.findViewById(R.id.unitImperialBtn);
                unitMetricUs = (TextView) dialog1.findViewById(R.id.unitMetricUs);
                unitCancelBtn = (TextView) dialog1.findViewById(R.id.unitCancelBtn);
                dialog1.show();
                setDialogListener1();
            }
        });
    }*/

    private void setDialogListener1() {
        unitImperialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, "Imperial selected", Toast.LENGTH_SHORT).show();
                unitSelect.setText("Imperial UK");
                weightSelect.setText("lbs");
                heightSelect.setText("ft in");
                dialog1.dismiss();
            }
        });

        unitMetricUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, "Metric selected", Toast.LENGTH_SHORT).show();
                unitSelect.setText("Metric US");
                weightSelect.setText("kg");
                heightSelect.setText("cm");
                dialog1.dismiss();
            }
        });

        unitCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegUserProfileActivity.this, RegisterScreenActivity.class);
        startActivity(intent);
        overridePendingTransitionExit();
    }
}
