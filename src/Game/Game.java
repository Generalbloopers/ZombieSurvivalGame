/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

/**
 *
 * @author gener
 */
import java.util.*;

class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static String location = "Abandoned House";
    private static List<String> inventory = new ArrayList<>();
    private static int health = 100;
    private static int hunger = 100;
    private static int thirst = 100;
    private static boolean hasWeapon = false;
    private static Set<String> safeHouses = new HashSet<>();
    private static Map<String, Integer> safeHouseUpgrades = new HashMap<>(); // Tracks upgrade levels
    private static List<String> locations = Arrays.asList("Gas Station", "Police Station", "House 1", "House 2", "House 3", "House 4", "House 5", "House 6", "House 7", "House 8", "House 9", "House 10");
    private static Random random = new Random();
    private static String[] weatherConditions = {"Sunny", "Rainy", "Foggy", "Stormy", "Snowy"};
    private static String currentWeather = weatherConditions[random.nextInt(weatherConditions.length)];
    private static int timeOfDay = 8; // 24-hour format, starts at 8 AM

    private static void explore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void checkInventory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void craftItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void convertToSafeHouse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void upgradeSafeHouse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void eatOrDrink() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void engageInCombat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private enum Choice {
        EXPLORE, INVENTORY, CRAFT, COMBAT, SAFEHOUSE, UPGRADE, EAT_DRINK, QUIT, INVALID
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Zombie Apocalypse Survival Game!");
        System.out.println("You wake up in an abandoned house. The city is overrun with zombies. Your goal: reach the Safe Zone.");
        
        while (true) {
            System.out.println("[DEBUG] Time before update: " + timeOfDay + " | Weather before update: " + currentWeather);
            updateTimeAndWeather(); // Progresses time and updates weather
            System.out.println("[DEBUG] Time after update: " + timeOfDay + " | Weather after update: " + currentWeather);
            
            System.out.println("[DEBUG] Hunger before reduction: " + hunger + " | Thirst before reduction: " + thirst + " | Health before reduction: " + health);
            reduceNeeds(); // Reduces hunger and thirst over time
            System.out.println("[DEBUG] Hunger after reduction: " + hunger + " | Thirst after reduction: " + thirst + " | Health after reduction: " + health);
            
            showOptions(); // Displays available actions
            String input = scanner.nextLine().toLowerCase();
            System.out.println("[DEBUG] Player chose option: " + input);
            handleChoice(getChoice(input)); // Processes the player's choice
        }
    }
    
    private static void updateTimeAndWeather() {
        timeOfDay += 2; // Each action progresses time by 2 hours
        if (timeOfDay >= 24) {
            timeOfDay = 0; // Reset to midnight
            currentWeather = weatherConditions[random.nextInt(weatherConditions.length)]; // Change weather
        }
    }
    
    private static void reduceNeeds() {
        hunger -= 5;
        thirst -= 5;
        if (hunger <= 0 || thirst <= 0) {
            health -= 10; // Losing health if hunger or thirst is empty
            System.out.println("You are starving or dehydrated! Find food and water quickly.");
            if (health <= 0) {
                System.out.println("You succumb to hunger and thirst. Game Over.");
                System.exit(0);
            }
        }
    }
    
    private static void showOptions() {
        System.out.println("\nYou are in: " + location);
        System.out.println("Health: " + health + " | Hunger: " + hunger + " | Thirst: " + thirst);
        System.out.println("Time: " + timeOfDay + ":00");
        System.out.println("Weather: " + currentWeather);
        System.out.println("What would you like to do?");
        System.out.println("1. Explore");
        System.out.println("2. Check Inventory");
        System.out.println("3. Craft Items");
        System.out.println("4. Engage in Combat");
        System.out.println("5. Convert Current Location into Safe House");
        System.out.println("6. Upgrade Safe House");
        System.out.println("7. Eat or Drink");
        System.out.println("8. Quit");
        System.out.print("Enter choice: ");
    }
    
    private static Choice getChoice(String input) {
        switch (input) {
            case "1": return Choice.EXPLORE;
            case "2": return Choice.INVENTORY;
            case "3": return Choice.CRAFT;
            case "4": return Choice.COMBAT;
            case "5": return Choice.SAFEHOUSE;
            case "6": return Choice.UPGRADE;
            case "7": return Choice.EAT_DRINK;
            case "8": return Choice.QUIT;
            default: return Choice.INVALID;
        }
    }
    
    private static void handleChoice(Choice choice) {
        switch (choice) {
            case EXPLORE:
                explore();
                break;
            case INVENTORY:
                checkInventory();
                break;
            case CRAFT:
                craftItems();
                break;
            case COMBAT:
                engageInCombat();
                break;
            case SAFEHOUSE:
                convertToSafeHouse();
                break;
            case UPGRADE:
                upgradeSafeHouse();
                break;
            case EAT_DRINK:
                eatOrDrink();
                break;
            case QUIT:
                System.out.println("Thanks for playing! Stay safe out there.");
                System.exit(0);
                break;
            case INVALID:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }
}
