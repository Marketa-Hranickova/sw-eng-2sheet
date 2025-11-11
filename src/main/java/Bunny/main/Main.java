package Bunny.main;



import Bunny.child.Child;
import Bunny.child.GiftPreference;
import Bunny.child.LocationType;
import Bunny.gifts.Gift;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Alice,12,snowy,book
Bob,14,urban,gadget
Charlie,9,coastal,toy
David,5,coastal,book
Emilia,4,snowy, gadget
Frida,6,somewhere,book
 */


public class Main {
    private static GiftWorkshopFacade workshop = new GiftWorkshopFacade();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Child> children = new ArrayList<>();

        System.out.println("Write name of kid, age, location and preferred gift or 'end':");
        System.out.println("locations:\n\tsnowy,urban,coastal\nGifts:\n\tbook,gadget");
        System.out.println("Example: Alice,5,snowy,book");

        // --- Input Parsing ---
        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("end") || line.isEmpty()) {
                    break;
                }
                try {
                    Child child = parseChildInput(line);
                    children.add(child);
                } catch (Exception e) {
                    System.err.println("Error: " + line + ". " + e.getMessage());
                }
            } else {
                break;
            }
        }
        scanner.close();

        // --- Processing and Output ---
        processAndOutput(children);
    }

    private static Child parseChildInput(String inputLine) {
        String[] parts = inputLine.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Wrong input, expected 4 values.");
        }

        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());

        LocationType location;
        try {
            location = LocationType.valueOf(parts[2].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            location = LocationType.UNKNOWN;
        }

        String rawPreference = parts[3].trim();

        return new Child(name, age, location, rawPreference);
    }

    private static void processAndOutput(List<Child> children) {
        List<String> served = new ArrayList<>();
        List<String> notServed = new ArrayList<>();

        for (Child child : children) {
            try {
                // 1. Gift Selection Strategy & Factory (Facade)
                String giftDescription;

                switch (child.preference) {
                    case BOOK:
                        String bookGenre = (child.age < 10) ? "fantasy" : "science";
                        Gift book = workshop.produceGift(child.preference, bookGenre);
                        giftDescription = book.describe();
                        break;
                    case GADGET:
                        String gadgetType = (child.age >= 10) ? "Smartwatch" : "Headphones";
                        Gift gadget = workshop.produceGift(child.preference, gadgetType);
                        giftDescription = gadget.describe();
                        break;
                    case TOY:
                    case UNKNOWN:
                    default:
                        notServed.add(child.name + ": Gift - " + child.rawPreference + "?");
                        continue;
                }

                // 2. Delivery Strategy
                String deliveryMethod = DeliveryContext.executeDelivery(child);

                // 3. Output
                served.add(child.name + ": Gift - " + giftDescription + ", Delivery - " + deliveryMethod);

            } catch (Exception e) {
                notServed.add(child.name + ": Processing Error - " + e.getMessage());
            }
        }

        System.out.println("\nChildren who can be served:");
        served.forEach(System.out::println);

        System.out.println("\nChildren who cannot be served:");
        notServed.forEach(System.out::println);
    }
}