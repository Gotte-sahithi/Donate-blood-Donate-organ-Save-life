import java.util.*;
class Donor {

    String name;
    String bloodGroup;
    String donationType;

    Donor(String name, String bloodGroup, String donationType) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.donationType = donationType;
    }
    void display() {
        System.out.println("Name: " + name + " | Blood Group: " + bloodGroup + " | Donation: " + donationType);
    }
}
public class DonationSystem {

    static ArrayList<Donor> donorList = new ArrayList<>();
    static Queue<String> emergencyQueue = new LinkedList<>();
    static HashMap<String, String> bloodCompatibility = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        bloodCompatibility.put("O-", "Universal Donor");
        bloodCompatibility.put("AB+", "Universal Receiver");
        bloodCompatibility.put("A+", "Donate to A+, AB+");

        int choice;

        do {
            System.out.println("\n===== Blood & Organ Donation System =====");
            System.out.println("1. Register Donor");
            System.out.println("2. Display Donors");
            System.out.println("3. Search Donor by Blood Group");
            System.out.println("4. Add Emergency Request");
            System.out.println("5. Process Emergency Request");
            System.out.println("6. Blood Group Compatibility");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerDonor();
                    break;

                case 2:
                    displayDonors();
                    break;

                case 3:
                    searchDonor();
                    break;

                case 4:
                    addEmergency();
                    break;

                case 5:
                    processEmergency();
                    break;

                case 6:
                    showCompatibility();
                    break;

                case 7:
                    System.out.println("Thank you for supporting donation!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 7);
    }
    static void registerDonor() {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Blood Group: ");
        String blood = sc.nextLine();

        System.out.print("Donation Type (Blood / Organ / Both): ");
        String type = sc.nextLine();

        donorList.add(new Donor(name, blood, type));

        System.out.println("Donor Registered Successfully!");
    }
    static void displayDonors() {

        if (donorList.isEmpty()) {
            System.out.println("No donors available.");
            return;
        }
        System.out.println("\nRegistered Donors:");

        for (Donor d : donorList) {
            d.display();
        }
    }
    static void searchDonor() {

        System.out.print("Enter Blood Group to Search: ");
        String blood = sc.nextLine();

        boolean found = false;

        for (Donor d : donorList) {
            if (d.bloodGroup.equalsIgnoreCase(blood)) {
                d.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No donor found with this blood group.");
        }
    }
    static void addEmergency() {

        System.out.print("Enter Emergency Requirement (Example: O- Blood or Kidney): ");
        String request = sc.nextLine();

        emergencyQueue.add(request);

        System.out.println("Emergency Request Added!");
    }
    static void processEmergency() {

        if (emergencyQueue.isEmpty()) {
            System.out.println("No emergency requests.");
        } else {
            System.out.println("Processing: " + emergencyQueue.poll());
        }
    }
    static void showCompatibility() {

        System.out.println("\nBlood Group Compatibility:");

        for (String key : bloodCompatibility.keySet()) {
            System.out.println(key + " -> " + bloodCompatibility.get(key));
        }
    }
}
