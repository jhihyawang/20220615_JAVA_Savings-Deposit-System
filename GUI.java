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
    setTitle("�Ȧ�s�x�t��");
    setSize(280,250);
    setLocation(400,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    try{
      bank.read_data();
    }catch(IOException e){
      JOptionPane.showMessageDialog(null,"�ɮ�Ū�����~");
    }

    startButton = new JButton("�s�W�b��");
    startButton.setAlignmentX(CENTER_ALIGNMENT);
    endButton = new JButton("�R���b��");
    endButton.setAlignmentX(CENTER_ALIGNMENT);
    payButton = new JButton("�b����");
    payButton.setAlignmentX(CENTER_ALIGNMENT);
    displayButton = new JButton("�b���T");
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
        String id = createInput("�п�J�b��");
        if(id.length()!=6){
          JOptionPane.showMessageDialog(null,"�п�J���X�Ʀr�b��");
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
        String id = createInput("�п�J�b��"); 
        if(id.length()!=6){
          JOptionPane.showMessageDialog(null,"�п�J���X�Ʀr�b��");
          return;}
        Account a = bank.searchAccount(id);
        if ( a == null){
          JOptionPane.showMessageDialog(null,"�b�����s�b");
          return;}
        int event =Integer.parseInt(createInput(String.format("�ثe�l�B:%f\n�п�J�������\n1.�s��\n2.����\n3.��b\n4.�d�ݥ������\n5.�멳����",a.getBalance())));  
        if(event>5||event<0)
          throw new Exception("��������u���J�Ʀr1~5");
        if(event == 1){
          int amount =Integer.parseInt(createInput("�п�J������B"));
          if(amount>0){
            a.deposit(amount);
            JOptionPane.showMessageDialog(null,id+"�w�s�J"+amount+"��");}
          else{
            JOptionPane.showMessageDialog(null,"�s�J���B���i�p�󵥩�s");}
          return;}
        if(event == 2){
          int amount =Integer.parseInt(createInput("�п�J������B"));
          if(amount < a.getBalance()){
            a.withdraw(amount);
            JOptionPane.showMessageDialog(null,id+"�w����"+amount+"��");}
          else
            JOptionPane.showMessageDialog(null,"�l�B����");
          return;}
        if(event == 3){
          String towho = createInput("�п�J���ڱb��");
          if(towho.length()!=6){
            JOptionPane.showMessageDialog(null,"�п�J���X�Ʀr�b��");
            return;}
          Account b = bank.searchAccount(towho);
          if(b != null){
            int amount =Integer.parseInt(createInput("�п�J������B"));
            if(amount <= a.getBalance()){
              a.transfer(bank.searchAccount(towho),amount);
              JOptionPane.showMessageDialog(null,id+"�w��b��"+towho+"�i"+amount+"�j��");}
            else
              JOptionPane.showMessageDialog(null,"�l�B����");}
          else
            JOptionPane.showMessageDialog(null,"�b�����s�b");
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
        JOptionPane.showMessageDialog(null,"��������u���J�Ʀr");
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
      throw new BadInputException("��J���ର��");
    return input;}
  
  class BadInputException extends Exception{
    public BadInputException(String message){
      super(message);
    }
  }
}
 
                                    


