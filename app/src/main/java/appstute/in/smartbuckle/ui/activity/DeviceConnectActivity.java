package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class DeviceConnectActivity extends BaseActivity {

    Typeface tf1,tf2;
    TextView pairTapConnect, devConnectHeader, devConnectSub;
    ImageView pairBuckle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_connect);
        init(); action();

        tf1 =Typeface.createFromAsset(getAssets(),"tt0142m_.ttf");
        tf2 =Typeface.createFromAsset(getAssets(),"chunkfive.otf");

        pairTapConnect.setTypeface(tf1);
        devConnectHeader.setTypeface(tf1); //done
        devConnectSub.setTypeface(tf1);
    }


    private void init()
    {
        pairTapConnect = (TextView) findViewById(R.id.pairTapConnect);
        pairBuckle = (ImageView) findViewById(R.id.pairBuckle);
        devConnectHeader = (TextView) findViewById(R.id.devConnectHeader);
        devConnectSub = (TextView) findViewById(R.id.devConnectSub);
    }

    private void action()
    {
       pairBuckle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DeviceConnectActivity.this,AddBuckleActivity.class);
               startActivity(intent);
               overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
           }
       });

       pairTapConnect.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DeviceConnectActivity.this,AddBuckleActivity.class);
               startActivity(intent);
               overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
           }
       });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DeviceConnectActivity.this,RegUserProfileActivity.class);
        startActivity(intent);
        overridePendingTransitionExit();
    }
}
