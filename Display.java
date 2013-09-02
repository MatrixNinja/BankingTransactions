package com.egarduno.Banking;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/*__________________________________

	Emilio Garduno
	08/14/2013
	Banking Transactions
__________________________________*/

public class Display {
	//==========GUI
	private JLabel lblAmount;
	private JLabel lblBalance;//Place holder for the Balance Button
	private JTextField txtAmount;
	private JRadioButton radSave;
	private JRadioButton radCheck;
	private JRadioButton radCredit;
	private JRadioButton radDebit;
	private JButton btnShowLog;
//	private JButton btnGetBalance;
	private JButton btnSubmit;
	private JButton btnExit;
	

	public Display() {
		createFrame();
	}
	
	private void createFrame(){
		JFrame gui = new JFrame();
		gui.setSize(400, 300);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.add(createGridPanel());
		gui.setVisible(true);
	}
	
	private JPanel createGridPanel(){
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(5,2));
		
		lblAmount = new JLabel("Enter the transaction amount: ");
		//User enters amount here
		txtAmount = new JTextField();
		//select which account (ButtonGroup will only let you select one Radio)
		radCheck = new JRadioButton("CHECKING");
		radSave = new JRadioButton("SAVINGS");
		ButtonGroup acct = new ButtonGroup();
		acct.add(radCheck);
		acct.add(radSave);
		//select an action
		radCredit = new JRadioButton("CREDIT");
		radDebit = new JRadioButton("DEBIT");
		ButtonGroup actn = new ButtonGroup();
		actn.add(radCredit);
		actn.add(radDebit);
		//display 
		btnShowLog = new JButton("Log");
		btnShowLog.addActionListener(new logEvent());
		//Display the balance
		lblBalance = new JLabel("[________[BALANCE]________]");//Place holder for the Balance Button
//		btnGetBalance = new JButton("Balance");
//		btnGetBalance.addActionListener(new addEvent());
		
		//submit action or close program
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new addEvent());
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new exitEvent());
		
		gridPanel.add(lblAmount);
		gridPanel.add(txtAmount);

		gridPanel.add(radCheck);
		gridPanel.add(radSave);

		gridPanel.add(radCredit);
		gridPanel.add(radDebit);
		
		gridPanel.add(btnShowLog);
		gridPanel.add(lblBalance); //Place holder for the Balance Button
//		gridPanel.add(btnGetBalance);
		
		gridPanel.add(btnSubmit);
		gridPanel.add(btnExit);
		return gridPanel;
	}
	

	private class addEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Checking c;
			
			try {c = new Checking();
				Savings s = new Savings();
				
				if(radCheck.isSelected()){
					c.Credit(Double.parseDouble(txtAmount.getText()));
				}else if(radSave.isSelected()){
					s.Credit(Double.parseDouble(txtAmount.getText()));
				}
				txtAmount.setText("");
			}
			catch (IOException e){
				e.printStackTrace();
			}
			
		}
	}
	
	private class logEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ReadLog read = new ReadLog("TransactionLog.txt");
			try {
				System.out.println(read.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private class exitEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

}//End Class
