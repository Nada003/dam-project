package com.example.guidetouristique2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.placeImage.setImageResource(place.getImageResId() != 0 ? place.getImageResId() : R.drawable.placeholder_image);
        holder.placeName.setText(place.getName());
        holder.placeDescription.setText(place.getDescription());

        if (place.hasRating()) {
            holder.ratingContainer.setVisibility(View.VISIBLE);
            holder.placeRating.setText(String.valueOf(place.getRating()));
        } else {
            holder.ratingContainer.setVisibility(View.GONE);
        }

        if (locationType.equals("restaurants")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.specialty));
        } else if (locationType.equals("hotels")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.amenities));
        } else if (locationType.equals("leisure")) {
            holder.placeSpecialtyLabel.setText(context.getString(R.string.activities));
        }
        holder.placeSpecialty.setText(place.getSpeciality());

        holder.placeAddress.setText(place.getAddress());
        holder.placeAddress.setVisibility(place.getAddress().isEmpty() ? View.GONE : View.VISIBLE);

        holder.placePhone.setText(place.getContact());
        holder.placePhone.setVisibility(place.getContact().isEmpty() ? View.GONE : View.VISIBLE);

        holder.placeEmail.setText(place.getEmail());
        holder.placeEmail.setVisibility(place.getEmail().isEmpty() ? View.GONE : View.VISIBLE);

        //  Clic sur le numéro pour ouvrir le composeur
        holder.placePhone.setOnClickListener(v -> {
            String phoneNumber = place.getContact();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            context.startActivity(intent);
        });

        // Clic sur l'email pour ouvrir Gmail
        holder.placeEmail.setOnClickListener(v -> {
            String email = place.getEmail();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + email));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact via Guide Touristique");
            context.startActivity(intent);
        });
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
