package Timetable;

import java.awt.EventQueue;





import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Advanced.Consecutive_sessions;
import DB.DbConnection;
import Home.Home;
import Lecturer.Add_Lecturer;
import Locations.ManageLocations;
import Rooms.ManageSessionsRooms;
import Session.Add_Session;
import Statistics.Statistics;
import Student.Add_StudentGroup;
import Subject.Add_Subjects;
import Tags.Add_Tags;
import WorkingDays.AddWorkingdays;
import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class Location {

	
	private Image home_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/home.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image lec_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/lecturer.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image stu_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/student.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image sub_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/subject.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image session_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/session.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image tag_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/tags.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image location_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/location.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image st_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/statics.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image days_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/Wdays.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image time_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/time.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image adv_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/adv1.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image room_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/room.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/pp.png")).getImage().getScaledInstance(1000,1000,Image.SCALE_SMOOTH);

	
	private JFrame frmAddStudentGroup;	private JTextField txtLecturer;
	private JComboBox comboBox;
	private JTable table;
	
	
	  public void fillLocations() {
			
			try {
				
				 Connection con = DbConnection.connect();
				 
				 String query="select DISTINCT selectRoom from notavailableTime";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("selectRoom");
					 comboBox.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DbConnection.connect();
				
				String query="select conSessionID AS SessionID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	  
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Location window = new Location();
					window.frmAddStudentGroup.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
	public Location() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddStudentGroup = new JFrame();
		frmAddStudentGroup.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmAddStudentGroup.setBackground(Color.YELLOW);
		frmAddStudentGroup.setResizable(false);
		frmAddStudentGroup.setTitle(" Time Table Management System");
		frmAddStudentGroup.setSize(1350, 728);
		frmAddStudentGroup.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentGroup.getContentPane().setLayout(null);
		frmAddStudentGroup.setIconImage(logo);
		
		frmAddStudentGroup.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup.setVisible(true);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 65);
		panel.setBackground(new Color(0, 139, 139));
		frmAddStudentGroup.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Generate Time Table");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setBounds(680, 13, 333, 29);
		panel.add(lblNewLabel_10);
		/*
		 * //JLabel lblNewLabel = new JLabel("Time Table Management System");
		 * lblNewLabel.setBounds(261, 5, 822, 61); panel.add(lblNewLabel);
		 * lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		 * lblNewLabel.setForeground(Color.WHITE);
		 */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 62, 262, 609);
		panel_1.setBackground(new Color(230, 230, 250));
		frmAddStudentGroup.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		//home button
				JButton btnHome = new JButton("Home");
				btnHome.setHorizontalAlignment(SwingConstants.LEFT);
				btnHome.setIcon(new ImageIcon(home_logo));
				btnHome.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
					
						frmAddStudentGroup.dispose();
						new Home();
						
					}
				});
				btnHome.setBounds(0, 13, 262, 33);
				panel_1.add(btnHome);
				btnHome.setForeground(new Color(255, 255, 255));
				btnHome.setBackground(new Color(0, 139, 139));
				btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
				
				
				//lecture button
				JButton btnLecturers = new JButton("Lecturers");
				btnLecturers.setHorizontalAlignment(SwingConstants.LEFT);
				btnLecturers.setIcon(new ImageIcon(lec_logo));
				btnLecturers.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							
							frmAddStudentGroup.dispose();
							new  Add_Lecturer();
							
						}
					});
				
				btnLecturers.setForeground(Color.WHITE);
				btnLecturers.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnLecturers.setBackground(new Color(0, 139, 139));
				btnLecturers.setBounds(0, 59, 264, 38);
				panel_1.add(btnLecturers);
				
				
				//student button
				JButton btnStudents = new JButton("Students");
				btnStudents.setHorizontalAlignment(SwingConstants.LEFT);
				btnStudents.setIcon(new ImageIcon(stu_logo));
		        btnStudents.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						
						frmAddStudentGroup.dispose();
						new Add_StudentGroup();
						
					}
				});
			
				
				btnStudents.setForeground(Color.WHITE);
				btnStudents.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnStudents.setBackground(new Color(0, 139, 139));
				btnStudents.setBounds(0, 108, 264, 38);
				panel_1.add(btnStudents);
				
				
				//subject button
				JButton btnSubjects = new JButton("Subjects");
				btnSubjects.setHorizontalAlignment(SwingConstants.LEFT);
				btnSubjects.setIcon(new ImageIcon(sub_logo));
				btnSubjects.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						Add_Subjects add_sub= new Add_Subjects();
						add_sub.main(null);
						frmAddStudentGroup.dispose();
						new Add_Subjects();
						
					}
				});
				btnSubjects.setForeground(Color.WHITE);
				btnSubjects.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnSubjects.setBackground(new Color(0, 139, 139));
				btnSubjects.setBounds(0, 157, 264, 38);
				panel_1.add(btnSubjects);
				
				//session button
				JButton btnSessions = new JButton("Sessions");
				btnSessions.setHorizontalAlignment(SwingConstants.LEFT);
				btnSessions.setIcon(new ImageIcon(session_logo));
				btnSessions.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//Add_Session add_session= new Add_Session();
						//add_session.main(null);
						frmAddStudentGroup.dispose();
						new Add_Session();
						
					}
				});
				btnSessions.setForeground(Color.WHITE);
				btnSessions.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnSessions.setBackground(new Color(0, 139, 139));
				btnSessions.setBounds(0, 206, 264, 38);
				panel_1.add(btnSessions);
				
				
				//Tags button
				JButton btnTags = new JButton("Tags");
				btnTags.setHorizontalAlignment(SwingConstants.LEFT);
				btnTags.setIcon(new ImageIcon(tag_logo));
				btnTags.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//Add_Tags add_tag= new Add_Tags();
						//add_tag.main(null);
						frmAddStudentGroup.dispose();
						new Add_Tags();
						
					}
				});
				btnTags.setForeground(Color.WHITE);
				btnTags.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnTags.setBackground(new Color(0, 139, 139));
				btnTags.setBounds(0, 255, 264, 38);
				panel_1.add(btnTags);
				
				
				//room button
				JButton btnRooms = new JButton("Rooms");
				btnRooms.setHorizontalAlignment(SwingConstants.LEFT);
				btnRooms.setIcon(new ImageIcon(room_logo));
				btnRooms.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//ManageSessionsRooms m_rooms= new ManageSessionsRooms ();
						//m_rooms.main(null);
						frmAddStudentGroup.dispose();
						new  ManageSessionsRooms();
						
					}
				});
				btnRooms.setForeground(Color.WHITE);
				btnRooms.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnRooms.setBackground(new Color(0, 139, 139));
				btnRooms.setBounds(0, 304, 264, 38);
				panel_1.add(btnRooms);
				
				
				//working days and hours button
				JButton btnWorkingDays = new JButton("Working days & Hours");
				btnWorkingDays.setHorizontalAlignment(SwingConstants.LEFT);
				btnWorkingDays.setIcon(new ImageIcon(days_logo));
				btnWorkingDays.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						AddWorkingdays w_days= new 	AddWorkingdays();
						w_days.main(null);
						frmAddStudentGroup.dispose();
						new AddWorkingdays();
						
					}
				});
				btnWorkingDays.setForeground(Color.WHITE);
				btnWorkingDays.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnWorkingDays.setBackground(new Color(0, 139, 139));
				btnWorkingDays.setBounds(0, 353, 264, 38);
				panel_1.add(btnWorkingDays);
				
				//location button
				JButton btnLocations = new JButton("Locations");
				btnLocations.setHorizontalAlignment(SwingConstants.LEFT);
				btnLocations.setIcon(new ImageIcon(location_logo));
				btnLocations.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//ManageLocations m_locations= new ManageLocations();
						//m_locations.main(null);
						frmAddStudentGroup.dispose();
						new ManageLocations();
						
					}
				});
				btnLocations.setForeground(Color.WHITE);
				btnLocations.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnLocations.setBackground(new Color(0, 139, 139));
				btnLocations.setBounds(0, 402, 264, 38);
				panel_1.add(btnLocations);
				
				//statics button
				JButton btnStatistics = new JButton("Statistics");
				btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
				btnStatistics.setIcon(new ImageIcon(st_logo));
				btnStatistics.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//Statistics stat= new Statistics ();
						//stat.main(null);
						frmAddStudentGroup.dispose();
						new   Statistics();
						
					}
				});
				btnStatistics.setForeground(Color.WHITE);
				btnStatistics.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnStatistics.setBackground(new Color(0, 139, 139));
				btnStatistics.setBounds(0, 451, 264, 38);
				panel_1.add(btnStatistics);
				
				//advanced button
				JButton btnAdvanced = new JButton("Advanced");
				btnAdvanced.setHorizontalAlignment(SwingConstants.LEFT);
				btnAdvanced.setIcon(new ImageIcon(adv_logo));
				btnAdvanced.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//Consecutive_sessions a_session= new Consecutive_sessions ();
						//a_session.main(null);
						frmAddStudentGroup.dispose();
						new Consecutive_sessions();
						
					}
				});
				btnAdvanced.setForeground(Color.WHITE);
				btnAdvanced.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnAdvanced.setBackground(new Color(0, 139, 139));
				btnAdvanced.setBounds(0, 500, 264, 38);
				panel_1.add(btnAdvanced);
				
				//generate button
				JButton btnTimetableGenerate = new JButton("Timetable Generate");
				btnTimetableGenerate.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimetableGenerate.setIcon(new ImageIcon(time_logo));
				btnTimetableGenerate.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						//Consecutive_sessions a_session= new Consecutive_sessions ();
						//a_session.main(null);
						frmAddStudentGroup.dispose();
						new Lecturer();
						
					}
				});
				btnTimetableGenerate.setForeground(Color.WHITE);
				btnTimetableGenerate.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnTimetableGenerate.setBackground(new Color(0, 139, 139));
				btnTimetableGenerate.setBounds(0, 549, 264, 38);
				panel_1.add(btnTimetableGenerate);
				
				
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(230, 230, 250));
		panel_6.setBounds(263, 62, 1081, 603);
		frmAddStudentGroup.getContentPane().add(panel_6);
		
		
		

		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setLayout(null);
		panel_6_1_1.setBounds(0, 40, 1081, 38);
		panel_6.add(panel_6_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Location");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(494, 0, 278, 31);
		panel_6_1_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Lecture");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				frmAddStudentGroup.dispose();
				new  Lecturer();
				
			}
		});
		
		btnNewButton_2_1.setBounds(0, 0, 372, 37);
		panel_6.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Student");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				frmAddStudentGroup.dispose();
				new  Student();
				
			}
		});
		btnNewButton_2_1_1.setBounds(371, 0, 372, 37);
		panel_6.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("Location");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frmAddStudentGroup.dispose();
				new  Location();
				
			}
		});
		btnNewButton_2_1_2.setBounds(742, 0, 339, 37);
		panel_6.add(btnNewButton_2_1_2);
		
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(32, 178, 170));
		separator_1.setBackground(new Color(0, 139, 139));
		separator_1.setBounds(0, 37, 1094, 19);
		panel_6.add(separator_1);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 91, 1059, 499);
		panel_6.add(panel_7);
		
	
		//generate button
		JButton btnNewButton_2 = new JButton("GENERATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
		
			}
		});
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 139, 139));
		btnNewButton_2.setBounds(698, 13, 164, 40);
		panel_7.add(btnNewButton_2);
		
		
		
		//print button
		JButton btnNewButton_3 = new JButton("PRINT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("Location TimeTable - "+ comboBox.getSelectedItem().toString());
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");  
			    String strDate= formatter.format(date);  
				MessageFormat footer = new MessageFormat("Timetable generated on:" +strDate);
				
				try {
					
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
					
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "       Unable to print","Alert",JOptionPane.WARNING_MESSAGE);
					
				}
				
			
			}
		});
		
	
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(0, 139, 139));
		btnNewButton_3.setBounds(874, 13, 155, 40);
		panel_7.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Location :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(137, 25, 93, 28);
		panel_7.add(lblNewLabel);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                               ----- Select Location -----"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(222, 22, 415, 28);
		panel_7.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 92, 1009, 378);
		panel_7.add(scrollPane);
		
		table = new JTable(){
		@Override
			public Component prepareRenderer(TableCellRenderer  renderer , int row ,int column) {
			
			Component c =super.prepareRenderer(  renderer ,  row , column);
			int renderWidth = c.getPreferredSize().width;
			TableColumn tbc =getColumnModel().getColumn(column);
			tbc.setPreferredWidth(Math.max(renderWidth + getIntercellSpacing().width, tbc.getPreferredWidth()));
			
			return c; 
			}
		};
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		table.setRowHeight(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		//table.set
		scrollPane.setViewportView(table);
		
		 fillLocations();
		 
		 //generate
		 btnNewButton_2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().toString().equals(" ") || comboBox.getSelectedItem().toString().equals("                               ----- Select Location -----"))
					{
						
						JOptionPane.showMessageDialog(null, "    Please Select Location ","Failed",JOptionPane.WARNING_MESSAGE);
					}
					else {
					try {
						
						Connection con = DbConnection.connect();
						
						String query="select Date As Day,startTime || ' ' || start as StartTime,endTime || ' ' || end As EndTime ,sessionSign As SessionSign from notavailableTime where selectRoom='"+comboBox.getSelectedItem().toString()+"' order by Date,startTime,endTime";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						
						
						TableColumnModel columnModel = table.getColumnModel();
					    columnModel.getColumn(0).setPreferredWidth(5);
						columnModel.getColumn(1).setPreferredWidth(5);
						columnModel.getColumn(2).setPreferredWidth(5);
						columnModel.getColumn(3).setPreferredWidth(600);
						
						
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				
					}
				}
			});

			
	}
}
