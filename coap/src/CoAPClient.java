import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;
import java.util.Scanner;

public class CoAPClient {
    public static void main(String[] args) throws ConnectorException, IOException {
        // Create a CoAP client
        CoapClient client = new CoapClient("coap://192.168.43.252:5683/team");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter method (GET, PUT, POST, DELETE) or 'stop' to exit: ");
            String method = scanner.nextLine().toUpperCase();
            
            if ("STOP".equals(method) || "EXIT".equals(method)) {
                break;
            }
            
            switch (method) {
                case "GET":
                    performGET(client);
                    break;
                // case "PUT":
                //     performPUT(client);
                //     break;
                // case "POST":
                //     performPOST(client);
                //     break;
                // case "DELETE":
                //     performDELETE(client);
                //     break;
                default:
                    System.err.println("Invalid method. Please enter GET, PUT, POST, DELETE, or 'stop' to exit.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Client stopped.");
    }
    
    private static void performGET(CoapClient client) throws ConnectorException, IOException {
        CoapResponse response = client.get();
        if (response != null) {
            System.out.println("GET Response: " + response.getResponseText());
        } else {
            System.err.println("Failed to perform GET request");
        }
    }
    
    // private static void performPUT(CoapClient client) throws ConnectorException, IOException {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Enter payload for PUT request: ");
    //     String payload = scanner.nextLine();
        
    //     CoapResponse response = client.put(payload, 0);
    //     if (response != null) {
    //         System.out.println("PUT Response: " + response.getResponseText());
    //     } else {
    //         System.err.println("Failed to perform PUT request");
    //     }
    // }
    
    // private static void performPOST(CoapClient client) throws ConnectorException, IOException {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Enter payload for POST request: ");
    //     String payload = scanner.nextLine();
        
    //     CoapResponse response = client.post(payload, 0);
    //     if (response != null) {
    //         System.out.println("POST Response: " + response.getResponseText());
    //     } else {
    //         System.err.println("Failed to perform POST request");
    //     }
    // }
    
    // private static void performDELETE(CoapClient client) throws ConnectorException, IOException {
    //     CoapResponse response = client.delete();
    //     if (response != null) {
    //         System.out.println("DELETE Response: " + response.getResponseText());
    //     } else {
    //         System.err.println("Failed to perform DELETE request");
    //     }
    // }
}
