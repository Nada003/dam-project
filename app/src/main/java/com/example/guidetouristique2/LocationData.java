package com.example.guidetouristique2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationData {

    // Main data structure to hold all location information
    private Map<String, Object> locations;

    public LocationData() {
        initializeData();
    }

    private void initializeData() {
        locations = new HashMap<>();

        // Initialize Leisure activities
        Map<String, Object> leisure = new HashMap<>();
        leisure.put("phone", "+213 24 81 59 59");
        leisure.put("email", "loisirs.boumerdes@tourism.dz");
        leisure.put("details", "Découvrez les nombreuses activités de loisirs disponibles à Boumerdes");

        List<Place> leisurePlaces = new ArrayList<>();
        leisurePlaces.add(new Place(
                "Parc d'attractions Boumerdes",
                "Un parc d'attractions familial avec manèges et jeux pour tous les âges",
                "https://images.pexels.com/photos/784916/pexels-photo-784916.jpeg",
                4.3f,
                "Manèges, jeux, restauration",
                "+213 24 81 59 60",
                "parc@loisirs-boumerdes.dz",
                "Centre-ville, Boumerdes"
        ));

        leisurePlaces.add(new Place(
                "Centre nautique",
                "Centre proposant des activités nautiques comme le jet-ski, la planche à voile et la plongée",
                "https://images.pexels.com/photos/1430672/pexels-photo-1430672.jpeg",
                4.5f,
                "Jet-ski, planche à voile, plongée",
                "+213 24 81 59 61",
                "nautique@loisirs-boumerdes.dz",
                "Plage Corso, Boumerdes"
        ));

        leisurePlaces.add(new Place(
                "Randonnées Mont Bouzegza",
                "Excursions guidées dans les montagnes avec vues panoramiques",
                "https://images.pexels.com/photos/554609/pexels-photo-554609.jpeg",
                4.7f,
                "Randonnées, pique-niques, observation de la faune",
                "+213 24 81 59 62",
                "randonnees@loisirs-boumerdes.dz",
                "Mont Bouzegza, Boumerdes"
        ));

        leisure.put("places", leisurePlaces);
        locations.put("leisure", leisure);

        // Initialize Restaurants
        List<Place> restaurants = new ArrayList<>();
        restaurants.add(new Place(
                "Le Rivage",
                "Restaurant de fruits de mer avec vue panoramique sur la mer",
                "https://images.pexels.com/photos/67468/pexels-photo-67468.jpeg",
                4.5f,
                "Fruits de mer",
                "+213 24 81 57 60",
                "lerivage@resto-boumerdes.dz",
                "Corniche de Boumerdes"
        ));

        restaurants.add(new Place(
                "L'Olivier",
                "Cuisine traditionnelle algérienne dans un cadre élégant",
                "https://images.pexels.com/photos/262978/pexels-photo-262978.jpeg",
                4.8f,
                "Cuisine traditionnelle",
                "+213 24 81 57 61",
                "olivier@resto-boumerdes.dz",
                "Centre-ville"
        ));

        restaurants.add(new Place(
                "Marina Lounge",
                "Restaurant moderne avec terrasse vue mer",
                "https://images.pexels.com/photos/260922/pexels-photo-260922.jpeg",
                4.3f,
                "Cuisine internationale",
                "+213 24 81 57 62",
                "marina@resto-boumerdes.dz",
                "Port de Boumerdes"
        ));

        locations.put("restaurants", restaurants);

        // Initialize Beaches
        Map<String, Object> beaches = new HashMap<>();
        beaches.put("phone", "+213 24 81 56 56");
        beaches.put("email", "plages.boumerdes@tourism.dz");
        beaches.put("details", "Plus de 100 km de côtes, avec des plages surveillées et aménagées");

        List<Place> beachPlaces = new ArrayList<>();
        beachPlaces.add(new Place(
                "Plage Boumerdes Centre",
                "Une plage familiale avec tous les équipements nécessaires",
                "https://images.pexels.com/photos/1705254/pexels-photo-1705254.jpeg",
                0,
                "",
                "+213 24 81 56 57",
                "",
                ""
        ));

        beachPlaces.add(new Place(
                "Plage Corso",
                "Magnifique plage de sable fin avec des activités nautiques",
                "https://images.pexels.com/photos/1032650/pexels-photo-1032650.jpeg",
                0,
                "",
                "+213 24 81 56 58",
                "corso.plage@tourism.dz",
                ""
        ));

        beachPlaces.add(new Place(
                "Plage Zemmouri",
                "Plage paisible idéale pour la détente et la baignade",
                "https://images.pexels.com/photos/1450353/pexels-photo-1450353.jpeg",
                0,
                "",
                "+213 24 81 56 59",
                "",
                ""
        ));

        beaches.put("places", beachPlaces);
        locations.put("beaches", beaches);

        // Initialize Gastronomy
        Map<String, Object> gastronomy = new HashMap<>();
        gastronomy.put("phone", "+213 24 81 57 57");
        gastronomy.put("email", "resto.boumerdes@tourism.dz");
        gastronomy.put("details", "Restaurants traditionnels et modernes, spécialités de fruits de mer");
        locations.put("gastronomy", gastronomy);

        // Initialize Hotels
        Map<String, Object> hotels = new HashMap<>();
        hotels.put("phone", "+213 24 81 58 58");
        hotels.put("email", "hotels.boumerdes@tourism.dz");
        hotels.put("details", "Découvrez nos hôtels de luxe et résidences balnéaires");

        List<Place> hotelPlaces = new ArrayList<>();
        hotelPlaces.add(new Place(
                "Hôtel Le Méridien",
                "Hôtel 5 étoiles avec vue panoramique sur la mer Méditerranée",
                "https://images.pexels.com/photos/258154/pexels-photo-258154.jpeg",
                4.8f,
                "Piscine, Spa, Restaurant gastronomique, Plage privée",
                "+213 24 81 58 59",
                "meridien.boumerdes@hotels.dz",
                "Boulevard de la Corniche, Boumerdes",
                "€€€€"
        ));

        hotelPlaces.add(new Place(
                "Résidence Les Sables d'Or",
                "Appartements de luxe en bord de mer avec services hôteliers",
                "https://images.pexels.com/photos/261102/pexels-photo-261102.jpeg",
                4.6f,
                "Cuisine équipée, Terrasse vue mer, Piscine, Salle de sport",
                "+213 24 81 58 60",
                "sablesdor@hotels.dz",
                "Zone touristique, Boumerdes",
                "€€€"
        ));

        hotelPlaces.add(new Place(
                "Marina Bay Resort",
                "Resort familial offrant une expérience balnéaire complète",
                "https://images.pexels.com/photos/338504/pexels-photo-338504.jpeg",
                4.5f,
                "Piscines, Spa, Aires de jeux, Restaurants, Club enfants",
                "+213 24 81 58 61",
                "marinabay@hotels.dz",
                "Route de la Marina, Boumerdes",
                "€€€"
        ));

        hotels.put("places", hotelPlaces);
        locations.put("hotels", hotels);
    }

    // Get all locations data
    public Map<String, Object> getAllLocations() {
        return locations;
    }

    // Get specific location data
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLocationData(String locationType) {
        if (locationType.equals("restaurants")) {
            Map<String, Object> result = new HashMap<>();
            result.put("places", locations.get("restaurants"));
            return result;
        }
        return (Map<String, Object>) locations.get(locationType);
    }

    // Get contact information for a location
    public ContactInfo getContactInfo(String locationType) {
        Map<String, Object> locationData = getLocationData(locationType);
        if (locationData != null) {
            String phone = (String) locationData.get("phone");
            String email = (String) locationData.get("email");
            String details = (String) locationData.get("details");
            return new ContactInfo(phone, email, details);
        }
        return null;
    }

    // Get places for a location
    @SuppressWarnings("unchecked")
    public List<Place> getPlaces(String locationType) {
        Map<String, Object> locationData = getLocationData(locationType);
        if (locationData != null && locationData.containsKey("places")) {
            return (List<Place>) locationData.get("places");
        } else if (locationType.equals("restaurants")) {
            return (List<Place>) locations.get("restaurants");
        }
        return new ArrayList<>();
    }

    // Contact Info class
    public static class ContactInfo {
        private String phone;
        private String email;
        private String details;

        public ContactInfo(String phone, String email, String details) {
            this.phone = phone;
            this.email = email;
            this.details = details;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getDetails() {
            return details;
        }
    }

    // Place class
    public static class Place {
        private String name;
        private String description;
        private String imageUrl;
        private float rating;
        private String speciality;
        private String contact;
        private String email;
        private String address;
        private String priceRange;

        public Place(String name, String description, String imageUrl, float rating,
                     String speciality, String contact, String email, String address) {
            this.name = name;
            this.description = description;
            this.imageUrl = imageUrl;
            this.rating = rating;
            this.speciality = speciality;
            this.contact = contact;
            this.email = email;
            this.address = address;
            this.priceRange = "";
        }

        public Place(String name, String description, String imageUrl, float rating,
                     String speciality, String contact, String email, String address,
                     String priceRange) {
            this.name = name;
            this.description = description;
            this.imageUrl = imageUrl;
            this.rating = rating;
            this.speciality = speciality;
            this.contact = contact;
            this.email = email;
            this.address = address;
            this.priceRange = priceRange;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public float getRating() {
            return rating;
        }

        public String getSpeciality() {
            return speciality;
        }

        public String getContact() {
            return contact;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public String getPriceRange() {
            return priceRange;
        }

        public boolean hasRating() {
            return rating > 0;
        }
    }
}