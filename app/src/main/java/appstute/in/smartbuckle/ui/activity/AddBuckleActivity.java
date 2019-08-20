package appstute.in.smartbuckle.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smart.library.blue.BleCode;
import com.smart.library.blue.BleContants;
import com.smart.library.blue.BleDevice;
import com.smart.library.blue.BleImp;
import com.smart.library.blue.BleReceiver;
import com.smart.library.blue.BleScan;
import com.smart.library.blue.BleService;
import com.smart.library.permission.PermissionsManager;
import com.smart.library.permission.PermissionsResultAction;

import java.util.List;

import in.appstute.smartbuckle.R;

public class AddBuckleActivity extends BaseActivity implements BleScan.BleScanImp, BleImp {

    TextView addBuckleHeader, infoText;
    Typeface tf1, tf2, tf3, tf4;
    ImageView navBackArrow;
    private ImageView imageViewAddBuckle;
    private BleDevice BleConnectDevice;
    private BleScan bleScan;
    private BleService mBleService;
    public BluetoothAdapter bluetoothAdapter;
    private RelativeLayout relativeListView;
    private RelativeLayout relativeAddBuckle;
    private RelativeLayout relativeInfoText;
    private BleReceiver mReceiver;
    String deviceAddress;
    String deviceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buckle);
        init();
        action();
        tf1 = Typeface.createFromAsset(getAssets(), "tt0140m_.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "chunkfive.otf");
        addBuckleHeader.setTypeface(tf2);
        infoText.setTypeface(tf1);
    }

    private void init() {
        addBuckleHeader = (TextView) findViewById(R.id.addBuckleHeader);
        infoText = (TextView) findViewById(R.id.infoText);
        navBackArrow = (ImageView) findViewById(R.id.navBackArrow);
        imageViewAddBuckle = (ImageView) findViewById(R.id.imageViewAddBuckle);
        relativeListView = (RelativeLayout) findViewById(R.id.relativeListView);
        relativeAddBuckle = (RelativeLayout) findViewById(R.id.relativeAddBuckle);
        relativeInfoText = (RelativeLayout) findViewById(R.id.relativeInfoText);
        relativeInfoText.setVisibility(View.VISIBLE);
    }

    private void action() {
        navBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBuckleActivity.this, HomeMoveActivity.class);
                startActivity(intent);
            }
        });

        imageViewAddBuckle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeInfoText.setVisibility(View.INVISIBLE);
                relativeListView.setVisibility(View.VISIBLE);
                bleStartScan();
                connectedDevice();
                //pairDevice();
            }
        });
    }

    public void bleStartScan() {
        super.onStart();
        // super.onStart();
        //initialization
        bleScan = new BleScan(this, this);
        //start the scan
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        bleScan.startScan();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(AddBuckleActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onScanStart() {

    }

    public void connectedDevice() {
        bluetoothAdapter = new BluetoothAdapter(this);
        ListView mDeviceLv = (ListView) findViewById(R.id.scan_lv);
        mDeviceLv.setAdapter(bluetoothAdapter);

        mDeviceLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (bleScan != null) {
                    bleScan.stopScan();
                }
                BleConnectDevice = (BleDevice) bluetoothAdapter.getItem(i);
                deviceAddress = BleConnectDevice.device.getAddress();
                deviceName = BleConnectDevice.device.getName();
                pairDevice(deviceName, deviceAddress);
            }
        });

    }


    public void pairDevice(String mDeviceName, String mDeviceAddress) {
        // Log.i(TAG, "Connect:" + mDeviceName + "[" + mDeviceAddress + "]");
        mBleService = ((ServiceCall) this.getApplication()).bleService;
        if (mBleService != null && mBleService.connect(mDeviceAddress)) {
            BleContants.BLE_CONNECTED_NAME = mDeviceName;
            BleContants.BLE_CONNECTED_ADDRESS = mDeviceAddress;
        }
    }

    @Override
    public void onScanStop() {

    }

    @Override
    public void onScanFail() {

    }

    @Override
    public void onScanDevices(List<BleDevice> unbindDevices, List<BleDevice> bindedDevices) {
        bluetoothAdapter.updateDevices(unbindDevices, bindedDevices);
    }

    @Override
    public void onSuccess(BleCode code, String result) {

    }

    @Override
    public void onFail(String error) {

    }
}
