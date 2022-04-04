package Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tables.Vehicle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Admin extends JDialog {
	public Connection connection;
	AppManager am;
	public MainView mv;
	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private JPasswordField passwordField;

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setTextField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * Create the dialog.
	 */
	public Admin(AppManager am) {
		this.am = am;
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(54, 87, 94, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setBounds(54, 131, 94, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			usernameField = new JTextField();
			usernameField.setBackground(new Color(245, 245, 245));
			usernameField.setBounds(135, 93, 96, 19);
			contentPanel.add(usernameField);
			usernameField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Introduce your creditantials");
			lblNewLabel_2.setBounds(54, 27, 242, 50);
			contentPanel.add(lblNewLabel_2);
		}

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(245, 245, 245));
		passwordField.setBounds(135, 128, 96, 19);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(250, 235, 215));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String userName = getUsernameField().getText();
						String passWord = getPasswordField().getText();
						makeConnection(userName, passWord);

						JButton btnNewButton = null;
						if (connection != null) {
							Statement statement = null;
							ResultSet permissions = null;
							
							try {
								statement = connection.createStatement();
								permissions = statement.executeQuery("SHOW GRANTS");
								
								boolean flag = false;
								while (permissions.next()) {
									String temp = permissions.getString("Grants for " + userName +"@localhost");
									
									System.out.println(temp);
									if (temp.indexOf("DELETE") != -1 || temp.indexOf("ALL") != -1)
										flag = true;
										
								}
								if (flag == true)
									am.ui.setStatus(1);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							mv = new MainView(am);
							mv.setVisible(true);
							
							setVisible(false);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(btnNewButton, "The connection failed.");
					}
				});

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(250, 235, 215));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
	}

	public void makeConnection(String userName, String passWord) {
		String DB_NAME = "car_park";
		String CONNECTION_LINK = "jdbc:mysql://localhost:3306/";

		try {
			connection = DriverManager.getConnection(CONNECTION_LINK + DB_NAME, userName, passWord);

			Statement sta = connection.createStatement();
		} catch (Exception exception) {
			 exception.printStackTrace();
		}
	}
}
