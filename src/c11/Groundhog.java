package c11;

public class Groundhog {
    protected int number;

    public Groundhog(int n) {
        number = n;
    }

    public String toString() {
        return "Groundhog #" + number;
    }

    public int hashCode() {

        return number;
    }

    public boolean equals(Object o) {
        return (o instanceof Groundhog) && (number == ((Groundhog) o).number);
    }
}
