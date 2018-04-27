package unam.fi.mx.mylogin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class CallActivity extends AppCompatActivity {

    String[] tels;
    ListView lstNumbers;
    Toolbar myToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        tels = getResources().getStringArray(R.array.tels);
        myToolBar = (Toolbar) findViewById(R.id.toolBarCall);
        lstNumbers = (ListView) findViewById(R.id.list_tels);
        Bundle parametros = this.getIntent().getExtras();
        lstNumbers.setOnClickListener((View.OnClickListener) ItemListener());


        ArrayAdapter<String> AdapterTels = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, tels);
        lstNumbers.setAdapter(AdapterTels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    protected AdapterView.OnItemClickListener ItemListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), tels[position].toString(), Toast.LENGTH_SHORT).show();
                Intent intentLlamar = new Intent(Intent.ACTION_CALL);

                intentLlamar.setData(Uri.parse(tels[position].toString()));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intentLlamar);
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAcercaDe:
                Intent intentAcerca = new Intent(getApplicationContext(), AcercaDe.class);
                startActivity(intentAcerca);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
