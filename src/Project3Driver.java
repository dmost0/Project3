import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Driver class is a frame as well as a starter with a main method
 *
 */
public class Project3Driver extends JFrame implements ActionListener{
	// Set field variables
	Diet diet;
	JTextField meatText;
	JTextField vegeText;
	JTextField drinkText;
	JTextField otherText;
	JTextField totalText;
	JTextField targetText;
	/**
	 * Creates an object of Project3Driver
	 */
	public Project3Driver()
	{
		// Instantiate instance variables
		diet = new Diet();
		
		// set frame settings
		setBackground(Color.WHITE);
		setSize(406,318);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the different sub panels of the JFrame
		buildTopPanel();
		buildCenterPanel();
		buildBottomPanel();
		
		// Let JFrame be visible
		setVisible(true);
		
	}
	
	/**
	 * Builds the center panel of the JFrame
	 */
	public void buildCenterPanel()
	{
		// Create Panels
		JPanel centerPanel = new JPanel(); // Holds all other sub panels
		JPanel centerBottom = new JPanel();
		JPanel topCenter = new JPanel();
		JPanel centerCenter = new JPanel();
		
		// Panel settings
		centerPanel.setLayout(new BorderLayout());
		
		// Create components
		JLabel categoryCaloriesPrompt = new JLabel("Enter the calories consumed in each category");
		JLabel meatLabel = new JLabel("Meat");
		meatText = new JTextField(10);
		JLabel vegeLabel = new JLabel("Vegetables/Fruit");
		vegeText = new JTextField(10);
		JLabel drinkLabel = new JLabel("Drinks");
		drinkText = new JTextField(10);
JLabel otherLabel = new JLabel("Other");
		otherText = new JTextField(10);
		JLabel totalLabel = new JLabel("Total calories consumed");
		totalText = new JTextField(10);
		totalText.setEditable(false); // cannot edit this text field
		// Components used by top center
		topCenter.add(categoryCaloriesPrompt);
		
		// Components used by center center
		centerCenter.add(meatLabel);
		centerCenter.add(meatText);
		centerCenter.add(vegeLabel);
		centerCenter.add(vegeText);
		centerCenter.add(drinkLabel);
		centerCenter.add(drinkText);
		centerCenter.add(otherLabel);
		centerCenter.add(otherText);
		
		// Components used by bottom center
		centerBottom.add(totalLabel);
		centerBottom.add(totalText);
		
		// Add sub panels to main center panel
		centerPanel.add(topCenter, BorderLayout.NORTH);
		centerPanel.add(centerCenter, BorderLayout.CENTER);
		centerPanel.add(centerBottom, BorderLayout.SOUTH);
		
		// Add main center panel to content pane center
		add(centerPanel,BorderLayout.CENTER);
	}
	
	/**
	 * Builds the bottom panel of the JFrame
	 */
	public void buildBottomPanel()
	{
		// Create bottom panel
		JPanel bottomPanel = new JPanel();
		
		// Create components
		JButton initialQuantities = new JButton("Set Initial Quantities");
		JButton updateTotal= new JButton("Update Daily Total");
		JButton close = new JButton("Close");
		
		// Register action listeners
		initialQuantities.addActionListener(this);
		updateTotal.addActionListener(this);
		close.addActionListener(this);
		
		// Set action command
		initialQuantities.setActionCommand("1");
		updateTotal.setActionCommand("2");
		close.setActionCommand("3");
		
		// Add components to bottomPanel
		bottomPanel.add(initialQuantities);
		bottomPanel.add(updateTotal);
		bottomPanel.add(close);
	
		// Add bottomPanel to content pane's south
		add(bottomPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * Builds the top panel of the JFrame
	 */
	public void buildTopPanel()
	{
		// Create top panel
		JPanel topPanel = new JPanel();
		
		// Create components
		JLabel targetCaloriesPrompt = new JLabel("Enter the number of calories for your diet");
		targetText = new JTextField(10);

		// Add components to topPanel
		topPanel.add(targetCaloriesPrompt);
		topPanel.add(targetText);
		
		// Add topPanel to content pane's north
		add(topPanel,BorderLayout.NORTH);
	}
	
	
	/**
	 * Starts the calorie counter program
	 * @param args default arguments
	 */
	public static void main(String[] args)
	{
		// Create a new Project3Driver
		new Project3Driver();
	}
	


	/**
	 * takes action based on the event that occurred.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Initial quantities button pressed
		if(e.getActionCommand() == "1"){
			// Set field text to initial quantities
			targetText.setText("2000");
			meatText.setText("650");
			vegeText.setText("625");
			drinkText.setText("450");
			otherText.setText("620");
			
			// Set diet field values to initial quantities
			diet.setTargetCalorieAmount(2000);
			diet.setMeat(650);
			diet.setVegetablesFruit(625);
			diet.setDrinks(450);
			diet.setOther(620);
			
		}
		// Update button pressed
		else if(e.getActionCommand() == "2"){
			// Check if any values are less than one
			if(Float.parseFloat(targetText.getText()) < 0 || Float.parseFloat(meatText.getText()) < 0 || Float.parseFloat(vegeText.getText()) < 0 || Float.parseFloat(drinkText.getText()) < 0 || Float.parseFloat(otherText.getText()) < 0)
				JOptionPane.showMessageDialog(rootPane, "Please do not enter negative numbers into the text field");
			// Not less than one
			else{
				// Set diet fields
				diet.setTargetCalorieAmount(Float.parseFloat(targetText.getText()));
				diet.setMeat(Float.parseFloat(meatText.getText()));
				diet.setVegetablesFruit(Float.parseFloat(vegeText.getText()));
				diet.setDrinks(Float.parseFloat(drinkText.getText()));
				diet.setOther(Float.parseFloat(otherText.getText()));
				
				// Get total
				totalText.setText(Float.toString(diet.getCaloriesConsumed()));
				
				// Below target
				if(diet.getOnTarget() < 0)
					JOptionPane.showMessageDialog(rootPane, "Calories consumed is less than the number allowed by the diet");
				// On target
				else if(diet.getOnTarget() == 0)
					JOptionPane.showMessageDialog(rootPane, "Calories consumed is equal to the number allowed by the diet");
				// Above target
				else
					JOptionPane.showMessageDialog(rootPane, "Calories consumed is greater than the number allowed by the diet");
			}
		}
		// Close button pressed
		else{
			// Makes frame invisible then disposes of it
			setVisible(false);
			dispose();
		}
	}
}