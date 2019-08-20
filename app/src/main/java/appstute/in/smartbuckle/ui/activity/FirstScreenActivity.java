package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class FirstScreenActivity extends BaseActivity {

    Button loginButton,regButton;
    Typeface tf1,tf2,tf3,tf4,tf5;
    TextView buckleTxt,buckleSubtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);

        init();
        action();

        tf1 =Typeface.createFromAsset(getAssets(),"tt0205m.ttf");
        tf2 =Typeface.createFromAsset(getAssets(),"futuramediumbt.ttf");
        tf3 =Typeface.createFromAsset(getAssets(),"unicode.futurab.ttf");
        tf4 =Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf5 =Typeface.createFromAsset(getAssets(),"tt0140m_.ttf");


        loginButton.setTypeface(tf2);  //futuramedium
        regButton.setTypeface(tf2);   //futuramedium
        buckleTxt.setTypeface(tf4);  //chunkfive
        buckleSubtxt.setTypeface(tf2);
    }


    private void init()
    {
      loginButton = (Button) findViewById(R.id.loginButton);
      regButton = (Button) findViewById(R.id.regButton);
      buckleTxt = (TextView) findViewById(R.id.buckleTxt);
      buckleSubtxt = (TextView) findViewById(R.id.buckleSubtxt);
    }

    private void action()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstScreenActivity.this,LoginScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstScreenActivity.this,RegisterScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }

}
