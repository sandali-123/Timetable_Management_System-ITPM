/**
 * IT19207582
 * R.M.S.J Rathnayake
 * 
 */
package Rooms;

import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Advanced.Consecutive_sessions;
import DB.DbConnection;
import Home.Home;
import Lecturer.Add_Lecturer;
import Locations.ManageLocations;
import Session.Add_Session;
import Statistics.Statistics;
import Student.Add_StudentGroup;
import Subject.Add_Subjects;
import Tags.Add_Tags;
import Timetable.Lecturer;
import WorkingDays.AddWorkingdays;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;
import javax.swing.ScrollPaneConstants;

public class ManageSessionsRooms {
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

	private JFrame rframe;
	private JTable rtable;
	private JTable rtable_1;
	private JTable rtable_2;
	private JComboBox session;
	private JComboBox sessionroom;
	private JTextArea generateroom;
	
	 public  void  loadSession(){ 
		  try {

				Connection con = DbConnection.connect();

				String query="select * from session ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("sessionSignature");
					session.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	 public void loadsessionRoom() {
		 try {
			 
			 Connection con = DbConnection.connect();
			 
			 String query ="select * from location";
			 PreparedStatement pst=con.prepareStatement(query);
			 ResultSet rs =pst.executeQuery();
			 
			 while(rs.next()) {
				 String room = rs.getString("roomName");
				 sessionroom.addItem(room);
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
					ManageSessionsRooms window = new ManageSessionsRooms();
					window.rframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageSessionsRooms() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rframe = new JFrame();
		rframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		rframe.setBackground(Color.YELLOW);
		rframe.setResizable(false);
		rframe.setTitle("Time Table Management System");
		rframe.setSize(1400, 860);
		rframe.setBounds(0, 0, 1350, 700);
		rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rframe.getContentPane().setLayout(null);
		rframe.setIconImage(logo);
		rframe.setLocationRelativeTo(null);
		rframe.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1344, 65);
		panel.setBackground(new Color(0, 139, 139));
		rframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Manage Session Rooms");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setBounds(723, 13, 279, 29);
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
		rframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Lecturers
		JButton btnLecturers = new JButton("Lecturers");
		btnLecturers.setHorizontalAlignment(SwingConstants.LEFT);
		btnLecturers.setIcon(new ImageIcon(lec_logo));
		btnLecturers.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					rframe.dispose();
					new  Add_Lecturer();
					
				}
			});
		
		btnLecturers.setForeground(Color.WHITE);
		btnLecturers.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLecturers.setBackground(new Color(0, 139, 139));
		btnLecturers.setBounds(0, 59, 264, 38);
		panel_1.add(btnLecturers);
		
		//Students
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setHorizontalAlignment(SwingConstants.LEFT);
		btnStudents.setIcon(new ImageIcon(stu_logo));
        btnStudents.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				rframe.dispose();
				new Add_StudentGroup();
				
			}
		});
	
		
		btnStudents.setForeground(Color.WHITE);
		btnStudents.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStudents.setBackground(new Color(0, 139, 139));
		btnStudents.setBounds(0, 108, 264, 38);
		panel_1.add(btnStudents);
		
		//Subjects
		JButton btnSubjects = new JButton("Subjects");
		btnSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add_Subjects add_sub= new Add_Subjects();
				//add_sub.main(null);
				rframe.dispose();
				new Add_Subjects();
				
			}
		});
		btnSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubjects.setIcon(new ImageIcon(sub_logo));
		btnSubjects.setForeground(Color.WHITE);
		btnSubjects.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubjects.setBackground(new Color(0, 139, 139));
		btnSubjects.setBounds(0, 157, 264, 38);
		panel_1.add(btnSubjects);
		
		//Sessions
		JButton btnSessions = new JButton("Sessions");
		btnSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add_Session add_session= new Add_Session();
				//add_session.main(null);
				rframe.dispose();
				new Add_Session();
				
			}
		});
		btnSessions.setHorizontalAlignment(SwingConstants.LEFT);
		btnSessions.setIcon(new ImageIcon(session_logo));
		btnSessions.setForeground(Color.WHITE);
		btnSessions.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSessions.setBackground(new Color(0, 139, 139));
		btnSessions.setBounds(0, 206, 264, 38);
		panel_1.add(btnSessions);
		
		//Tags
		JButton btnTags = new JButton("Tags");
		btnTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add_Tags add_tag= new Add_Tags();
				//add_tag.main(null);
				rframe.dispose();
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
		
		//Rooms
		JButton btnRooms = new JButton("Rooms");
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//ManageSessionsRooms m_rooms= new ManageSessionsRooms ();
				//m_rooms.main(null);
				rframe.dispose();
				new  ManageSessionsRooms();
				
			}
		});
		btnRooms.setHorizontalAlignment(SwingConstants.LEFT);
		btnRooms.setIcon(new ImageIcon(room_logo));
		btnRooms.setForeground(Color.WHITE);
		btnRooms.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRooms.setBackground(new Color(0, 139, 139));
		btnRooms.setBounds(0, 304, 264, 38);
		panel_1.add(btnRooms);
		
		//Working
		JButton btnWorkingDays = new JButton("Working days & Hours");
		btnWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//AddWorkingdays w_days= new 	AddWorkingdays();
				//w_days.main(null);
				rframe.dispose();
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
		
		//Locations
		JButton btnLocations = new JButton("Locations");
		btnLocations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManageLocations m_locations= new ManageLocations();
				//m_locations.main(null);
				rframe.dispose();
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
		
		//Statistics
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Statistics stat= new Statistics ();
				//stat.main(null);
				rframe.dispose();
				new   Statistics();
				
				
			}
		});
		btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistics.setIcon(new ImageIcon(st_logo));
		btnStatistics.setForeground(Color.WHITE);
		btnStatistics.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStatistics.setBackground(new Color(0, 139, 139));
		btnStatistics.setBounds(0, 451, 264, 38);
		panel_1.add(btnStatistics);
		
		//Advances
		JButton btnAdvanced = new JButton("Advanced");
		btnAdvanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Consecutive_sessions a_session= new Consecutive_sessions ();
				//a_session.main(null);
				rframe.dispose();
				new Consecutive_sessions();
				
			
			}
		});
		btnAdvanced.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdvanced.setIcon(new ImageIcon(adv_logo));
		btnAdvanced.setForeground(Color.WHITE);
		btnAdvanced.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdvanced.setBackground(new Color(0, 139, 139));
		btnAdvanced.setBounds(0, 500, 264, 38);
		panel_1.add(btnAdvanced);
		
		//Timetable
		JButton btnTimetableGenerate = new JButton("Timetable Generate");
		btnTimetableGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rframe.dispose();
				new Lecturer();
			}
		});
		btnTimetableGenerate.setHorizontalAlignment(SwingConstants.LEFT);
		btnTimetableGenerate.setIcon(new ImageIcon(time_logo));
		btnTimetableGenerate.setForeground(Color.WHITE);
		btnTimetableGenerate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTimetableGenerate.setBackground(new Color(0, 139, 139));
		btnTimetableGenerate.setBounds(0, 549, 264, 38);
		panel_1.add(btnTimetableGenerate);
		
		//Home
		JButton btnManageGroups = new JButton("Home");
		btnManageGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.main(null);
				rframe.dispose();
				new Home();
				
			}
		});
		btnManageGroups.setHorizontalAlignment(SwingConstants.LEFT);
		btnManageGroups.setIcon(new ImageIcon(home_logo));
		btnManageGroups.setBounds(0, 13, 262, 33);
		panel_1.add(btnManageGroups);
		
		btnManageGroups.setForeground(new Color(255, 255, 255));
		btnManageGroups.setBackground(new Color(0, 139, 139));
		btnManageGroups.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		/*JLabel rlblNewLabel_1 = new JLabel(" Manage Sessions Rooms");
		rlblNewLabel_1.setForeground(new Color(32, 178, 170));
		rlblNewLabel_1.setBackground(new Color(32, 178, 170));
		rlblNewLabel_1.setBounds(262, 69, 1082, 36);
		rlblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		rlblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		rframe.getContentPane().add(rlblNewLabel_1);*/
		
		JSeparator separator = new JSeparator();
		separator.setBounds(262, 108, 1082, 12);
		separator.setForeground(new Color(32, 178, 170));
		separator.setBackground(new Color(0, 139, 139));
		rframe.getContentPane().add(separator);
		
		JPanel srpanel_2 = new JPanel();
		srpanel_2.setBackground(new Color(230, 230, 250));
		srpanel_2.setBounds(262, 108, 1082, 563);
		rframe.getContentPane().add(srpanel_2);
		srpanel_2.setLayout(null);
		
		JPanel srpanel_3 = new JPanel();
		srpanel_3.setBounds(36, 82, 1018, 448);
		srpanel_2.add(srpanel_3);
		srpanel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Session");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(108, 79, 116, 13);
		srpanel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(560, 79, 78, 13);
		srpanel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selected Session Room");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(108, 179, 167, 32);
		srpanel_3.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 184, 647, 60);
		srpanel_3.add(scrollPane);
		
		generateroom = new JTextArea();
		scrollPane.setViewportView(generateroom);
		generateroom.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("SUBMIT");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText(session.getSelectedItem().toString()+"\n"+"-"+sessionroom.getSelectedItem().toString());
				
				String sessionCode=session.getSelectedItem().toString();
				String room=sessionroom.getSelectedItem().toString();
				String sessionRoomCode = generateroom.getText();
				
				try {
					Connection con = DbConnection.connect();
					
					String query = "INSERT INTO roomSession values (null,'"+sessionCode+"','"+room+"','"+sessionRoomCode+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x==0) {
						JLabel label = new JLabel("This is alredy exist");
    					label.setHorizontalAlignment(SwingConstants.CENTER);
    					JOptionPane.showMessageDialog(null, label);
					}else {
    						JLabel label = new JLabel("Inserted Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
    					}
						
    					con.close();
					
				}catch(Exception exception) {
					exception.printStackTrace();
					
				}
				
		}
		
	});
		
		btnNewButton_4.setBackground(new Color(0, 139, 139));
		btnNewButton_4.setBounds(404, 299, 105, 32);
		srpanel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CLEAR");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText("");
				session.setSelectedIndex(0);
				sessionroom.setSelectedIndex(0);
				
			}
		});
		btnNewButton_5.setBackground(new Color(0, 139, 139));
		btnNewButton_5.setBounds(685, 299, 105, 32);
		srpanel_3.add(btnNewButton_5);
		
		session = new JComboBox();
		session.setModel(new DefaultComboBoxModel(new String[] {"Select Session---------------"}));
		session.setBounds(280, 71, 242, 30);
		srpanel_3.add(session);
		
		loadSession();
		
		sessionroom = new JComboBox();
		sessionroom.setModel(new DefaultComboBoxModel(new String[] {"Select Room-------------"}));
		sessionroom.setBounds(685, 71, 242, 30);
		srpanel_3.add(sessionroom);
		
		loadsessionRoom();
		
		JPanel srpanel_6 = new JPanel();
		srpanel_6.setBounds(0, 0, 1082, 49);
		srpanel_2.add(srpanel_6);
		srpanel_6.setLayout(null);
		
		
		JLabel lollblNewLabel_1 = new JLabel("Add Session Rooms");
		lollblNewLabel_1.setForeground(new Color(0, 128, 128));
		lollblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lollblNewLabel_1.setBounds(406, 13, 278, 31);
		srpanel_6.add(lollblNewLabel_1);
		
		//addsessionroom button
		JButton btnNewButton = new JButton("Add SessionRooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManageSessionsRooms manage_ro = new ManageSessionsRooms();
				//manage_ro.main(null);
				rframe.dispose();
				new ManageSessionsRooms();
				
			}
		});
		btnNewButton.setBounds(262, 70, 179, 38);
		rframe.getContentPane().add(btnNewButton);
		
		//viewsession button
		JButton btnNewButton_1 = new JButton("View Session Rooms");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ViewSeesionRooms view_ses = new ViewSeesionRooms();
				//view_ses.main(null);
				rframe.dispose();
				new ViewSeesionRooms();
			}
		});
		btnNewButton_1.setBounds(440, 70, 237, 38);
		rframe.getContentPane().add(btnNewButton_1);
		
		//add consession button
		JButton btnNewButton_2 = new JButton("Add ConsecutiveSessionsRooms");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ConsecutiveSessionRooms add_con = new ConsecutiveSessionRooms();
				//add_con.main(null);
				rframe.dispose();
				new ConsecutiveSessionRooms();
			
			}
		});
		btnNewButton_2.setBounds(677, 70, 251, 38);
		rframe.getContentPane().add(btnNewButton_2);
		
		//view consessionroom
		JButton btnNewButton_3 = new JButton("View ConsecutiveSessionsRooms");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ViewConsecutiveRooms view_con = new ViewConsecutiveRooms();
				//view_con.main(null);
				rframe.dispose();
				new ViewConsecutiveRooms();
				
			}
		});
		btnNewButton_3.setBounds(927, 70, 246, 38);
		rframe.getContentPane().add(btnNewButton_3);
		
		
		
		
		
	}
}
