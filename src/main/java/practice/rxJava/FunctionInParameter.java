package practice.rxJava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInParameter {
    public static void main(String[] args) {

        // Defining fucntion inline
        BiFunction<String,String,String> addTwoStrings = (s, s2) -> s+s2;
        System.out.println(addTwoStrings.apply("Hello", "World!!"));

        Function<String,String> tranformStringToLowerCase= s -> {
            return s.toLowerCase();
        };

        System.out.println(transformAndConcatenateString("Hello", "World!!",tranformStringToLowerCase));

    }

    // Demo for showing functions are first class citizen in reactive model by passing a function as parameter to other function
    public static String transformAndConcatenateString(String a, String b, Function<String,String> stringTransform){
        if(stringTransform!=null){
            a=stringTransform.apply(a);
            b=stringTransform.apply(b);
        }
        return a+b;
    }
}
