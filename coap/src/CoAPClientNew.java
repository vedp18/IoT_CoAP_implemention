import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;
import java.util.Scanner;

public class CoAPClientNew {
    public static void main(String[] args) throws ConnectorException, IOException {
        // Create a CoAP client
        CoapClient client = new CoapClient("coap://127.0.0.1:5683/test");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter method (GET, PUT, POST, DELETE) or 'stop' to exit: ");
            String method = scanner.nextLine().toUpperCase();
            
            if ("STOP".equals(method) || "EXIT".equals(method)) {
                break;
            }
            
            switch (method) {
                case "GET":
                    Long startTime = System.currentTimeMillis();
                    performGET(client);
                    Long endTime = System.currentTimeMillis();

                    Long elaspedTime = endTime - startTime;
                    System.out.println("Received in : " + elaspedTime + " ms");

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
            // System.out.println("GET Response: " + response.getResponseText());
            ForFile.convertResponseToFile(response, "C:\\Users\\Monk\\Desktop\\IoT_CoAP_implemention-main\\coap\\data\\received.txt");

            System.out.println("Received " + response.getPayload().length + ",,  sucesfully");
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
