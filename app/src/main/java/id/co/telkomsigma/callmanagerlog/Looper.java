package id.co.telkomsigma.callmanagerlog;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 4/15/2016 : 10:07 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class Looper implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final String TAG = "CallLog";

    private Activity activity;

    private List<DTOCallLog> result = new ArrayList<>();
    private PostProcessing<List<DTOCallLog>> postProcessing;

    public Looper(Activity activity, PostProcessing<List<DTOCallLog>> postProcessing) {
        this.activity = activity;
        activity.getLoaderManager().initLoader(ApplicationConstant.URL_LOADER, null, Looper.this);
        this.postProcessing = postProcessing;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.d(TAG, "onCreateLoader() >> loaderID : " + id);
        switch (id) {
            case ApplicationConstant.URL_LOADER:
                return new CursorLoader(
                        activity,
                        CallLog.Calls.CONTENT_URI,
                        null,
                        null,
                        null,
                        null
                );
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d(TAG, "onLoadFinished()");
        DTOCallLog dtoCallLog;
            while (data.moveToNext()) {
                dtoCallLog = new DTOCallLog();
                String phNumber = data.getString(data.getColumnIndex(CallLog.Calls.NUMBER));
                String callType = data.getString(data.getColumnIndex(CallLog.Calls.TYPE));
                String callDate = data.getString(data.getColumnIndex(CallLog.Calls.DATE));
                Date callDayTime = new Date(Long.valueOf(callDate));
                String callDuration = data.getString(data.getColumnIndex(CallLog.Calls.DURATION));
                String cachedFormattedNumber = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_FORMATTED_NUMBER));
                String cachedLookUpURI = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_LOOKUP_URI));
                String cachedMatchedNumber = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_MATCHED_NUMBER));
                String cachedName = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_NAME));
                String normalizedNumber = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_NORMALIZED_NUMBER));
                String cachedNumberLevel = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_NUMBER_LABEL));
                String cachedNumberType = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_NUMBER_TYPE));
                String cachedPhotoId = data.getString(data.getColumnIndex(CallLog.Calls.CACHED_PHOTO_ID));
                String geocodedLocation = data.getString(data.getColumnIndex(CallLog.Calls.GEOCODED_LOCATION));
                String countryIso = data.getString(data.getColumnIndex(CallLog.Calls.COUNTRY_ISO));
                String isRead = data.getString(data.getColumnIndex(CallLog.Calls.IS_READ));
                String isNew = data.getString(data.getColumnIndex(CallLog.Calls.NEW));
                int numberPresentation = Integer.parseInt(data.getString(data.getColumnIndex(CallLog.Calls.NUMBER_PRESENTATION)));
                String presentationOfNumber = null;
                switch (numberPresentation){
                    case CallLog.Calls.PRESENTATION_ALLOWED:
                        presentationOfNumber = "Allowed";
                        break;
                    case CallLog.Calls.PRESENTATION_RESTRICTED:
                        presentationOfNumber = "Restricted";
                        break;
                    case CallLog.Calls.PRESENTATION_UNKNOWN:
                        presentationOfNumber = "UnKnown";
                        break;
                    case CallLog.Calls.PRESENTATION_PAYPHONE:
                        presentationOfNumber = "PayPhone";
                        break;
                }

                String dir = null;

                int callTypeCode = Integer.parseInt(callType);
                switch (callTypeCode) {
                    case CallLog.Calls.OUTGOING_TYPE:
                        dir = "Outgoing";
                        break;

                    case CallLog.Calls.INCOMING_TYPE:
                        dir = "Incoming";
                        break;

                    case CallLog.Calls.MISSED_TYPE:
                        dir = "Missed";
                        break;
                    case CallLog.Calls.VOICEMAIL_TYPE:
                        dir = "Voice Mail";
                        break;
                }
                dtoCallLog.setNumber(phNumber);
                dtoCallLog.setDate(callDate);
                dtoCallLog.setDirection(dir);
                dtoCallLog.setDuration(callDuration);
                dtoCallLog.setType(callType);
                dtoCallLog.setCallDayTime(callDayTime);
                dtoCallLog.setCachedFormattedNumber(cachedFormattedNumber);
                dtoCallLog.setCachedLookUpURI(cachedLookUpURI);
                dtoCallLog.setCachedMatchedNumber(cachedMatchedNumber);
                dtoCallLog.setCachedName(cachedName);
                dtoCallLog.setNormalizedNumber(normalizedNumber);
                dtoCallLog.setCachedNumberLevel(cachedNumberLevel);
                dtoCallLog.setCachedNumberType(cachedNumberType);
                dtoCallLog.setCachedPhotoId(cachedPhotoId);
                dtoCallLog.setGeocodedLocation(geocodedLocation);
                dtoCallLog.setCountryIso(countryIso);
                dtoCallLog.setIsRead(isRead);
                dtoCallLog.setIsNew(isNew);
                dtoCallLog.setPresentationOfNumber(presentationOfNumber);

                result.add(dtoCallLog);
            }
        data.close();
        postProcessing.onPostProcess(result);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d(TAG, "onLoaderReset()");
        // do nothing
    }
}
