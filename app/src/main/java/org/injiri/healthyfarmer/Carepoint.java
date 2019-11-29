package org.injiri.healthyfarmer;

import java.util.Arrays;

public class Carepoint {
    private String name;
    private String openingHours;
    private String contact;
    private  double geometry[];

    public Carepoint() {
    }

    public Carepoint(String name, String openingHours, String contact, double[] geometry) {
        this.name = name;
        this.openingHours = openingHours;
        this.contact = contact;
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double[] getGeometry() {
        return geometry;
    }

    public void setGeometry(double[] geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Carepoint{" +
                "name='" + name + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", contact='" + contact + '\'' +
                ", geometry=" + Arrays.toString(geometry) +
                '}';
    }
}
