package software.gaurav.com.paysmart.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import software.gaurav.com.paysmart.R;
import software.gaurav.com.paysmart.barCode.IntentIntegrator;
import software.gaurav.com.paysmart.barCode.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.initiateScan();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == IntentIntegrator.REQUEST_CODE){
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
            if (scanResult != null)
            {
                // handle scan result
                Toast.makeText(this, scanResult.toString(), Toast.LENGTH_LONG).show();
            }
            else
            {
                // else continue with any other code you need in the method
                Toast.makeText(this, "Null", Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
