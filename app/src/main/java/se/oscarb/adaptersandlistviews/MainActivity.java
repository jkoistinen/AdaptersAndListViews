package se.oscarb.adaptersandlistviews;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hämta vår ListView
        ListView myListView = (ListView) findViewById(R.id.my_list_view);

        //Create Garage
        Garage myGarage = new Garage();

        CarArrayAdapter myCarArrayAdapter = new CarArrayAdapter(this, R.layout.complex_item_layout, myGarage.getCars());

        // Använd vår adapter
        myListView.setAdapter(myCarArrayAdapter);

    }
}
