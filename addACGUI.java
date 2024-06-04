import javax.swing.*;
import java.lang.Character.*;
import java.awt.*;
import java.awt.event.*;

public class addACGUI extends JFrame{
  private Container cp;
  private JLabel tyLabel,nameLabel,idLabel;
  private JComboBox types;
  private JTextField name,id;
  private JButton addButtun,clrButton;
  private final String[] ACCOUNTS = {"支票帳戶","儲蓄帳戶"};
  
  public addACGUI(){
    setTitle("新增帳戶");
    setSize(280,250);
    setLocation(680,200);

    
    tyLabel = new JLabel("帳戶種類");
    types = new JComboBox(ACCOUNTS);
    nameLabel = new JLabel("姓名");
    name = new JTextField(20);
    idLabel = new JLabel("帳號");
    id = new JTextField(20);    
    addButtun = new JButton("新增帳戶");
    clrButton = new JButton("清除");
    
    cp = getContentPane();
    cp.setLayout(new BorderLayout(10,20));
    JPanel cpan = new JPanel();
    cpan.setLayout(new GridLayout(3,2,10,20));
    cpan.add(tyLabel);
    cpan.add(types);
    cpan.add(nameLabel);
    cpan.add(name);
    cpan.add(idLabel);
    cpan.add(id);
    
    JPanel span = new JPanel();
    span.setLayout(new GridLayout(1,2,10,20));
    span.add(addButtun);
    span.add(clrButton);
    
    cp.add(cpan,BorderLayout.NORTH);
    cp.add(span,BorderLayout.SOUTH);
    setVisible(true);
//註冊
    InputHandler ih = new InputHandler();
    name.addActionListener(ih);
    id.addActionListener(ih);
    addButtun.addActionListener(ih);
    clrButton.addActionListener(new ClrButtonHandler());
  }
  private class InputHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      try{
        GUI g = new GUI();
        String innam = name.getText();
        String inid = id.getText();
        if(innam == null || innam.equals(""))
          throw new Exception("姓名不能為空");
        if(inid == null|| inid.equals(""))
          throw new Exception("帳號不能為空");
        
        for (int i = 0; i < inid.length(); i++) {
          if (Character.isDigit(inid.charAt(i)) == false) {
            JOptionPane.showMessageDialog(null,"帳號只能有數字");
            return;}
        }
        if(inid.length()!=6){
          JOptionPane.showMessageDialog(null,"請輸入六碼數字帳號");
          return;}
        int t = types.getSelectedIndex();
        if(t==0)
          JOptionPane.showMessageDialog(null,g.getBank().addAccount(innam,inid,"c"));
        else
          JOptionPane.showMessageDialog(null,g.getBank().addAccount(innam,inid,"s"));
        g.getBank().save_data();
      }catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage());
      }
    }
  }
  private class ClrButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      name.setText("");
      id.setText("");
    }
  }
}
      
    
    
    
    