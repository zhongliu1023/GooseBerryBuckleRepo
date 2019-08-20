package appstute.in.smartbuckle.common.webutil;

import android.content.Context;
import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import appstute.in.smartbuckle.common.util.JsonKeys;
import appstute.in.smartbuckle.common.util.JsonUtil;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

import in.appstute.smartbuckle.R;



public class HttpClient {
    public static final AsyncHttpClient httpClient;
    public static final int CONNECTION_TIMEOUT = 600000;
    public static final String CONTENT_TYPE_JSON = "application/json";

    static {
        httpClient = new AsyncHttpClient(true, 80, 443);
        httpClient.setTimeout(CONNECTION_TIMEOUT);
        try {
            if (!TextUtils.isEmpty(System.getProperty("http.proxyHost")) && !TextUtils.isEmpty(System.getProperty("http.proxyPort"))) {
                httpClient.setProxy(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
            }
        } catch (Exception e) {

        }
    }


    public static void post(final Context context, String url, HttpEntity httpEntity,
                            final APIResponseHandler responseHandler) {

        httpClient.post(context, url, httpEntity, CONTENT_TYPE_JSON, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject responseJsonObject = new JSONObject(new String(responseBody));
                    String errorMessageCode = JsonUtil.getString(responseJsonObject, JsonKeys.ERROR_CODE);
                    if (TextUtils.isEmpty(errorMessageCode))
                        responseHandler.onSuccess(responseJsonObject);
                    else
                        responseHandler.onFailure(statusCode, errorMessageCode);
                } catch (JSONException e) {
                    responseHandler.onFailure(statusCode, context.getResources().getString(R.string.error_in_json));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseHandler.onFailure(statusCode, "");
            }
        });
    }

    public static void post(final Context context, String url, RequestParams requestParams,
                            final APIResponseHandler responseHandler) {

        httpClient.post(context, url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject responseJsonObject = new JSONObject(new String(responseBody));
                    String errorMessage = JsonUtil.getString(responseJsonObject, JsonKeys.ERROR_CODE);
                    if (TextUtils.isEmpty(errorMessage))
                        responseHandler.onSuccess(responseJsonObject);
                    else
                        responseHandler.onFailure(statusCode, errorMessage);
                } catch (JSONException e) {
                    responseHandler.onFailure(statusCode, context.getResources().getString(R.string.error_in_json));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseHandler.onFailure(statusCode, "");
            }
        });
    }


    public static void post(final Context context, String url, HttpEntity httpEntity,
                            final APIResponseHandler responseHandler, String headers) {

        httpClient.addHeader("Content-Type", CONTENT_TYPE_JSON);
        httpClient.post(context, url, httpEntity, CONTENT_TYPE_JSON, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject responseJsonObject = new JSONObject(new String(responseBody));
                    responseHandler.onSuccess(responseJsonObject);
                } catch (JSONException e) {
                    responseHandler.onFailure(statusCode, context.getResources().getString(R.string.error_in_json));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseHandler.onFailure(statusCode, "");
            }
        });
    }


    public static void get(final Context context, String url, HttpEntity httpEntity,
                           final APIResponseHandler responseHandler) {

        httpClient.get(context, url, httpEntity, CONTENT_TYPE_JSON, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject responseJsonObject = new JSONObject(new String(responseBody));
                    String errorMessage = JsonUtil.getString(responseJsonObject, JsonKeys.ERROR_CODE);
                    if (TextUtils.isEmpty(errorMessage))
                        responseHandler.onSuccess(responseJsonObject);
                    else
                        responseHandler.onFailure(statusCode, errorMessage);
                } catch (JSONException e) {
                    responseHandler.onFailure(statusCode, context.getResources().getString(R.string.error_in_json));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseHandler.onFailure(statusCode, "");
            }
        });
    }

   /* public static void get(final Context context, String url, HttpClient httpClient, final APIResponseHandler apiResponseHandler) {
        httpClient.get(context, url, httpClient, new APIResponseHandler() {
            @Override
            public void onSuccess(JSONObject responseJsonObject) {
                try {
               *//* JSONObject responseJsonObject = new JSONObject(new String(responseJsonObject));*//*
                    String errorMessage = JsonUtil.getString(responseJsonObject, JsonKeys.ERROR_CODE);
                    if (TextUtils.isEmpty(errorMessage))
                        apiResponseHandler.onSuccess(responseJsonObject);
                    else
                        apiResponseHandler.onFailure(200, errorMessage);
                } catch (JSONException e) {
                    apiResponseHandler.onFailure(200, context.getResources().getString(R.string.error_in_json));
                }
            }

            @Override
            public void onFailure(int errorCode, String errorMessageCode) {
                apiResponseHandler.onFailure(200, context.getResources().getString(R.string.error_in_json));
            }
        });
    }*/

}
