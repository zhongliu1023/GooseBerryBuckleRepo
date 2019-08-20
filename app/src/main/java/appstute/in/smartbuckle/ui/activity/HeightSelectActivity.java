package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import appstute.in.smartbuckle.model.UserVo;
import in.appstute.smartbuckle.R;


public class HeightSelectActivity extends BaseActivity {

    Button heightBackBtn;
    EditText editTextHeightFeet, editTextHeightInch;
    TextView textViewHtFeetInches, textViewHtFInch;
    TextView heightHead,heightSubhead,heightSelectTxt,feetTxt,inchTxt,centimeterTxt;
    Typeface tf1,tf2;
    private int htFeet, htInches;
    private UserVo userVo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_select);
        init(); action();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(),"tt0142m_.ttf");

        heightHead.setTypeface(tf2);
        heightSubhead.setTypeface(tf2);
        heightSelectTxt.setTypeface(tf2);
        feetTxt.setTypeface(tf2);
        inchTxt.setTypeface(tf2);
        heightBackBtn.setTypeface(tf2);
        centimeterTxt.setTypeface(tf2);

        /*Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            htFeet = bundle.getInt("htFeet");
            htInches = bundle.getInt("htInches");
        }

        if(htFeet != 0){
            textViewHtFeetInches.setText(htFeet+" ' " + htInches+"''");
            textViewHtFeetInches.setVisibility(View.VISIBLE);
            textViewHtFInch.setVisibility(View.INVISIBLE);
        }else{
            textViewHtFeetInches.setVisibility(View.INVISIBLE);
            textViewHtFInch.setVisibility(View.VISIBLE);
        }*/

     /*   if(userVo !=null) {
            if (userVo.getHeightFeet() != 0) {
                userVo = new UserVo();
                htFeet = userVo.getHeightFeet();
                htInches = userVo.getHeightInch();
            }
        }

        if (htFeet != 0)
        {
            textViewHtFeetInches.setText(userVo.getHeightFeet());
            textViewHtFeetInches.setVisibility(View.VISIBLE);
            textViewHtFInch.setVisibility(View.INVISIBLE);

        }
        else{
            textViewHtFeetInches.setVisibility(View.INVISIBLE);
            textViewHtFInch.setVisibility(View.VISIBLE);
        }*/



    }

    private void init()
     {
        heightBackBtn = (Button) findViewById(R.id.heightBackBtn);
        heightHead = (TextView) findViewById(R.id.heightHead);
        heightSubhead = (TextView) findViewById(R.id.heightSubhead);
         heightSelectTxt = (TextView) findViewById(R.id.heightSelectTxt);
         feetTxt = (TextView) findViewById(R.id.feetTxt);
         inchTxt = (TextView) findViewById(R.id.inchTxt);
         centimeterTxt = (TextView) findViewById(R.id.centimeterTxt);
         editTextHeightFeet = (EditText) findViewById(R.id.heightFeet);
         editTextHeightInch = (EditText) findViewById(R.id.heightInch);
         textViewHtFeetInches = (TextView) findViewById(R.id.htfeetinches);
         textViewHtFInch = (TextView) findViewById(R.id.viewfeetinches);

     }

    private void action()
    {
        heightBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(HeightSelectActivity.this,RegUserProfileActivity.class);
              //  startActivity(intent);
                finish();
                overridePendingTransitionExit();
            }
        });
    }
                //Bundle bundle = new Bundle();
              //  int heightFeet = Integer.parseInt(editTextHeightFeet.getText().toString());
               // int heightInch = Integer.parseInt(editTextHeightInch.getText().toString());
               /* if(!editTextHeightFeet.getText().toString().isEmpty() && !editTextHeightInch.getText().toString().isEmpty())
                {
                    userVo = new UserVo();
                    userVo.setHeightFeet(heightFeet);
                    userVo.setHeightInch(heightInch);
                    //bundle.putInt("heightFeet", Integer.parseInt(editTextHeightFeet.getText().toString()));
                    //bundle.putInt("heightInch", Integer.parseInt(editTextHeightInch.getText().toString()));
                }else if(htFeet != 0){
                    userVo.getHeightFeet();
                    userVo.getHeightInch();
                    //bundle.putInt("heightFeet", htFeet);
                    //bundle.putInt("heightInch", htInches);
                }
*/




    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // Intent intent = new Intent(HeightSelectActivity.this,RegUserProfileActivity.class);
       // startActivity(intent);
        overridePendingTransitionExit();
        finish();
    }
}
