import java.util.Set;

public class Hamster extends Pet{
    public Hamster(String name, Set<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        return super.toString()+"; HAMSTER";
    }
}
