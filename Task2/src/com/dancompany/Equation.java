import java.io.Serializable;

public final class Equation implements Serializable {
    public double a;
    public double b;
    public double c;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
