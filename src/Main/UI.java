package Main;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import javax.swing.JTextField;

public class UI {
	AppManager am;
	private int status = 0;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	JFrame frmCarPark;

	/**
	 * Create the application.
	 */
	public UI(AppManager am) {
		this.am = am;
		
		initialize();
		
		frmCarPark.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarPark = new JFrame();
		frmCarPark.setTitle("Car Park");
		frmCarPark.setBounds(100, 100, 450, 300);
		frmCarPark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarPark.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStatus(2);
				Admin login = new Admin(am);
				login.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(29, 25, 110, 52);
		frmCarPark.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New user");
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStatus(3);
				Registration reg = new Registration(am);
				reg.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(150, 95, 110, 52);
		frmCarPark.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Guest");
		btnNewButton_3.setBackground(new Color(255, 250, 240));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStatus(4);
				MainView mv = new MainView(am);
				mv.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(283, 165, 110, 52);
		frmCarPark.getContentPane().add(btnNewButton_3);
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, 436, 263);
		bgPanel.setBackground(new Color(255, 228, 181));
		bgPanel.setLayout(null);
		frmCarPark.getContentPane().add(bgPanel);

		JLabel bgLabel = new JLabel();
		bgLabel.setBounds(-67, 0, 503, 367);

		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("cars-ga459829eb_640.png"));
		bgLabel.setIcon(bgIcon);
		bgPanel.add(bgLabel);
	}

	
}