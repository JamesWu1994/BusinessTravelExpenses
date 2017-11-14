import java.awt.*;  
import java.awt.event.*;  

import javax.swing.*;  

import java.text.DecimalFormat;  

public class BusinessTripTravelExpenses extends JFrame{

	private JPanel Panel;  
	private JLabel ldays, lairfare, lcar, lmiles, lparking, lseminar, llodge, meals, parking, lodge, mile;  
	private JTextField tdays, tairfaire, tcar, tmiles, tparking, tseminar, tlodge;
	private JButton calculations;
	
	private final double MEALS_PER_DAY=37.00;
	private final double PARKING_PER_DAY=10.00;
	private final double LODGING_PER_DAY=95.00;
	private final double D_PER_MILE=0.27;
	
	private final int WINDOW_WIDTH=500;
	private final int WINDOW_HEIGHT=500;

	public BusinessTripTravelExpenses()  

	{  
  

	setTitle("Business Trip Travel Expenses");
	setSize (WINDOW_WIDTH, WINDOW_HEIGHT);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	buildTravelInfoPanel();
	buildTravelInfoPanel();
	add(Panel);
	setVisible(true);

	} 
	private void buildTravelInfoPanel()  

	{  
	Panel=new JPanel();

	ldays = new JLabel("Number of days on trip: ");  

	lairfare = new JLabel("Amount of airfair: ");  

	lcar = new JLabel("Amount of car rental: ");  

	lmiles = new JLabel("Miles driven: ");  

	lparking = new JLabel("Parking Fees: ");  

	lseminar = new JLabel("Conference registration: ");  

	llodge = new JLabel("Lodging charges per night: ");  
	
	DecimalFormat dollar = new DecimalFormat("$#,##0.00");  
	meals=new JLabel ("Meals per day: $" + MEALS_PER_DAY);
	parking=new JLabel ("Parking fee per day: $"+PARKING_PER_DAY);
	lodge=new JLabel ("Lodging fee per day: $" + LODGING_PER_DAY);
	mile=new JLabel ("Charges per mile: $"+D_PER_MILE);
	
	tdays=new JTextField(10);
	
	JTextField tairfare = new JTextField(10);
	tcar=new JTextField(10);
	tmiles=new JTextField(10);
	tparking=new JTextField(10);
	tseminar=new JTextField(10);
	tlodge=new JTextField(10);
	
	calculations=new JButton("Display the details");
	calculations.addActionListener(new Calc());
	
	Panel.add(ldays);
	Panel.add(tdays);
	Panel.add(lairfare);
	Panel.add(tairfare);
	Panel.add(lcar);
	Panel.add(tcar);
	Panel.add(lmiles);
	Panel.add(tmiles);
	Panel.add(lparking);
	Panel.add(tparking);
	Panel.add(lseminar);
	Panel.add(tseminar);
	Panel.add(llodge);
	Panel.add(tlodge);
	
	Panel.add(meals);
	Panel.add(parking);
	Panel.add(lodge);
	Panel.add(mile);
	Panel.add(calculations);
	}
	
	private class CalcButtonListener implements ActionListener
	{
		double totalExpenses;
		double allowedExpenses;
		
		double days=
				Integer.parseInt(tdays.getText());
		private JLabel tairfare;
		double d1=
				Double.parseDouble(tairfare.getText());
		double d2=
				Double.parseDouble(tcar.getText());
		double d3=
				Double.parseDouble(tmiles.getText());
		double d4=
				Double.parseDouble(tparking.getText());
		double d5=
				Double.parseDouble(tseminar.getText());
		double d6=
				Double.parseDouble(tlodge.getText());
		{
		totalExpenses=d1+d2+(d3*D_PER_MILE)+d4+d5+(d6*days);
		
		allowedExpenses=(MEALS_PER_DAY+PARKING_PER_DAY+LODGING_PER_DAY)*days+(d3*D_PER_MILE);
		
		if (totalExpenses>allowedExpenses)
			JOptionPane.showMessageDialog (null, "Total expenses by business person: $" + Double.tostring(totalExpenses)+"\nExpenses must be paid by business person: $"+"\nAllowable expenses for the trip: $"++ Double.tostring(allowedExpenses)+"\nAmount saved by the business person: $"++ Double.tostring(allowedExpenses-totalExpenses)));
	}
	
	public static void main(String args[])
	}