/*Author: Abheek Gulati
For: NJIT class CS 656
*/

import java.io.*;
import  java.net.*;

class Server {

	public static void main(String args[]) throws Exception {

		ServerSocket inputSocket = new ServerSocket(3033);

		String toURL;

		while (true) {

			Socket connectionSocket = inputSocket.accept();

			System.out.println("connectionSocket: " + connectionSocket);

			BufferedReader fromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			toURL = fromClient.readLine();

			System.out.println("URL received from client: " + toURL);

			InetAddress IPAddress = InetAddress.getByName(toURL);

			String siteIP = IPAddress.getHostAddress();
			String siteName = IPAddress.getHostName();

			System.out.println("Address of requested site: " + siteIP + '\n' + " and the host name is: " + siteName);

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			outToClient.writeBytes(siteIP);

			System.out.println("Sent");

			connectionSocket.close();

		}
	}
}
