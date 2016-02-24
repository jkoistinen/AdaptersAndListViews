package se.oscarb.adaptersandlistviews;

import java.util.ArrayList;

/**
 * Created by jk on 23/02/16.
 */
public class Garage {

    ArrayList<Car> cars = new ArrayList();

    public Garage(){

        // Lägg till i cars...
        cars.add(new Car("Toyota", R.drawable.toyota));
        cars.add(new Car("Volvo", R.drawable.volvo));
        cars.add(new Car("Mercedes", R.drawable.mb));
        cars.add(new Car("Lada", R.drawable.lada));
        cars.add(new Car("Toyota", R.drawable.toyota));
        cars.add(new Car("Volvo", R.drawable.volvo));
        cars.add(new Car("Mercedes", R.drawable.mb));
        cars.add(new Car("Lada", R.drawable.lada));

    }

    public ArrayList<Car> getCars(){
        return cars;
    }


}
