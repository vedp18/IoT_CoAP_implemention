
---

# Implementation of CoAP Protocol Using Java Eclipse Californium Library 

This project demonstrates a simple CoAP (Constrained Application Protocol) communication between a client and a server. The server is hosted on a Raspberry Pi Model 3, while the client can be run on any other device within the same network. The server handles specific resources and responds to GET requests from the client.

## Project Structure

```plaintext
coap/
│
├── bin/
│   └── Contains compiled `.class` files for the project.
│
├── lib/
│   └── Contains all required libraries for the project.
│
└── src/
    ├── CoAPClient.java
    └── CoAPServer.java
```

### CoAPClient.java
- **Purpose:** The client program initiates a connection to the CoAP server and allows the user to send GET requests.
- **Usage:** Run on any device within the same network as the server.

#### Key Functionalities:
- **GET Request:** Retrieves data from the server. (Other methods like PUT, POST, DELETE can be implemented but are commented out.)

### CoAPServer.java
- **Purpose:** The server program listens for incoming requests on specific resources (`time` and `team`) and responds accordingly.
- **Usage:** Run on a Raspberry Pi Model 3.

#### Key Functionalities:
- **Resource `time`:** Responds with the current server time.
- **Resource `team`:** Responds with a list of team members.

## How to Run

### Prerequisites:
- Java Development Kit (JDK) installed.
- Eclipse Californium library included in `lib/`.

### Steps:
1. **Compile the Project:**
   - Navigate to the `src/` directory.
   - Compile the Java files:
     ```sh
     javac -d ../bin CoAPClient.java CoAPServer.java
     ```

2. **Run the Server:**
   - On the Raspberry Pi, navigate to the `bin/` directory.
   - Start the server:
     ```sh
     java CoAPServer
     ```

3. **Run the Client:**
   - On another device, navigate to the `bin/` directory.
   - Start the client:
     ```sh
     java CoAPClient
     ```

4. **Interact with the Client:**
   - The client will prompt for the method (GET, PUT, POST, DELETE).
   - Type `GET` to retrieve the data from the server.

## Additional Information

### Server Configuration:
- **Port:** 5683 (default CoAP port)
- **Network Interface:** Configured to prefer IPv4 and bind to `127.0.0.1`.

### Resources:
- **`time`:** Returns the current time from the server.
- **`team`:** Returns a list of predefined team members.

## Contributing

Feel free to fork this repository and submit pull requests. Contributions are welcome!

## Acknowledgments

- The project uses the [Eclipse Californium CoAP framework](https://www.eclipse.org/californium/).

---
