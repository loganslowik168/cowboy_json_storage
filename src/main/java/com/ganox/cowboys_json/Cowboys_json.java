package com.ganox.cowboys_json;
import java.io.*;

class PlayerSerialization {
    
    // Player class that implements Serializable
    static class Player implements Serializable {
        private static final long serialVersionUID = 1L; // For serialization
        int level, health, ammo, experiencePoints, highScore;

        // Constructor to initialize player attributes
        public Player(int level, int health, int ammo, int experiencePoints, int highScore) {
            this.level = level;
            this.health = health;
            this.ammo = ammo;
            this.experiencePoints = experiencePoints;
            this.highScore = highScore;
        }

        // Method to display player information
        public void displayPlayerInfo() {
            System.out.println("Player Level: " + level);
            System.out.println("Health: " + health);
            System.out.println("Ammo: " + ammo);
            System.out.println("Experience Points: " + experiencePoints);
            System.out.println("High Score: " + highScore);
        }
    }
}

public class Cowboys_json {

    public static void main(String[] args) {
        // Create a new player
        PlayerSerialization.Player player = new PlayerSerialization.Player(1, 100, 30, 0, 0);

        // Display initial player information
        System.out.println("Initial Player Info:");
        player.displayPlayerInfo();

        // Serialize the player object
        String filename = "player.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(player);
            System.out.println("Player object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the player object
        PlayerSerialization.Player deserializedPlayer = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            deserializedPlayer = (PlayerSerialization.Player) in.readObject();
            System.out.println("Player object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }

        // Display deserialized player information
        System.out.println("\nDeserialized Player Info:");
        if (deserializedPlayer != null) {
            deserializedPlayer.displayPlayerInfo();
        }
    }
}
