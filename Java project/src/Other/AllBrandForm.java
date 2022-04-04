package Other;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.AppManager;
import Main.BDlink;
import Main.MainView;
import Tables.BrandTableModel;
import Tables.Vehicle;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AllBrandForm extends JDialog {
	AppManager am;
	private final JPanel contentPanel = new JPanel();

	JComboBox brandCombo;
	JComboBox statusCombo;
	/**
	 * Create the dialog.
	 */
	public AllBrandForm(AppManager am, MainView mv) {
		this.am = am;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Brand");
			lblNewLabel.setBounds(36, 76, 45, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Status");
			lblNewLabel_1.setBounds(36, 122, 45, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			String[] brandOptions = {"Lamboghini", "Audi","Dacia", "Ferrari", "BMW", "Volkswagen", "Ford", "Renault", "Citroen", "Toyota"};
			brandCombo = new JComboBox(brandOptions);
			brandCombo.setBackground(new Color(250, 235, 215));
			brandCombo.setBounds(80, 72, 105, 21);
			contentPanel.add(brandCombo);
		}
		{
			String[] statusOptions = {"Parcat", "De vanzare", "De inchiriat", "In reparatii", "Ireparabil", "Indisponibil"};
			statusCombo = new JComboBox(statusOptions);
			statusCombo.setBackground(new Color(250, 235, 215));
			statusCombo.setBounds(80, 118, 105, 21);
			contentPanel.add(statusCombo);
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
						List<Vehicle> res = am.bd.getAllBrandCars(brandCombo.getSelectedItem().toString(), statusCombo.getSelectedItem().toString());
						
						
						AllBrandTableModel drmodel = new AllBrandTableModel(res);
						mv.table.setModel(drmodel);
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

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
