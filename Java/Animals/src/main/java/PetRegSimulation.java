import java.util.Scanner;
import java.util.regex.Pattern;

public class PetRegSimulation {
    public static void main(String[] args) {
        PetRegistry petRegistry = new PetRegistry();
        Scanner sc = new Scanner(System.in);
        int option = 1;
        while (option != 0) {
            System.out.println("MAIN MENU");
            System.out.println("""
                    1. Print all pets
                    2. Add a new pet
                    3. Teach a pet new commands
                    4. Show the pet count
                    0. Quit""");
            Pattern optionPattern = Pattern.compile(" *[0-4] *");
            String inputString = sc.nextLine();
            while (!optionPattern.matcher(inputString).matches()) {
                System.out.println("Incorrect input, try again");
                inputString = sc.nextLine();
            }
            option = Integer.parseInt(inputString.strip());
            switch (option){
                case 1:
                    petRegistry.printAllPets();
                    break;
                case 2:
                    try {
                        petRegistry.addNewPet();
                    }
                    catch (NamelessPetException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    petRegistry.teachNewCommands();
                    break;
                case 4:
                    System.out.println("Pet count: "+PetCounter.petCounter);
                    break;
                default:
                    break;
            }
        }
        System.out.println("BYE...");
    }
}
