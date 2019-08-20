package appstute.in.smartbuckle.common.webutil;

/**
 * Created by ashishshah on 25/04/17.
 */

interface APICallbacks
{
    <E> void onSuccess(E responseObject);

    <E> void onFailure(int errorCode, String errorMessage, E failureDetails);

}
