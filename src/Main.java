import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Wykonaj_Callable callable1 = new Wykonaj_Callable(10);
        Wykonaj_Callable callable2 = new Wykonaj_Callable(10);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1)
        {
            @Override
            protected void done()
            {
                try
                {
                    System.out.println("FutureTask1 output = " + get());
                }
                catch (InterruptedException | ExecutionException e)
                {
                    e.printStackTrace();
                }
            }
        };

        FutureTask<String> futureTask2 = new FutureTask<String>(callable2)
        {
            @Override
            protected void done()
            {
                try
                {
                    System.out.println("FutureTask2 output = " + get());
                }
                catch (InterruptedException | ExecutionException e)
                {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true)
        {
            if (futureTask1.isDone() && futureTask2.isDone())
            {
                System.out.println("Zakonczone");
                executor.shutdown();
                return;
            }
        }
    }
}