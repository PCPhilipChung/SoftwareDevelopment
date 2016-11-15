package Assignment3;

import java.net.Socket;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * This class represents the client and they will send the credit card number to the server.
 * @author Philip
 *
 */
public class CardClient {
	
	public static void main(String [] args){
		Socket clientSocket;
		
		try{
			clientSocket = new Socket(InetAddress.getByName("localhost"),0141);
			System.out.println("Connected to " + clientSocket.getInetAddress().getHostName());
			
			ObjectOutputStream oosToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream oisFromServer = new ObjectInputStream(clientSocket.getInputStream());
			
			try{
				long creditCardNumber = 4012888888881881L;
		
				CreditCard creditCard = new CreditCard(creditCardNumber);
			
				System.out.println("Client is sending this credit card number to the server for validation: " + creditCard);
				
				oosToServer.writeObject(creditCard);
				
				oosToServer.flush();
				
				creditCard = (CreditCard) oisFromServer.readObject();
				System.out.println("The result has been returned by the server:");
				System.out.println(creditCard.getCreditCardNumber() + " is " + ((creditCard.getIsValid() == true) ? "valid!" : "not valid!") );
			
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(EOFException eof){
				System.out.println("The client has terminated connection");
			}catch(IOException e){
				e.printStackTrace();
			}
			oosToServer.close();
			oisFromServer.close();
			clientSocket.close();
		}catch(IOException e){
			e.getStackTrace();
		}
		System.out.println("Client is now terminating!");
	}
}
