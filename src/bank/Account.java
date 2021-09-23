package bank;

import java.util.ArrayList;

import static bank.Tools.isActiveToString;

public abstract class Account {

    // Properties
    private AccountType         accountType;
    private float               interestRate;
    private String              accountNumber;
    private float               lastPeriodBalance;
    private float               currentBalance;
    private ArrayList<Period>   periods;
    private String              selectedPeriod;
    private boolean             isActive;

    // Getters
    public AccountType getAccountType()         {  return accountType;      }
    public float    getInterestRate()           {  return interestRate;     }
    public String   getAccountNumber()          {  return accountNumber;    }
    public float    getLastPeriodBalance()      {  return lastPeriodBalance;}
    public float    getCurrentBalance()         {  return currentBalance;   }
    public ArrayList<Period> getPeriods()       {  return periods;          }
    public String   getSelectedPeriod()         {  return selectedPeriod;   }
    public boolean  isActive()                  {  return isActive;         }

    // Setters
    public void setAccountType          (AccountType accountType)   {this.accountType           = accountType;          }
    public void setInterestRate         (float interestRate)        {this.interestRate          = interestRate;         }
    public void setLastPeriodBalance    (float lastPeriodBalance)   {this.lastPeriodBalance     = lastPeriodBalance;    }
    public void setCurrentBalance       (float currentBalance)      {this.currentBalance        = currentBalance;       }
    public void setPeriods              (ArrayList<Period> periods) {this.periods               = periods;              }
    public void setActive               (boolean active)            {isActive                   = active;               }

    // Constructor

    // Constructor for new accounts
    public Account(AccountType accountType, float interestRate, String periodID) {
        setAccountType(accountType);
        setAccountNumber("");
        setInterestRate(interestRate);
        setLastPeriodBalance(0);
        setCurrentBalance(0);
        setPeriods(new ArrayList<Period>(1));
        setSelectedPeriod(periodID);
        setActive(true);
    }

    private void setSelectedPeriod(String periodID) {   this.selectedPeriod = periodID;    }


    // Behaviour

    private void setAccountNumber(String accountNumber) {
        if (accountNumber.isEmpty()) {
            this.accountNumber = Tools.getRandomNumberXpositions(8);
        }
        else {
            this.accountNumber = accountNumber;
        }
    }

    @Override
    public String toString() {
        return  "************************************************" + '\n' +
                "Account Type:                   " + accountType           + '\n' +
                "Interest Rate:                  " + interestRate          + '\n' +
                "Account Number:                 " + accountNumber         + '\n' +
                "Selected Period:                " + selectedPeriod        + '\n' +
                "Balance of the previous period: " + lastPeriodBalance     + '\n' +
                "Current Balance:                " + currentBalance        + '\n' +
                "Account Status:                 " + isActiveToString(isActive) + '\n';
    }

    public void selectPeriod   (int year, int month) {
        this.selectedPeriod = findPeriod(year, month);
    }

    public String findPeriod   (int year, int month) {
        String result = "";
        for (Period period: periods ) {
                if (period.periodID.getYear() == year && period.periodID.getMonth() == month) {
                    result =period.periodID.getPeriodID();
                    break;
                }
        }
        return result;
    }

}