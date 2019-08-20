package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.DisplayContext;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.appstute.smartbuckle.R;


public class RegisterDeviceSuccess extends BaseActivity {

    Typeface tf1,tf2;
    TextView devSuccessHeader, devSuccessSub, connected, deviceTxt, deviceName;
    Button addBuckleDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_devicesuccess);
       /* if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new MoveFragment()).commit();
        } */
        init();
        setListener();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(),"tt0142m_.ttf");

        devSuccessSub.setTypeface(tf2);
        devSuccessHeader.setTypeface(tf1);
        connected.setTypeface(tf2);
        deviceTxt.setTypeface(tf2);
        deviceName.setTypeface(tf2);

    }

    private void init()
    {
        devSuccessHeader = (TextView) findViewById(R.id.devSuccessHeader);
        devSuccessSub = (TextView) findViewById(R.id.devSuccessSub);
        connected = (TextView) findViewById(R.id.connected);
        deviceTxt = (TextView) findViewById(R.id.deviceTxt);
        deviceName = (TextView) findViewById(R.id.deviceName);
        addBuckleDone = (Button) findViewById(R.id.addBuckleDone);
    }

    private void setListener()
    {
        addBuckleDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(RegisterDeviceSuccess.this,HomeMoveActivity.class);
               startActivity(intent);
               // Intent i = new Intent(RegisterDeviceSuccess.this,MoveFragment.class);
               // startActivity(i);

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegisterDeviceSuccess.this,AddBuckleActivity.class);
        startActivity(intent);
        overridePendingTransitionExit();
    }
}
