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

public class WeightSelectionActivity extends BaseActivity {

    Button weightBackBtn;
    TextView weightHead, weightSubhead, weightSelectTxt, lbsTxt, textViewWtLbs, textViewFeet;
    Typeface tf1, tf2;
    private EditText editTextWeightLbs;
    private TextView lbs;
    private int wtLbs;
    private UserVo userVo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_selection);

        init();
        action();

        /*Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            wtLbs = bundle.getInt("wtLbs");

        }

        if(wtLbs != 0){
            textViewWtLbs.setText(wtLbs+" lbs ");
            textViewFeet.setVisibility(View.VISIBLE);
            textViewWtLbs.setVisibility(View.INVISIBLE);
        }else{
            textViewFeet.setVisibility(View.INVISIBLE);
            textViewWtLbs.setVisibility(View.VISIBLE);
        }*/


       /* if(userVo != null) {

            if (userVo.getWeightLbs() != 0) {
                wtLbs = userVo.getHeightFeet();

            }
        }

        if (wtLbs != 0)
        {
            textViewWtLbs.setText(userVo.getHeightFeet());
            textViewWtLbs.setVisibility(View.VISIBLE);
            textViewFeet.setVisibility(View.INVISIBLE);

        }
        else{
            textViewWtLbs.setVisibility(View.INVISIBLE);
            textViewFeet.setVisibility(View.VISIBLE);
        }
*/


        tf1 = Typeface.createFromAsset(getAssets(), "chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");

        weightHead.setTypeface(tf2);
        weightSubhead.setTypeface(tf2);
        weightSelectTxt.setTypeface(tf2);
        lbsTxt.setTypeface(tf2);
        lbs.setTypeface(tf2);
        weightBackBtn.setTypeface(tf2);
    }

    private void init() {
        weightBackBtn = (Button) findViewById(R.id.weightBackBtn);
        weightHead = (TextView) findViewById(R.id.weightHead);
        weightSubhead = (TextView) findViewById(R.id.weightSubhead);
        weightSelectTxt = (TextView) findViewById(R.id.weightSelectTxt);
        lbsTxt = (TextView) findViewById(R.id.lbsTxt);
        lbs = (TextView) findViewById(R.id.lbs);
        editTextWeightLbs = (EditText) findViewById(R.id.weightLbs);
        textViewWtLbs = (TextView) findViewById(R.id.wtfeet);
        textViewFeet = (TextView) findViewById(R.id.feet);

    }

    private void action() {
        weightBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int weightLbs = Integer.parseInt(editTextWeightLbs.getText().toString());

                if (!editTextWeightLbs.getText().toString().isEmpty())
                {
                    UserVo userVo = new UserVo();
                    userVo.setWeightLbs(weightLbs);
                } else if (wtLbs != 0) {
                    editTextWeightLbs.setText(userVo.getWeightLbs());
                }


*/
                /*Bundle bundle = new Bundle();

                if(!editTextWeightLbs.getText().toString().isEmpty())
                {
                    bundle.putInt("weightLbs", Integer.parseInt(editTextWeightLbs.getText().toString()));
                }
                else if(wtLbs != 0){
                    bundle.putInt("weightLbs", wtLbs);
                }*/

                Intent intent = new Intent(WeightSelectionActivity.this, RegUserProfileActivity.class);
                //intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransitionExit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Intent intent = new Intent(WeightSelectionActivity.this,RegUserProfileActivity.class);
        //startActivity(intent);
        overridePendingTransitionExit();
        finish();
    }
}
