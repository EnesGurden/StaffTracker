import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
    private JTextField textAdSoyad;
    private JTable jt;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
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
    public gui()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 581, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLog = new JButton("Show Log");
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
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
        jt.setModel(new DefaultTableModel(
            new Object[][] {
                { null, null, null, null },
                { null, null, null, null },
            },
            new String[] {
                "ID", "Ad Soyad", "Giri\u015F Tarihi", "\u00C7\u0131k\u0131\u015F Tarihi" }));
                jt.getColumnModel().getColumn(1).setPreferredWidth(118);
        jt.getColumnModel().getColumn(2).setPreferredWidth(151);
        jt.getColumnModel().getColumn(3).setPreferredWidth(126);
        jt.setBounds(10, 11, 545, 311);
        contentPane.add(jt);
        btnLog.setBounds(437, 333, 118, 23);
        contentPane.add(btnLog);

        JLabel lblAdSoyad = new JLabel("Ad Soyad: ");
        lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAdSoyad.setBounds(145, 124, 105, 14);
        contentPane.add(lblAdSoyad);

        textAdSoyad = new JTextField();
        textAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
        textAdSoyad.setBounds(236, 118, 163, 28);
        contentPane.add(textAdSoyad);
        textAdSoyad.setColumns(10);

        JButton btnGiris = new JButton("Giriş");
        btnGiris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (!textAdSoyad.getText().isEmpty()) {
                    Personel temp = new Personel(textAdSoyad.getText(), LocalDateTime.now(), null);
                    DB.insert(temp);
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ Lütfen ad soyad giriniz!");
                    return;
                }
            }
        });
        btnGiris.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGiris.setBounds(195, 183, 89, 23);
        contentPane.add(btnGiris);

        JButton btnCikis = new JButton("Çıkış");
        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (!textAdSoyad.getText().isEmpty()) {
                    Personel temp = new Personel(textAdSoyad.getText(), null, LocalDateTime.now());
                    DB.insert(temp);
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ Lütfen ad soyad giriniz!");
                    return;
                }
            }
        });
        btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCikis.setBounds(310, 183, 94, 23);
        contentPane.add(btnCikis);
    }
}
