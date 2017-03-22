package com.androidprojects.esprit.moviessampleapp;

/**
 * Created by Amal on 15/03/2017.
 */

    public class Movie {

        private String name;
        private int thumbnail;
        private int rating;

        public Movie(){

        }

        public Movie(String name, int rating, int thumbnail) {
            this.name = name;
            this.rating = rating;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(int thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

