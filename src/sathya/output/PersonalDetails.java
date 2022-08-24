package sathya.output;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PersonalDetails")
public class PersonalDetails {
    private AccountDetails accountdetails;
    public AccountDetails getAccountdetails() {
        return accountdetails;
    }
    public void setAccountdetails(AccountDetails accountdetails) {
        this.accountdetails = accountdetails;
    }
}

