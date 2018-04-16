package practice.rxJava.Observable;

import practice.rxJava.DataGenerator.DataGenerator;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.FutureTask;

public class ObservableOnFuture {
    public static void main(String[] args) {

        Observable<List<Integer>> observableFutureList;

        // Creating a future task that returns list of Integers
        FutureTask<List<Integer>> listFutureTask = new FutureTask<>(() -> {
            return DataGenerator.getNaturalNumbers();
        });


        // Wraps Observable on future but still run() of futuretask is called in scheduler
        observableFutureList= Observable.from(listFutureTask);

        // run using computation type of scheduler
        Schedulers.computation().createWorker().schedule(() -> {
                listFutureTask.run();
        });

        //Subscribe to future list and print each integer of Integer list
        observableFutureList.subscribe(list-> {
            list.forEach(e -> {
                System.out.println(e);
            });
        });

    }
}
