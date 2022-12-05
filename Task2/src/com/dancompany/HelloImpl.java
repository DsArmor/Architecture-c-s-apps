
import java.rmi.RemoteException;
import java.util.ArrayList;

public class HelloImpl implements Hello {

    @Override
    public Solution solve(Equation equation) throws RemoteException {
        boolean solution =  false;
        boolean infinite = false;
        ArrayList<Double> roots = new ArrayList<>();
        double a = equation.a;
        double b = equation.b;
        double c = equation.c;
        if (a != 0.0) {
            double D = b * b - 4 * a * c;
            if (D > 0) {
                solution = true;
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                roots.add(x2);
                roots.add(x1);
            } else if (D == 0) {
                solution = true;
                roots.add( -b / (2 * a));
            }
        } else {
            solution = true;
            if (b != 0.0) {
                if (c != 0)
                    roots.add( -c / b);
                else
                    infinite = true;
            } else if (c == 0.0)
                infinite = true;
            else
                solution = false;
        }
        return new Solution(solution, infinite, roots);
    }
}
