package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static java.time.LocalTime.now;


public class Home {

    protected void newCustomer() {
    }


    public static void main(String[] args) {
        boolean test = false;
        Customer customer = new Customer(test);
        customer.newBankAccount( AccountType.CHEQUE_ACCOUNT, 0.05f, BigDecimal.valueOf(25), "202108");
        System.out.println("So far, I have created the Customer, And one Cheque Account, \n Let us invoke the Customer info... ");
        System.out.println("************************************************");
        System.out.println(customer.toString());
        System.out.println("\n...and the list of accounts:\n");
        System.out.println( customer.listAccounts() );

        // Instantiate the cheque account into the Accounts array
        // First, bring the Array of accounts
        ArrayList<Account> accounts = customer.getAccounts();

        // Go to the instantiated account
        Account account = accounts.get(0);

        // Get the periods of the account
        ArrayList<Period> periods = account.getPeriods();

        // Add a new period
        periods.add( new Period() );

        // Bring the referred period
        Period p = periods.get( 0 );

        System.out.println("Now, we feed the transactions, and print the period...");


        // Add deposit
        p.transactions.add( new Transaction("chqAccCred", "Deposit, test 1", BigDecimal.valueOf(1234567.89) ));

        p.transactions.add( new ChequeAccountDebit( "Cheque", "Cheque test",
                BigDecimal.valueOf(-1234567.89), "beneficiary", 1,
                new Date())
        );
        System.out.println("\n Transactions: \n" + p.printBalance() );

    }
}
