import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public final class Solution implements Serializable {
    boolean solution;
    boolean infinite;
    ArrayList<Double> roots;

    public Solution(boolean solution, boolean infinite, ArrayList<Double> roots) {
        this.solution = solution;
        this.infinite = infinite;
        this.roots = roots;
    }
}
