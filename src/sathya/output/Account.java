package sathya.output;

import javax.xml.bind.annotation.XmlElement;

public class Account {
	    private Object name;
	    private Integer id;
	    private Object bankname;
	    @XmlElement(name="name")
	    public Object getName() {
	        return name;
	    }
	    public void setName(Object name) {
	        this.name = name;
	    }
	    @XmlElement(name="id")
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    @XmlElement(name="bankname")
	    public Object getBankname() {
	        return bankname;
	    }
	    public void setBankname(Object bankname) {
	        this.bankname = bankname;
	    }
	}
