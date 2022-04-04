package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registration extends JDialog {
	AppManager am;
	private final JPanel contentPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField emailField;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public Registration(AppManager am) {
		setTitle("Register ");
		this.am = am;

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 450, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("First Name");
			lblNewLabel.setBounds(31, 57, 66, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Last Name");
			lblNewLabel_1.setBounds(31, 82, 66, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Email");
			lblNewLabel_2.setBounds(30, 107, 66, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Username");
			lblNewLabel_3.setBounds(30, 132, 66, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Password");
			lblNewLabel_4.setBounds(30, 157, 66, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			fnameField = new JTextField();
			fnameField.setBackground(new Color(245, 245, 245));
			fnameField.setBounds(97, 55, 300, 20);
			contentPanel.add(fnameField);
			fnameField.setColumns(10);
		}
		{
			lnameField = new JTextField();
			lnameField.setBackground(new Color(245, 245, 245));
			lnameField.setBounds(97, 80, 300, 20);
			contentPanel.add(lnameField);
			lnameField.setColumns(10);
		}
		{
			emailField = new JTextField();
			emailField.setBackground(new Color(245, 245, 245));
			emailField.setBounds(97, 105, 300, 20);
			contentPanel.add(emailField);
			emailField.setColumns(10);
		}
		{
			userField = new JTextField();
			userField.setBackground(new Color(245, 245, 245));
			userField.setBounds(97, 130, 300, 20);
			contentPanel.add(userField);
			userField.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(245, 245, 245));
			passwordField.setBounds(97, 155, 300, 20);
			contentPanel.add(passwordField);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Registration");
			lblNewLabel_5.setBounds(31, 15, 87, 30);
			contentPanel.add(lblNewLabel_5);
		}
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
						if (userField.getText().length() >= 5 && passwordField.getText().length() >= 8
								&& fnameField.getText().length() != 0 && lnameField.getText().length() != 0
								&& emailField.getText().length() != 0)
							am.bd.addUser(userField.getText(), passwordField.getText(), fnameField.getText(),
									lnameField.getText(), emailField.getText());
						else
							JOptionPane.showMessageDialog(okButton,
									"Datele introduse nu respecta conditiile minime de validare\n"
											+ "(Username >= 5 characters\nPassword >= 8 characters)\n");
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(250, 235, 215));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
