package se.oscarb.adaptersandlistviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk on 17/02/16.
 */
public class MyCustomAdapter extends ArrayAdapter {

    Context context;
    ArrayList<String> thingsToPrint;

    public MyCustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.context = context;
        thingsToPrint = (ArrayList) objects;

    }

    // Vi override metoden getView for att kunna anvnda vår komplexa layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Skapa den View som visas för varje item i en ListView
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View itemView  = layoutInflater.inflate(R.layout.complex_item_layout, parent, false);

        //Hämta det som finns inuti vår itemView
        ImageView icon = (ImageView) itemView.findViewById(R.id.left_icon);
        TextView topText = (TextView) itemView.findViewById(R.id.toptext);
        TextView bottomText = (TextView) itemView.findViewById(R.id.bottomtext);

        // Sätt värden

        topText.setText(thingsToPrint.get(position));
        bottomText.setText("Position" + position);

        return itemView;
    }
}
