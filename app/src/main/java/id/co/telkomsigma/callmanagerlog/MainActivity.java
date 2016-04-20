package id.co.telkomsigma.callmanagerlog;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ListActivity implements PostProcessing<List<DTOCallLog>>{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void loadCallLog(){
        Looper looper = new Looper(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostProcess(List<DTOCallLog> dtoCallLogs) {
        for (DTOCallLog dtoCallLog : dtoCallLogs){
            Log.i("LOGS ", dtoCallLog.toString());
        }

        this.setListAdapter(new CallLogArrayAdapter(this, dtoCallLogs));
    }
}
