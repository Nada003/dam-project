package com.example.guidetouristique2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class LocationData {

    public List<Place> getPlaces(Context context, String locationType) {
        List<Place> places = new ArrayList<>();

        switch (locationType) {
            case "beaches":
                places.add(new Place(
                        context.getString(R.string.beach1_name),
                        context.getString(R.string.beach1_description),
                        R.drawable.plage_corso,
                        3.6,
                        true,
                        context.getString(R.string.beach1_speciality),
                        context.getString(R.string.beach1_address),
                        "+213 20 79 58 12",
                        "plagecorso@email.com"
                ));
                places.add(new Place(
                        context.getString(R.string.beach2_name),
                        context.getString(R.string.beach2_description),
                        R.drawable.plage_grandbleu,
                        4.7,
                        true,
                        context.getString(R.string.beach2_speciality),
                        context.getString(R.string.beach2_address),
                        "+213 797 78 89 82",
                        "complexgrandbleu@email.com"
                ));
                break;

            case "restaurants":
                places.add(new Place(
                        context.getString(R.string.restaurant1_name),
                        context.getString(R.string.restaurant1_description),
                        R.drawable.restaurant_woodpecker,
                        4.8,
                        true,
                        context.getString(R.string.restaurant1_speciality),
                        context.getString(R.string.restaurant1_address),
                        "+213 24 75 02 36",
                        "restaurantWoodPecker@email.com"
                ));
                places.add(new Place(
                        context.getString(R.string.restaurant2_name),
                        context.getString(R.string.restaurant2_description),
                        R.drawable.restaurant_lkanoun,
                        5.0,
                        true,
                        context.getString(R.string.restaurant2_speciality),
                        context.getString(R.string.restaurant2_address),
                        "+0558 54 57 58",
                        "contact@restoalgerie.com"
                ));
                break;

            case "hotels":
                places.add(new Place(
                        context.getString(R.string.hotel1_name),
                        context.getString(R.string.hotel1_description),
                        R.drawable.hotel_plaza,
                        4.9,
                        true,
                        context.getString(R.string.hotel1_speciality),
                        context.getString(R.string.hotel1_address),
                        "+0660 20 65 53",
                        "reservation@hotelboumerdesplaza.com"
                ));
                places.add(new Place(
                        context.getString(R.string.hotel2_name),
                        context.getString(R.string.hotel2_description),
                        R.drawable.hotel_albatros,
                        4.0,
                        true,
                        context.getString(R.string.hotel2_speciality),
                        context.getString(R.string.hotel2_address),
                        "+213 24 94 10 64",
                        "hotelAlbatrosBeach@email.com"
                ));
                break;

            case "leisure":
                places.add(new Place(
                        context.getString(R.string.leisure1_name),
                        context.getString(R.string.leisure1_description),
                        R.drawable.centre_equestre,
                        4.3,
                        true,
                        context.getString(R.string.leisure1_speciality),
                        context.getString(R.string.leisure1_address),
                        "+213 797 78 89 82",
                        "complexgrandbleu@email.com"
                ));
                places.add(new Place(
                        context.getString(R.string.leisure2_name),
                        context.getString(R.string.leisure2_description),
                        R.drawable.foret_de_corso,
                        4.2,
                        true,
                        context.getString(R.string.leisure2_speciality),
                        context.getString(R.string.leisure2_address),
                        "+334455667",
                        "leisure2@email.com"
                ));
                break;

            default:
                return new ArrayList<>();
        }

        return places;
    }

    public static class Place {
        private String name;
        private String description;
        private int imageResId;
        private double rating;
        private boolean hasRating;
        private String speciality;
        private String address;
        private String contact;
        private String email;

        public Place(String name, String description, int imageResId, double rating, boolean hasRating,
                     String speciality, String address, String contact, String email) {
            this.name = name;
            this.description = description;
            this.imageResId = imageResId;
            this.rating = rating;
            this.hasRating = hasRating;
            this.speciality = speciality;
            this.address = address;
            this.contact = contact;
            this.email = email;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public int getImageResId() { return imageResId; }
        public double getRating() { return rating; }
        public boolean hasRating() { return hasRating; }
        public String getSpeciality() { return speciality; }
        public String getAddress() { return address; }
        public String getContact() { return contact; }
        public String getEmail() { return email; }
    }
}
