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
import java.awt.event.ActionEvent;

public class RefillAdd extends JDialog {
	BDlink bds;
	private final JPanel contentPanel = new JPanel();
	private JTextField nbField;
	private JTextField fuelField;
	private JTextField dateField;
	private JTextField kmField;
	private JTextField driverField;

	/**
	 * Create the dialog.
	 */
	public RefillAdd(BDlink bds, int mode, int id, Alimentare al) {
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
			JLabel lblNewLabel = new JLabel("Registration Number");
			lblNewLabel.setBounds(10, 29, 124, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Fuel");
			lblNewLabel_1.setBounds(10, 52, 124, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Fueling Date");
			lblNewLabel_2.setBounds(10, 75, 124, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Kilometers");
			lblNewLabel_3.setBounds(10, 98, 96, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Driver ID");
			lblNewLabel_4.setBounds(10, 120, 96, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			nbField = new JTextField();
			nbField.setBackground(new Color(245, 245, 245));
			nbField.setBounds(132, 26, 294, 19);
			contentPanel.add(nbField);
			nbField.setColumns(10);
		}
		{
			fuelField = new JTextField();
			fuelField.setBackground(new Color(245, 245, 245));
			fuelField.setBounds(132, 49, 294, 19);
			contentPanel.add(fuelField);
			fuelField.setColumns(10);
		}
		{
			dateField = new JTextField();
			dateField.setBackground(new Color(245, 245, 245));
			dateField.setBounds(132, 72, 294, 19);
			contentPanel.add(dateField);
			dateField.setColumns(10);
		}
		{
			kmField = new JTextField();
			kmField.setBackground(new Color(245, 245, 245));
			kmField.setBounds(132, 95, 294, 19);
			contentPanel.add(kmField);
			kmField.setColumns(10);
		}
		{
			driverField = new JTextField();
			driverField.setBackground(new Color(245, 245, 245));
			driverField.setBounds(132, 118, 294, 19);
			contentPanel.add(driverField);
			driverField.setColumns(10);
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
							if (nbField.getText().length() != 0 && fuelField.getText().length() != 0
									&& dateField.getText().length() != 0 && kmField.getText().length() != 0
									&& driverField.getText().length() != 0 ) {
								Date date = new Date(5);
								Alimentare a = null;
								try {
									a = new Alimentare(nbField.getText(), Integer.parseInt(fuelField.getText()),
											date.valueOf(dateField.getText()), Integer.parseInt(kmField.getText()), 
											Integer.parseInt(driverField.getText()));
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try {
									bds.addRefill(a);
									JOptionPane.showMessageDialog(okButton, "Refill added succesfully.");
									setVisible(false);
									dispose();
								} catch (SQLException e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error saving refill.");
								}
							} else
								JOptionPane.showMessageDialog(okButton, "Invalid data entry.");
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				} else if (mode == 1) {
					nbField.setText(al.getNr());
					Integer x = new Integer(al.getFuel());
					fuelField.setText(x.toString());
					@SuppressWarnings("removal")
					Date dt = al.getFueling_date();
					dateField.setText(dt.toString());
					x = new Integer(al.getKm());
					kmField.setText(x.toString());
					x = al.getDriverid();
					driverField.setText(x.toString());
					
					JButton okButton = new JButton("Update");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (nbField.getText().length() != 0 && fuelField.getText().length() != 0
									&& dateField.getText().length() != 0 && kmField.getText().length() != 0
									&& driverField.getText().length() != 0 ) {
								Date date = new Date(5);
								Alimentare a = new Alimentare(nbField.getText(), Integer.parseInt(fuelField.getText()),
										date.valueOf(dateField.getText()), Integer.parseInt(kmField.getText()), 
										Integer.parseInt(driverField.getText()));
								try {
									bds.updateRefill(id, a);
									JOptionPane.showMessageDialog(okButton, "Refill updated succesfully.");
									setVisible(false);
									dispose();
								} catch (Exception e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error updating refill.");
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
