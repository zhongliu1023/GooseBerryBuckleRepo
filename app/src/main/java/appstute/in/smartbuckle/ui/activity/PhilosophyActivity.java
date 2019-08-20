package appstute.in.smartbuckle.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.appstute.smartbuckle.R;

public class PhilosophyActivity extends BaseActivity {

    Typeface tf1,tf2,tf3;
    TextView philosophyHeader, philosophyMainText;
    ImageView philosophyToSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philosophy);
        init(); setListener();

        tf1 = Typeface.createFromAsset(getAssets(),"chunkfive.otf");
        tf2 = Typeface.createFromAsset(getAssets(), "tt0142m_.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "tt0144m_.ttf");

        philosophyMainText.setTypeface(tf2);
        philosophyHeader.setTypeface(tf1);
    }

    private void init()
    {
        philosophyMainText = (TextView) findViewById(R.id.philosophyMainText);
        philosophyHeader = (TextView) findViewById(R.id.philosophyHeader);
        philosophyToSet = (ImageView) findViewById(R.id.philosophyToSet);
    }
    private void setListener()
    {
        philosophyToSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhilosophyActivity.this, HomeMoveActivity.class);
                startActivity(intent);
            }
        });
    }
}
