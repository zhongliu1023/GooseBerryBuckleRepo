package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class AssistMeActivity extends BaseActivity {

    Typeface tf1,tf2;
    TextView assistMeHeader;
    ImageView navassistToSet, suitcaseImg, policyImg;
    TextView helpBuckleTxt, policyTxt, versionTxt, updatedVersionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_me);

        init(); setListener();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0144m_.ttf");

        assistMeHeader.setTypeface(tf1);
        helpBuckleTxt.setTypeface(tf2);
        policyTxt.setTypeface(tf2);
        versionTxt.setTypeface(tf2);
        updatedVersionTxt.setTypeface(tf2);
    }

    private void init()
    {
        assistMeHeader = (TextView) findViewById(R.id.assistMeHeader);
        helpBuckleTxt = (TextView) findViewById(R.id.helpBuckleTxt);
        policyTxt = (TextView) findViewById(R.id.policyTxt);
        versionTxt = (TextView) findViewById(R.id.versionTxt);
        updatedVersionTxt = (TextView) findViewById(R.id.updatedVersionTxt);

        navassistToSet = (ImageView) findViewById(R.id.navassistToSet);
        suitcaseImg = (ImageView) findViewById(R.id.suitcaseImg);
        policyImg = (ImageView) findViewById(R.id.policyImg);
    }

    private void setListener()
    {
        navassistToSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistMeActivity.this, HomeMoveActivity.class);
                startActivity(intent);
            }
        });
        suitcaseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.gooseberry.store/support";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        policyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.gooseberry.store/policy";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
