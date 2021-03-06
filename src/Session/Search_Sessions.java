// IT19210452
// W.M.S.T Wijekoon

package Session;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;


import Home.Home;
import Lecturer.Add_Lecturer;
import Locations.ManageLocations;
import Rooms.ManageSessionsRooms;
import Statistics.Statistics;
import Student.Add_StudentGroup;
import Subject.Add_Subjects;
import Tags.Add_Tags;
import Timetable.Lecturer;
import WorkingDays.AddWorkingdays;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Advanced.Consecutive_sessions;
import DB.DbConnection;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Search_Sessions {

	private JFrame SrchSesFrm;
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

	private JTable table;
	private JComboBox lecbox;
	private JComboBox subjBox;
	private JComboBox groupBox;
	
	
	public void refreshtable() {

		try {

			Connection con = DbConnection.connect();

			String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);



		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}
	//load data to dropdown lec
	 public  void  loadLecturer1(){ 
		  try {

				Connection con = DbConnection.connect();

				String query="select * from lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("lectureName");
					lecbox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
}

	
	//load data to dropdown subject name
	  public  void  loadSubjectName(){ 
		  try {

				Connection con = DbConnection.connect();

				String query="select * from subjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("subName");
					subjBox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}	  
	//load data to dropdown group id
	  public  void  loadGroup(){ 
		  try {

				Connection con = DbConnection.connect();

				String query="select DISTINCT GroupID from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("GroupID");
					groupBox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown Subgroup id
	  public  void  loadSubGroup(){ 
		  try {

				Connection con = DbConnection.connect();

				String query="select * from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubGroupID");
					groupBox.addItem(name);
					 
				}

				con.close();
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
					Search_Sessions window = new Search_Sessions();
					window.SrchSesFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search_Sessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SrchSesFrm = new JFrame();
	
		
		SrchSesFrm.setSize(1400, 860);
		SrchSesFrm.setBounds(0, 0, 1350, 700);
		SrchSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SrchSesFrm.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		SrchSesFrm.setBackground(Color.YELLOW);
		SrchSesFrm.setTitle("Time Table Management System");
		SrchSesFrm.setLocationRelativeTo(null);
		SrchSesFrm.setIconImage(logo);
		SrchSesFrm.setVisible(true);
		//ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SrchSesFrm.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 1344, 65);
		SrchSesFrm.getContentPane().add(panel);

		JLabel label = new JLabel(" Sessions");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBackground(new Color(32, 178, 170));
		label.setBounds(262, 18, 1082, 36);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 62, 262, 609);
		SrchSesFrm.getContentPane().add(panel_1);

		JButton btnManageGroups = new JButton("Home");
		btnManageGroups.setHorizontalAlignment(SwingConstants.LEFT);
		btnManageGroups.setIcon(new ImageIcon(home_logo));
		btnManageGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				SrchSesFrm.dispose();
				new Home();
				
			}
		});
		btnManageGroups.setForeground(new Color(255, 255, 255));
		btnManageGroups.setBackground(new Color(0, 139, 139));
		btnManageGroups.setBounds(0, 10, 264, 38);
		btnManageGroups.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(btnManageGroups);

		JButton btnViewGroups_1 = new JButton("<<Back");
		btnViewGroups_1.setBounds(12, 724, 238, 50);
		btnViewGroups_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btnViewGroups_1);

		JButton button_7 = new JButton("Lecturers");
		button_7.setHorizontalAlignment(SwingConstants.LEFT);
		button_7.setIcon(new ImageIcon(lec_logo));
		button_7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				SrchSesFrm.dispose();
				new Add_Lecturer();

			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_7.setBackground(new Color(0, 139, 139));
		button_7.setBounds(0, 59, 264, 38);
		panel_1.add(button_7);

		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				SrchSesFrm.dispose();
				new Add_StudentGroup();
			}
		});
		btnStudents.setHorizontalAlignment(SwingConstants.LEFT);
		btnStudents.setIcon(new ImageIcon(stu_logo));
		btnStudents.setForeground(Color.WHITE);
		btnStudents.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStudents.setBackground(new Color(0, 139, 139));
		btnStudents.setBounds(0, 108, 264, 38);
		panel_1.add(btnStudents);

		JButton btnSubjects = new JButton("Subjects");
		btnSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubjects.setIcon(new ImageIcon(sub_logo));
		btnSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				SrchSesFrm.dispose();
				new Add_Subjects();
			}
		});
		btnSubjects.setForeground(Color.WHITE);
		btnSubjects.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubjects.setBackground(new Color(0, 139, 139));
		btnSubjects.setBounds(0, 157, 264, 38);
		panel_1.add(btnSubjects);

		JButton btnSessions = new JButton("Sessions");
		btnSessions.setHorizontalAlignment(SwingConstants.LEFT);
		btnSessions.setIcon(new ImageIcon(session_logo));
		btnSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				SrchSesFrm.dispose();
				new Add_Session();
			}
		});
		btnSessions.setForeground(Color.WHITE);
		btnSessions.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSessions.setBackground(new Color(0, 139, 139));
		btnSessions.setBounds(0, 206, 264, 38);
		panel_1.add(btnSessions);

		JButton btnTags = new JButton("Tags");
		btnTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SrchSesFrm.dispose();
				new Add_Tags();
			}
		});
		btnTags.setHorizontalAlignment(SwingConstants.LEFT);
		btnTags.setIcon(new ImageIcon(tag_logo));
		btnTags.setForeground(Color.WHITE);
		btnTags.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTags.setBackground(new Color(0, 139, 139));
		btnTags.setBounds(0, 255, 264, 38);
		panel_1.add(btnTags);

		JButton btnRooms = new JButton("Rooms");
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SrchSesFrm.dispose();
				new ManageSessionsRooms();
			}
		});
		btnRooms.setHorizontalAlignment(SwingConstants.LEFT);
		btnRooms.setIcon(new ImageIcon(room_logo));
		btnRooms.setForeground(Color.WHITE);
		btnRooms.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRooms.setBackground(new Color(0, 139, 139));
		btnRooms.setBounds(0, 304, 264, 38);
		panel_1.add(btnRooms);

		JButton btnWorkingDays = new JButton("Working days & Hours");
		btnWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SrchSesFrm.dispose();
				new AddWorkingdays();
			}
		});
		btnWorkingDays.setHorizontalAlignment(SwingConstants.LEFT);
		btnWorkingDays.setIcon(new ImageIcon(days_logo));
		btnWorkingDays.setForeground(Color.WHITE);
		btnWorkingDays.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnWorkingDays.setBackground(new Color(0, 139, 139));
		btnWorkingDays.setBounds(0, 353, 264, 38);
		panel_1.add(btnWorkingDays);

		JButton btnLocations = new JButton("Locations");
		btnLocations.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SrchSesFrm.dispose();
				new ManageLocations();

			}
		});
		btnLocations.setHorizontalAlignment(SwingConstants.LEFT);
		btnLocations.setIcon(new ImageIcon(location_logo));
		btnLocations.setForeground(Color.WHITE);
		btnLocations.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLocations.setBackground(new Color(0, 139, 139));
		btnLocations.setBounds(0, 402, 264, 38);
		panel_1.add(btnLocations);

		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SrchSesFrm.dispose();
				new Statistics();
			}
		});
		btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistics.setIcon(new ImageIcon(st_logo));
		btnStatistics.setForeground(Color.WHITE);
		btnStatistics.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStatistics.setBackground(new Color(0, 139, 139));
		btnStatistics.setBounds(0, 451, 264, 38);
		panel_1.add(btnStatistics);

		JButton btnAdvanced = new JButton("Advanced");
		btnAdvanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SrchSesFrm.dispose();
				new Consecutive_sessions();
			}

		});
		btnAdvanced.setIcon(new ImageIcon(adv_logo));
		btnAdvanced.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdvanced.setForeground(Color.WHITE);
		btnAdvanced.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdvanced.setBackground(new Color(0, 139, 139));
		btnAdvanced.setBounds(0, 500, 264, 38);
		panel_1.add(btnAdvanced);

		JButton btnTimetableGenerate = new JButton("Timetable Generate");
		btnTimetableGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				SrchSesFrm.dispose();
				new Lecturer();
			}
		});
		btnTimetableGenerate.setIcon(new ImageIcon(time_logo));
		btnTimetableGenerate.setHorizontalAlignment(SwingConstants.LEFT);
		btnTimetableGenerate.setForeground(Color.WHITE);
		btnTimetableGenerate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTimetableGenerate.setBackground(new Color(0, 139, 139));
		btnTimetableGenerate.setBounds(0, 549, 264, 38);
		panel_1.add(btnTimetableGenerate);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(32, 178, 170));
		separator.setBackground(new Color(0, 139, 139));
		separator.setBounds(262, 102, 1082, 9);
		SrchSesFrm.getContentPane().add(separator);

		JButton button = new JButton("Add New Session");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SrchSesFrm.dispose();
			new Add_Session();
			}
		});
		button.setBounds(262, 66, 258, 37);
		SrchSesFrm.getContentPane().add(button);

		JButton button_1 = new JButton("Manage Sessions");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				SrchSesFrm.dispose();
				new Manage_Session();
				
			}
		});
		button_1.setBounds(517, 66, 258, 37);
		SrchSesFrm.getContentPane().add(button_1);

		JButton button_2 = new JButton("Search Sessions");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SrchSesFrm.dispose();
				new Search_Sessions();
			}
		});
		button_2.setBounds(774, 66, 258, 37);
		SrchSesFrm.getContentPane().add(button_2);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_2.setBounds(262, 107, 1082, 37);
		SrchSesFrm.getContentPane().add(panel_2);

		JLabel lblSearchSessions = new JLabel("Search Sessions");
		lblSearchSessions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchSessions.setForeground(new Color(0, 128, 128));
		lblSearchSessions.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSearchSessions.setBounds(405, 0, 278, 31);
		panel_2.add(lblSearchSessions);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBounds(272, 144, 1065, 527);
		SrchSesFrm.getContentPane().add(panel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 201, 1045, 277);
		panel_3.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		

		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setForeground(SystemColor.textText);
		table.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		//table header
				JTableHeader h = table.getTableHeader();
				h.setBackground(new Color(	153, 153, 153));
				h.setForeground(Color.WHITE);
				h.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
				h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				

		table.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));


		
		table.setModel(new DefaultTableModel( new Object[][] { }, new String[] { }
				));
		
		//display details in a table				
		scrollPane_1.setViewportView(table);

				try {
					Connection con = DbConnection.connect();

					//String query="select * from session ";
					String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
					
			
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(1);
					columnModel.getColumn(1).setPreferredWidth(80);
					columnModel.getColumn(2).setPreferredWidth(80);
					columnModel.getColumn(3).setPreferredWidth(20);
					columnModel.getColumn(4).setPreferredWidth(40);
					columnModel.getColumn(5).setPreferredWidth(30);
					columnModel.getColumn(6).setPreferredWidth(50);
					columnModel.getColumn(7).setPreferredWidth(1);
					columnModel.getColumn(8).setPreferredWidth(1);
					columnModel.getColumn(9).setPreferredWidth(300);


				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				//Search bar for lecturer
			
				 lecbox = new JComboBox();
				 lecbox.setBackground(Color.WHITE);
				 lecbox.setForeground(Color.DARK_GRAY);
				 lecbox.setFont(UIManager.getFont("Spinner.font"));
				lecbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							String l2 = lecbox.getSelectedItem().toString();
							 Connection con = DbConnection.connect();
							// String selection=(String)searchcomboBox.getSelectedItem();
							 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where lec1=? or lec2= '"+l2+"'";
							 PreparedStatement pst= con.prepareStatement(query);
							 pst.setString(1,(String)lecbox.getSelectedItem());
							 ResultSet rs=pst.executeQuery();

							 table.setModel(DbUtils.resultSetToTableModel(rs));
							 pst.close();
							 
						 }catch(Exception ep) {
							 ep.printStackTrace();
						 }
						
						
						
					}
				});
				lecbox.setModel(new DefaultComboBoxModel(new String[] {"                      Select Lecturer"}));
				lecbox.setBounds(50, 109, 223, 27);
				panel_3.add(lecbox);
				
				
			
				//Search bar for subName
				subjBox = new JComboBox();
				subjBox.setBackground(Color.WHITE);
				subjBox.setForeground(Color.DARK_GRAY);
				subjBox.setFont(UIManager.getFont("Spinner.font"));
				subjBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							 Connection con = DbConnection.connect();
							// String selection=(String)searchcomboBox.getSelectedItem();
							 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where subName=?";
							 PreparedStatement pst= con.prepareStatement(query);
							 pst.setString(1,(String)subjBox.getSelectedItem());
							 ResultSet rs=pst.executeQuery();

							 table.setModel(DbUtils.resultSetToTableModel(rs));
							 pst.close();
							 
						 }catch(Exception ep) {
							 ep.printStackTrace();
						 }
						
						
						
					}
				});
				
				
				//Search bar for Groupid
				 groupBox = new JComboBox();
				 groupBox.setBackground(Color.WHITE);
				 groupBox.setForeground(Color.DARK_GRAY);
				 groupBox.setFont(UIManager.getFont("Spinner.font"));
				 groupBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								 Connection con = DbConnection.connect();
								// String selection=(String)searchcomboBox.getSelectedItem();
								 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where studentGroup=?";
								 PreparedStatement pst= con.prepareStatement(query);
								 pst.setString(1,(String)groupBox.getSelectedItem());
								 ResultSet rs=pst.executeQuery();

								 table.setModel(DbUtils.resultSetToTableModel(rs));
								 pst.close();
								 
							 }catch(Exception ep) {
								 ep.printStackTrace();
							 }
							
							
							
						}
					});
				 
				 
		
		JLabel label_1 = new JLabel("Search by Lecturer :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(78, 61, 180, 37);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Search by Group/Sub Group :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(444, 61, 215, 37);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("Search by Subject :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(850, 61, 215, 37);
		panel_3.add(label_3);

		

		
		groupBox.setModel(new DefaultComboBoxModel(new String[] {"                       Select Group"}));
		groupBox.setBounds(438, 109, 223, 27);
		panel_3.add(groupBox);

		 
		subjBox.setModel(new DefaultComboBoxModel(new String[] {"                      Select Subject"}));
		subjBox.setBounds(812, 109, 223, 27);
		panel_3.add(subjBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 1045, 474);
		panel_3.add(panel_4);
		
		//clear button
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setToolTipText("Click button to clear search bar");
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lecbox.setSelectedIndex(0);;
				groupBox.setSelectedIndex(0);
				subjBox.setSelectedIndex(0);
				refreshtable();
				
				
			}
		});
		btnNewButton.setBounds(477, 489, 140, 27);
		panel_3.add(btnNewButton);
		
		
		        //load data to dropdown lec1
				loadLecturer1();
		
				//load data to dropdown subject name
				loadSubjectName();
				//load data to dropdown group id
				loadGroup();//load data to dropdown Subgroup id
				loadSubGroup();
				
	}

}
