package bank;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ChequeAccountDebit extends Transaction {

    // Attributes
    String  beneficiary;
    int     chequeNumber;
    Date    chequeDatedOn;

    // Constructor for Debits

    public ChequeAccountDebit(String transactionType, String transactionDescription, BigDecimal amount, String beneficiary, int chequeNumber, Date chequeDatedOn) {
        super(transactionType, transactionDescription, amount);
        this.beneficiary = beneficiary;
        this.chequeNumber = chequeNumber;
        this.chequeDatedOn = chequeDatedOn;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() + " " +
                Tools.Pad( beneficiary, 25, " ", true) +
                Tools.Pad("Ch: " + chequeNumber, 8, " ", true) +
                Tools.Pad("Cheque dated on: " + sdf.format(chequeDatedOn), 30, " ", true) ;
    }
}
