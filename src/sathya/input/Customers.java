package sathya.input;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;


@XmlRootElement(name="Customers")
public class Customers {

 private Account[] account;
 
 public Account[] getAccount()
       { return account; }
 public void setAccount(Account[] value) { this.account = value; }
}


