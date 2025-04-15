package com.example.guidetouristique2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guidetouristique2.LocationData;
import com.example.guidetouristique2.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private List<LocationData.Place> places;
    private Context context;
    private String locationType;

    public PlaceAdapter(Context context, List<LocationData.Place> places, String locationType) {
        this.context = context;
        this.places = places;
        this.locationType = locationType;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_place_card, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        LocationData.Place place = places.get(position);

        // Set image using setImageResource for local images
        holder.placeImage.setImageResource(R.drawable.placeholder_image); // or use setImageURI for URI-based images

        // Set place name
        holder.placeName.setText(place.getName());

        // Set place description
        holder.placeDescription.setText(place.getDescription());

        // Handle rating
        if (place.hasRating()) {
            holder.ratingContainer.setVisibility(View.VISIBLE);
            holder.placeRating.setText(String.valueOf(place.getRating()));
        } else {
            holder.ratingContainer.setVisibility(View.GONE);
        }

        // Set specialty or amenities label based on location type
        if (locationType.equals("restaurants")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.specialty));
            holder.placeSpecialty.setText(place.getSpeciality());
        } else if (locationType.equals("hotels")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.amenities));
            holder.placeSpecialty.setText(place.getSpeciality());
        } else if (locationType.equals("leisure")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.activities));
            holder.placeSpecialty.setText(place.getSpeciality());
        }

        // Set address if available
        if (place.getAddress() != null && !place.getAddress().isEmpty()) {
            holder.placeAddress.setText(place.getAddress());
            holder.placeAddress.setVisibility(View.VISIBLE);
        } else {
            holder.placeAddress.setVisibility(View.GONE);
        }

        // Set contact information
        if (place.getContact() != null && !place.getContact().isEmpty()) {
            holder.placePhone.setText(place.getContact());
            holder.placePhone.setVisibility(View.VISIBLE);
        } else {
            holder.placePhone.setVisibility(View.GONE);
        }

        if (place.getEmail() != null && !place.getEmail().isEmpty()) {
            holder.placeEmail.setText(place.getEmail());
            holder.placeEmail.setVisibility(View.VISIBLE);
        } else {
            holder.placeEmail.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return places != null ? places.size() : 0;
    }

    public void updateData(List<LocationData.Place> newPlaces) {
        this.places = newPlaces;
        notifyDataSetChanged();
    }

    static class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImage;
        TextView placeName;
        TextView placeDescription;
        TextView placeRating;
        TextView placeSpecialtyLabel;
        TextView placeSpecialty;
        TextView placeAddress;
        TextView placePhone;
        TextView placeEmail;
        LinearLayout ratingContainer;

        PlaceViewHolder(View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            placeDescription = itemView.findViewById(R.id.place_description);
            placeRating = itemView.findViewById(R.id.place_rating);
            placeSpecialtyLabel = itemView.findViewById(R.id.place_specialty_label);
            placeSpecialty = itemView.findViewById(R.id.place_specialty);
            placeAddress = itemView.findViewById(R.id.place_address);
            placePhone = itemView.findViewById(R.id.place_phone);
            placeEmail = itemView.findViewById(R.id.place_email);
            ratingContainer = itemView.findViewById(R.id.rating_container);
        }
    }
}
