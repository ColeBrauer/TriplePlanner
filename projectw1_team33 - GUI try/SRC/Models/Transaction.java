package Models;

public class Transaction{
    String TransactionName;
    Integer TransactionAmount;

    public Transaction(String TName, Integer TAmount){
        TransactionName = TName;
        TransactionAmount = TAmount;
    }

    public String getTransactionName(){
        return TransactionName;
    }

    public Integer getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public void setTransactionName(String transactionName) {
        TransactionName = transactionName;
    }
}
