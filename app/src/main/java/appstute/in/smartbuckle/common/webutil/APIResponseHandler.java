package appstute.in.smartbuckle.common.webutil;

import org.json.JSONObject;

/**
 * Created by ashishshah on 25/04/17.
 */

public interface APIResponseHandler
{
    void onSuccess(JSONObject responseJsonObject);
    void onFailure(int errorCode, String errorMessage);
}
