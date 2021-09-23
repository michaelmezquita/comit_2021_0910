package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
// import java.util.concurrent.ThreadLocalRandom;
import static bank.AccountType.*;


public class Customer {

    // Attributes
    private String  businessName;
    private String  firstName;
    private String  lastName;
    private String  address;
    private String  emailAddress;
    private String  password;
    private String  customerID;
    private boolean signedIn;
    private ArrayList<Account> accounts;
    private int     selectedAccount;

    //Getters
    public String   getBusinessName()           { return businessName;  }
    public String   getFirstName()              { return firstName;     }
    public String   getLastName()               { return lastName;      }
    public String   getAddress()                { return address;       }
    public String   getEmailAddress()           { return emailAddress;  }
    public String   getPassword()               { return password; }
    public String   getCustomerID()             { return customerID;    }
    public boolean  getIsSignedIn()             { return signedIn;      }
    public ArrayList<Account> getAccounts() { return accounts; }

    // Setters
    public void setBusinessName(String businessName)    { this.businessName = businessName; }
    public void setFirstName(String firstName)          { this.firstName = firstName;       }
    public void setLastName(String lastName)            { this.lastName = lastName;         }
    public void setAddress(String address)              { this.address = address;           }
    public void setEmailAddress( String emailAddress)   { this.emailAddress = emailAddress; }
    public void setPassword(String password)            { this.password = password;         }
    public void setSignedIn(boolean signedIn)           { this.signedIn = signedIn;         }

    public void setCustomerID() {
        customerID = Tools.getRandomNumberXpositions(8);
    }


    // Constructors
    public Customer( boolean test )
        {
            businessName    = "Business Name";
            firstName       = "first Name";
            lastName        = "last Name";
            address         = "address";
            emailAddress    = "email address";
            password        = "password";

            if (test) { throw new UnsupportedOperationException("Pending to create new customer using scanner");}

            setBusinessName(businessName);
            setFirstName(firstName);
            setLastName(lastName);
            setAddress(address);
            setEmailAddress(emailAddress);
            setPassword(password);
            accounts = new ArrayList<Account>();
    }

    // Behaviour
    public boolean signIn() {setSignedIn( true  ); return true;}
    public void signOut()   {setSignedIn( false );}

    public void signUp(
            String _businessName,
            String _firstName,
            String _lastName,
            String _address,
            String _emailAddress,
            String _password
    ){
            setBusinessName(_businessName);
            setFirstName(_firstName);
            setLastName(_lastName);
            setAddress(_address);
            setEmailAddress(_emailAddress);
            setPassword(_password);
            setCustomerID();
    }

    public void newBankAccount(AccountType accountType, float interestRate, BigDecimal bouncedCheckFee, String period){
        PeriodID tempPeriod = new PeriodID();
        switch(accountType){
            case CHEQUE_ACCOUNT :
                    accounts.add( new Cheques(interestRate, bouncedCheckFee, tempPeriod.currentPeriod) );
                    break;
            case CREDIT_CARD    :
                    if(true) new UnsupportedOperationException("Not implemented new CREDIT_CARD account.");
                        break;
            case DEBIT_CARD     :
                    if (true) throw new UnsupportedOperationException("Not implemented new DEBIT_CARD account.");
                        break;
        }
    }

    public String listAccounts() {
        StringBuilder result = new StringBuilder();
        for (Account account : accounts) {
            result.append(account.toString());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Customer:\n" +
                "Business Name: " + businessName + '\n' +
                "First Name   : " + firstName + '\n' +
                "Last Name    : " + lastName + '\n' +
                "Address      : " + address + '\n' +
                "Customer ID  : " + customerID + '\n'
                ;
    }
}
