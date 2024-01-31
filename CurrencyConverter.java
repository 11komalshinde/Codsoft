package codsoft;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CurrencyConverter {

	private JFrame frame;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(116, 30, 282, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(25, 80, 466, 279);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(34, 38, 138, 26);
		panel.add(lblNewLabel_1);
		
		
		amount = new JTextField();
		amount.setBounds(223, 38, 197, 26);
		panel.add(amount);
		amount.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("From");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(34, 104, 138, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("To");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(34, 163, 138, 26);
		panel.add(lblNewLabel_1_2);
		
		JComboBox from = new JComboBox();
		from.setModel(new DefaultComboBoxModel(new String[] {"USD", "Indian Rupees"}));
		from.setBounds(223, 104, 197, 27);
		panel.add(from);
		
		JComboBox to = new JComboBox();
		to.setModel(new DefaultComboBoxModel(new String[] {"Indian Rupees", "Shrilankan Rupees", "USD"}));
		to.setBounds(223, 163, 197, 27);
		panel.add(to);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 Double tot; 
				 int amt=Integer.parseInt(amount.getText());
			        
			        if(from.getSelectedItem().toString() == "USD" && to.getSelectedItem().toString() == "Shrilankan Rupees")
			        {
			            tot = amt * 320.00;
			   
			            JOptionPane.showInputDialog(this,"Your amount will be "+ tot.toString());
			        }
			       else  if(from.getSelectedItem().toString() == "USD" && to.getSelectedItem().toString() == "Indian Rupees")
			        {
			            tot = amt * 83.15;
			            JOptionPane.showInputDialog(this,"Your amount will be "+ tot.toString());
			            //JOptionPane.showMessageDialog(convert, this, "Your Amount will be " + tot.toString(), 0);
			        }  
			       else  if(from.getSelectedItem().toString() == "Indian Rupees" && to.getSelectedItem().toString() == "USD")
			        {
			            tot = amt * 0.012;
			            JOptionPane.showInputDialog(this,"Your amount will be "+ tot.toString());
			            //JOptionPane.showMessageDialog(convert, this, "Your Amount will be " + tot.toString(), 0);
			        }  
				
			}
		});
		convert.setFont(new Font("Times New Roman", Font.BOLD, 22));
		convert.setBounds(175, 243, 111, 26);
		panel.add(convert);
	}
}
