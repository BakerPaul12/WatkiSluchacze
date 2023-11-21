import java.util.concurrent.Callable;
public class Wykonaj_Callable implements Callable<String> {
    private final long waitTime;
    public Wykonaj_Callable(int time)
    {
        this.waitTime=time;
    }
    @Override
    public String call() throws Exception
    {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }

}
