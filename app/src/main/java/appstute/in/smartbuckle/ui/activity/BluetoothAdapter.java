package appstute.in.smartbuckle.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.library.blue.BleCode;
import com.smart.library.blue.BleContants;
import com.smart.library.blue.BleDevice;
import com.smart.library.blue.BleImp;
import com.smart.library.blue.BleReceiver;
import com.smart.library.blue.BleService;

import java.util.ArrayList;
import java.util.List;

import in.appstute.smartbuckle.R;

/**
 * Created by appstute on 4/5/17.
 */

public class BluetoothAdapter extends BaseAdapter implements BleImp {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_EMPTY = 2;

    private List<BleDevice> mUnbondDevices = new ArrayList<>();
    private List<BleDevice> mBondedDevices = new ArrayList<>();
    private final Context mContext;

    public BluetoothAdapter(Context context) {
        mContext = context;
    }

    public void clearDevices() {
        mBondedDevices.clear();
        mUnbondDevices.clear();
        notifyDataSetChanged();
    }

    public void updateDevices(List<BleDevice> unbindDevices, List<BleDevice> bindedDevices) {
        this.mUnbondDevices = unbindDevices;
        this.mBondedDevices = bindedDevices;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        final int bondedCount = mBondedDevices.size() + 1;
        final int availableCount = mUnbondDevices.isEmpty() ? 2 : mUnbondDevices.size() + 1;
        if (bondedCount == 1) {
            return availableCount;
        }
        return bondedCount + availableCount;
    }

    @Override
    public Object getItem(int position) {
        final int bondedCount = mBondedDevices.size() + 1; // 1 for the title
        if (mBondedDevices.isEmpty()) {
            if (position == 0) {
                return R.string.scanner_subtitle_not_bonded;
            } else {
                return mUnbondDevices.get(position - 1);
            }
        } else {
            if (position == 0) {
                return R.string.scanner_subtitle_bonded;
            }
            if (position < bondedCount) {
                return mBondedDevices.get(position - 1);
            }
            if (position == bondedCount) {
                return R.string.scanner_subtitle_not_bonded;
            }
            return mUnbondDevices.get(position - bondedCount - 1);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) == TYPE_ITEM;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;
        }
        if (!mBondedDevices.isEmpty() && position == mBondedDevices.size() + 1) {
            return TYPE_TITLE;
        }
        if (position == getCount() - 1 && mUnbondDevices.isEmpty()) {
            return TYPE_EMPTY;
        }
        return TYPE_ITEM;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View oldView, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        final int type = getItemViewType(position);
        View view = oldView;
        switch (type) {
            case TYPE_EMPTY:
                if (view == null) {
                    view = inflater.inflate(R.layout.device_list_empty, parent, false);
                }
                break;
            case TYPE_TITLE:
                if (view == null) {
                    view = inflater.inflate(R.layout.device_list_title, parent, false);
                }
                break;
            default:
                if (view == null) {
                    view = inflater.inflate(R.layout.device_list_row, parent, false);
                    final ViewHolder holder = new ViewHolder();
                    holder.name = (TextView) view.findViewById(R.id.name);
                    holder.imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
                    view.setTag(holder);
                }

                final BleDevice device = (BleDevice) getItem(position);
                final ViewHolder holder = (ViewHolder) view.getTag();
                final String name = device.name;
                final String address = device.device.getAddress();
                if (device.name.contains("105")) {
                    holder.imageViewIcon.setImageResource(R.mipmap.buckle1);
                    holder.name.setText(name != null ? name : "n/a");
                } else {
                 /* if(mBondedDevices.contains(device)){
                      mBondedDevices.remove(device);
                  }else{
                      mUnbondDevices.remove(device);
                  }*/
                }
                break;
        }
        return view;
    }

    @Override
    public void onSuccess(BleCode code, String result) {

    }

    @Override
    public void onFail(String error) {

    }

    private class ViewHolder {
        private ImageView imageViewIcon;
        private TextView name;
    }
}
