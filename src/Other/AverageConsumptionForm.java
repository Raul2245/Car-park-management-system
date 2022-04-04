package Other;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.AppManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AverageConsumptionForm extends JDialog {
	AppManager am;
	private final JPanel contentPanel = new JPanel();
	private JTextField driverField;

	/**
	 * Create the dialog.
	 */
	public AverageConsumptionForm(AppManager am) {
		this.am = am;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Driver ID");
		lblNewLabel.setBounds(24, 35, 85, 13);
		contentPanel.add(lblNewLabel);

		driverField = new JTextField();
		driverField.setBackground(new Color(245, 245, 245));
		driverField.setBounds(130, 32, 96, 19);
		contentPanel.add(driverField);
		driverField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Average Consumption:");
		lblNewLabel_1.setBounds(24, 79, 174, 19);
		contentPanel.add(lblNewLabel_1);

		JLabel avgConsum = new JLabel("0");
		avgConsum.setBounds(161, 82, 227, 13);
		contentPanel.add(avgConsum);

		JButton btnNewButton = new JButton("Get Average");
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				am.adm.makeConnection("Admin", "admdtbs123");

				CallableStatement st = null;
				try {

					st = am.adm.connection.prepareCall("CALL consum_mediu(?, ?);");
					st.setInt(1, Integer.parseInt(driverField.getText()));
					st.registerOutParameter(2, Types.DOUBLE);
					st.execute();

					double res = st.getDouble(2);

					
					avgConsum.setText(Double.toString(res));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						st.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(236, 31, 121, 21);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("L/km");
		lblNewLabel_2.setBounds(236, 82, 45, 13);
		contentPanel.add(lblNewLabel_2);
	}
}
