package sathya;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import sathya.input.Account;
import sathya.input.Customers;
import sathya.output.AccountDetails;
import sathya.output.ObjectFactory;
import sathya.output.PersonalDetails;
import xmlpojo.Accountdetails;


public class XMLReader {

	public static void main(String[] args) throws IOException {
		String inputFileName="C:\\Users\\Sruthi\\eclipse-workspace\\SeleniumAutomation-Framework\\XmlReader\\src\\sathya\\input\\Input.xml";
		String outputFileName="C:\\Users\\Sruthi\\eclipse-workspace\\SeleniumAutomation-Framework\\XmlReader\\src\\sathya\\output\\output.xml";
		Customers cust=readXMLFile(inputFileName);
		PersonalDetails personalDetails=readXMLFilePersonalDetail(outputFileName,cust);
		writeXMLFile(personalDetails);
	}
	
	public static Customers readXMLFile(String fileName) {
		Customers cust = null;
		try {
			 JAXBContext context = JAXBContext.newInstance(Customers.class);
			 Unmarshaller unmarshaller = context.createUnmarshaller();
			 cust = (Customers) unmarshaller.unmarshal(
			    new File(fileName));
			 System.out.println(cust.getAccount().length); 
			 Account[] acc=cust.getAccount();
			 System.out.println(acc[0].getBankname()+"---"+acc[0].getID()+"----"+acc[0].getName());
			 System.out.println(); 	 
			 
			 } 
			 catch (JAXBException e) {
			      e.printStackTrace();
			   }
		 return cust;

		}

	public static PersonalDetails readXMLFilePersonalDetail(String fileName,Customers customers) {
		PersonalDetails personalDetails = null;
		try {
			 JAXBContext context = JAXBContext.newInstance(PersonalDetails.class);
			 Unmarshaller unmarshaller = context.createUnmarshaller();
			 personalDetails = (PersonalDetails) unmarshaller.unmarshal(
			    new File(fileName));
			 System.out.println(personalDetails.getAccountdetails()); 
			 AccountDetails accDetails=personalDetails.getAccountdetails();
			 accDetails.setAccount(customers.getAccount());
			 Account[] acc=accDetails.getAccount();
			 System.out.println(acc.length); 
				
			 System.out.println(acc[0].getBankname()+"---"+acc[0].getID()+"----"+acc[0].getName());
			 System.out.println(); 	 
			 
			 } 
			 catch (JAXBException e) {
			      e.printStackTrace();
			   }
		 return personalDetails;

		}
	
	public static void writeXMLFile(PersonalDetails personalDetails) throws IOException {
		ObjectFactory factory=new ObjectFactory();
		
	
		try {
			JAXBContext context=JAXBContext.newInstance(PersonalDetails.class);
			Marshaller marsheller=context.createMarshaller();
			JAXBElement<PersonalDetails> element = factory.createPersonalDetails(personalDetails);
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
	        marshaller.marshal(element,System.out);
	        
	        File file =new File(System.getProperty("user.dir")+"\\src"+"\\sathya\\output\\NewXML.xml");
	       	System.out.println(System.getProperty("user.dir")+"\\src\\xmlgenerator");
	        	file.getParentFile().mkdir();
	        	//if(!file.exists())
	        	   file.createNewFile();
	        	//}
			marsheller.marshal(personalDetails, file);
			marsheller.marshal(personalDetails,System.out);
			 } 
			 catch (JAXBException e) {
			      e.printStackTrace();
			   }
		

		}
	
}
