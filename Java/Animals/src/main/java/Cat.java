import java.util.Set;

public class Cat extends Pet {
    public Cat(String name, Set<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        return super.toString()+"; CAT";
    }
}
