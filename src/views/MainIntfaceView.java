package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.myCompenent.MyTableModel;

import httpFrame.http.Http;
import httpFrame.http.dasApi.DownLoadApkTest;
import tools.IpAddressUtil;
import tools.LogsWriter;
import tools.Protocol;
import tools.SystemTimes;
import udp.CommandSocket;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.datatransfer.StringSelection;
import java.awt.GridLayout;

public class MainIntfaceView extends JFrame implements ActionListener,WindowListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable devTable;
	private JPanel panel_10;
	private JRadioButton broadcastIPRadioButton;
	public static JRadioButton overlayIPRadioButton;
	private JLabel label;
	public static JLabel ipJLabel1;
	public static JTextField overlayIPTextField;
	public static JLabel ipJLabel2;
	public static JTextField overlayIPTextField2;
	public static JLabel ipJLabel3;
	private static String ip = "255.255.255.255";
	private JPanel panel_6;
	private JButton getDevButton;
	private JPanel panel_9;
	private JRadioButton devCheckBox;
	private JRadioButton devCheckBox_1;
	private JButton btnD;
	private static CommandSocket commandSocket = null;
	private static Protocol protocol = null;
	private JTabbedPane tabbedPane;
	private JPanel panel_2;
	private JPanel panel_3;
	public static JTextArea logTextArea;
	private JTextField copyUrlTextField_1;
	private JLabel lblUrl;
	private JButton button;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainIntfaceView frame = new MainIntfaceView();
					frame.setVisible(true);
					new Http();
				} catch (Exception e) {
					e.printStackTrace();
				}
				protocol = new Protocol();
				commandSocket = new CommandSocket();
				new Thread(commandSocket).start(); 
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public MainIntfaceView() {
		setTitle("IP\u53C2\u6570\u8BBE\u7F6E");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 120, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		this.addWindowListener(this);
		
		
		ButtonGroup bg = new ButtonGroup();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("设备信息", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_10 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(panel_10);
		
		label = new JLabel("   \u641C\u7D22\u7C7B\u578B\uFF1A");
		label.setFont(new Font("宋体14", Font.PLAIN, 14));
		panel_10.add(label);
		
		broadcastIPRadioButton = new JRadioButton("\u5E7F\u64AD\u641C\u7D22");
		broadcastIPRadioButton.setSelected(true);
		broadcastIPRadioButton.setFont(new Font("宋体14", Font.PLAIN, 14));
		broadcastIPRadioButton.addActionListener(this);
		panel_10.add(broadcastIPRadioButton);
		
		overlayIPRadioButton = new JRadioButton("\u8DE8\u7F51\u6BB5\u641C\u7D22");
		overlayIPRadioButton.setFont(new Font("宋体14", Font.PLAIN, 14));
		overlayIPRadioButton.addActionListener(this);
		panel_10.add(overlayIPRadioButton);
		bg.add(broadcastIPRadioButton);
		bg.add(overlayIPRadioButton);
		
		ipJLabel1 = new JLabel("   起始IP地址：");
		ipJLabel1.setFont(new Font("宋体14", Font.PLAIN, 14));
		panel_10.add(ipJLabel1);
		
		overlayIPTextField = new JTextField();
		overlayIPTextField.setHorizontalAlignment(SwingConstants.CENTER);
		overlayIPTextField.setText("192.168.");
		overlayIPTextField.setFont(new Font("宋体14", Font.PLAIN, 14));
		panel_10.add(overlayIPTextField);
		overlayIPTextField.setColumns(15);
		
		ipJLabel2 = new JLabel(" \u6570\u91CF:");
		ipJLabel2.setFont(new Font("宋体14", Font.PLAIN, 14));
		panel_10.add(ipJLabel2);
		
		overlayIPTextField2 = new JTextField();
		overlayIPTextField2.setHorizontalAlignment(SwingConstants.CENTER);
		overlayIPTextField2.setFont(new Font("宋体14", Font.PLAIN, 14));
		panel_10.add(overlayIPTextField2);
		overlayIPTextField2.setColumns(5);
		
		ipJLabel3 = new JLabel("\u4F8B\uFF1A192.168.0.1 25,\u5171\u641C\u7D2225\u53F0\u8BBE\u5907");
		ipJLabel3.setFont(new Font("宋体14", Font.PLAIN, 11));
		panel_10.add(ipJLabel3);
		
		ipJLabel1.setVisible(false);
		ipJLabel2.setVisible(false);
		ipJLabel3.setVisible(false);
		overlayIPTextField.setVisible(false);
		overlayIPTextField2.setVisible(false);
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		getDevButton = new JButton("搜索设备");
		panel_6.add(getDevButton);
		getDevButton.setFont(new Font("宋体14", Font.PLAIN, 14));
		
		btnD = new JButton("D20程序更新");
		panel_6.add(btnD);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread(()->{
					JFileChooser jfc=new JFileChooser();  
					jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
//					FileNameExtensionFilter filter = new FileNameExtensionFilter("*.apk");
//					jfc.setFileFilter(filter);
					jfc.setCurrentDirectory(new File("./APK"));
					jfc.setDialogTitle("请选择D20程序升级文件：。apk后缀");  
					int returnVal = jfc.showOpenDialog(null);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file=jfc.getSelectedFile();  
//						System.out.println(returnVal);
						
						String url = "";
						if( null != file) {
							DownLoadApkTest.setFileName(file.getName());
							DownLoadApkTest.setFilePath(file.getParent());
							DownLoadApkTest.setDownLocalFile(".APK");
							url = "http://" + Http.getServerIP() + ":" + Http.getPort() + DownLoadApkTest.URL_NAME +"/"+ file.getName();
							copyUrlTextField_1.setText(url);
						}
						
						protocol.commandWord = "01";
						protocol.validData = "{\"AppUrl\":\"" + url + "\"}";
						protocol.commandLength = Integer.toHexString(protocol.validData.length());
						System.out.println(protocol.validData);
						DefaultTableModel tableModel = (DefaultTableModel)devTable.getModel();
						int count = tableModel.getRowCount();
						for (int i = 0 ; i < count; i++) {
							if ((boolean) tableModel.getValueAt(i, 1)) {
								commandSocket.SendDatagram(tableModel.getValueAt(i, 3).toString(), protocol.getSendDate());
								tableModel.setValueAt("正在升级中", i, 7);
							}
						}
					}
					
					
//					String logs = "<html>["+SystemTimes.getSysTime()+"] 鍚慽p涓猴紙"+ip+"锛夊彂閫佹暟鎹細"+ url +"<br>";
//					if(CommandSocket.isNotReceiveData(3000)) {
//						logs += "["+SystemTimes.getSysTime()+"] ip涓猴紙"+ip+"锛夎繑鍥炴暟鎹細"+CommandSocket.getReceiveData()+"<br>";
//					}else {
//						logs += "["+SystemTimes.getSysTime()+"] ip涓猴紙"+ip+"锛�3s鍐呮湭杩斿洖鏁版嵁<br></html>";
//					}
				}).start(); 
			}
		});
		btnD.setHorizontalAlignment(SwingConstants.RIGHT);
		btnD.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		lblUrl = new JLabel("Url地址：");
		panel_6.add(lblUrl);
		
		copyUrlTextField_1 = new JTextField();
		copyUrlTextField_1.setEditable(false);
		panel_6.add(copyUrlTextField_1);
		copyUrlTextField_1.setFont(new Font("宋体14", Font.PLAIN, 14));
		copyUrlTextField_1.setColumns(50);
		
		button = new JButton("复制");
		panel_6.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				java.awt.datatransfer.Clipboard clipboard=getToolkit().getSystemClipboard();
				StringSelection text1=new StringSelection(copyUrlTextField_1.getText().replaceAll(" ", ""));
				clipboard.setContents(text1, null);
			}
		});
		button.setFont(new Font("宋体14", Font.PLAIN, 14));
		getDevButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new Thread(()->{
					protocol.commandWord = "00";
					protocol.commandLength = "000000";
					if (broadcastIPRadioButton.isSelected()) {
//						commandSocket.SendDatagram("255.255.255.255",protocol.getSendDate());
//						测试
						commandSocket.SendDatagram("172.20.1.84",protocol.getSendDate());
//						commandSocket.SendDatagram("255.255.255.255","Send00000000");
					}else if (overlayIPRadioButton.isSelected()) {
						ip = overlayIPTextField.getText().trim();
						if(!IpAddressUtil.isIP(ip)) {
							JOptionPane.showMessageDialog(null, "请输入正确的IP地址", "跨网段搜索设备", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								
								int length = Integer.parseInt(overlayIPTextField2.getText().trim().replaceAll(" ", ""), 10);
								String[] IPstr = ip.split("\\.");
								for (int i = 0; i < length ;i++) {
									if((Integer.parseInt(IPstr[3], 10)+i) <= 255) {
										ip = IPstr[0]+"."+ IPstr[1]+"."+IPstr[2]+"."+(Integer.parseInt(IPstr[3], 10)+i);
										commandSocket.SendDatagram(ip, protocol.getSendDate());
									}else {
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, "搜索数量不能为空或者非数字", "跨网段搜索设备", JOptionPane.ERROR_MESSAGE);
//								e.printStackTrace();
							}
						}
					}
				}).start();
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(BorderFactory.createTitledBorder("设备参数信息"));
		devTable = new JTable();
		devTable.setCellSelectionEnabled(true);
		devTable.setColumnSelectionAllowed(true);
		devTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u9009\u4E2D", "\u8BBE\u5907MAC\u5730\u5740", "\u8BBE\u5907IP", "\u7AEF\u53E3", "\u8BBE\u5907\u540D\u79F0", "\u8F6F\u4EF6\u7248\u672C\u53F7", "\u5347\u7EA7\u72B6\u6001"
			}
			
		) {
			@Override
			public boolean isCellEditable(int row, int column) {
				 return false;
			}
		});
		devTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		devTable.getColumnModel().getColumn(0).setMinWidth(40);
		devTable.getColumnModel().getColumn(0).setMaxWidth(40);
		devTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		devTable.getColumnModel().getColumn(1).setMinWidth(50);
		devTable.getColumnModel().getColumn(1).setMaxWidth(50);
		devTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		devTable.getColumnModel().getColumn(2).setMinWidth(80);
		devTable.getColumnModel().getColumn(2).setMaxWidth(180);
		devTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		devTable.getColumnModel().getColumn(3).setMinWidth(120);
		devTable.getColumnModel().getColumn(3).setMaxWidth(180);
		devTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		devTable.getColumnModel().getColumn(4).setMinWidth(80);
		devTable.getColumnModel().getColumn(4).setMaxWidth(80);
		devTable.getColumnModel().getColumn(5).setPreferredWidth(120);
		devTable.getColumnModel().getColumn(5).setMinWidth(120);
		devTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		devTable.getColumnModel().getColumn(6).setMinWidth(100);
		devTable.getColumnModel().getColumn(6).setMaxWidth(150);
		TableColumn tc = devTable.getColumnModel().getColumn(1);
		tc.setCellEditor(devTable.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(devTable.getDefaultRenderer(Boolean.class));
		devTable.addMouseListener(this);

		devTable.setFont(new Font("宋体14", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(devTable);
		scrollPane.setEnabled(false);
		panel_1.add( scrollPane, BorderLayout.CENTER);
		
		panel_9 = new JPanel();
		panel_1.add(panel_9, BorderLayout.NORTH);
		FlowLayout flowLayout_4 = (FlowLayout) panel_9.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		devCheckBox = new JRadioButton("\u5168\u9009");
		devCheckBox.setFont(new Font("宋体14", Font.PLAIN, 12));
		devCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(devCheckBox.isSelected()) {
//					devCheckBox_1.setSelected(false);
					DefaultTableModel model = (DefaultTableModel)devTable.getModel();
//					List<Vector<Object>> list = model.getDataVector();
////					model.setRowCount(0);
					
					for(int i = 0 ; i < model.getRowCount(); i ++) {
						model.setValueAt(true, i, 1);
					}
					model.fireTableDataChanged();
				}
			}
		});
		panel_9.add(devCheckBox);
		
		devCheckBox_1 = new JRadioButton("\u5168\u4E0D\u9009");
		devCheckBox_1.setFont(new Font("宋体14", Font.PLAIN, 12));
		devCheckBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(devCheckBox_1.isSelected()) {
//					devCheckBox.setSelected(false);
					DefaultTableModel model = (DefaultTableModel)devTable.getModel();
					for(int i = 0 ; i < devTable.getRowCount(); i ++) {
						model.setValueAt(false, i, 1);
					}
					model.fireTableDataChanged();
				}
			}
		});
		panel_9.add(devCheckBox_1);
		
		ButtonGroup bg1= new ButtonGroup();
		bg1.add(devCheckBox);
		bg1.add(devCheckBox_1);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("日志", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		logTextArea = new JTextArea();
		panel_3.add(logTextArea, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(broadcastIPRadioButton.isSelected()) {
			ipJLabel1.setVisible(false);
			ipJLabel2.setVisible(false);
			ipJLabel3.setVisible(false);
			overlayIPTextField.setVisible(false);
			overlayIPTextField2.setVisible(false);
		}else if(overlayIPRadioButton.isSelected()) {
			ipJLabel1.setVisible(true);
			ipJLabel2.setVisible(true);
			ipJLabel3.setVisible(true);
			overlayIPTextField.setVisible(true);
			overlayIPTextField2.setVisible(true);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel)devTable.getModel();
		int row = devTable.getSelectedRow();
//		System.out.println(row);
//		System.out.println(model.getValueAt(row, 1));
		if ((boolean) model.getValueAt(row, 1)) {
			model.setValueAt(false, row, 1);
		}else {
			model.setValueAt(true, row, 1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 鍐欐棩蹇楋紝 url 涓簄ull 鍒欎笉鍐檜rl
	 * @param url
	 * @param info
	 */
	public static void writeLogsTextArea(String url, String info) {
		if (logTextArea.getLineCount() > 500) {
			logTextArea.setText("");
		}
		info = LogsWriter.writeUrlInfo(LogsWriter.All_LOGS, url, info);
		
		if(info.length() < 10000) {
			logTextArea.append(info);
//			logTextArea.paintImmediately(logTextArea.getBounds()); 
			
		}else {
			logTextArea.append("[" + SystemTimes.getSysTime() + "]" + "  " + url + "\r\n");
		}
		logTextArea.setCaretPosition( logTextArea.getDocument().getLength());
	}
	
}
