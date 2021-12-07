package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

public class MovieView extends JPanel{
	private JComboBox movieSelector;
	private JComboBox theatreSelector;
	private JComboBox timeSelector;
	private JButton movieButton;
	private JButton theatreButton;
	private JButton timeButton;
	private JButton backButton;
	private JButton confirmButton;
	private ArrayList<String> movieList;
	private ArrayList<String> theatreList;
	private ArrayList<String> timeList;
	
	public MovieView() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(new Insets(5,5,5,5)));
		movieList = new ArrayList<String>();
		theatreList = new ArrayList<String>();
		timeList = new ArrayList<String>();
		
		JLabel title = new JLabel("Choose a Movie, Theatre, and Time");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		
		
		JPanel topPanel = new JPanel();
		topPanel.add(Box.createRigidArea(new Dimension(0, 160)));
		topPanel.add(title);
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		// -------------------------FOR TESTING PURPOSES--------------------
		String [] s1 = {"James Bond", "Matrix"};
		String [] s2 = {"Theatre 1", "Theatre3"};
		String [] s3 = {"6:30", "9:00"};
		setMovieList(s1);
		setTheatreList(s2);
		setTimeList(s3);
		//------------------------------------------------------------------
		
		movieSelector = new JComboBox(movieList.toArray());
		movieSelector.setPreferredSize(new Dimension(300,25));
		movieButton = new JButton("Select");
		
		JPanel moviePanel = new JPanel(new FlowLayout());
		moviePanel.add(movieSelector);
		moviePanel.add(Box.createRigidArea(new Dimension(10,0)));
		moviePanel.add(movieButton);
		
		theatreSelector = new JComboBox(theatreList.toArray());
		theatreSelector.setPreferredSize(new Dimension(300,25));
		theatreButton = new JButton("Select");
		
		JPanel theatrePanel = new JPanel(new FlowLayout());
		theatrePanel.add(theatreSelector);
		theatrePanel.add(Box.createRigidArea(new Dimension(10,0)));
		theatrePanel.add(theatreButton);
		
		
		timeSelector = new JComboBox(timeList.toArray());
		timeSelector.setPreferredSize(new Dimension(300,25));
		timeButton = new JButton("Select");
		
		JPanel timePanel = new JPanel(new FlowLayout());
		timePanel.add(timeSelector);
		timePanel.add(Box.createRigidArea(new Dimension(10,0)));
		timePanel.add(timeButton);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(moviePanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		centerPanel.add(theatrePanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		centerPanel.add(timePanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 100)));
		
		backButton = new JButton("Back");
		confirmButton = new JButton("Confirm");
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(backButton, BorderLayout.WEST);
		bottomPanel.add(confirmButton, BorderLayout.EAST);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		
	}
	
	public void setMovieList(String [] strings) {
		for (int i = 0; i < strings.length; i++) {
			movieList.add(strings[i]);
		}
	}
	
	public void setTheatreList(String [] strings) {
		for (int i = 0; i < strings.length; i++) {
			theatreList.add(strings[i]);
		}
	}
	
	public void setTimeList(String [] strings) {
		for (int i = 0; i < strings.length; i++) {
			timeList.add(strings[i]);
		}
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
	public void addMenuListener(ActionListener listener) {
		backButton.addActionListener(listener);
		confirmButton.addActionListener(listener);
	}
	
	public void addActionListener(ActionListener listener) {
		confirmButton.addActionListener(listener);
		movieButton.addActionListener(listener);
		theatreButton.addActionListener(listener);
		timeButton.addActionListener(listener);
	}
	
	public String getSelectedMovie() {
		return (String)movieSelector.getSelectedItem();
	}
	
	public String getSelectedTheatre() {
		return (String)theatreSelector.getSelectedItem();
	}
	
	public String getSelectedTime() {
		return (String)timeSelector.getSelectedItem();
	}
}
