import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Streams{
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,4,5,6 );
        int result =
        numeros.stream()
            .filter(a -> a > 3)
            .reduce(0, (a, b) -> {return a + b;});
        System.out.println(numeros + " " + result);


        String resultado = numeros.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" ; "));
        System.out.println(resultado);
    }
}
