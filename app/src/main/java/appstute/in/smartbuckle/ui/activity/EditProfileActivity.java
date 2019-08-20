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
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class EditProfileActivity extends BaseActivity {

    final Context context = this;
    Typeface tf1,tf2;
    ImageView navProfileToSet;
    TextView genMaleBtn, genFemaleBtn, genCancelBtn, unitImperialBtn, unitMetricUs, unitCancelBtn, editProfileHeader, userName, dispNameofUser, passwordTxt, dispPassword, genEditTxt, genChange, heightEditTxt, heightEditCmFt, weightEditTxt, weightEditLbsKg
    ,unitTxt, unitSelect1,phoneTxt,dispPhone;
    private Dialog dialog,dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
        action();
        setListener();
        setListener1();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");

        editProfileHeader.setTypeface(tf1);
        userName.setTypeface(tf2);
        dispNameofUser.setTypeface(tf2);
        phoneTxt.setTypeface(tf2);
        dispPhone.setTypeface(tf2);
        passwordTxt.setTypeface(tf2);
        dispPassword.setTypeface(tf2);
        genEditTxt.setTypeface(tf2);
        genChange.setTypeface(tf2);
        heightEditTxt.setTypeface(tf2);
        heightEditCmFt.setTypeface(tf2);
        weightEditTxt.setTypeface(tf2);
        weightEditLbsKg.setTypeface(tf2);
        unitTxt.setTypeface(tf2);
        unitSelect1.setTypeface(tf2);
    }

    private void init() {
        navProfileToSet = (ImageView) findViewById(R.id.navProfileToSet);
        editProfileHeader = (TextView) findViewById(R.id.editProfileHeader);
        userName = (TextView) findViewById(R.id.userName);
        dispNameofUser = (TextView) findViewById(R.id.dispNameofUser);
        passwordTxt = (TextView) findViewById(R.id.passwordTxt);
        dispPassword = (TextView) findViewById(R.id.dispPassword);
        genEditTxt = (TextView) findViewById(R.id.genEditTxt);
        genChange = (TextView) findViewById(R.id.genChange);
        heightEditTxt = (TextView) findViewById(R.id.heightEditTxt);
        heightEditCmFt = (TextView) findViewById(R.id.heightEditCmFt);
        weightEditTxt = (TextView) findViewById(R.id.weightEditTxt);
        weightEditLbsKg = (TextView) findViewById(R.id.weightEditLbsKg);
        unitTxt = (TextView) findViewById(R.id.unitTxt);
        unitSelect1 = (TextView) findViewById(R.id.unitSelect1);
        phoneTxt = (TextView) findViewById(R.id.phoneTxt);
        dispPhone = (TextView) findViewById(R.id.dispPhone);
    }

    private void setListener() {
        navProfileToSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, HomeMoveActivity.class);
                startActivity(intent);
            }
        });

        genChange.setOnClickListener(new View.OnClickListener() {
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
    }
    private void setListener1()
    {
        unitSelect1.setOnClickListener(new View.OnClickListener() {
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
    private void setDialogListener()
    {
        genMaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genChange.setText("Male");
                dialog.dismiss();
            }
        });

        genFemaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genChange.setText("Female");
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
    private void setDialogListener1()
    {
        unitImperialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitSelect1.setText("Imperial UK");
                dialog1.dismiss();
            }
        });

        unitMetricUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                unitSelect1.setText("Metric US");
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

    private void action()
    {
        heightEditCmFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, HeightSelectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        weightEditLbsKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, WeightSelectionActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }
}
