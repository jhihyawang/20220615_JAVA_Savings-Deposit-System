public class SavingAccount extends Account{
  private final Double INTERESTRATE = 0.001;
  private static final int SERVICE_FEE = 20;
  public SavingAccount(String n,String id){
    super(n,id);
   }
  public String treatment(){
      withdraw(getBalance()-SERVICE_FEE);
      double interest = getBalance() * INTERESTRATE / 100;
      deposit(interest);
      return "已新增利息和扣除本月行政費用";
   }
   public String dispAccount(){
     return "儲蓄帳戶||姓名:"+getName()+"||帳號:"+getID()+"||餘額:"+getBalance();
   } 
   public String getType(){return "s";}
}