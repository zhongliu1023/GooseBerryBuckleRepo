package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;


public class GoogleFitActivity extends BaseActivity {

    Typeface tf1,tf2;
    ImageView navgfitToSet;
    TextView googleFitHeader, syncTxt, gfitBottomTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_fit);
        init(); setListener();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0144m_.ttf");

        googleFitHeader.setTypeface(tf1);
        syncTxt.setTypeface(tf2); gfitBottomTxt.setTypeface(tf2);
    }

    private void init()
    {
        navgfitToSet = (ImageView) findViewById(R.id.navgfitToSet);
        googleFitHeader = (TextView) findViewById(R.id.googleFitHeader);
        syncTxt = (TextView) findViewById(R.id.syncTxt);
        gfitBottomTxt = (TextView) findViewById(R.id.gfitBottomTxt);
    }

    private void setListener()
    {
        navgfitToSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoogleFitActivity.this, HomeMoveActivity.class);
                startActivity(intent);
            }
        });
    }
}
