package bank;

import java.math.BigDecimal;

public class Cheques extends Account {
    // Attributes
    BigDecimal bouncedChequeFee;

    // Getters
    public BigDecimal getBouncedChequeFee() { return bouncedChequeFee;  }

    // Setters
    public void setBouncedChequeFee(BigDecimal bouncedChequeFee) { this.bouncedChequeFee = bouncedChequeFee; }

    // Constructors

    public Cheques(float interestRate, BigDecimal bouncedChequeFee, String periodID) {
        super(AccountType.CHEQUE_ACCOUNT, interestRate, periodID);
        setAccountType(AccountType.CHEQUE_ACCOUNT);
        this.bouncedChequeFee = bouncedChequeFee;
    }


    // Behaviour

    @Override
    public String toString() {
        return super.toString() + "\nCheque Account Commissions: \n" +
                "Bounced Cheque Fee: " + bouncedChequeFee;
    }
}
