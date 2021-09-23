package bank;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;

public class Transaction {

    // Attributes
    private String      transactionType;
    private int         transactionID;
    private Date        transactionDate;
    private String      transactionDescription;
    private BigDecimal  amount;

    // Getters
    public String       getTransactionType(){ return transactionType;   }
    public int          getTransactionID()  { return transactionID;     }
    public Date         getTransactionDate(){ return transactionDate;   }
    public String getTransactionDescription() { return transactionDescription;   }
    public BigDecimal   getAmount()         { return amount;            }

    // Setters
    public void setTransactionType  (String transactionType){ this.transactionType  = transactionType; }
    public void setTransactionDescription  (String transactionDescription)  { this.transactionDescription = transactionDescription;  }
    public void setAmount           (BigDecimal amount)     { this.amount           = amount;          }

    public void setTransactionDate  ()  {
       this.transactionDate = new Date();
    }

    public void setTransactionID() {
        transactionID = ThreadLocalRandom.current().nextInt(11111111, 99999999);
    }


    // Constructors
    public Transaction(String transactionType, String transactionDescription, BigDecimal amount) {
        setTransactionType(transactionType);
        setTransactionID();
        setTransactionDate();
        setTransactionDescription(transactionDescription);
        setAmount(amount);
    }

    // Behaviour
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  Tools.Pad( transactionType, 12, " ", true ) +
                Tools.Pad( (Integer.toString(transactionID)), 10, " ", true) +
                Tools.Pad( sdf.format(transactionDate), 21, " ", true) +
                Tools.Pad( amount.toString(), 15, " ", false)
                ;
    }

    public void moveForward(int move) {throw new UnsupportedOperationException("moveForward not implemented yet!");  }
    public void moveBackward(int move) {throw new UnsupportedOperationException("moveBackward not implemented yet!");  }
}
