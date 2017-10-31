package id.co.telkomsigma.callmanagerlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created on 4/15/2016 : 11:21 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CallLogArrayAdapter extends ArrayAdapter<DTOCallLog> {

    private Context context;
    private List<DTOCallLog> values;


    public CallLogArrayAdapter(Context context, List<DTOCallLog> objects) {
        super(context, R.layout.list_call, objects);
        this.context = context;
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_call, parent, false);

        TextView txtNumber = (TextView) rowView.findViewById(R.id.txtNumber);
        txtNumber.setText("Phone Number : "+values.get(position).getNumber());

        TextView txtDate = (TextView) rowView.findViewById(R.id.txtDate);
        txtDate.setText("Date : "+values.get(position).getDate());

        TextView txtDirection = (TextView) rowView.findViewById(R.id.txtDirection);
        txtDirection.setText("Direction : "+values.get(position).getDirection());

        TextView txtDuration = (TextView) rowView.findViewById(R.id.txtDuration);
        txtDuration.setText("Duration : "+values.get(position).getDuration());

        TextView txtType = (TextView) rowView.findViewById(R.id.txtType);
        txtType.setText("Type : "+values.get(position).getType());

        TextView txtCallDayTime = (TextView) rowView.findViewById(R.id.txtCallDayTime);
        txtCallDayTime.setText("Call Day Time : "+values.get(position).getCallDayTime());

        TextView txtCachedFormattedNumber = (TextView) rowView.findViewById(R.id.txtCachedFormattedNumber);
        txtCachedFormattedNumber.setText("Cached Formatted Number : "+values.get(position).getCachedFormattedNumber());

        TextView txtCachedLookupUri = (TextView) rowView.findViewById(R.id.txtCachedLookUpURI);
        txtCachedLookupUri.setText("Cached Lookup URI : "+values.get(position).getCachedLookUpURI());

        TextView txtCachedMatchedNumber = (TextView) rowView.findViewById(R.id.txtCachedMatchedNumber);
        txtCachedMatchedNumber.setText("Cached Matched Number : "+values.get(position).getCachedMatchedNumber());

        TextView txtCachedName = (TextView) rowView.findViewById(R.id.txtCachedName);
        txtCachedName.setText("Cached Name : "+values.get(position).getCachedName());

        TextView txtNormalizedNumber = (TextView) rowView.findViewById(R.id.txtNormalizedNumber);
        txtNormalizedNumber.setText("Normalized Number : "+values.get(position).getNormalizedNumber());

        TextView txtCachedNumberLevel = (TextView) rowView.findViewById(R.id.txtCachedNumberLevel);
        txtCachedNumberLevel.setText("Cached Number Level : "+values.get(position).getCachedNumberLevel());

        TextView txtCachedNumberType = (TextView) rowView.findViewById(R.id.txtCachedNumberType);
        txtCachedNumberType.setText("Cached Number Type : "+values.get(position).getCachedNumberType());

        TextView txtCachedPhotoId = (TextView) rowView.findViewById(R.id.txtCachedPhotoId);
        txtCachedPhotoId.setText("Cached Photo Id : "+values.get(position).getCachedPhotoId());

        TextView txtGeoCodedLocation = (TextView) rowView.findViewById(R.id.txtGeocodedLocation);
        txtGeoCodedLocation.setText("GeoCoded Location : "+values.get(position).getGeocodedLocation());

        TextView txtCountryISO = (TextView) rowView.findViewById(R.id.txtCountryIso);
        txtCountryISO.setText("Country ISO : "+values.get(position).getCountryIso());

        TextView txtIsRead = (TextView) rowView.findViewById(R.id.txtIsRead);
        txtIsRead.setText("Is Read : "+values.get(position).getIsRead());

        TextView txtIsNew = (TextView) rowView.findViewById(R.id.txtIsNew);
        txtIsNew.setText("Is New : "+values.get(position).getIsNew());

        TextView txtPresentationOfNumber = (TextView) rowView.findViewById(R.id.txtPresentationOfNumber);
        txtPresentationOfNumber.setText("Presentation of Number : "+values.get(position).getPresentationOfNumber());

        return rowView;
    }
}
