package xmlreader;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import xmlpojo.Accountdetails;
import xmlpojo.ObjectFactory;



public class XMLReaderAccountDetails {
	
	public static void main(String[] args) throws IOException {
		ObjectFactory factory=new ObjectFactory();
		
		
		String cbId="CB001";
		String cId="CID001";
		String cAcctNo="134200001";
		String cAcctType="savings";
		String cBank="ICICI";
		String cCustLimit="30000";
		
		Accountdetails accountDetails=factory.createAccountdetails();
		accountDetails.setAccountno(Integer.parseInt(cAcctNo));
		accountDetails.setAccounttype(cAcctType);
		accountDetails.setBankname(cBank);
		accountDetails.setLimit(Integer.parseInt(cCustLimit));
		
try{
			
			JAXBContext context=JAXBContext.newInstance(Accountdetails.class);
			Marshaller marsheller=context.createMarshaller();
			JAXBElement<Accountdetails> element = factory.createAccountdetails(accountDetails);
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
	        marshaller.marshal(element,System.out);
	        
	        File file =new File(System.getProperty("user.dir")+"\\src"+"\\xmlgenerator\\"+cbId+".xml");
	       	System.out.println(System.getProperty("user.dir")+"\\src\\xmlgenerator");
	        	file.getParentFile().mkdir();
	        	//if(!file.exists())
	        	   file.createNewFile();
	        	//}
			marsheller.marshal(accountDetails, file);
			marsheller.marshal(accountDetails,System.out);
			
			
			
		//	marsheller.marshal(book, new File("C://xml//book.xml"));
		//	marsheller.marshal(book, System.out);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
		

}
