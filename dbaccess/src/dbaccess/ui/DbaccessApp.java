package dbaccess.ui;
import dbaccess.dao.MieterDAO;
import dbaccess.core.Mieter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class DbaccessApp extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	private JTable table;
	private MieterDAO mieterDAO;
	private MieterTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DbaccessApp frame = new DbaccessApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DbaccessApp() {
		
		table = new JTable();
		try {
			mieterDAO = new MieterDAO();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		setTitle("Autovermietung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter mid");
		panel.add(lblNewLabel);
		
		searchTextField = new JTextField();
		panel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String mid = searchTextField.getText();
					List <Mieter> mieters = null;
					mieters = mieterDAO.searchMieter(mid);
					
//					for(Mieter tmieter : mieters) {
//						System.out.println(tmieter);
//					}
//					if(mid != null && mid.trim().length() > 0) {
//						mieter = mieterDAO.searchMieters(mid);
//					} else {
//						c
//					}
					
					model = new MieterTableModel(mieters);
					table.setModel(model);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(DbaccessApp.this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		panel.add(btnSearch);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		contentPane.add(table.getTableHeader(), BorderLayout.CENTER);
		
		scrollPane.setColumnHeaderView(table);
	}

}
