package cmpe273.example;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author saung
 *
 */
public class BlockingHttpClient {

    /**
     * Make HTTP GET call to the given url
     * 
     * @param url
     */
    public void get(String url) {
	ClientConfig cc = new DefaultClientConfig();
	Client client = Client.create(cc);
	client.resource(url);
	WebResource webResource = client.resource(url);
	ClientResponse response = webResource.get(ClientResponse.class);
	System.out.println("Waiting for response...");
	System.out.println("Got Response. HTTP Code = " + response.getStatus());
	System.out.println("Done!");
    }
}
