package bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Period {
    // Attributes
            PeriodID    periodID;
    private BigDecimal  previousBalance;
    private BigDecimal  periodBalance;
    private boolean     isClosed;
    ArrayList<Transaction> transactions;

    // Getters
    public String       getPeriodID()           { return periodID.getPeriodID();    }
    public BigDecimal   getPreviousBalance()    { return previousBalance;           }
    public BigDecimal   getCurrentBalance()     { return periodBalance;             }
    public boolean      isClosed()              { return isClosed;                  }


    // Setters
    public void setPreviousBalance  (BigDecimal previousBalance){  this.previousBalance = previousBalance;  }
    public void setPeriodBalance    (BigDecimal periodBalance)  {  this.periodBalance   = periodBalance;    }
    public void setClosed           (boolean closed)            {  isClosed             = closed;           }

    // Constructors
    public Period()
    {
        transactions = new ArrayList<Transaction>();
        periodID = new PeriodID();
    }


    // Behaviour
    public void getPreviousPeriodID()   {throw new UnsupportedOperationException("getPreviousPeriodID not implemented yet!");   }
    public BigDecimal getBalanceFromPeriodID() {throw new UnsupportedOperationException("getBalanceFromPeriodID not implemented yet");}
    public void selectPeriod()          {throw new UnsupportedOperationException("SelectPeriod not implemented yet!"        );  }
    public void closePeriod()           {throw new UnsupportedOperationException("ClosePeriod not implemented yet!"         );  }
    public void newPeriod()             {throw new UnsupportedOperationException("NewPeriod not implemented yet!"           );  }
    public void calculateInterests()    {throw new UnsupportedOperationException("CalculateInterests not implemented yet!"  );  }
    public void calculateMonthlyCommissions() {throw new UnsupportedOperationException("CalculateMonthly not implemented yet!");}
    public void calculateBalance()      {throw new UnsupportedOperationException("CalculateBalance not implemented yet!"    );  }


    public String printBalance() {
        String transactionType;
        StringBuilder result = new StringBuilder();
        for (Transaction t : transactions
             ) {
            switch (t.getTransactionType()) {
                case "chqAccCred" -> result.append(t.toString() + '\n');
                case "Cheque" -> result.append(((ChequeAccountDebit) t).toString() + '\n');
            }
        }
        return result.toString();
    }

}
