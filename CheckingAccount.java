public class CheckingAccount extends Account{
  private int transactionCount;
  private static double TRANSACTION_FEE = 2.0;
  private static final int FREE_TRANSACTIONS = 3;
  
  public CheckingAccount(String n,String id){
   super(n,id);
   transactionCount = 0;
  }
  public void deposit(double amount){
    transactionCount = transactionCount+1;      
    super.deposit(amount);
  }
  public void withdraw(double amount){
     transactionCount = transactionCount+1;
     super.withdraw(amount);
   }
   public void transfer(Account other,double amount){
     transactionCount = transactionCount+1;
     super.transfer(other,amount);
   }
   
  public String treatment(){
      if (transactionCount > FREE_TRANSACTIONS){
         double fees = TRANSACTION_FEE *(transactionCount - FREE_TRANSACTIONS);
         super.withdraw(fees);
      }
      transactionCount = 0;
      return "已扣除交易費用";
  }
  public void setTransactionCount(int transactionCount){
    this.transactionCount = transactionCount;}
  
  public int getTransactionCount(){
    return transactionCount;
  }
  public String dispAccount(){
    return "支票帳戶||姓名:"+getName()+"||帳號:"+getID()+"||餘額:"+getBalance()+"||交易次數:"+ transactionCount;
  }
  public String getType(){return "c";}
}
  

