/**
 * 
 */
package cmpe273.example;

/**
 * @author saung
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String url = "http://www.google.com";

	System.out.println("Calling in blocking mode.");
	BlockingHttpClient blockClient = new BlockingHttpClient();
	blockClient.get(url);

	System.out.println("Calling in non-blocking mode.");
	NonBlockingHttpClient nonBlockingHttpClient = new NonBlockingHttpClient();
	nonBlockingHttpClient.get(url);
    }

}
