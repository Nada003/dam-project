package com.example.guidetouristique2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder> {

    private final List<Feature> features;
    private final LayoutInflater inflater;
    private final OnFeatureClickListener listener;

    public interface OnFeatureClickListener {
        void onInfoButtonClick(String featureType);
        void onFeatureImageClick(String featureType);
    }

    public FeatureAdapter(Context context, List<Feature> features, OnFeatureClickListener listener) {
        this.features = features;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public FeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_feature_card, parent, false);
        return new FeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureViewHolder holder, int position) {
        Feature feature = features.get(position);

        holder.featureImage.setImageResource(feature.getImageResId() != 0 ? feature.getImageResId() : R.drawable.placeholder_image);
        holder.featureTitle.setText(feature.getTitle());
        holder.featureDescription.setText(feature.getDescription());

        final String featureType = feature.getType();

        holder.featureButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onInfoButtonClick(featureType);
            }
        });

        holder.featureImage.setOnClickListener(v -> {
            if (listener != null) {
                listener.onFeatureImageClick(featureType);
            }
        });
    }

    @Override
    public int getItemCount() {
        return features != null ? features.size() : 0;
    }

    static class FeatureViewHolder extends RecyclerView.ViewHolder {
        ImageView featureImage;
        TextView featureTitle;
        TextView featureDescription;
        Button featureButton;

        FeatureViewHolder(View itemView) {
            super(itemView);
            featureImage = itemView.findViewById(R.id.feature_image);
            featureTitle = itemView.findViewById(R.id.feature_title);
            featureDescription = itemView.findViewById(R.id.feature_description);
            featureButton = itemView.findViewById(R.id.feature_button);
        }
    }

    public static class Feature {
        private final String title;
        private final String description;
        private final int imageResId;
        private final String type;

        public Feature(String title, String description, int imageResId, String type) {
            this.title = title;
            this.description = description;
            this.imageResId = imageResId;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getType() {
            return type;
        }
    }
}
