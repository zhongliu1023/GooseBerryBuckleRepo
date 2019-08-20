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

import appstute.in.smartbuckle.common.util.ValidationUtil;
import in.appstute.smartbuckle.R;


public class RegisterScreenActivity extends BaseActivity {

    Typeface tf1,tf2,tf3,tf4,tf5;
    TextView regHeaderTxt,regSubheaderTxt,regBottomTxt,regBottomLoginTxt;
    Button regNextButton;
    private EditText editTextFullName;
    private EditText editTextPhoneNo;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextReEnterPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        init();
        action();

        tf1 =Typeface.createFromAsset(getAssets(),"tt0142m_.ttf");
        tf2 =Typeface.createFromAsset(getAssets(),"futuramediumbt.ttf");
        tf3 =Typeface.createFromAsset(getAssets(),"tt0140m_.ttf");
        tf4 =Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf5 =Typeface.createFromAsset(getAssets(),"unicode.futurabb.ttf");

        regHeaderTxt.setTypeface(tf3);
        regSubheaderTxt.setTypeface(tf3);
        regBottomTxt.setTypeface(tf3);
        regBottomLoginTxt.setTypeface(tf3);
        editTextFullName.setTypeface(tf3);
        editTextPhoneNo.setTypeface(tf3);
        editTextEmail.setTypeface(tf3);
        editTextPassword.setTypeface(tf3);
        editTextReEnterPassword.setTypeface(tf3);

    }

    private void action()
    {
        regNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    Intent intent = new Intent(RegisterScreenActivity.this, RegUserProfileActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }
        });

        regBottomLoginTxt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(RegisterScreenActivity.this, LoginScreenActivity.class );
            startActivity(i);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        }
    });


    }

    private void init()
    {
        regHeaderTxt = (TextView) findViewById(R.id.regHeaderTxt);
        regSubheaderTxt = (TextView) findViewById(R.id.regSubheaderTxt);
        regBottomTxt = (TextView) findViewById(R.id.regBottomTxt);
        regNextButton = (Button) findViewById(R.id.regNextButton);
        regBottomLoginTxt = (TextView) findViewById(R.id.regBottomLoginTxt);
        editTextFullName = (EditText) findViewById(R.id.enterFullname);
        editTextPhoneNo = (EditText) findViewById(R.id.enterCellphone);
        editTextEmail = (EditText) findViewById(R.id.enterEmail);
        editTextPassword = (EditText) findViewById(R.id.enterPassword);
        editTextReEnterPassword = (EditText) findViewById(R.id.enterReenter);



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegisterScreenActivity.this,FirstScreenActivity.class);
        startActivity(intent);
        overridePendingTransitionExit();
    }



    private boolean validate() {
        boolean validData = true;
        if (editTextFullName.getText().toString().isEmpty())
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.error_empty_full_name), null, getString(R.string.error_empty_full_name_title));
        }
        else if(!ValidationUtil.checkValidate(editTextPhoneNo.getText().toString().trim()))
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.error_empty_phone_no),null, getString(R.string.error_empty_phone_no_title));
        }
        else if (!ValidationUtil.validateEmailField(editTextEmail.getText().toString().trim()))
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.email_constraint_mismatch), null, null);
        }
        else if(editTextPassword.getText().toString().isEmpty() || editTextPassword.getText().toString().length()< 6)
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.error_empty_password),null, getString(R.string.error_empty_password_title));
        }
        else if (!editTextReEnterPassword.getText().toString().equals(editTextPassword.getText().toString()))
        {
            validData = false;
            showDialogBox(getResources().getString(R.string.error_password_match), null, getString(R.string.error_password_match_title));
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
