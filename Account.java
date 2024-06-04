import java.util.ArrayList; 
import javax.swing.*;
import java.util.Scanner; 
/**
   餘額可以透過存款和提款更改
*/
public class Account{
   private double balance;
   private int trasactioncount;
   private String name,id,transaction;
   private ArrayList<String> transacString = new ArrayList<String>();
   
   public Account(String n,String id){
      balance = 100;
      setName(n);
      setID(id);
      setTransactions("");
   }
//設定姓名
   public void setName(String n){
     name = n;}
   public String getName(){
     return name;}
//設定帳號
   public void setID(String id){
     this.id = id;
     }
//取得帳號
    public String getID(){
      return id;
    }    
   /**
   存款
   */
   public void deposit(double amount) throws IllegalArgumentException{
     if(amount<0)
       throw new IllegalArgumentException("存入金額不可小於零");
     else {
       balance = balance + amount;
       Transaction t = new Transaction(0,amount);
       transacString.add(t.getdetail());}
   }
   /**
   提款
   */
   public void withdraw(double amount)throws IllegalArgumentException{
     if(balance < amount)
       throw new IllegalArgumentException("提款金額不可大於帳號餘額");
     else{
       balance = balance - amount;
       Transaction t = new Transaction(1,amount);
       transacString.add(t.getdetail());}
       }
   /**
   目前餘額
   */
   public void setBalance(double b){
     balance = b;
   }
   public double getBalance(){
      return balance;
   }

   /**
      轉帳
      先從帳戶提款 再存入他人的帳戶
      Transfers money from the bank account to another account
   */
   public void transfer(Account other,double amount){
      setBalance(getBalance()-amount);
      other.deposit(amount);
      Transaction t = new Transaction(2,amount);
      transacString.add(t.getdetail());
   }
   public String dispAccount(){
     return "姓名:"+getName()+"||帳號:"+getID()+"||餘額:"+getBalance();
   } 
   public String treatment(){return "";}
   public String getType(){return "";}
   
   public void setTransactions(String t){
     transaction = t;
   }
   public int getTransactionCount(){
     return 0;
   }
   public void setTransactionCount(int transactionCount){
     trasactioncount = transactionCount;
   }
     
   public String dispTransaction(){
     String t = "";
     for(int i = 0;i<transacString.size();i++)
       t = t + transacString.get(i)+"\n";
     return transaction+t;
   }
}



