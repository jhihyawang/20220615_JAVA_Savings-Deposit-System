import java.util.ArrayList; 
import javax.swing.*;
import java.util.Scanner; 
/**
   �l�B�i�H�z�L�s�کM���ڧ��
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
//�]�w�m�W
   public void setName(String n){
     name = n;}
   public String getName(){
     return name;}
//�]�w�b��
   public void setID(String id){
     this.id = id;
     }
//���o�b��
    public String getID(){
      return id;
    }    
   /**
   �s��
   */
   public void deposit(double amount) throws IllegalArgumentException{
     if(amount<0)
       throw new IllegalArgumentException("�s�J���B���i�p��s");
     else {
       balance = balance + amount;
       Transaction t = new Transaction(0,amount);
       transacString.add(t.getdetail());}
   }
   /**
   ����
   */
   public void withdraw(double amount)throws IllegalArgumentException{
     if(balance < amount)
       throw new IllegalArgumentException("���ڪ��B���i�j��b���l�B");
     else{
       balance = balance - amount;
       Transaction t = new Transaction(1,amount);
       transacString.add(t.getdetail());}
       }
   /**
   �ثe�l�B
   */
   public void setBalance(double b){
     balance = b;
   }
   public double getBalance(){
      return balance;
   }

   /**
      ��b
      ���q�b�ᴣ�� �A�s�J�L�H���b��
      Transfers money from the bank account to another account
   */
   public void transfer(Account other,double amount){
      setBalance(getBalance()-amount);
      other.deposit(amount);
      Transaction t = new Transaction(2,amount);
      transacString.add(t.getdetail());
   }
   public String dispAccount(){
     return "�m�W:"+getName()+"||�b��:"+getID()+"||�l�B:"+getBalance();
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



