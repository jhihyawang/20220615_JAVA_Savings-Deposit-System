import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;
public class Transaction{
  private String trans_no ,trans_date;
  private int trans_type;
  private double trade;

  public Transaction(){
    this(0,0.0);
  }
  public Transaction(int tt,double t){
    Random r = new Random();
    trans_no = ""+getDate().replaceAll("-","").replaceAll(":","").replaceAll(" ","")+(r.nextInt(900000)+100000);
    setTranstype(tt);
    setTrade(t);
  }
  public String getTransno(){
    return trans_no;}
  
  public void setTranstype(int tt){
    trans_type = tt;}
  public int getTranstype(){
    return trans_type;}  

  public void setTrade(double t){
    trade = t;}
  public double getTrade(){
    return trade;}  
  
  public String getDate(){
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String sd = d.format(currentDateTime);
    return sd;}
  
  public String getdetail(){
    String t="";
    if(getTranstype()==0)
      t = "存款";
    if(getTranstype()==1)
      t = "提款";
    if(getTranstype()==2)
      t = "轉帳";
    return "交易時間:"+getDate()+"||交易編號:"+getTransno()+"||交易種類:"+ t +"||交易金額:"+getTrade();
}
}