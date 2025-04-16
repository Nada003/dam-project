package com.example.guidetouristique2;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guidetouristique2.LocationData.Place;

import java.util.List;

public class FeaturesActivity extends AppCompatActivity {

    private LocationData locationData;
    private Dialog contactDialog;
    private Dialog locationDetailsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        // Initialize location data
        locationData = new LocationData();

        // Initialize dialogs
        initializeDialogs();

        // Set up card click listeners
        setupCardClickListeners();
    }

    private void initializeDialogs() {
        // Initialize contact info dialog
        contactDialog = new Dialog(this);
        contactDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        contactDialog.setContentView(R.layout.dialog_contact_info);
        contactDialog.setCancelable(true);

        ImageButton closeContactButton = contactDialog.findViewById(R.id.btn_close);
        closeContactButton.setOnClickListener(v -> contactDialog.dismiss());

        // Initialize location details dialog
        locationDetailsDialog = new Dialog(this);
        locationDetailsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        locationDetailsDialog.setContentView(R.layout.dialog_location_details);
        locationDetailsDialog.setCancelable(true);

        ImageButton closeLocationButton = locationDetailsDialog.findViewById(R.id.btn_close_location);
        closeLocationButton.setOnClickListener(v -> locationDetailsDialog.dismiss());
    }

    private void setupCardClickListeners() {
        CardView beachesCard = findViewById(R.id.beaches_card);
        beachesCard.setOnClickListener(v -> showLocationDetails("beaches"));

        CardView restaurantsCard = findViewById(R.id.restaurants_card);
        restaurantsCard.setOnClickListener(v -> showLocationDetails("restaurants"));

        CardView hotelsCard = findViewById(R.id.hotels_card);
        hotelsCard.setOnClickListener(v -> showLocationDetails("hotels"));

        CardView leisureCard = findViewById(R.id.leisure_card);
        leisureCard.setOnClickListener(v -> showLocationDetails("leisure"));
    }

    private void showContactInfo(String locationType) {
        List<Place> places = locationData.getPlaces(this, locationType);


        if (places != null && !places.isEmpty()) {
            // On prend le premier comme exemple pour afficher son contact
            Place place = places.get(0);

            TextView dialogTitle = contactDialog.findViewById(R.id.dialog_title);
            TextView dialogDetails = contactDialog.findViewById(R.id.dialog_details);
            TextView contactPhone = contactDialog.findViewById(R.id.contact_phone);
            TextView contactEmail = contactDialog.findViewById(R.id.contact_email);

            dialogTitle.setText(R.string.contact_information);
            dialogDetails.setText(place.getAddress());
            contactPhone.setText(place.getContact());
            contactEmail.setText(place.getEmail());

            contactDialog.show();
        }
    }

    private void showLocationDetails(String locationType) {
        List<Place> places = locationData.getPlaces(this, locationType);

        if (places != null && !places.isEmpty()) {
            TextView dialogTitle = locationDetailsDialog.findViewById(R.id.dialog_location_title);
            RecyclerView placesRecyclerView = locationDetailsDialog.findViewById(R.id.places_recycler_view);

            if (locationType.equals("restaurants") || locationType.equals("gastronomy")) {
                dialogTitle.setText(R.string.discover_restaurants);
            } else if (locationType.equals("hotels")) {
                dialogTitle.setText(R.string.discover_hotels);
            } else if (locationType.equals("leisure")) {
                dialogTitle.setText(R.string.discover_leisure);
            } else {
                dialogTitle.setText(R.string.discover_beaches);
            }

            PlaceAdapter adapter = new PlaceAdapter(this, places, locationType);
            placesRecyclerView.setAdapter(adapter);

            GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
            placesRecyclerView.setLayoutManager(layoutManager);

            locationDetailsDialog.show();
        }
    }
}
