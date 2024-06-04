import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
import java.io.*;
public class Bank{
  private Account a ;
  private ArrayList<Account> account;
  static String file_R; 
  public Bank(){
    account = new ArrayList<Account>();
  }
  public String addAccount(String name,String id,String type){
    if(searchAccount(id) != null){
      return "帳戶已存在";}
    if(type.equals("c"))
      account.add(new CheckingAccount(name,id));
    else
      account.add(new SavingAccount(name,id));
    return "帳戶新增成功";
    }
//overloading
  public String addAccount(Account a){
    account.add(a);
    return "帳戶新增成功";
    }
  
  public String deleteAccount(String id){
    Account a = searchAccount(id);
    if(a == null){
      return "帳戶不存在";}
    else{
      a.treatment(); 
      account.remove(a);
    }
    return "已成功結算帳戶，退還餘額:"+a.getBalance();
  }  

  public String getAllAccountInformation(){
    String information = "";
    for ( int i = 0; i < account.size() ; i++){
      information += account.get(i).dispAccount().concat("\n");
    }
    return information;
  }

  public Account searchAccount(String id){
    if(id.length()!=6)
      throw new IllegalArgumentException("請輸入六碼帳號");
    for(int i=0;i<account.size();i++){
      if(account.get(i).getID().equals(id))
        return account.get(i);
    }
    return null;
    }

  public void read_data()throws IOException{
    FileReader fileID = new FileReader("test.txt");
    Scanner s = new Scanner(fileID).useDelimiter("\t");
    Account a;         
    while(s.hasNext()){
      if (s.hasNextLine()){
          String type = s.next();
          String name = s.next();
          String id = s.next();
          double balance = s.nextDouble();
          int transactionCount = s.nextInt();
          String transactions = s.next();
          if(type.equals("c")){
            a = new CheckingAccount(name,id);
            a.setTransactionCount(transactionCount);}
          else
            a = new SavingAccount(name,id);
          a.setBalance(balance);

          a.setTransactions(transactions);         
          addAccount(a);
      }
        else
          break;
    }
    fileID.close();
  }
  public void save_data(){
    FileWriter f = null;
    try{
      f = new FileWriter("test.txt");
    }catch(IOException e){
      System.out.println("檔案開啟錯誤");
      System.exit(-1);
    }
    BufferedWriter outData = new BufferedWriter(f);
    
    try{
      for (int i=0; i<account.size(); i++) {
        if(account.get(i).getType().equals("c")){
          outData.write(account.get(i).getType() + "\t");      
          outData.write(account.get(i).getName() + "\t"); 
          outData.write(account.get(i).getID() + "\t");  
          outData.write(account.get(i).getBalance() + "\t");  
          outData.write(account.get(i).getTransactionCount() + "\t");
          outData.write(account.get(i).dispTransaction() + "\t"); 
        }
        else{
          outData.write(account.get(i).getType() + "\t");      
          outData.write(account.get(i).getName() + "\t"); 
          outData.write(account.get(i).getID() + "\t");  
          outData.write(account.get(i).getBalance() + "\t");  
          outData.write(0+"\t");
          outData.write(account.get(i).dispTransaction() + "\t");
        }
      }
    }catch(IOException e){
      System.out.println("資料輸出錯誤");
      System.exit(-2);}
    
    try{
      outData.close();
    }catch (IOException e){
      System.out.println("檔案關閉錯誤");
      System.exit(-3);}     
  }
}
    


