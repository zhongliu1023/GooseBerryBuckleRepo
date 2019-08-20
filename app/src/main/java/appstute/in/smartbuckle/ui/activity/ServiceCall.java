package appstute.in.smartbuckle.ui.activity;

import com.smart.library.blue.BleApp;
import com.smart.library.blue.BleLogs;

/**
 * Created by appstute on 3/5/17.
 */

public class ServiceCall extends BleApp {

    @Override
    public void onCreate() {
        super.onCreate();
        bindBleService(getApplicationContext());
        BleLogs.setDebug(true);
        BleLogs.setTag("BleLogs");
    }

}
