package cmpe273.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;

/**
 * @author saung
 *
 */
public class NonBlockingHttpClient {

    /**
     * Make HTTP GET call to the given url
     * 
     * @param url
     */
    public void get(String url) {
	ClientConfig cc = new DefaultNonBlockingClientConfig();
	Client c = NonBlockingClient.create(cc);
	AsyncWebResource awr = c.asyncResource(url);
	// makes HTTP GET call
	awr.get(new TypeListener<ClientResponse>(ClientResponse.class) {

	    public void onComplete(Future<ClientResponse> f)
		    throws InterruptedException {
		try {
		    System.out.println("Got Response. HTTP Code = "
			    + f.get().getStatus());
		} catch (ExecutionException e) {
		    System.out.println("Something went wrong!");
		}
	    }

	});
	System.out.println("Continued to execute...");
	System.out.println("Done!");
    }
}
