package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainApplication {
	public static void serializeTheObject(final Customer customer) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("src/data.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customer);
			System.out.println("Object Serialized successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deSerializeTheObject() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream("src/data.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			Customer customer = (Customer) object;
			System.out.println("De-Serialization done!");
			System.out.println(customer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("1. Serialize the object");
		System.out.println("2. De-Serialize the object");
		System.out.println("3. exit");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Customer customer = new Customer("Cus001", "Abc Traders",
					"Guest@123", 570048, "Pune");
			serializeTheObject(customer);
			break;
		case 2:
			deSerializeTheObject();
			break;
		default:
			System.exit(0);
		}
		sc.close();
	}
}
