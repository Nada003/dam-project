package com.example.guidetouristique2;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guidetouristique2.LocationData.ContactInfo;
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

        // Set up close button for contact dialog
        ImageButton closeContactButton = contactDialog.findViewById(R.id.btn_close);
        closeContactButton.setOnClickListener(v -> contactDialog.dismiss());

        // Initialize location details dialog
        locationDetailsDialog = new Dialog(this);
        locationDetailsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        locationDetailsDialog.setContentView(R.layout.dialog_location_details);
        locationDetailsDialog.setCancelable(true);

        // Set up close button for location details dialog
        ImageButton closeLocationButton = locationDetailsDialog.findViewById(R.id.btn_close_location);
        closeLocationButton.setOnClickListener(v -> locationDetailsDialog.dismiss());
    }

    private void setupCardClickListeners() {
        // Beaches card
        CardView beachesCard = findViewById(R.id.beaches_card);
        beachesCard.setOnClickListener(v -> showLocationDetails("beaches"));

        // Restaurants card
        CardView restaurantsCard = findViewById(R.id.restaurants_card);
        restaurantsCard.setOnClickListener(v -> showLocationDetails("restaurants"));

        // Hotels card
        CardView hotelsCard = findViewById(R.id.hotels_card);
        hotelsCard.setOnClickListener(v -> showLocationDetails("hotels"));

        // Leisure card
        CardView leisureCard = findViewById(R.id.leisure_card);
        leisureCard.setOnClickListener(v -> showLocationDetails("leisure"));
    }

    private void showContactInfo(String locationType) {
        ContactInfo contactInfo = locationData.getContactInfo(locationType);

        if (contactInfo != null) {
            TextView dialogTitle = contactDialog.findViewById(R.id.dialog_title);
            TextView dialogDetails = contactDialog.findViewById(R.id.dialog_details);
            TextView contactPhone = contactDialog.findViewById(R.id.contact_phone);
            TextView contactEmail = contactDialog.findViewById(R.id.contact_email);

            dialogTitle.setText(R.string.contact_information);
            dialogDetails.setText(contactInfo.getDetails());
            contactPhone.setText(contactInfo.getPhone());
            contactEmail.setText(contactInfo.getEmail());

            contactDialog.show();
        }
    }

    private void showLocationDetails(String locationType) {
        // Get places for the selected location type
        List<Place> places = locationData.getPlaces(locationType);

        if (places != null && !places.isEmpty()) {
            TextView dialogTitle = locationDetailsDialog.findViewById(R.id.dialog_location_title);
            RecyclerView placesRecyclerView = locationDetailsDialog.findViewById(R.id.places_recycler_view);

            // Set dialog title based on location type
            if (locationType.equals("restaurants") || locationType.equals("gastronomy")) {
                dialogTitle.setText(R.string.discover_restaurants);
            } else if (locationType.equals("hotels")) {
                dialogTitle.setText(R.string.discover_hotels);
            } else if (locationType.equals("leisure")) {
                dialogTitle.setText(R.string.discover_leisure);
            } else {
                dialogTitle.setText(R.string.discover_beaches);
            }

            // Set up places adapter
            PlaceAdapter adapter = new PlaceAdapter(this, places, locationType);
            placesRecyclerView.setAdapter(adapter);

            // Set layout manager
            GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
            placesRecyclerView.setLayoutManager(layoutManager);

            locationDetailsDialog.show();
        }
    }
}