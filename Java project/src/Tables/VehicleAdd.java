package Tables;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VehicleAdd extends JDialog {
	BDlink bds;
	private final JPanel contentPanel = new JPanel();
	private JTextField nbField;
	private JTextField brandField;
	private JTextField kmField;
	private JTextField statusField;
	private JTextField lotField;
	private JTextField driverField;
	private JTextField fuelDateField;
	private JTextField fuelField;
	private JTextField yearField;

	/**
	 * Create the dialog.
	 */
	public VehicleAdd(BDlink bds, int mode, int id, Vehicle vh) {
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
			JLabel nbLabel = new JLabel("Registration Number");
			nbLabel.setBounds(5, 13, 110, 13);
			contentPanel.add(nbLabel);
		}
		{
			nbField = new JTextField();
			nbField.setBackground(new Color(245, 245, 245));
			nbField.setBounds(120, 10, 300, 20);
			contentPanel.add(nbField);
			nbField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Brand ID");
			lblNewLabel.setBounds(5, 37, 110, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			brandField = new JTextField();
			brandField.setBackground(new Color(245, 245, 245));
			brandField.setBounds(120, 35, 300, 20);
			contentPanel.add(brandField);
			brandField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Kilometers");
			lblNewLabel_1.setBounds(5, 62, 110, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			kmField = new JTextField();
			kmField.setBackground(new Color(245, 245, 245));
			kmField.setBounds(120, 60, 300, 20);
			contentPanel.add(kmField);
			kmField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Status ID");
			lblNewLabel_2.setBounds(5, 85, 110, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			statusField = new JTextField();
			statusField.setBackground(new Color(245, 245, 245));
			statusField.setBounds(120, 85, 300, 20);
			contentPanel.add(statusField);
			statusField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Lot ID");
			lblNewLabel_3.setBounds(5, 112, 110, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lotField = new JTextField();
			lotField.setBackground(new Color(245, 245, 245));
			lotField.setBounds(120, 110, 300, 20);
			contentPanel.add(lotField);
			lotField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Driver ID");
			lblNewLabel_4.setBounds(5, 137, 110, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Fuel Date");
			lblNewLabel_5.setBounds(5, 162, 110, 13);
			contentPanel.add(lblNewLabel_5);
		}
		{
			fuelDateField = new JTextField();
			fuelDateField.setBackground(new Color(245, 245, 245));
			fuelDateField.setBounds(120, 160, 300, 20);
			contentPanel.add(fuelDateField);
			fuelDateField.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Fuel");
			lblNewLabel_7.setBounds(5, 187, 110, 13);
			contentPanel.add(lblNewLabel_7);
		}
		{
			fuelField = new JTextField();
			fuelField.setBackground(new Color(245, 245, 245));
			fuelField.setBounds(120, 185, 300, 20);
			contentPanel.add(fuelField);
			fuelField.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Year");
			lblNewLabel_8.setBounds(5, 212, 110, 13);
			contentPanel.add(lblNewLabel_8);
		}
		{
			yearField = new JTextField();
			yearField.setBackground(new Color(245, 245, 245));
			yearField.setBounds(120, 211, 300, 20);
			contentPanel.add(yearField);
			yearField.setColumns(10);
		}
		{
			driverField = new JTextField();
			driverField.setBackground(new Color(245, 245, 245));
			driverField.setBounds(120, 135, 300, 20);
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
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString = fuelDateField.getText();
							Date date = new Date(5);

							if (nbField.getText().length() != 0 && brandField.getText().length() != 0
									&& kmField.getText().length() != 0 && statusField.getText().length() != 0
									&& lotField.getText().length() != 0 && driverField.getText().length() != 0
									&& fuelField.getText().length() != 0 && yearField.getText().length() != 0) {
								Vehicle v = new Vehicle(nbField.getText(), Integer.parseInt(brandField.getText()),
										Integer.parseInt(kmField.getText()), Integer.parseInt(statusField.getText()),
										Integer.parseInt(lotField.getText()), Integer.parseInt(driverField.getText()),
										date.valueOf(fuelDateField.getText()), Integer.parseInt(fuelField.getText()),
										Integer.parseInt(yearField.getText()));
								try {
									bds.addVehicle(v);
									JOptionPane.showMessageDialog(okButton, "Vehicle added succesfully.");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(okButton, "Error adding vehicle.");
								}
								setVisible(false);
								dispose();
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
				if (mode == 1) {
					nbField.setText(vh.getNb());
					Integer x = vh.getBrandid();
					brandField.setText(x.toString());
					x = vh.getKm();
					kmField.setText(x.toString());
					x = vh.getStatusid();
					statusField.setText(x.toString());
					x = vh.getLotid();
					lotField.setText(x.toString());
					x = vh.getDriverid();
					driverField.setText(x.toString());
					Date dt = vh.getFuel_date();
					fuelDateField.setText(dt.toString());
					x = vh.getFuel();
					fuelField.setText(x.toString());
					x = vh.getOut_year();
					yearField.setText(x.toString());
					JButton okButton = new JButton("Update");
					okButton.setBackground(new Color(250, 235, 215));
					okButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							Date date = new Date(5);

							Vehicle v = new Vehicle(nbField.getText(), Integer.parseInt(brandField.getText()),
									Integer.parseInt(kmField.getText()), Integer.parseInt(statusField.getText()),
									Integer.parseInt(lotField.getText()), Integer.parseInt(driverField.getText()), date.valueOf(fuelDateField.getText()),
									Integer.parseInt(fuelField.getText()), Integer.parseInt(yearField.getText()));
							try {
								bds.updateVehicle(id, v);
								JOptionPane.showMessageDialog(okButton, "Vehicle updated succesfully.");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(okButton, "Error updating vehicle.");
							}
							setVisible(false);
							dispose();
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
