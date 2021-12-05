package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TicketView extends JPanel{
	private JComboBox tickets;
	private JButton refundButton;
	private JButton backButton;
	private JTextField balance;
	private ArrayList<String> ticketList;
	
	public TicketView() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(new Insets(5,5,5,5)));
		ticketList = new ArrayList<String>();
		
		JLabel title = new JLabel("Tickets");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		
		JPanel topPanel = new JPanel();
		topPanel.add(title);
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		//Populate this with a function getTickets()
		String [] strings = {"James Bond | Theatre 1 | 6:30", "Matrix | Theatre 4 | 9:00"};
		setTicketList(strings);
		tickets = new JComboBox(ticketList.toArray());
		tickets.setPreferredSize(new Dimension(300,30));
		
		refundButton = new JButton("Refund");
		refundButton.setPreferredSize(new Dimension(80,30));
		
		JPanel innerPanel = new JPanel(new FlowLayout());
		innerPanel.add(tickets);
		innerPanel.add(Box.createRigidArea(new Dimension(25,0)));
		innerPanel.add(refundButton);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(Box.createRigidArea(new Dimension(0,180)));
		centerPanel.add(innerPanel);
		
		backButton = new JButton("Back");
		
		JLabel bLabel = new JLabel("Account Balance: ");
		balance = new JTextField(7);
		balance.setEditable(false);
		
		JPanel botRight = new JPanel(new FlowLayout());
		botRight.add(bLabel);
		botRight.add(balance);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(backButton, BorderLayout.WEST);
		bottomPanel.add(botRight, BorderLayout.EAST);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void setTicketList(String [] strings) {
		for (int i = 0; i < strings.length; i++ ) {
			ticketList.add(strings[i]);
		}
	}
	
	public JButton getRefundButton() {
		return refundButton;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public void addMenuListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public void addActionListener(ActionListener listener) {
		refundButton.addActionListener(listener);
	}
	
	public void setBalance(String balance) {
		this.balance.setText(balance);
	}
	
	public String getTicket() {
		return (String)tickets.getSelectedItem();
	}
}
