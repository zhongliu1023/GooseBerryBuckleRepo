package appstute.in.smartbuckle.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import in.appstute.smartbuckle.R;

public class LoginScreenActivity extends BaseActivity {

    Typeface tf1,tf2,tf3,tf4,tf5,tf6;
    TextView loginHeaderTxt,loginSubheaderTxt,loginBottomTxt, regWith, regHereTxt;
    Button resetBtn, loginMainbtn;
    EditText editTextLoginName,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        init(); setListener();

        tf1 =Typeface.createFromAsset(getAssets(),"tt0205m.ttf");
        tf2 =Typeface.createFromAsset(getAssets(),"futuramediumbt.ttf");
        tf3 =Typeface.createFromAsset(getAssets(),"unicode.futurab.ttf");
        tf4 =Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf5 =Typeface.createFromAsset(getAssets(),"unicode.futurabb.ttf");
        tf6 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");

        loginHeaderTxt.setTypeface(tf6);
        loginSubheaderTxt.setTypeface(tf6);
        loginBottomTxt.setTypeface(tf6);
        loginMainbtn.setTypeface(tf2);
        resetBtn.setTypeface(tf6);
        regWith.setTypeface(tf6); regHereTxt.setTypeface(tf6);
        editTextLoginName.setTypeface(tf6);
        editTextPassword.setTypeface(tf6);
    }

    private void init()
     {
        loginHeaderTxt = (TextView) findViewById(R.id.loginHeaderTxt);
        loginSubheaderTxt = (TextView) findViewById(R.id.loginSubheaderTxt);
        loginBottomTxt = (TextView) findViewById(R.id.loginBottomTxt);
        regWith = (TextView) findViewById(R.id.regWith);
        regHereTxt = (TextView) findViewById(R.id.regHereTxt);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        loginMainbtn = (Button) findViewById(R.id.loginMainbtn);
         editTextLoginName = (EditText) findViewById(R.id.loginUsername);
         editTextPassword = (EditText) findViewById(R.id.loginPassword);
     }

    private void setListener()
    {
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this,ResetPasswordActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        loginMainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    Intent intent = new Intent(LoginScreenActivity.this, DeviceConnectActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }
        });
        regHereTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this,RegisterScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransitionExit();
        finish();
    }


    private boolean validate()
    {
        boolean validData = true;
        if(editTextLoginName.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty())
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.error_login_cell_phone), null, getString(R.string.error_login_cell_phone_title));
        }
        return validData;

    }

    public void showDialogBox(String message, final EditText editText, String Title)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(Title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if(editText!=null)
                {
                    editText.setText(" ");
                    editText.requestFocus();
                }

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }



}
