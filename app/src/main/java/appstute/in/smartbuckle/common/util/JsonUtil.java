package appstute.in.smartbuckle.common.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static String getString(JSONObject jsonObject, String key)
            throws JSONException {
        if (jsonObject.isNull(key)||jsonObject.getString(key).equalsIgnoreCase("null")) {
            logError(key);
            return "";
        } else
            return jsonObject.getString(key);
    }

    public static JSONArray getJsonArray(JSONObject jsonObject, String key)
            throws JSONException {
        if (jsonObject.isNull(key)) {
            logError(key);
            return new JSONArray();
        } else
            return jsonObject.getJSONArray(key);
    }

    public static String getString(JSONArray jsonArray, int position)
            throws JSONException {
        if (jsonArray.isNull(position)) {
            logError("" + position);
            return "";
        } else
            return jsonArray.getString(position);
    }

    public static JSONObject getJsonObject(JSONObject jsonObject, String key) throws JSONException {
        if (jsonObject.isNull(key)) {
            logError("" + key);
            return new JSONObject();
        } else
            return jsonObject.getJSONObject(key);
    }

    public static JSONObject getJsonObject(JSONArray jsonArray, int position)
            throws JSONException {
        if (jsonArray.isNull(position)) {
            logError("" + position);
            return new JSONObject();
        } else
            return jsonArray.getJSONObject(position);
    }

    public static int getInt(JSONObject jsonObject, String key)
            throws JSONException {
        if (!jsonObject.has(key)) {
            logError(key);
            return -1;
        } else
            return jsonObject.getInt(key);
    }

    public static int getInt(JSONArray jsonArray, int position)
            throws JSONException {
        if (jsonArray.isNull(position)) {
            logError(position);
            return -1;
        } else
            return jsonArray.getInt(position);
    }

    public static boolean getBoolean(JSONObject jsonObject, String key) throws JSONException {
        if (jsonObject.isNull(key)) {
            logError(key);
            return false;
        } else
            return jsonObject.getBoolean(key);
    }

    public static double getDouble(JSONObject jsonObject, String key) throws JSONException {
        if (jsonObject.isNull(key)) {
            logError(key);
            return 0;
        }
        return jsonObject.getDouble(key);
    }

    public static double getDouble(JSONArray jsonArray, int position) throws JSONException {
        if (jsonArray.isNull(position)) {
            logError(position);
            return 0;
        }
        return jsonArray.getDouble(position);
    }

    public static long getLong(JSONObject jsonObject, String key) throws JSONException {
        if (jsonObject.isNull(key)) {
            logError(key);
            return 0;
        }
        return jsonObject.getLong(key);
    }
    public static void logError(String key) {
        Log.e("JSONParsing", "Null value for " + key);
    }

    public static void logError(int position) {
        Log.e("JSONParsing", "Null value at " + position + " position.");
    }



}
