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
      return "�w�s�W�Q���M���������F�O��";
   }
   public String dispAccount(){
     return "�x�W�b��||�m�W:"+getName()+"||�b��:"+getID()+"||�l�B:"+getBalance();
   } 
   public String getType(){return "s";}
}