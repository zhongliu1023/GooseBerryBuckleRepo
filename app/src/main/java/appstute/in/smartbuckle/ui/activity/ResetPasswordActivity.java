package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class ResetPasswordActivity extends BaseActivity {

    Typeface tf1,tf2;
    TextView resetHeaderTxt, resetSubheaderTxt;
    EditText resetUsername;
    Button resetPassSendBtn;
    ImageView navigateResetToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        init(); setListener();

        tf1 =Typeface.createFromAsset(getAssets(),"futuramediumbt.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");
        resetHeaderTxt.setTypeface(tf2);
        resetSubheaderTxt.setTypeface(tf2);
        resetUsername.setTypeface(tf2);
        resetPassSendBtn.setTypeface(tf1);
    }

    private void init() {
        resetHeaderTxt = (TextView) findViewById(R.id.resetHeaderTxt);
        resetSubheaderTxt = (TextView) findViewById(R.id.resetSubheaderTxt);
        resetUsername = (EditText) findViewById(R.id.resetUsername);
        resetPassSendBtn = (Button) findViewById(R.id.resetPassSendBtn);
        navigateResetToLogin = (ImageView) findViewById(R.id.navigateResetToLogin);
    }

    private void setListener() {
        navigateResetToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ResetPasswordActivity.this,LoginScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransitionExit();
        finish();
    }

}
