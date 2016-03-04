package yashaguo.secondhomework;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate=(Button) findViewById(R.id.go);
        calculate.setOnClickListener(this);

        Button webbtn=(Button) findViewById(R.id.web);
        webbtn.setOnClickListener(this);

        Button dialbtn=(Button) findViewById(R.id.dial);
        dialbtn.setOnClickListener(this);

        Button mapbtn=(Button) findViewById(R.id.map);
        mapbtn.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            //explicit intent check if its click
            case R.id.go:
                Intent i1 = new Intent(this, Tip.class);
                startActivityForResult(i1, 35);
                break;

            //implicit intent, call GoogleMaps
            case R.id.map:
                Uri uri2 = Uri.parse("geo:42.3889167,-71.2208033?z=18");
                //Uri uri2 = Uri.parse("geo:0,0?q=175+forest+street+waltham+ma");
                Intent i2 = new Intent(Intent.ACTION_VIEW,uri2);


                if (i2.resolveActivity(getPackageManager()) != null) {
                    startActivity(i2);
                }

                break;

            //implicit intent, call dialer
            case R.id.dial:
                Uri uri3 = Uri.parse("tel:7818912000.");
                Intent i3 = new Intent(Intent.ACTION_CALL,uri3);

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE},
                            25);
                    startActivity(i3);
                } else {
                    startActivity(i3);
                }

                break;

            case R.id.web:
                Intent i4 = new Intent(this, Browser.class);
                startActivityForResult(i4, 35);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case (35): {

                if (resultCode == Activity.RESULT_OK)
                    Toast.makeText(this, "Result OK for " + requestCode, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, "Result NOT OK for " + requestCode, Toast.LENGTH_LONG).show();
                break;
            }

            case (44): {

                if (resultCode == Activity.RESULT_OK) {
                    Log.e("IntentTest", "Result OK for " + requestCode);
                    Toast.makeText(this, "Result OK for " + requestCode, Toast.LENGTH_LONG).show();
                } else {
                    Log.e("IntentTest", "Result NOT OK for " + requestCode);
                    Toast.makeText(this, "Result NOT OK for " + requestCode, Toast.LENGTH_LONG).show();
                }
                break;
            }



        }}}