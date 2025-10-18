import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAdSoyad;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad: ");
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdSoyad.setBounds(60, 75, 105, 14);
		contentPane.add(lblAdSoyad);
		
		textAdSoyad = new JTextField();
		textAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdSoyad.setBounds(175, 72, 163, 20);
		contentPane.add(textAdSoyad);
		textAdSoyad.setColumns(10);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personel temp= new Personel(textAdSoyad.getText(),LocalDateTime.now(),null);
				DB.insert(temp);
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGiris.setBounds(110, 134, 89, 23);
		contentPane.add(btnGiris);
		
		JButton btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personel temp= new Personel(textAdSoyad.getText(),null,LocalDateTime.now());
				DB.insert(temp);
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(225, 134, 94, 23);
		contentPane.add(btnCikis);

	}
}
