import java.util.Scanner;

public class Dining {
	private Dining() {
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baseCost = 5.0;
        double totalCost = baseCost;
        int totalQuantity = 0;

        System.out.println("Welcome to the Dining Experience Manager!");

        // Define the menu
        String[] menu = {
            "Meal 1 - $10.00",
            "Meal 2 - $15.00",
            "Meal 3 - $20.00"
        };

        // Meal prices
        double[] mealPrices = {10.0, 15.0, 20.0};
        // Meal availability
        boolean[] mealAvailability = {true, false, true};

        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }

            System.out.print("Select a meal (1-" + menu.length + "): ");
            int mealChoice = scanner.nextInt();
            if (mealChoice < 1 || mealChoice > menu.length) {
                System.out.println("Invalid meal choice. Please select a valid option.");
                continue;
            }

            int mealIndex = mealChoice - 1;

            if (!mealAvailability[mealIndex]) {
                System.out.println("Sorry, this meal is not available. Please select another meal.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0 || quantity > 100) {
                System.out.println("Invalid quantity. Please enter a positive integer between 1 and 100.");
                continue;
            }

            totalQuantity += quantity;
            totalCost += mealPrices[mealIndex] * quantity;

            System.out.println("Do you want to order more meals? (y/n): ");
            String more = scanner.next();

            if (!more.equalsIgnoreCase("y")) { // NOPMD by jeremymartinez on 11/4/23, 2:01 AM
                break;
            }
        }

        if (totalQuantity > 5) {
            totalCost *= 0.9; // Apply 10% discount for more than 5 meals
        }

        if (totalQuantity > 10) {
            totalCost *= 0.8; // Apply 20% discount for more than 10 meals
        }

        if (totalCost > 50) {
            totalCost -= 10; // Apply $10 discount for total cost > $50
        }

        if (totalCost > 100) {
            totalCost -= 25; // Apply $25 discount for total cost > $100
        }
        System.out.println("\nYour order:");
        int[] selectedQuantities = new int[menu.length];

        for (int i = 0; i < menu.length; i++) {
            if (selectedQuantities[i] > 0) {
                System.out.println(menu[i] + ": " + selectedQuantities[i] + " x " + mealPrices[i]);
            }
        }


        System.out.println("Total Cost: $" + totalCost);

        System.out.print("Confirm the order? (y/n): ");
        String confirm = scanner.next();

        if ("y".equalsIgnoreCase(confirm)) {
            System.out.println("Order confirmed. Total cost: $" + (int) totalCost);
        } else {
            System.out.println("Order canceled. -1");
        }
        scanner.close();
    }
}
