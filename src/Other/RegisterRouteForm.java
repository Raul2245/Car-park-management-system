package Other;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.AppManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterRouteForm extends JDialog {
	AppManager am;
	private final JPanel contentPanel = new JPanel();
	private JTextField nbField;
	private JTextField driverField;
	private JTextField dateField;

	/**
	 * Create the dialog.
	 */
	public RegisterRouteForm(AppManager am) {
		this.am = am;
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Registration Number");
			lblNewLabel.setBounds(34, 51, 109, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			nbField = new JTextField();
			nbField.setBackground(new Color(245, 245, 245));
			nbField.setBounds(136, 48, 96, 19);
			contentPanel.add(nbField);
			nbField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Driver ID");
			lblNewLabel_1.setBounds(48, 93, 70, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			driverField = new JTextField();
			driverField.setBackground(new Color(245, 245, 245));
			driverField.setBounds(136, 90, 96, 19);
			contentPanel.add(driverField);
			driverField.setColumns(10);
		}
		{
			dateField = new JTextField();
			dateField.setBackground(new Color(245, 245, 245));
			dateField.setBounds(136, 132, 96, 19);
			contentPanel.add(dateField);
			dateField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Arrival date");
			lblNewLabel_2.setBounds(34, 135, 92, 13);
			contentPanel.add(lblNewLabel_2);
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
						am.adm.makeConnection("Admin", "admdtbs123");

						CallableStatement st = null;
						try {

							st = am.adm.connection.prepareCall("CALL inregistrare_ruta(?, ?, ?);");
							st.setString(1, nbField.getText());
							st.setInt(2, Integer.parseInt(driverField.getText()));
							st.setDate(3, Date.valueOf(dateField.getText()));
							st.execute();
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								st.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(okButton, "Error registering route.");
							}
						}
						JOptionPane.showMessageDialog(okButton, "Route registered successfully.");
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
