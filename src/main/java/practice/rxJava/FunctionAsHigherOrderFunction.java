package practice.rxJava;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionAsHigherOrderFunction {

    public static void main(String[] args) {

        Supplier<String> resultantFunction = transformAndConcatenateString("Hello", " World!!", String::toLowerCase);
        System.out.println(resultantFunction.get());
    }

    // 1. Function returning higher order function
    // 2. Until .get() is not called higher order function is not executed
    public static Supplier<String> transformAndConcatenateString(final String a, final String b, Function<String,String> stringTransform){
        return () -> {
            String aa =a;
            String bb=b;
            if(stringTransform!=null){
                aa=stringTransform.apply(a);
                bb=stringTransform.apply(b);
            }
            return aa+bb;
        };
    }
}
