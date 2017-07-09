import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by alan on 17-7-9.
 */
public class AsyncTemplate {


    ExecutorService theadPool = Executors.newFixedThreadPool(10);



    private<T> T execute(final AsyncCallback<T> callback){

        Future<T> future  = theadPool.submit(new AsyncCallable() {
            /**
             * 覆写 call 方法,回调 callback()
             */
            public T call() throws Exception {
                return callback.callBack();
            }
        });


    }
}
