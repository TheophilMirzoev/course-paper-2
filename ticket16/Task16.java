package ticket16;
import java.util.function.UnaryOperator;

public class Task16 {
    public static void main(String[] args) throws Incorect {
        //squaring(5);

        Man man = new Man("");



    }
    public static void squaring(Integer integer) {
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(integer));
    }
}
