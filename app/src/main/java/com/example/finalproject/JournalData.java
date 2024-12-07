package com.example.finalproject;

public class JournalData {
        private String day, time, location, mood, thoughts;

        public JournalData(String day, String time, String location, String mood, String thoughts) {
            this.day = day;
            this.time = time;
            this.location = location;
            this.mood = mood;
            this.thoughts = thoughts;
        }

        public String getDay() {
            return day;
        }
        public void setDay(String description) {
            this.day = day;
        }
        public String getTime() {
            return time;
        }
        public void setTime(String time) { this.time = time; }
        public String getLocation() {
        return location;
    }
        public void setLocation(String location) {
        this.location = location;
    }
        public String getMood() {
        return mood;
    }
        public void setMood(String mood) { this.mood = mood; }
        public String getThoughts() {
        return thoughts;
    }
        public void setThoughts(String thoughts) { this.thoughts = thoughts; }
}