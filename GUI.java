import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class GUI extends JFrame{
  private Container container;
  private JButton startButton,endButton,payButton,displayButton;
  private Bank bank;
  
  public GUI(){
    setBank(new Bank());
    setTitle("銀行存儲系統");
    setSize(280,250);
    setLocation(400,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    try{
      bank.read_data();
    }catch(IOException e){
      JOptionPane.showMessageDialog(null,"檔案讀取錯誤");
    }

    startButton = new JButton("新增帳戶");
    startButton.setAlignmentX(CENTER_ALIGNMENT);
    endButton = new JButton("刪除帳戶");
    endButton.setAlignmentX(CENTER_ALIGNMENT);
    payButton = new JButton("帳戶交易");
    payButton.setAlignmentX(CENTER_ALIGNMENT);
    displayButton = new JButton("帳戶資訊");
    displayButton.setAlignmentX(CENTER_ALIGNMENT);
    
    JPanel panel = new JPanel();
    
    container = getContentPane();
    panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(startButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(endButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(payButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(displayButton);
    container.add(panel);
   
    startButton.addActionListener(new startHandler());
    endButton.addActionListener(new endHandler());
    payButton.addActionListener(new payHandler());
    displayButton.addActionListener(new displayHandler());
    setVisible(true);    
  }
  public void setBank(Bank input){
    bank = input;
  }
  public Bank getBank(){
    return bank;
  }
  private class startHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      addACGUI f = new addACGUI();
      bank.save_data();
    }
  }  


  private class endHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      try{
        String id = createInput("請輸入帳號");
        if(id.length()!=6){
          JOptionPane.showMessageDialog(null,"請輸入六碼數字帳號");
          return;}
        JOptionPane.showMessageDialog(null, bank.deleteAccount(id));
        bank.save_data();
      }
      catch (BadInputException err){
        JOptionPane.showMessageDialog(null,err.getMessage());
      }
    }
  }

  
  private class payHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      try{
        String id = createInput("請輸入帳號"); 
        if(id.length()!=6){
          JOptionPane.showMessageDialog(null,"請輸入六碼數字帳號");
          return;}
        Account a = bank.searchAccount(id);
        if ( a == null){
          JOptionPane.showMessageDialog(null,"帳號不存在");
          return;}
        int event =Integer.parseInt(createInput(String.format("目前餘額:%f\n請輸入交易種類\n1.存款\n2.提款\n3.轉帳\n4.查看交易紀錄\n5.月底結算",a.getBalance())));  
        if(event>5||event<0)
          throw new Exception("交易種類只能輸入數字1~5");
        if(event == 1){
          int amount =Integer.parseInt(createInput("請輸入交易金額"));
          if(amount>0){
            a.deposit(amount);
            JOptionPane.showMessageDialog(null,id+"已存入"+amount+"元");}
          else{
            JOptionPane.showMessageDialog(null,"存入金額不可小於等於零");}
          return;}
        if(event == 2){
          int amount =Integer.parseInt(createInput("請輸入交易金額"));
          if(amount < a.getBalance()){
            a.withdraw(amount);
            JOptionPane.showMessageDialog(null,id+"已提款"+amount+"元");}
          else
            JOptionPane.showMessageDialog(null,"餘額不足");
          return;}
        if(event == 3){
          String towho = createInput("請輸入收款帳號");
          if(towho.length()!=6){
            JOptionPane.showMessageDialog(null,"請輸入六碼數字帳號");
            return;}
          Account b = bank.searchAccount(towho);
          if(b != null){
            int amount =Integer.parseInt(createInput("請輸入交易金額"));
            if(amount <= a.getBalance()){
              a.transfer(bank.searchAccount(towho),amount);
              JOptionPane.showMessageDialog(null,id+"已轉帳給"+towho+"【"+amount+"】元");}
            else
              JOptionPane.showMessageDialog(null,"餘額不足");}
          else
            JOptionPane.showMessageDialog(null,"帳號不存在");
          return;}
        if(event == 4){
          JOptionPane.showMessageDialog(null,a.dispTransaction());
          return;}        
        if(event == 5){
          JOptionPane.showMessageDialog(null,a.treatment());}
        bank.save_data();
      }
      catch (BadInputException err){
        JOptionPane.showMessageDialog(null,err.getMessage());
      }
      catch(NumberFormatException ef){
        JOptionPane.showMessageDialog(null,"交易種類只能輸入數字");
      }catch(Exception ep){
        JOptionPane.showMessageDialog(null,ep.getMessage());}
    }
  }
  private class displayHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      JOptionPane.showMessageDialog(null,bank.getAllAccountInformation());
      bank.save_data();
    }
  }
  private String createInput(String message) throws BadInputException{
    String input = JOptionPane.showInputDialog(null,message);
    if(input == null || input.equals(""))
      throw new BadInputException("輸入不能為空");
    return input;}
  
  class BadInputException extends Exception{
    public BadInputException(String message){
      super(message);
    }
  }
}
 
                                    


