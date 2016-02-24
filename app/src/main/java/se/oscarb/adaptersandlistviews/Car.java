package se.oscarb.adaptersandlistviews;

import java.util.Arrays;

/**
 * Created by jk on 23/02/16.
 */
public class Car {

    public int imageId;
    public String name;

    public Car(){

    }

    public Car(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }
}
