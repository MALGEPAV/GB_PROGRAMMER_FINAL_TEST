import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class PetRegistry {
    ArrayList<Pet> registry;

    public PetRegistry() {
        registry = new ArrayList<>();
    }

    public void printAllPets() {
        if (registry.isEmpty()) {
            System.out.println("No pets...");
            return;
        }
        System.out.println("Pets:");
        for (int i = 0; i < registry.size(); i++) {
            System.out.println("ID: "+i + "; " + registry.get(i));
        }
    }

    public void addNewPet() throws NamelessPetException{
        Scanner sc = new Scanner(System.in);
        System.out.println("CREATING A NEW PET");
        System.out.println("Enter the NAME of the new pet:");
        String newName = sc.nextLine();
        if (newName.isEmpty()) throw new NamelessPetException();

        Set<String> newCommands = new HashSet<>();
        System.out.println("Enter the COMMANDS the new pet can execute:\n" +
                "(Enter an empty string to stop)");
        String newCommand;
        while (!(newCommand = sc.nextLine()).isEmpty()) {
            newCommands.add(newCommand);
        }
        System.out.println("""
                Select the SPECIES of the new pet:
                1. Cat
                2. Dog
                3. Hamster""");
          int opt;
        Pattern optionPattern = Pattern.compile(" *[1-3] *");
        String inputString = sc.nextLine();
        while (!optionPattern.matcher(inputString).matches()){
            System.out.println("Incorrect input, try again");
            inputString = sc.nextLine();
        }
        opt = Integer.parseInt(inputString.strip());
        Pet newPet=null;
        switch (opt) {
            case 1:
                newPet = new Cat(newName, newCommands);
                registry.add(newPet);
                break;
            case 2:
                newPet = new Dog(newName, newCommands);
                registry.add(newPet);
                break;
            case 3:
                newPet = new Hamster(newName, newCommands);
                registry.add(newPet);
                break;
        }

        System.out.println("A NEW PET HAS BEEN ADDED:");
        PetCounter.add();
        System.out.println(newPet);
    }

    public void teachNewCommands() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the pet to learn new commands:");
        int id;
        if (!sc.hasNextInt() || (id = sc.nextInt())>=registry.size() || id<0){
            System.out.println("No pet with such ID");
            return;
        }
        Pet selectedPet = registry.get(id);
        System.out.printf("%s is about to learn some new commands\n", selectedPet.getName());
        System.out.println("Enter new commands\n" +
                "(Enter an empty string to stop)");
        String newCommand;
        Scanner scanner = new Scanner(System.in);
        while (!(newCommand = scanner.nextLine()).isEmpty()) {
            selectedPet.learnNewCommand(newCommand);
        }
        System.out.printf("%s now knows these commands:\n", selectedPet.getName());
        System.out.println(selectedPet.getCommands());
    }
}
