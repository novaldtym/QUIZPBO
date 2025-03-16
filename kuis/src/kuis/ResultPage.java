
package kuis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResultPage  extends JFrame {
    private JLabel hasilLabel;
    
    public ResultPage (String nama, String nim,String pilihan, double hasil) {
        setTitle("Result Page");
        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String kelulusan = tentukanKelulusan(hasil);
        if (kelulusan.equals("DITERIMA")){
            hasilLabel = new JLabel("DITERIMA !!!" + nama "(" + nim ")" + "Kamu DITERIMA sebagai" + pilihan );
            hasilLabel.setBounds(250, 100, 300, 30);
            hasilLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 20));
            add(hasilLabel);
        } else {
            hasilLabel = new JLabel("TIDAK DITERIMA !!!" + nama "(" + nim ")" + "Kamu TIDAK DITERIMA sebagai" + pilihan );
            hasilLabel.setBounds(250, 100, 300, 30);
            hasilLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 20));
            add(hasilLabel);
        
        }
    }
    
    private String tentukanKelulusan(double hasil) {
        if (hasil >= 85)
                return "DITRERIMA";
            } else {
                return "TIDAK DITERIMA"
            }
    }
}
