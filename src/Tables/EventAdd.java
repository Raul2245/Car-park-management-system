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

public class EventAdd extends JDialog {
	BDlink bds;
	private final JPanel contentPanel = new JPanel();
	private JTextField eventField;
	private JTextField employeeField;
	private JTextField dateField;
	private JTextField nbField;

	/**
	 * Create the dialog.
	 */
	public EventAdd(BDlink bds, int mode, int id, Lot_event le) {
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
			JLabel lblNewLabel_1 = new JLabel("Event ID");
			lblNewLabel_1.setBounds(10, 70, 96, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Employee ID");
			lblNewLabel_2.setBounds(10, 93, 96, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Event Date");
			lblNewLabel_3.setBounds(10, 116, 96, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			eventField = new JTextField();
			eventField.setBackground(new Color(245, 245, 245));
			eventField.setBounds(143, 67, 271, 19);
			contentPanel.add(eventField);
			eventField.setColumns(10);
		}
		{
			employeeField = new JTextField();
			employeeField.setBackground(new Color(245, 245, 245));
			employeeField.setBounds(143, 90, 271, 19);
			contentPanel.add(employeeField);
			employeeField.setColumns(10);
		}
		{
			dateField = new JTextField();
			dateField.setBackground(new Color(245, 245, 245));
			dateField.setBounds(143, 113, 271, 19);
			contentPanel.add(dateField);
			dateField.setColumns(10);
		}
		
		nbField = new JTextField();
		nbField.setBackground(new Color(245, 245, 245));
		nbField.setBounds(143, 136, 271, 19);
		contentPanel.add(nbField);
		nbField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Vehicle Number");
		lblNewLabel_4.setBounds(10, 139, 123, 13);
		contentPanel.add(lblNewLabel_4);
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
							if (nbField.getText().length() != 0 && eventField.getText().length() != 0
									&& employeeField.getText().length() != 0 && dateField.getText().length() != 0) {
								Date date = new Date(5);
								Lot_event l = null;
								try {
									l = new Lot_event(
											0, Integer.parseInt(eventField.getText()), 
											Integer.parseInt(employeeField.getText()),date.valueOf(dateField.getText()) );
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
									JOptionPane.showMessageDialog(okButton, e2);
								}
								try {
									bds.addEvent(l, nbField.getText());
									JOptionPane.showMessageDialog(okButton, "Event added succesfully.");
									setVisible(false);
									dispose();
								} catch (SQLException e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, e1);
								}
							} else
								JOptionPane.showMessageDialog(okButton, "Invalid data entry.");
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				} else if (mode == 1) {
					Integer x = new Integer(le.getLotid());
					nbField.setText(x.toString());
					x = new Integer(le.getEventid());
					eventField.setText(x.toString());
					x = new Integer(le.getEmp_id());
					employeeField.setText(x.toString());
					Date dt = le.getEv_date();
					dateField.setText(dt.toString());
					
					JButton okButton = new JButton("Update");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (nbField.getText().length() != 0 && eventField.getText().length() != 0
									&& employeeField.getText().length() != 0 && dateField.getText().length() != 0) {
								Date date = new Date(5);
								Lot_event l = new Lot_event(
										0, Integer.parseInt(eventField.getText()), 
										Integer.parseInt(employeeField.getText()),date.valueOf(dateField.getText()) );
								try {
									bds.updateEvent(id, l);
									JOptionPane.showMessageDialog(okButton, "Event updated succesfully.");
									setVisible(false);
									dispose();
								} catch (Exception e1) {
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error updating event.");
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
