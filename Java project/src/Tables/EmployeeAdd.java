package Tables;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.BDlink;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class EmployeeAdd extends JDialog {
	BDlink bds;
	private final JPanel contentPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField ageField;
	private JTextField salaryField;
	private JTextField adressField;
	private JTextField roleField;
	private JTextField dateField;
	private JTextField lotField;

	/**
	 * Create the dialog.
	 */
	public EmployeeAdd(BDlink bds, int mode, int id, Employee em) {
		this.bds = bds;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(10, 33, 90, 13);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(10, 59, 90, 13);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(10, 82, 90, 13);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setBounds(10, 105, 90, 13);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Adress");
		lblNewLabel_5.setBounds(10, 128, 90, 13);
		contentPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Role");
		lblNewLabel_6.setBounds(10, 151, 90, 13);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Employment Date");
		lblNewLabel_7.setBounds(10, 174, 90, 13);
		contentPanel.add(lblNewLabel_7);

		fnameField = new JTextField();
		fnameField.setBackground(new Color(245, 245, 245));
		fnameField.setBounds(99, 30, 316, 19);
		contentPanel.add(fnameField);
		fnameField.setColumns(10);

		lnameField = new JTextField();
		lnameField.setBackground(new Color(245, 245, 245));
		lnameField.setBounds(99, 56, 316, 19);
		contentPanel.add(lnameField);
		lnameField.setColumns(10);

		ageField = new JTextField();
		ageField.setBackground(new Color(245, 245, 245));
		ageField.setBounds(99, 79, 316, 19);
		contentPanel.add(ageField);
		ageField.setColumns(10);

		salaryField = new JTextField();
		salaryField.setBackground(new Color(245, 245, 245));
		salaryField.setBounds(99, 102, 316, 19);
		contentPanel.add(salaryField);
		salaryField.setColumns(10);

		adressField = new JTextField();
		adressField.setBackground(new Color(245, 245, 245));
		adressField.setBounds(99, 125, 316, 19);
		contentPanel.add(adressField);
		adressField.setColumns(10);

		roleField = new JTextField();
		roleField.setBackground(new Color(245, 245, 245));
		roleField.setBounds(99, 148, 316, 19);
		contentPanel.add(roleField);
		roleField.setColumns(10);

		dateField = new JTextField();
		dateField.setBackground(new Color(245, 245, 245));
		dateField.setBounds(99, 171, 316, 19);
		contentPanel.add(dateField);
		dateField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Lot ID");
		lblNewLabel_8.setBounds(10, 197, 90, 13);
		contentPanel.add(lblNewLabel_8);

		lotField = new JTextField();
		lotField.setBackground(new Color(245, 245, 245));
		lotField.setBounds(98, 194, 317, 19);
		contentPanel.add(lotField);
		lotField.setColumns(10);
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
									&& adressField.getText().length() != 0 && roleField.getText().length() != 0
									&& dateField.getText().length() != 0 && lotField.getText().length() != 0) {
								Date date = new Date(5);
								Employee ep = null;
								try {
									ep = new Employee(fnameField.getText(), lnameField.getText(),
											Integer.parseInt(ageField.getText()), Integer.parseInt(salaryField.getText()),
											adressField.getText(), roleField.getText(),
											 date.valueOf(dateField.getText()), Integer.parseInt(lotField.getText()));
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try {
									bds.addEmployee(ep);
									JOptionPane.showMessageDialog(okButton, "Employee added succesfully.");
									setVisible(false);
									dispose();
								} catch (SQLException e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error saving employee.");
								}
							} else
								JOptionPane.showMessageDialog(okButton, "Invalid data entry.");
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				} else if (mode == 1) {
					fnameField.setText(em.getNname());
					lnameField.setText(em.getSurname());
					@SuppressWarnings("removal")
					Integer x = new Integer(em.getAge());
					ageField.setText(x.toString());
					x = em.getSalary();
					salaryField.setText(x.toString());
					adressField.setText(em.getAdress());
					roleField.setText(em.getEmp_role());
					Date dt = em.getEmp_date();
					dateField.setText(dt.toString());
					x = em.getLotid();
					lotField.setText(x.toString());
					
					JButton okButton = new JButton("Update");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (fnameField.getText().length() != 0 && lnameField.getText().length() != 0
									&& ageField.getText().length() != 0 && salaryField.getText().length() != 0
									&& adressField.getText().length() != 0 && roleField.getText().length() != 0
									&& dateField.getText().length() != 0 && lotField.getText().length() != 0) {
								Date date = new Date(5);
								Employee ep = new Employee(fnameField.getText(), lnameField.getText(),
										Integer.parseInt(ageField.getText()), Integer.parseInt(salaryField.getText()),
										adressField.getText(), roleField.getText(),
										 date .valueOf(dateField.getText()), Integer.parseInt(lotField.getText()));
								try {
									bds.updateEmployee(id, ep);
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
