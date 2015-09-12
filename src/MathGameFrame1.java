import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MathGameFrame1 {

	private JFrame frame;
	private JTextField textFieldAnswer;
	private JLabel lblQuestion;
	private JLabel lblCheckAns;
	private RandomizeQuestion question;
	private int score = 0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathGameFrame1 window = new MathGameFrame1();
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
	public MathGameFrame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setColumns(10);
		
		JLabel lblQuestion = new JLabel("2 * 2");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 34));
		JLabel lblCheckAns = new JLabel("Podaj prawidłową odpowiedź :)");
		lblCheckAns.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JLabel lblScore = new JLabel("0");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 34));
		question = new RandomizeQuestion();
		lblQuestion.setText(question.getRandomizeProduct());
		
		JButton btnCheck = new JButton("Sprawd\u017A!");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ans;

				try {
					ans = Integer.parseInt(textFieldAnswer.getText());
					if(ans == question.getAnswer()) { 
						lblCheckAns.setText("Super!"); 
						lblQuestion.setText(question.getRandomizeProduct());
						score ++;
						lblScore.setText(Integer.toString(score));
						textFieldAnswer.setText("");
					
					} else {
						lblCheckAns.setText("Prawie! No sprobuj jeszcze raz.");
					}
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, "To nie jest liczba całkowita. Spróbuj jeszcze raz :)");
				}
			}
		});
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JLabel lblScoreInfo = new JLabel("Twój wynik:");
		
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCheckAns)
						.addComponent(btnCheck, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(lblScoreInfo)
					.addGap(40)
					.addComponent(lblScore)
					.addContainerGap(152, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(lblQuestion)
					.addGap(18)
					.addComponent(label)
					.addGap(25)
					.addComponent(textFieldAnswer, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblQuestion)
							.addComponent(label))
						.addComponent(textFieldAnswer, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCheck, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCheckAns)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScoreInfo)
						.addComponent(lblScore))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
