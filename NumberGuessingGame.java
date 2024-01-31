package codsoft;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.xml.soap.Text;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class NumberGuessingGame {

	private JFrame frame;
	private JTextField txtnum;
	private final Random random = new Random();
    private int randomNumber;
    private int guessCount = 0;
    private int attempt=1;
	/**
	 * Launch the application.
	 */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNumber = random.nextInt(100);
        System.out.println(randomNumber);
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberGuessingGame window = new NumberGuessingGame();
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
	public NumberGuessingGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number Guessing Game");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(190, 10, 254, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(24, 52, 580, 409);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Make a guess between 1-100");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(154, 10, 264, 36);
		panel.add(lblNewLabel_1);
		
		txtnum = new JTextField();
		txtnum.setBounds(194, 56, 189, 31);
		panel.add(txtnum);
		txtnum.setColumns(10);
		
		JLabel lblguess = new JLabel("Guesses");
		lblguess.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblguess.setBounds(231, 226, 106, 13);
		panel.add(lblguess);
		
		JLabel lblresult = new JLabel("");
		lblresult.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblresult.setBounds(194, 166, 189, 25);
		panel.add(lblresult);
		
		JLabel lblscore = new JLabel("Your Score : ");
		lblscore.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblscore.setBounds(218, 374, 129, 25);
		panel.add(lblscore);
		
		JButton checkGuess = new JButton("Check Guess");
		checkGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(txtnum.getText()) == randomNumber){
					lblresult.setText("Your guess is correct!");
		            
		        } else if(Integer.parseInt(txtnum.getText()) > randomNumber){
		        	lblresult.setText("Too High");
		           
		        } else if(Integer.parseInt(txtnum.getText()) < randomNumber){
		        	lblresult.setText("Too Low");
		            
		        }
				
		        guessCount++;
		        if(guessCount>=15)
				{
					checkGuess.setEnabled(false);
				}
		        lblguess.setText("Guesses: " + guessCount);
		        
		        if(attempt==5 && lblresult.getText()=="Your guess is correct!")
				{
					lblscore.setText("Your Score : "+2);
				}
		        else if(attempt==4&& lblresult.getText()=="Your guess is correct!")
				{
					lblscore.setText("Your Score : "+4);
				}
		        else if(attempt==3&& lblresult.getText()=="Your guess is correct!")
				{
					lblscore.setText("Your Score : "+6);
				}
		        else if(attempt==2 && lblresult.getText()=="Your guess is correct!")
				{
					lblscore.setText("Your Score : "+8);
				}
		        else if(attempt==1 && lblresult.getText()=="Your guess is correct!")
				{
					lblscore.setText("Your Score : "+10);
				}
				
		        
			}
		});
		checkGuess.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkGuess.setBounds(214, 97, 150, 43);
		panel.add(checkGuess);
		
		JLabel lblNewLabel_2 = new JLabel("Total Attempts : 5");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 314, 158, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblattempt = new JLabel("Your Attempt : 1");
		lblattempt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblattempt.setBounds(339, 314, 231, 25);
		panel.add(lblattempt);
		
		
		
		JButton btnplay = new JButton("Play Again");
		
		btnplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess.setEnabled(true);
				
				
				
					
				
				lblscore.setText("Your Score : ");
				attempt++;
				if(attempt>5)
				{
					checkGuess.setEnabled(false);
					btnplay.setEnabled(false);
					lblattempt.setText("Your Attempts are finished");
				}
				else {
				lblattempt.setText("Your Attempt : "+attempt);}
				randomNumber = random.nextInt(100);
		        guessCount = 0;
		        lblguess.setText("Guesses: " + guessCount);
		        
		       
		        
				
			}
		});
		
		btnplay.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnplay.setBounds(99, 471, 132, 43);
		frame.getContentPane().add(btnplay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnExit.setBounds(399, 471, 132, 43);
		frame.getContentPane().add(btnExit);
	}
}
