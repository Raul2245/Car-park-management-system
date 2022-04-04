package Tables;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Main.BDlink;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DriverAdd extends JDialog {
	BDlink bds;
	private final JPanel contentPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField ageField;
	private JTextField salaryField;
	private JTextField adressField;
	private JTextField routeField;

	/**
	 * Create the dialog.
	 */
	public DriverAdd(BDlink bds, int mode, int id, Driver dv) {
		this.bds = bds;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("       First Name");
			lblNewLabel.setBounds(11, 14, 85, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			fnameField = new JTextField();
			fnameField.setBackground(new Color(245, 245, 245));
			fnameField.setBounds(97, 11, 334, 19);
			contentPanel.add(fnameField);
			fnameField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("      Last Name");
			lblNewLabel_1.setBounds(13, 39, 83, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lnameField = new JTextField();
			lnameField.setBackground(new Color(245, 245, 245));
			lnameField.setBounds(97, 36, 334, 19);
			contentPanel.add(lnameField);
			lnameField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Age");
			lblNewLabel_2.setBounds(43, 64, 53, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			ageField = new JTextField();
			ageField.setBackground(new Color(245, 245, 245));
			ageField.setBounds(97, 61, 334, 19);
			contentPanel.add(ageField);
			ageField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("   Salary");
			lblNewLabel_3.setBounds(32, 89, 64, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			salaryField = new JTextField();
			salaryField.setBackground(new Color(245, 245, 245));
			salaryField.setBounds(97, 86, 334, 19);
			contentPanel.add(salaryField);
			salaryField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("   Adress");
			lblNewLabel_4.setBounds(30, 114, 66, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			adressField = new JTextField();
			adressField.setBackground(new Color(245, 245, 245));
			adressField.setBounds(97, 111, 334, 19);
			contentPanel.add(adressField);
			adressField.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("    Route ID");
			lblNewLabel_5.setBounds(22, 139, 74, 13);
			contentPanel.add(lblNewLabel_5);
		}
		{
			routeField = new JTextField();
			routeField.setBackground(new Color(245, 245, 245));
			routeField.setBounds(97, 136, 334, 19);
			contentPanel.add(routeField);
			routeField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if (mode == 0) {
					JButton okButton = new JButton("Save");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (fnameField.getText().length() != 0 && lnameField.getText().length() != 0
									&& ageField.getText().length() != 0 && salaryField.getText().length() != 0
									&& adressField.getText().length() != 0 && routeField.getText().length() != 0) {
								Date date = new Date(5);
								Driver d = null;
								try {
									d = new Driver(fnameField.getText(), lnameField.getText(),
											Integer.parseInt(ageField.getText()), Integer.parseInt(salaryField.getText()),
											adressField.getText(), Integer.parseInt(routeField.getText()));
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try {
									bds.addDriver(d);
									JOptionPane.showMessageDialog(okButton, "Driver added succesfully.");
									setVisible(false);
									dispose();
								} catch (SQLException e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error saving driver.");
								}
							} else
								JOptionPane.showMessageDialog(okButton, "Invalid data entry.");
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				} else if (mode == 1) {
					fnameField.setText(dv.getNname());
					lnameField.setText(dv.getSurname());
					@SuppressWarnings("removal")
					Integer x = new Integer(dv.getAge());
					ageField.setText(x.toString());
					x = dv.getSalary();
					salaryField.setText(x.toString());
					adressField.setText(dv.getAdress());
					x = dv.getRouteid();
					routeField.setText(x.toString());
					
					JButton okButton = new JButton("Update");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (fnameField.getText().length() != 0 && lnameField.getText().length() != 0
									&& ageField.getText().length() != 0 && salaryField.getText().length() != 0
									&& adressField.getText().length() != 0 && routeField.getText().length() != 0) {
								Date date = new Date(5);
								Driver d = new Driver(fnameField.getText(), lnameField.getText(),
										Integer.parseInt(ageField.getText()), Integer.parseInt(salaryField.getText()),
										adressField.getText(), Integer.parseInt(routeField.getText()));
								try {
									bds.updateDriver(id, d);
									JOptionPane.showMessageDialog(okButton, "Employee updated succesfully.");
									setVisible(false);
									dispose();
								} catch (Exception e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error updating employee.");
								}
							} else
								JOptionPane.showMessageDialog(okButton, "Invalid data entry.");

						}
					});

					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
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
