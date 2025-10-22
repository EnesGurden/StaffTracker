import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textAdSoyad;
	private static JTextField textKimlikNo;
	private static JTextField textDogum;
	private static JTextField textAnneAdi;
	private static JTextField textBabaAdi;
	private JTable jt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLog = new JButton("Show Log");
		btnLog.setVisible(false);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnLog.getText().equals("Show Log")) {
					List<Personel> personelList = new ArrayList<>();
					;
					try {
						personelList = DB.selectAll();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					DefaultTableModel table = new DefaultTableModel(personelList.size(), 4);
					for (Personel p : personelList) {
						Object[] rowData = new Object[4];
						rowData[0] = p.getId();
						rowData[1] = p.getAdSoyad();
						rowData[2] = p.getGirisTarihi();
						rowData[3] = p.getCikisTarihi();
						table.addRow(rowData);
					}
					jt.setModel(table);
					jt.setVisible(true);
					btnLog.setText("Hide Log");
				} else {
					jt.setVisible(false);
					btnLog.setText("Show Log");
				}
			}
		});

		jt = new JTable();
		jt.setVisible(false);
		jt.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, },
				new String[] { "ID", "Ad Soyad", "Giri\u015F Tarihi", "\u00C7\u0131k\u0131\u015F Tarihi" }));
		jt.getColumnModel().getColumn(1).setPreferredWidth(118);
		jt.getColumnModel().getColumn(2).setPreferredWidth(151);
		jt.getColumnModel().getColumn(3).setPreferredWidth(126);
		jt.setBounds(10, 11, 545, 311);
		contentPane.add(jt);
		btnLog.setBounds(437, 333, 118, 23);
		contentPane.add(btnLog);

		JLabel lblAdSoyad = new JLabel("Ad Soyad: ");
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdSoyad.setBounds(135, 24, 105, 14);
		contentPane.add(lblAdSoyad);

		textAdSoyad = new JTextField();
		textAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdSoyad.setBounds(236, 18, 163, 28);
		textAdSoyad.setColumns(10);
		contentPane.add(textAdSoyad);

		JLabel lblKimlikNo = new JLabel("Kimlik No: ");
		lblKimlikNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKimlikNo.setBounds(135, 64, 105, 14);
		contentPane.add(lblKimlikNo);

		textKimlikNo = new JTextField();
		textKimlikNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textKimlikNo.setBounds(236, 58, 163, 28);
		textKimlikNo.setColumns(10);
		contentPane.add(textKimlikNo);
		lastCheck();

		JLabel lblDogum = new JLabel("Doğum Tarihi: ");
		lblDogum.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDogum.setBounds(135, 104, 105, 18);
		contentPane.add(lblDogum);

		textDogum = new JTextField();
		textDogum.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDogum.setBounds(236, 98, 163, 28);
		textDogum.setColumns(10);
		contentPane.add(textDogum);

		JLabel lblAnneAdi = new JLabel("Anne Adı: ");
		lblAnneAdi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnneAdi.setBounds(135, 144, 105, 18);
		contentPane.add(lblAnneAdi);

		textAnneAdi = new JTextField();
		textAnneAdi.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAnneAdi.setBounds(236, 138, 163, 28);
		textAnneAdi.setColumns(10);
		contentPane.add(textAnneAdi);

		JLabel lblBabaAdi = new JLabel("Baba Adı: ");
		lblBabaAdi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBabaAdi.setBounds(135, 184, 105, 18);
		contentPane.add(lblBabaAdi);

		textBabaAdi = new JTextField();
		textBabaAdi.setFont(new Font("Tahoma", Font.BOLD, 14));
		textBabaAdi.setBounds(236, 178, 163, 28);
		textBabaAdi.setColumns(10);
		contentPane.add(textBabaAdi);

		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMessage = lastCheck();
				if (errorMessage == null) {
					Personel p = new Personel(textAdSoyad.getText(), textKimlikNo.getText(), textDogum.getText(),
							textAnneAdi.getText(), textBabaAdi.getText(), LocalDateTime.now(), null);
					DB.insert(p);
				} else {
					JOptionPane.showMessageDialog(null, errorMessage);
					return;
				}
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGiris.setBounds(195, 223, 89, 23);
		contentPane.add(btnGiris);

		JButton btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMessage = lastCheck();
				if (errorMessage == null) {
					Personel p = new Personel(textAdSoyad.getText(), textKimlikNo.getText(), textDogum.getText(),
							textAnneAdi.getText(), textBabaAdi.getText(), null, LocalDateTime.now());
					DB.insert(p);
				} else {
					JOptionPane.showMessageDialog(null, errorMessage);
					return;
				}
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(310, 223, 94, 23);
		contentPane.add(btnCikis);
	}

	private String lastCheck() {
		String adSoyad = textAdSoyad.getText().trim();
		if (adSoyad.isEmpty()) {
			return "❌ Ad Soyad boş olamaz!";
		} else if (adSoyad.matches(".*\\d.*")) {
			return "❌ Ad Soyad rakam içeremez!";
		}

		String kimlikNo = textKimlikNo.getText().trim();
		if (kimlikNo.length() != 11) {
			return "❌ Kimlik No 11 haneli olmalıdır!";
		} else if (!kimlikNo.matches("^\\d{11}$")) {
			return "❌ Kimlik No sadece rakam içermelidir!";
		}

		String dogumTarihi = textDogum.getText().trim();
		if (dogumTarihi.isEmpty()) {
			return "❌ Doğum tarihi boş olamaz!";
		} else {
			try {
				LocalDate.parse(dogumTarihi);
			} catch (Exception ex) {
				return "❌ Geçersiz Tarih formatı! (YYYY-MM-DD)";
			}
		}

		String anneAdi = textAnneAdi.getText().trim();
		if (anneAdi.isEmpty()) {
			return "❌ Anne adı boş olamaz!";
		} else if (anneAdi.matches(".*\\d.*")) {
			return "❌ Anne adı rakam içeremez!";
		}

		String babaAdi = textBabaAdi.getText().trim();
		if (babaAdi.isEmpty()) {
			return "❌ Baba adı boş olamaz!";
		} else if (babaAdi.matches(".*\\d.*")) {
			return "❌ Baba adı rakam içeremez!";
		}
		return null;
	}
}
