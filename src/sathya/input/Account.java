package sathya.input;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Account {
		 private String id;
		 private String name;
		 private String bankname;
		 
		 
		 @XmlElement(name="id")
		 public String getID() { return id; }
		 public void setID(String value) { this.id = value; }

		
		 @XmlElement(name="name")
		 public String getName() { return name; }
		 public void setName(String value) { this.name = value; }

		
		 @XmlElement(name="bankname")
		 public String getBankname() { return bankname; }
		 public void setBankname(String value) { this.bankname = value; }
}

