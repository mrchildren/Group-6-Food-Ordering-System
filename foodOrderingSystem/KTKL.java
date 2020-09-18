import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.sql.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KTKL{

	private JFrame frame;
	private Connection conn;
	private JTable ALA_TABLE;
	private JTable COMBO_TABLE;
	private JTable CART_TABLE;
	private int tick;
	private int orderid;
	private JButton B_TABLE1,B_TABLE2,B_TABLE3,B_TABLE4,B_TABLE5,B_TABLE6,B_TABLE7,B_TABLE8,B_TABLE9;
	private JButton DEVT1,DEVT2,DEVT3,DEVT4,DEVT5,DEVT6,DEVT7,DEVT8,DEVT9;
	private JButton STAR1,STAR2,STAR3,STAR4,STAR5;
	private JTextArea MENU_DESC;
	private JLabel CART_PRICE,CART_QTY,CART_ID,PAYMENT_TOTAL,orderlabel,timenext;
	private JLabel DEVL1,DEVL2,DEVL3,DEVL4,DEVL5,DEVL6,DEVL7,DEVL8,DEVL9,MENU_IMG,CART_IMG,DESTI,tebel;
	private JTextField DEVNAME;
	private JTextField DEVDESC;
	private JTextField DEVPRICE;
	private JTextField DEVDIR;
	private int tablechosed,payment,FBCK;
	private JTable FB_TABLE;
	private JTextField customsql;
	private JTable customtable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					try {
			            //here you can put the selected theme class name in JTattoo
			            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.MintLookAndFeel");

			        } catch (ClassNotFoundException ex) {
			            java.util.logging.Logger.getLogger(KTKL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (InstantiationException ex) {
			            java.util.logging.Logger.getLogger(KTKL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (IllegalAccessException ex) {
			            java.util.logging.Logger.getLogger(KTKL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			            java.util.logging.Logger.getLogger(KTKL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        }
					
					KTKL window = new KTKL();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KTKL() {
		
		
		try {
			conn = DriverManager.getConnection("jdbc:h2:./DB", "sa", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FBCK=0;
		tablechosed=0;
		tick=10;
		frame = new JFrame();
		frame.setBounds(100, 100, 1086, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setFont(new Font("Arial Black", Font.PLAIN, 26));
		tabbedPane.setBounds(12, 13, 1056, 592);
		frame.getContentPane().add(tabbedPane);
		try {
			ResultSet od = conn.prepareStatement("SELECT * FROM oorder ORDER BY o_id DESC LIMIT 1;").executeQuery();
			while(od.next()) {
				orderid=od.getInt(1);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab(" WELCOME ", null, panel, null);
		tabbedPane.setEnabledAt(0, false);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(" TABLES ", null, panel_1, null);
		tabbedPane.setEnabledAt(1, false);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(569, 64, 37, 38);
		panel_1.add(lblNewLabel_2);
		
		B_TABLE1 = new JButton("");
		B_TABLE1.setBorderPainted(false);
		B_TABLE1.setBorder(null);
		B_TABLE1.setContentAreaFilled(false);
		B_TABLE1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE1.setBounds(561, 115, 64, 64);
		panel_1.add(B_TABLE1);
		
		B_TABLE2 = new JButton("");
		B_TABLE2.setBorderPainted(false);
		B_TABLE2.setBorder(null);
		B_TABLE2.setContentAreaFilled(false);
		B_TABLE2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE2.setBounds(671, 115, 64, 64);
		panel_1.add(B_TABLE2);
		
		B_TABLE3 = new JButton("");
		B_TABLE3.setBorderPainted(false);
		B_TABLE3.setBorder(null);
		B_TABLE3.setContentAreaFilled(false);
		B_TABLE3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE3.setBounds(793, 115, 64, 64);
		panel_1.add(B_TABLE3);
		
		B_TABLE4 = new JButton("");
		B_TABLE4.setBorderPainted(false);
		B_TABLE4.setBorder(null);
		B_TABLE4.setContentAreaFilled(false);
		B_TABLE4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE4.setBounds(901, 115, 64, 64);
		panel_1.add(B_TABLE4);
		
		B_TABLE5 = new JButton("");
		B_TABLE5.setBorderPainted(false);
		B_TABLE5.setBorder(null);
		B_TABLE5.setContentAreaFilled(false);
		B_TABLE5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE5.setBounds(618, 271, 64, 64);
		panel_1.add(B_TABLE5);

		B_TABLE6 = new JButton("");
		B_TABLE6.setBounds(844, 271, 64, 64);
		B_TABLE6.setBorderPainted(false);
		B_TABLE6.setBorder(null);
		B_TABLE6.setContentAreaFilled(false);
		B_TABLE6.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		panel_1.add(B_TABLE6);

		B_TABLE7 = new JButton("");
		B_TABLE7.setBorderPainted(false);
		B_TABLE7.setBorder(null);
		B_TABLE7.setContentAreaFilled(false);
		B_TABLE7.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE7.setBounds(580, 441, 64, 64);
		panel_1.add(B_TABLE7);

		B_TABLE8 = new JButton("");
		B_TABLE8.setBorderPainted(false);
		B_TABLE8.setBorder(null);
		B_TABLE8.setContentAreaFilled(false);
		B_TABLE8.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE8.setBounds(735, 441, 64, 64);
		panel_1.add(B_TABLE8);

		B_TABLE9 = new JButton("");
		B_TABLE9.setBorderPainted(false);
		B_TABLE9.setBorder(null);
		B_TABLE9.setContentAreaFilled(false);
		B_TABLE9.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
		B_TABLE9.setBounds(889, 441, 64, 64);
		panel_1.add(B_TABLE9);

		
		JButton B_TABLE_PREV = new JButton("");
		B_TABLE_PREV.setBorderPainted(false);
		B_TABLE_PREV.setBorder(null);
		B_TABLE_PREV.setContentAreaFilled(false);
		B_TABLE_PREV.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		B_TABLE_PREV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		B_TABLE_PREV.setBounds(64, 421, 64, 64);
		panel_1.add(B_TABLE_PREV);
		
		JLabel label_3 = new JLabel("2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_3.setBounds(684, 64, 37, 38);
		panel_1.add(label_3);
		
		JLabel label_5 = new JLabel("3");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_5.setBounds(803, 64, 37, 38);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("4");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_6.setBounds(916, 64, 37, 38);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("5");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_7.setBounds(638, 348, 37, 38);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("6");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_8.setBounds(864, 348, 37, 38);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("7");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_9.setBounds(588, 403, 37, 38);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("8");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_10.setBounds(747, 403, 37, 38);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("9");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label_11.setBounds(901, 403, 37, 38);
		panel_1.add(label_11);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/LAYOUT2.JPG")));
		lblNewLabel.setBounds(0, 0, 1051, 541);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
				refresh_table();
			}
		});
		btnNewButton_1.setBounds(966, 470, 73, 58);

		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		panel.add(btnNewButton_1);
		
		JButton btnDinein = new JButton("DINE-IN");
		btnDinein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh_table();
				
				if(DEVT1.getBackground()==Color.red && DEVT2.getBackground()==Color.red && DEVT3.getBackground()==Color.red && DEVT4.getBackground()==Color.red && 
						DEVT5.getBackground()==Color.red && DEVT6.getBackground()==Color.red && DEVT7.getBackground()==Color.red && DEVT8.getBackground()==Color.red && DEVT9.getBackground()==Color.red)
				{JOptionPane.showMessageDialog(frame, "There are no available table at the moment!","Sorry!",2);}
				else {tabbedPane.setSelectedIndex(1);}
				
				
			}
		});
		btnDinein.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnDinein.setBounds(157, 331, 289, 64);
		panel.add(btnDinein);
		
		JButton btnTakeaway = new JButton("TAKEAWAY");
		btnTakeaway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=0;
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnTakeaway.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnTakeaway.setBounds(603, 331, 289, 64);
		panel.add(btnTakeaway);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/welc.png")));
		lblNewLabel_1.setBounds(12, 13, 1027, 305);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" MENU ", null, panel_2, null);
		tabbedPane.setEnabledAt(2, false);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		tabbedPane_1.setBounds(12, 13, 715, 515);
		panel_2.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab(" COMBO ", null, scrollPane_1, null);
		
		COMBO_TABLE = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    COMBO_TABLE.getTableHeader().setReorderingAllowed(false);
		COMBO_TABLE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ResultSet rs = conn.prepareStatement("select desc,IMGDIR from products where p_id="+COMBO_TABLE.getValueAt(COMBO_TABLE.getSelectedRow(), 0)+";").executeQuery();
					while(rs.next()) {
						MENU_DESC.setText(rs.getString(1));
						
						MENU_IMG.setIcon(new ImageIcon(".\\IMG\\"+rs.getString(2)+""));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		COMBO_TABLE.setFont(new Font("Arial Black", Font.PLAIN, 20));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		COMBO_TABLE.setDefaultRenderer(String.class, centerRenderer);
		COMBO_TABLE.setRowHeight(30);
		
		scrollPane_1.setViewportView(COMBO_TABLE);
		
		B_TABLE1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=1;
				if(DEVT1.getBackground()==Color.GREEN) {tablechosed=1;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=2;
				if(DEVT2.getBackground()==Color.GREEN) {tablechosed=2;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=3;
				if(DEVT3.getBackground()==Color.GREEN) {tablechosed=3;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=4;
				if(DEVT4.getBackground()==Color.GREEN) {tablechosed=4;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tablechosed=5;
				if(DEVT5.getBackground()==Color.GREEN) {tablechosed=5;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=6;
				if(DEVT6.getBackground()==Color.GREEN) {tablechosed=6;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=7;
				if(DEVT7.getBackground()==Color.GREEN) {tablechosed=7;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=8;
				if(DEVT8.getBackground()==Color.GREEN) {tablechosed=8;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});

		B_TABLE9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablechosed=9;
				if(DEVT9.getBackground()==Color.GREEN) {tablechosed=9;tabbedPane.setSelectedIndex(2);}
				else {JOptionPane.showMessageDialog(frame, "This table is unavailable!","Sorry!",2);}
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_1.addTab(" ALA - CARTE ", null, scrollPane_2, null);
		
		ALA_TABLE = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    ALA_TABLE.getTableHeader().setReorderingAllowed(false);
		ALA_TABLE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ResultSet rs = conn.prepareStatement("select desc,IMGDIR from products where p_id="+ALA_TABLE.getValueAt(ALA_TABLE.getSelectedRow(), 0)+";").executeQuery();
					while(rs.next()) {
						MENU_DESC.setText(rs.getString(1));
						
						MENU_IMG.setIcon(new ImageIcon(".\\IMG\\"+rs.getString(2)+""));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
			}
		});
		ALA_TABLE.setFont(new Font("Arial Black", Font.PLAIN, 20));
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		ALA_TABLE.setDefaultRenderer(String.class, centerRenderer);
		ALA_TABLE.setRowHeight(30);
		scrollPane_2.setViewportView(ALA_TABLE);
		
		MENU_IMG = new JLabel("");
		MENU_IMG.setIcon(null);
		MENU_IMG.setBounds(739, 13, 300, 300);
		panel_2.add(MENU_IMG);
		
		JButton B_MENU_CART = new JButton("");
		B_MENU_CART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tabbedPane_1.getSelectedIndex()==1) {
						conn.createStatement().execute("insert into cart(qty, p_id, o_id) values (1,"+ALA_TABLE.getValueAt(ALA_TABLE.getSelectedRow(), 0)+","+orderid+");");
						refresh();
					}else {
						conn.createStatement().execute("insert into cart(qty, p_id, o_id) values (1,"+COMBO_TABLE.getValueAt(COMBO_TABLE.getSelectedRow(), 0)+","+orderid+");");
						refresh();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				MENU_DESC.setText("");
				MENU_IMG.setIcon(null);
				CART_IMG.setIcon(null);
				CART_QTY.setText("");
			}
		});
		B_MENU_CART.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/ADD TO CART.png")));
		B_MENU_CART.setBounds(856, 425, 64, 64);
		B_MENU_CART.setBorderPainted(false);
		B_MENU_CART.setBorder(null);
		B_MENU_CART.setContentAreaFilled(false);
		panel_2.add(B_MENU_CART);
		
		JButton B_MENU_NEXT = new JButton("");
		B_MENU_NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double y=0;
				tabbedPane.setSelectedIndex(3);
				try {
					ResultSet rs = conn.prepareStatement("SELECT products.p_id, products.name ,cart.qty, products.price, (cart.qty*products.price) as sub from cart inner join products where cart.o_id="+orderid+" and cart.p_id=products.p_id;").executeQuery();
					while(rs.next()) {
						y=y+(rs.getInt(3)*rs.getDouble(4));
					}CART_PRICE.setText(Double.toString(y));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				MENU_DESC.setText("");
				MENU_IMG.setIcon(null);
				CART_IMG.setIcon(null);
				CART_QTY.setText("");

				ALA_TABLE.clearSelection();
				COMBO_TABLE.clearSelection();
				CART_TABLE.clearSelection();
			}
		});
		B_MENU_NEXT.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/NEXT.png")));
		B_MENU_NEXT.setBounds(975, 464, 64, 64);
		B_MENU_NEXT.setBorderPainted(false);
		B_MENU_NEXT.setBorder(null);
		B_MENU_NEXT.setContentAreaFilled(false);
		panel_2.add(B_MENU_NEXT);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		button_1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBounds(739, 464, 64, 64);
		panel_2.add(button_1);
		
		MENU_DESC = new JTextArea();
		MENU_DESC.setWrapStyleWord(true);
		MENU_DESC.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MENU_DESC.setLineWrap(true);
		MENU_DESC.setEnabled(false);
		MENU_DESC.setEditable(false);
		MENU_DESC.setBounds(739, 326, 300, 86);
		panel_2.add(MENU_DESC);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab(" CART ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		tabbedPane_2.setBounds(12, 13, 715, 473);
		panel_3.add(tabbedPane_2);
		
		JScrollPane CARTITEM = new JScrollPane();
		tabbedPane_2.addTab("ITEM", null, CARTITEM, null);
		
		CART_TABLE = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    CART_TABLE.getTableHeader().setReorderingAllowed(false);
	    
		CART_TABLE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CART_QTY.setText(CART_TABLE.getValueAt(CART_TABLE.getSelectedRow(), 2).toString());
				CART_ID.setText(CART_TABLE.getValueAt(CART_TABLE.getSelectedRow(), 0).toString());
				
				ResultSet rs;
				try {
					rs = conn.prepareStatement("select imgdir from products where p_id="+CART_ID.getText()+";").executeQuery();
					while(rs.next()) {
						CART_IMG.setIcon(new ImageIcon(".\\IMG\\"+rs.getString(1)+""));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		CART_TABLE.setFont(new Font("Arial Black", Font.PLAIN, 20));
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		CART_TABLE.setDefaultRenderer(String.class, centerRenderer);
		CART_TABLE.setRowHeight(30);
		CARTITEM.setViewportView(CART_TABLE);
		
		CART_IMG = new JLabel("");
		CART_IMG.setBounds(739, 13, 300, 300);
		panel_3.add(CART_IMG);
		
		JButton B_CART_MINUS = new JButton("");
		B_CART_MINUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(CART_QTY.getText())!=1) {
					try {
						conn.createStatement().execute("update cart set qty="+Integer.toString((Integer.parseInt(CART_QTY.getText())-1))+" where cart.p_id="+CART_ID.getText()+" AND o_ID = "+orderid+";");
						CART_QTY.setText(Integer.toString((Integer.parseInt(CART_QTY.getText())-1)));
						refresh();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					double y=0;
					try {
						ResultSet rs = conn.prepareStatement("SELECT products.p_id, products.name ,cart.qty, products.price, (cart.qty*products.price) as sub from cart inner join products where cart.o_id="+orderid+" and cart.p_id=products.p_id;").executeQuery();
						while(rs.next()) {
							y=y+(rs.getInt(3)*rs.getDouble(4));
						}CART_PRICE.setText(Double.toString(y));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		B_CART_MINUS.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/MINUS.png")));
		B_CART_MINUS.setBounds(776, 368, 64, 64);
		B_CART_MINUS.setBorderPainted(false);
		B_CART_MINUS.setBorder(null);
		B_CART_MINUS.setContentAreaFilled(false);
		panel_3.add(B_CART_MINUS);
		
		JButton B_CART_ADD = new JButton("");
		B_CART_ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.createStatement().execute("update cart set qty="+Integer.toString((Integer.parseInt(CART_QTY.getText())+1))+" where cart.p_id="+CART_ID.getText()+" AND o_ID = "+orderid+";");
					CART_QTY.setText(Integer.toString((Integer.parseInt(CART_QTY.getText())+1)));
					refresh();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				double y=0;
				try {
					ResultSet rs = conn.prepareStatement("SELECT products.p_id, products.name ,cart.qty, products.price, (cart.qty*products.price) as sub from cart inner join products where cart.o_id="+orderid+" and cart.p_id=products.p_id;").executeQuery();
					while(rs.next()) {
						y=y+(rs.getInt(3)*rs.getDouble(4));
					}CART_PRICE.setText(Double.toString(y));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		B_CART_ADD.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/ADD.png")));
		B_CART_ADD.setBounds(935, 368, 64, 64);
		B_CART_ADD.setBorderPainted(false);
		B_CART_ADD.setBorder(null);
		B_CART_ADD.setContentAreaFilled(false);
		panel_3.add(B_CART_ADD);
		
		JButton B_CART_NEXT = new JButton("");
		B_CART_NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(CART_PRICE.getText())>1) {
					PAYMENT_TOTAL.setText("RM "+CART_PRICE.getText());
					tabbedPane.setSelectedIndex(4);
				}else {
					JOptionPane.showMessageDialog(frame, "Your Cart Is Empty!","Sorry!",2);
				}
			}
		});
		B_CART_NEXT.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/NEXT.png")));
		B_CART_NEXT.setBounds(975, 464, 64, 64);
		B_CART_NEXT.setBorderPainted(false);
		B_CART_NEXT.setBorder(null);
		B_CART_NEXT.setContentAreaFilled(false);
		panel_3.add(B_CART_NEXT);
		
		JButton B_CART_REMOVE = new JButton("");
		B_CART_REMOVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.createStatement().execute("delete from cart where p_id="+CART_ID.getText()+" and o_id="+orderid+";");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				refresh();
				double y=0;
				tabbedPane.setSelectedIndex(3);
				try {
					ResultSet rs = conn.prepareStatement("SELECT products.p_id, products.name ,cart.qty, products.price, (cart.qty*products.price) as sub from cart inner join products where cart.o_id="+orderid+" and cart.p_id=products.p_id;").executeQuery();
					while(rs.next()) {
						y=y+(rs.getInt(3)*rs.getDouble(4));
					}CART_PRICE.setText(Double.toString(y));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				MENU_DESC.setText("");
				MENU_IMG.setIcon(null);
				CART_IMG.setIcon(null);
				CART_QTY.setText("");
			}
		});
		B_CART_REMOVE.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/REMOVE.png")));
		B_CART_REMOVE.setBounds(860, 464, 64, 64);
		B_CART_REMOVE.setBorderPainted(false);
		B_CART_REMOVE.setBorder(null);
		B_CART_REMOVE.setContentAreaFilled(false);
		panel_3.add(B_CART_REMOVE);
		
		JButton B_CART_PREV = new JButton("");
		B_CART_PREV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
				MENU_DESC.setText("");
				MENU_IMG.setIcon(null);
				CART_IMG.setIcon(null);
				CART_QTY.setText("");
				ALA_TABLE.clearSelection();
				COMBO_TABLE.clearSelection();
				CART_TABLE.clearSelection();
			}
			
		});
		B_CART_PREV.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		B_CART_PREV.setBounds(739, 464, 64, 64);
		B_CART_PREV.setBorderPainted(false);
		B_CART_PREV.setBorder(null);
		B_CART_PREV.setContentAreaFilled(false);
		panel_3.add(B_CART_PREV);
		
		JLabel lblGrandTotal = new JLabel("GRAND TOTAL : RM");
		lblGrandTotal.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblGrandTotal.setBounds(193, 499, 322, 29);
		panel_3.add(lblGrandTotal);
		
		CART_PRICE = new JLabel("0.00");
		CART_PRICE.setFont(new Font("Arial Black", Font.PLAIN, 30));
		CART_PRICE.setBounds(527, 499, 200, 29);
		panel_3.add(CART_PRICE);
		
		CART_QTY = new JLabel("");
		CART_QTY.setHorizontalAlignment(SwingConstants.CENTER);
		CART_QTY.setFont(new Font("Arial Black", Font.PLAIN, 30));
		CART_QTY.setBounds(859, 386, 64, 29);
		panel_3.add(CART_QTY);
		
		CART_ID = new JLabel("");
		CART_ID.setHorizontalAlignment(SwingConstants.CENTER);
		CART_ID.setFont(new Font("Arial Black", Font.PLAIN, 30));
		CART_ID.setBounds(860, 326, 64, 29);
		CART_ID.setVisible(false);
		panel_3.add(CART_ID);
		tabbedPane.setEnabledAt(3, false);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab(" PAYMENT ", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblYourGrandTotal = new JLabel("YOUR GRAND TOTAL IS");
		lblYourGrandTotal.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblYourGrandTotal.setBounds(330, 13, 391, 66);
		panel_4.add(lblYourGrandTotal);
		
		JButton btnCash = new JButton("CASH");
		btnCash.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnCash.setBounds(603, 311, 289, 64);
		panel_4.add(btnCash);
		
		JButton btnOnlineBanking = new JButton("ONLINE BANKING");
		btnOnlineBanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment=0;
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnOnlineBanking.setFont(new Font("Arial Black", Font.PLAIN, 25));
		btnOnlineBanking.setBounds(157, 311, 289, 64);
		panel_4.add(btnOnlineBanking);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		button.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(12, 464, 64, 64);
		panel_4.add(button);
		
		PAYMENT_TOTAL = new JLabel("RM 0.00");
		PAYMENT_TOTAL.setHorizontalAlignment(SwingConstants.CENTER);
		PAYMENT_TOTAL.setFont(new Font("Arial Black", Font.PLAIN, 63));
		PAYMENT_TOTAL.setBounds(298, 92, 454, 66);
		panel_4.add(PAYMENT_TOTAL);
		
		JLabel lblChoiceOfPayment = new JLabel("CHOICE OF PAYMENT");
		lblChoiceOfPayment.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblChoiceOfPayment.setBounds(345, 201, 360, 66);
		panel_4.add(lblChoiceOfPayment);
		tabbedPane.setEnabledAt(4, false);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab(" BANK ", null, panel_5, null);
		tabbedPane.setEnabledAt(5, false);
		panel_5.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setEnabled(false);
		tabbedPane_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		tabbedPane_3.setBounds(12, 13, 1027, 515);
		panel_5.add(tabbedPane_3);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_3.addTab("", null, panel_12, null);
		panel_12.setLayout(null);
		
		JButton BANK_PREV = new JButton("");
		BANK_PREV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		BANK_PREV.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		BANK_PREV.setContentAreaFilled(false);
		BANK_PREV.setBorderPainted(false);
		BANK_PREV.setBorder(null);
		BANK_PREV.setBounds(12, 395, 64, 64);
		panel_12.add(BANK_PREV);
		
		JButton btnMaybanku = new JButton("");
		btnMaybanku.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/mb2ub.png")));
		btnMaybanku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(1);
			}
		});
		btnMaybanku.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnMaybanku.setBounds(366, 43, 289, 64);
		btnMaybanku.setContentAreaFilled(false);
		btnMaybanku.setBorderPainted(false);
		btnMaybanku.setBorder(null);
		panel_12.add(btnMaybanku);
		
		JButton btnBankIslam = new JButton("");
		btnBankIslam.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/bib.png")));
		btnBankIslam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(3);
			}
		});
		btnBankIslam.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnBankIslam.setBounds(366, 364, 289, 64);
		btnBankIslam.setContentAreaFilled(false);
		btnBankIslam.setBorderPainted(false);
		btnBankIslam.setBorder(null);
		panel_12.add(btnBankIslam);
		
		JButton btnPublicBank = new JButton("");
		btnPublicBank.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/pbbton.png")));
		btnPublicBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(4);
			}
		});
		btnPublicBank.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnPublicBank.setBounds(366, 150, 289, 64);
		btnPublicBank.setContentAreaFilled(false);
		btnPublicBank.setBorderPainted(false);
		btnPublicBank.setBorder(null);
		panel_12.add(btnPublicBank);
		
		JButton btnBankRakyat = new JButton("");
		btnBankRakyat.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/brb.png")));
		btnBankRakyat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(2);
			}
		});
		btnBankRakyat.setFont(new Font("Arial Black", Font.PLAIN, 31));
		btnBankRakyat.setBounds(366, 257, 289, 64);
		btnBankRakyat.setContentAreaFilled(false);
		btnBankRakyat.setBorderPainted(false);
		btnBankRakyat.setBorder(null);
		panel_12.add(btnBankRakyat);
		
		JButton button_8 = new JButton("");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment=9;
				nextcust();
				tabbedPane.setSelectedIndex(6);
				Timer timer = new Timer();
				timer.schedule(new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	tick--;
		            	timenext.setText(Integer.toString(tick));
		            	if(tick==0) {
		            		try {
								conn.createStatement().execute("insert into feedback(rating,o_id) values("+FBCK+","+orderid+");");
							} catch (SQLException e) {
								e.printStackTrace();
							}
		            		STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							
							tick=10;
							timenext.setText(Integer.toString(tick));
							FBCK=0;new_orderid();refresh();
							
							tabbedPane.setSelectedIndex(0);
							timer.cancel();
		            	}
		            }
		        },0, 1000);
				
			}
		});
		button_8.setContentAreaFilled(false);
		button_8.setBorderPainted(false);
		button_8.setBorder(null);
		button_8.setBounds(946, 395, 64, 64);
		panel_12.add(button_8);
		
		JPanel panel_14 = new JPanel();
		tabbedPane_3.addTab("", null, panel_14, null);
		tabbedPane_3.setEnabledAt(1, false);
		panel_14.setLayout(null);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(0);
			}
		});
		button_2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBounds(12, 395, 64, 64);
		panel_14.add(button_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/MB2U.jpg")));
		label_1.setBounds(0, 0, 1022, 472);
		panel_14.add(label_1);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_3.addTab("", null, panel_7, null);
		panel_7.setLayout(null);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(0);
			}
		});
		button_3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBounds(12, 395, 64, 64);
		panel_7.add(button_3);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/rakyat.jpg")));
		label_13.setBounds(0, 0, 1022, 472);
		panel_7.add(label_13);
		tabbedPane_3.setEnabledAt(2, false);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_3.addTab("", null, panel_8, null);
		panel_8.setLayout(null);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(0);
			}
		});
		button_4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBorder(null);
		button_4.setBounds(12, 395, 64, 64);
		panel_8.add(button_4);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/bi.jpg")));
		label_14.setBounds(0, 0, 1022, 472);
		panel_8.add(label_14);
		tabbedPane_3.setEnabledAt(3, false);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_3.addTab("", null, panel_9, null);
		panel_9.setLayout(null);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_3.setSelectedIndex(0);
			}
		});
		button_5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/PREV.png")));
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBorder(null);
		button_5.setBounds(12, 395, 64, 64);
		panel_9.add(button_5);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/pbe.jpg")));
		label_15.setBounds(0, 0, 1022, 472);
		panel_9.add(label_15);
		tabbedPane_3.setEnabledAt(4, false);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab(" BILL ", null, panel_6, null);
		tabbedPane.setEnabledAt(6, false);
		panel_6.setLayout(null);
		
		STAR1 = new JButton("");
		STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
		STAR1.setContentAreaFilled(false);
		STAR1.setBorderPainted(false);
		STAR1.setBorder(null);
		STAR1.setBounds(341, 407, 64, 64);
		panel_6.add(STAR1);
		
		STAR2 = new JButton("");
		STAR2.setContentAreaFilled(false);
		STAR2.setBorderPainted(false);
		STAR2.setBorder(null);
		STAR2.setBounds(417, 407, 64, 64);
		panel_6.add(STAR2);
		
		STAR3 = new JButton("");
		STAR3.setContentAreaFilled(false);
		STAR3.setBorderPainted(false);
		STAR3.setBorder(null);
		STAR3.setBounds(493, 407, 64, 64);
		panel_6.add(STAR3);
		
		STAR4 = new JButton("");
		STAR4.setContentAreaFilled(false);
		STAR4.setBorderPainted(false);
		STAR4.setBorder(null);
		STAR4.setBounds(569, 407, 64, 64);
		panel_6.add(STAR4);
		
		STAR5 = new JButton("");
		STAR5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				FBCK=5;
			}
		});
		STAR4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				FBCK=4;
			}
		});
		STAR3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				FBCK=3;
			}
		});
		STAR2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				FBCK=2;
			}
		});
		STAR1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(Y).png")));
				STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
				FBCK=1;
				
			}
		});
		

		
		STAR5.setContentAreaFilled(false);
		STAR5.setBorderPainted(false);
		STAR5.setBorder(null);
		STAR5.setBounds(645, 407, 64, 64);
		panel_6.add(STAR5);
		
		STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
		STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
		STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
		STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
		
		JLabel lblThankYouYour = new JLabel("THANK YOU! YOUR ORDER NUMBER");
		lblThankYouYour.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblThankYouYour.setBounds(225, 13, 601, 66);
		panel_6.add(lblThankYouYour);
		
		orderlabel = new JLabel("123123");
		orderlabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderlabel.setFont(new Font("Arial Black", Font.PLAIN, 63));
		orderlabel.setBounds(341, 92, 368, 66);
		panel_6.add(orderlabel);
		
		JLabel lblPleaseProceedTo = new JLabel("PLEASE PROCEED TO");
		lblPleaseProceedTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseProceedTo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblPleaseProceedTo.setBounds(341, 194, 368, 43);
		panel_6.add(lblPleaseProceedTo);
		
		DESTI = new JLabel("THE COUNTER");
		DESTI.setHorizontalAlignment(SwingConstants.CENTER);
		DESTI.setFont(new Font("Arial Black", Font.PLAIN, 30));
		DESTI.setBounds(341, 250, 368, 43);
		panel_6.add(DESTI);
		
		JLabel lblFeedback = new JLabel("YOUR FEEDBACK IS APPRECIATED");
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFeedback.setBounds(331, 366, 389, 29);
		panel_6.add(lblFeedback);
		
		timenext = new JLabel("10");
		timenext.setHorizontalAlignment(SwingConstants.CENTER);
		timenext.setFont(new Font("Arial Black", Font.PLAIN, 30));
		timenext.setBounds(999, 485, 40, 43);
		panel_6.add(timenext);
		
		tebel = new JLabel("THE COUNTER");
		tebel.setHorizontalAlignment(SwingConstants.CENTER);
		tebel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		tebel.setBounds(341, 306, 368, 43);
		panel_6.add(tebel);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("", null, panel_10, null);
		tabbedPane.setEnabledAt(7, false);
		panel_10.setLayout(null);
		
		JLabel lblTableManagement = new JLabel("Table Management");
		lblTableManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableManagement.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblTableManagement.setBounds(12, 13, 252, 23);
		panel_10.add(lblTableManagement);
		
		DEVT1 = new JButton("1 ");
		DEVT1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		
		DEVT1.setBackground(Color.GREEN);
		DEVT1.setForeground(Color.WHITE);
		DEVT1.setBounds(89, 49, 43, 35);
		panel_10.add(DEVT1);
		
		DEVL1 = new JLabel("");
		DEVL1.setForeground(Color.BLACK);
		DEVL1.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL1.setBounds(12, 49, 65, 35);
		panel_10.add(DEVL1);
		
		DEVL2 = new JLabel("");
		DEVL2.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL2.setForeground(Color.BLACK);
		DEVL2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL2.setBounds(12, 87, 65, 35);
		panel_10.add(DEVL2);
		
		DEVL3 = new JLabel("");
		DEVL3.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL3.setForeground(Color.BLACK);
		DEVL3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL3.setBounds(12, 125, 65, 35);
		panel_10.add(DEVL3);
		
		DEVL4 = new JLabel("");
		DEVL4.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL4.setForeground(Color.BLACK);
		DEVL4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL4.setBounds(12, 163, 65, 35);
		panel_10.add(DEVL4);
		
		DEVL5 = new JLabel("");
		DEVL5.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL5.setForeground(Color.BLACK);
		DEVL5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL5.setBounds(12, 201, 65, 35);
		panel_10.add(DEVL5);
		
		DEVT2 = new JButton("2");
		DEVT2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT2.setForeground(Color.WHITE);
		DEVT2.setBackground(Color.GREEN);
		DEVT2.setBounds(89, 87, 43, 35);
		panel_10.add(DEVT2);
		
		DEVT3 = new JButton("3");
		DEVT3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT3.setForeground(Color.WHITE);
		DEVT3.setBackground(Color.GREEN);
		DEVT3.setBounds(89, 125, 43, 35);
		panel_10.add(DEVT3);
		
		DEVT4 = new JButton("4");
		DEVT4.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT4.setForeground(Color.WHITE);
		DEVT4.setBackground(Color.GREEN);
		DEVT4.setBounds(89, 163, 43, 35);
		panel_10.add(DEVT4);
		
		DEVT5 = new JButton("5");
		DEVT5.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT5.setForeground(Color.WHITE);
		DEVT5.setBackground(Color.GREEN);
		DEVT5.setBounds(89, 201, 43, 35);
		panel_10.add(DEVT5);
		
		DEVT9 = new JButton("9");
		DEVT9.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT9.setForeground(Color.WHITE);
		DEVT9.setBackground(Color.GREEN);
		DEVT9.setBounds(221, 163, 43, 35);
		panel_10.add(DEVT9);
		
		DEVT8 = new JButton("8");
		DEVT8.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT8.setForeground(Color.WHITE);
		DEVT8.setBackground(Color.GREEN);
		DEVT8.setBounds(221, 125, 43, 35);
		panel_10.add(DEVT8);
		
		DEVT7 = new JButton("7");
		DEVT7.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT7.setForeground(Color.WHITE);
		DEVT7.setBackground(Color.GREEN);
		DEVT7.setBounds(221, 87, 43, 35);
		panel_10.add(DEVT7);
		
		DEVT6 = new JButton("6");
		DEVT6.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		DEVT6.setForeground(Color.WHITE);
		DEVT6.setBackground(Color.GREEN);
		DEVT6.setBounds(221, 49, 43, 35);
		panel_10.add(DEVT6);
		
		JLabel lblMenuManagement = new JLabel("Menu Management");
		lblMenuManagement.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblMenuManagement.setBounds(413, 13, 206, 23);
		panel_10.add(lblMenuManagement);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblName.setBounds(413, 49, 85, 25);
		panel_10.add(lblName);
		
		JButton button_6 = new JButton("INIT");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.createStatement().execute("CREATE TABLE PRODUCTS(\r\n" + 
							"P_ID int NOT NULL AUTO_INCREMENT,\r\n" + 
							"NAME VARCHAR(20) NOT NULL,\r\n" + 
							"DESC VARCHAR(99) NOT NULL,\r\n" + 
							"PRICE double(5) NOT NULL,\r\n" + 
							"IMGDIR VARCHAR(99) NOT NULL,\r\n" + 
							"TYPE INT NOT NULL,\r\n" + 
							"PRIMARY KEY (P_ID)\r\n" + 
							");\r\n" + 
							"\r\n" + 
							"CREATE TABLE OORDER ( \r\n" + 
							"O_ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
							"TOTPRICE DOUBLE(5),\r\n" + 
							"DATE DATE,\r\n" + 
							"TIME TIME,\r\n" + 
							"PRIMARY KEY (O_ID)\r\n" + 
							");\r\n" + 
							"\r\n" + 
							"CREATE TABLE CART(\r\n" + 
							"CA_ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
							"QTY INT NOT NULL,\r\n" + 
							"P_ID INT NOT NULL,\r\n" + 
							"O_ID INT NOT NULL,\r\n" + 
							"PRIMARY KEY(CA_ID),\r\n" + 
							"FOREIGN KEY(P_ID) REFERENCES PRODUCTS(P_ID),\r\n" + 
							"FOREIGN KEY(O_ID) REFERENCES OORDER(O_ID)\r\n" + 
							");\r\n" + 
							"\r\n" + 
							"CREATE TABLE TABLES(\r\n" + 
							"T_ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
							"OCCUPIED INT NOT NULL,\r\n" + 
							"O_ID INT,\r\n" + 
							"FOREIGN KEY(O_ID) REFERENCES OORDER(O_ID)\r\n" + 
							");\r\n" + 
							"\r\n" + 
							"CREATE TABLE FEEDBACK(\r\n" + 
							"F_ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
							"RATING INT NOT NULL,\r\n" + 
							"O_ID INT NOT NULL,\r\n" + 
							"FOREIGN KEY(O_ID) REFERENCES OORDER(O_ID)\r\n" + 
							");\r\n" + 
							"\r\n" + 
							"INSERT INTO TABLES values (1,0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"INSERT INTO TABLES (OCCUPIED,O_ID) values (0,null);\r\n" + 
							"\r\n" + 
							"insert into products (Name,DESC,price,imgdir,type) values ('Rice','Plain White Rice',2.00,'rice.png',1);\r\n" + 
							"insert into products (Name,DESC,price,imgdir,type) values ('7-UP Can','Canned 7-Up',2.50,'7up.png',1);\r\n" + 
							"insert into products (Name,DESC,price,imgdir,type) values ('Pepsi Can','Canned Pepsi',2.50,'pepsi.png',1);\r\n" + 
							"insert into products (Name,DESC,price,imgdir,type) values ('ChickChop Combo','Chicken Chop with fries, served with pepsi',8.5,'chop.jpg',2);\r\n" + 
							"insert into products (Name,DESC,price,imgdir,type) values ('Nasi Lemak Combo','Nasi Lemak served with curry chicken, served with 7-up',6.5,'lemak.jpg',2);\r\n" + 
							"\r\n" + 
							"insert into oorder values (1402,null,null,null);");
					} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_6.setForeground(Color.BLACK);
		button_6.setBackground(Color.GREEN);
		button_6.setBounds(980, 15, 65, 25);
		panel_10.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				refresh_table();
			}
		});
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setBorder(null);
		button_7.setBounds(12, 464, 64, 64);
		panel_10.add(button_7);
		
		JLabel lblDesc = new JLabel("Desc. :");
		lblDesc.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesc.setForeground(Color.BLACK);
		lblDesc.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblDesc.setBounds(413, 87, 75, 25);
		panel_10.add(lblDesc);
		
		JLabel lblPrice = new JLabel("Price  :");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPrice.setBounds(413, 125, 85, 25);
		panel_10.add(lblPrice);
		
		JLabel lblType = new JLabel("Type   :");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblType.setBounds(413, 201, 85, 25);
		panel_10.add(lblType);
		
		JLabel lblImgdir = new JLabel("ImgDir:");
		lblImgdir.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgdir.setForeground(Color.BLACK);
		lblImgdir.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblImgdir.setBounds(413, 163, 85, 25);
		panel_10.add(lblImgdir);
		
		DEVL6 = new JLabel("");
		DEVL6.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL6.setForeground(Color.BLACK);
		DEVL6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL6.setBounds(144, 49, 65, 35);
		panel_10.add(DEVL6);
		
		DEVL7 = new JLabel("");
		DEVL7.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL7.setForeground(Color.BLACK);
		DEVL7.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL7.setBounds(144, 87, 65, 35);
		panel_10.add(DEVL7);
		
		DEVL8 = new JLabel("");
		DEVL8.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL8.setForeground(Color.BLACK);
		DEVL8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL8.setBounds(144, 125, 65, 35);
		panel_10.add(DEVL8);
		
		DEVL9 = new JLabel("");
		DEVL9.setHorizontalAlignment(SwingConstants.LEFT);
		DEVL9.setForeground(Color.BLACK);
		DEVL9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		DEVL9.setBounds(144, 163, 65, 35);
		panel_10.add(DEVL9);
		
		DEVNAME = new JTextField();
		DEVNAME.setBounds(503, 53, 116, 22);
		panel_10.add(DEVNAME);
		DEVNAME.setColumns(10);
		
		DEVDESC = new JTextField();
		DEVDESC.setColumns(10);
		DEVDESC.setBounds(503, 87, 116, 22);
		panel_10.add(DEVDESC);
		
		DEVPRICE = new JTextField();
		DEVPRICE.setColumns(10);
		DEVPRICE.setBounds(503, 129, 116, 22);
		panel_10.add(DEVPRICE);
		
		DEVDIR = new JTextField();
		DEVDIR.setColumns(10);
		DEVDIR.setBounds(503, 167, 116, 22);
		panel_10.add(DEVDIR);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"COMBO", "ALA CARTE"}));
		comboBox.setBounds(504, 201, 116, 23);
		panel_10.add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x=1;
					if(comboBox.getSelectedIndex()==0) {x=2;}else {x=1;}
					conn.createStatement().execute("insert into products(name,desc,price,imgdir,TYPE) values('"+DEVNAME.getText()+"','"+DEVDESC.getText()+"',"+DEVPRICE.getText()+",'"+DEVDIR.getText()+"',"+x+");");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}refresh();refresh_table();
			}
		});
		btnNewButton.setBounds(469, 239, 97, 25);
		panel_10.add(btnNewButton);
		
		JLabel lblFeedback_1 = new JLabel("FEEDBACK");
		lblFeedback_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFeedback_1.setBounds(12, 249, 252, 23);
		panel_10.add(lblFeedback_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 285, 242, 206);
		panel_10.add(scrollPane);
		
		FB_TABLE = new JTable();
		scrollPane.setViewportView(FB_TABLE);
		
		JButton btnNewButton_2 = new JButton("RUN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = conn.prepareStatement("select o_id,rating from feedback where rating !=0 order by o_id asc;").executeQuery();
					FB_TABLE.setModel(buildTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(95, 503, 97, 25);
		panel_10.add(btnNewButton_2);
		
		JLabel lblCustom = new JLabel("CUSTOM");
		lblCustom.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustom.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustom.setBounds(719, 13, 242, 23);
		panel_10.add(lblCustom);
		
		customsql = new JTextField();
		customsql.setBounds(719, 49, 242, 22);
		panel_10.add(customsql);
		customsql.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("QUERY");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = conn.prepareStatement(customsql.getText()).executeQuery();
					customtable.setModel(buildTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(719, 87, 97, 25);
		panel_10.add(btnNewButton_3);
		
		JButton btnNonQuery = new JButton("NONQUERY");
		btnNonQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.createStatement().execute(customsql.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNonQuery.setBounds(864, 87, 97, 25);
		panel_10.add(btnNonQuery);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(719, 125, 320, 403);
		panel_10.add(scrollPane_3);
		
		customtable = new JTable();
		scrollPane_3.setViewportView(customtable);
		
		DEVT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT1.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=1;");
						DEVT1.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=1;");
					conn.createStatement().execute("update tables set o_id=null where t_id=1;");
					DEVT1.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT2.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=2;");
						DEVT2.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=2;");
					conn.createStatement().execute("update tables set o_id=null where t_id=2;");
					DEVT2.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT3.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=3;");
						DEVT3.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=3;");
					conn.createStatement().execute("update tables set o_id=null where t_id=3;");
					DEVT3.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT4.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=4;");
						DEVT4.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=4;");
					conn.createStatement().execute("update tables set o_id=null where t_id=4;");
					DEVT4.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT5.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=5;");
						DEVT5.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=5;");
					conn.createStatement().execute("update tables set o_id=null where t_id=5;");
					DEVT5.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT6.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=6;");
						DEVT6.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=6;");
					conn.createStatement().execute("update tables set o_id=null where t_id=6;");
					DEVT6.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT7.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=7;");
						DEVT7.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=7;");
					conn.createStatement().execute("update tables set o_id=null where t_id=7;");
					DEVT7.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT8.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=8;");
						DEVT8.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=8;");
					conn.createStatement().execute("update tables set o_id=null where t_id=8;");
					DEVT8.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		DEVT9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_table();
				refresh();
				if(DEVT9.getBackground()==Color.green) {
					try {
						conn.createStatement().execute("update tables set occupied=1 where t_id=9;");
						DEVT9.setBackground(Color.red);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {try {
					conn.createStatement().execute("update tables set occupied=0 where t_id=9;");
					conn.createStatement().execute("update tables set o_id=null where t_id=9;");
					DEVT9.setBackground(Color.green);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			}
		});
		
		refresh_table();
		refresh();
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
				payment=1;
				nextcust();
				Timer timer = new Timer();
				timer.schedule(new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	tick--;
		            	timenext.setText(Integer.toString(tick));
		            	if(tick==0) {
		            		try {
								conn.createStatement().execute("insert into feedback(rating,o_id) values("+FBCK+","+orderid+");");
							} catch (SQLException e) {
								e.printStackTrace();
							}FBCK=0;
		            		STAR1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							STAR5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/STAR(N).png")));
							
							tick=10;
							timenext.setText(Integer.toString(tick));
							tabbedPane.setSelectedIndex(0);
							new_orderid();refresh();
							timer.cancel();
		            	}
		            }
		        },0, 1000);
			}
		});
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	public void new_orderid() {
		try {
			conn.createStatement().execute("insert into oorder(totprice,date,time) values (null,null,null);");
			
			ResultSet od;
			od = conn.prepareStatement("SELECT * FROM oorder ORDER BY o_id DESC LIMIT 1;").executeQuery();
			while(od.next()) {
				orderid=od.getInt(1);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			ResultSet rs = conn.prepareStatement("select (p_id*1) as id, name, price from products where type=1 and products.p_id not in(select p_id from cart where o_id="+orderid+") order by p_id asc").executeQuery();
			ALA_TABLE.setModel(buildTableModel(rs));
			
			rs = conn.prepareStatement("select (p_id*1) as id, name, price from products where type=2 and products.p_id not in(select p_id from cart where o_id="+orderid+") order by p_id asc").executeQuery();
			COMBO_TABLE.setModel(buildTableModel(rs));
			
			rs = conn.prepareStatement("SELECT (products.p_id*1) as id, products.name ,cart.qty, products.price ,(cart.qty*products.price) as subtotal from cart inner join products where cart.o_id="+orderid+" and cart.p_id=products.p_id order by products.p_id asc;").executeQuery();
			CART_TABLE.setModel(buildTableModel(rs));
			
			orderlabel.setText(Integer.toString(orderid));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refresh_table()
	{
		try {
			
			ResultSet rs = conn.prepareStatement("select occupied from tables where t_id=1;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT1.setBackground(Color.GREEN);
				}else {B_TABLE1.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT1.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=2;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT2.setBackground(Color.GREEN);
				}else {B_TABLE2.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT2.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=3;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT3.setBackground(Color.GREEN);
				}else {B_TABLE3.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT3.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=4;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT4.setBackground(Color.GREEN);
				}else {B_TABLE4.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT4.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=5;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT5.setBackground(Color.GREEN);
				}else {B_TABLE5.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT5.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=6;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE6.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT6.setBackground(Color.GREEN);
				}else {B_TABLE6.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT6.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=7;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE7.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT7.setBackground(Color.GREEN);
				}else {B_TABLE7.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT7.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=8;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE8.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT8.setBackground(Color.GREEN);
				}else {B_TABLE8.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT8.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select occupied from tables where t_id=9;").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					B_TABLE9.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/AVAILABLE.png")));
					DEVT9.setBackground(Color.GREEN);
				}else {B_TABLE9.setIcon(new ImageIcon(KTKL.class.getResource("/assets_img/UNAVAILABLE.png")));DEVT9.setBackground(Color.red);}
			}
			
			rs = conn.prepareStatement("select o_id from tables where t_id = 1").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL1.setText("EMPTY");} else {DEVL1.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 2").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL2.setText("EMPTY");} else {DEVL2.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 3").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL3.setText("EMPTY");} else {DEVL3.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 4").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL4.setText("EMPTY");} else {DEVL4.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 5").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL5.setText("EMPTY");} else {DEVL5.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 6").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL6.setText("EMPTY");} else {DEVL6.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 7").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL7.setText("EMPTY");} else {DEVL7.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 8").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL8.setText("EMPTY");} else {DEVL8.setText(Integer.toString(rs.getInt(1)));}
			}
			rs = conn.prepareStatement("select o_id from tables where t_id = 9").executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)<1000) {DEVL9.setText("EMPTY");} else {DEVL9.setText(Integer.toString(rs.getInt(1)));}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void nextcust() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println(date);  
		
	    Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        String myDateString=sdf.format(cal.getTime());
		
		try {
			conn.createStatement().execute("update oorder set date='"+date+"' where o_id="+orderid+";");
			conn.createStatement().execute("update oorder set time='"+myDateString+"' where o_id="+orderid+";");
			conn.createStatement().execute("update oorder set totprice = "+CART_PRICE.getText()+" where o_id="+orderid+";");
			
			if(payment==1) {
				
				if(tablechosed==0) {
					DESTI.setText("THE COUNTER");
					tebel.setText("");
				}else {
					conn.createStatement().execute("update tables set occupied=1,o_id="+orderid+" where t_id="+tablechosed+";");
					refresh_table();
					tebel.setText("Table : "+tablechosed);
					DESTI.setText("THE COUNTER");
				}
			}else {
				if(tablechosed==0) {
					tebel.setText("");
					DESTI.setText("THE COUNTER");
				}else {
					conn.createStatement().execute("update tables set occupied=1,o_id="+orderid+" where t_id="+tablechosed+";");
					refresh_table();
					tebel.setText("Table : "+tablechosed);
					DESTI.setText("YOUR TABLE");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
