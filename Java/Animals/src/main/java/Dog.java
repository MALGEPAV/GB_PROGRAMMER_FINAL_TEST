import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dog extends Pet {
    public Dog(String name, Set<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        return super.toString() + "; DOG";
    }
}
