package se.oscarb.adaptersandlistviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jk on 17/02/16.
 */
public class CarArrayAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Car> carsToPrint;

    public CarArrayAdapter(Context context, int resource, ArrayList Car) {
        super(context, resource, Car);

        this.context = context;
        carsToPrint = Car;
    }

    //Used for optimisation of findVieById.
    static class ViewHolder {
        ImageView icon;
        TextView topText;
        TextView bottomText;
    }

    // Vi override metoden getView for att kunna anvnda vår komplexa layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Skapa den View som visas för varje item i en ListView
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View itemView;


        //This below is optimization, only call the expensive layoutinflater if the conertView is not set (null).
        if (convertView == null){

            itemView  = layoutInflater.inflate(R.layout.complex_item_layout, parent, false);
            Log.i("TEST:::", "convertView is null");

        }else{

            itemView = convertView;
            Log.i("TEST:::", "convertView is NOT null");
        }

        //ViewHolder is used to optimise lookups against findViewById
        ViewHolder holder = new ViewHolder();
        holder.icon = (ImageView) itemView.findViewById(R.id.left_icon);
        holder.topText = (TextView) itemView.findViewById(R.id.toptext);
        holder.bottomText = (TextView) itemView.findViewById(R.id.bottomtext);

        holder.icon.setImageBitmap(decodeSampledBitmapFromResource(getContext().getResources(), carsToPrint.get(position).getImageId(), 100, 100));
        holder.topText.setText(carsToPrint.get(position).toString());
        holder.bottomText.setText("Position" + position);

        itemView.setTag(holder);

        return itemView;
    }

    private int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    private Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
