package com.filehandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//3.	Write an application to write 3 accounts having an account_no as integer then balance as double & then name as String into a file. Finally read all accounts & print the details on the console. Note: use DataInputStream & DataOutputStream.
class Account{
	public int id;
	public double balance;
	public String name;
	public Account(int id, double balance, String name) {
		this.id = id;
		this.balance = balance;
		this.name = name;
	}
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.name = null;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", name=" + name + "]";
	}
	
}

public class DataInputOutputAccount {
	public static void writeAccount(Account a[]) throws Exception {
		File file = new File("accounts.txt");
		FileOutputStream fos = new FileOutputStream(file); 
		DataOutputStream dos = new DataOutputStream(fos);
		for(int i=0 ; i<3;i++) {
			dos.writeInt(a[i].id);
			dos.writeDouble(a[i].balance);
			dos.writeUTF(a[i].name);
		}
		dos.flush();
		fos.flush();
		dos.close();
		fos.close();
		
	}
	public static void readAccount() throws Exception {
		Account[] b = new Account[3];
		File file = new File("accounts.txt");
		FileInputStream fis = new FileInputStream(file); 
		DataInputStream dis = new DataInputStream(fis);
		for(int i=0 ; i<3;i++) {
			b[i] = new Account();
			b[i].id=dis.readInt();
			b[i].balance=dis.readDouble();
			b[i].name=dis.readUTF();
			System.out.println("Account no."+i+"details are : \n "+b[i]);
		}
		dis.close();
		fis.close();
		
	}
	public static void main(String[] args) throws Exception {
		Account[] a = new Account[3];
		a[0] = new Account(1,2000,"Rajo");
		a[1] = new Account(2,4000,"Aditya");
		a[2] = new Account(3,6000,"Tind");
		writeAccount(a);
		readAccount();
	}
}
