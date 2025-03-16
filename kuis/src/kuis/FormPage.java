package kuis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormPage extends JFrame implements ActionListener{
    JButton tombolApply;
    JLabel namaLabel, nimLabel, judulLabel, writingLabel, codingLabel, interviewLabel;
    JTextField namaField, nimField,writingField,codingField,interviewField;
    JRadioButton radioAndro,radioWeb;
    ButtonGroup groupPilihan;

    
    private void iniComponents() {
        setTitle("Envorement Software Development Intern");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        judulLabel = new JLabel ("REGISTRATION FORM");
        judulLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 25));
        judulLabel.setBounds(250, 10, 200, 30);
        add(judulLabel);
        
        namaLabel = new JLabel ("Nama");
        namaLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 15));
        namaLabel.setBounds(50, 60, 30, 30);
        add(namaLabel);
        
        nimLabel = new JLabel ("NIM");
        nimLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 15));
        nimLabel.setBounds(50, 100, 30, 30);
        add(nimLabel);
        
        writingLabel = new JLabel ("Writing Score");
        writingLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 15));
        writingLabel.setBounds(450, 100, 200, 30);
        add(writingLabel);
        
        
        codingLabel = new JLabel ("Coding Score");
        codingLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 15));
        codingLabel.setBounds(450, 150, 200, 30);
        add(codingLabel);
        
        
        interviewLabel = new JLabel ("Interview Score");
        interviewLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 15));
        interviewLabel.setBounds(450, 200, 200, 30);
        add(interviewLabel);
        
        // Input Field
        namaField = new JTextField();
        namaField.setBounds(80, 60, 150, 30);
        add(namaField);

        nimField = new JTextField();
        nimField.setBounds(80, 100, 150, 30);
        add(nimField);

        
        radioAndro = new JRadioButton("Android Developer");
        radioWeb = new JRadioButton("Web Developer");
        groupPilihan = new ButtonGroup();
        groupPilihan.add(radioAndro);
        groupPilihan.add(radioWeb);;
        radioAndro.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        radioWeb.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        radioAndro.setBounds(50, 150, 100, 30);
        radioWeb.setBounds(50, 200 , 100, 30);
        add(radioAndro);
        add(radioWeb);
        
        tombolApply = new JButton ("APPLY");
        tombolApply.setBounds(330, 300, 100, 30);
        tombolApply.addActionListener(this);
        add(tombolApply);
        
    
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tombolApply) {
            applyAction();
        }

    }
    
    private void applyAction() {
        try {
            String nama = namaField.getText().trim();
            String nim = nimField.getText().trim();
            String pilihan = "";

            if (radioAndro.isSelected()) {
                pilihan = "Android Developer";
               } else if (radioWeb.isSelected()) {
                pilihan = "Web Developer";
               }
            if (!radioAndro.isSelected() && !radioWeb.isSelected()) {
                JOptionPane.showMessageDialog(this, "Pilih salah satu pilihan", "Error", JOptionPane.ERROR_MESSAGE);
                return;
               }
            if (nama.isEmpty() || nim.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
               return;

            if (pilihan.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Pilih salah satu jenis Magang", "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }
            
            double writing = double.parsedouble(writingField.getText());
            double coding = double.parsedouble(codingField.getText());
            double interview = double.parsedouble(interviewField.getText());
            
            String pilih = pilihan;
            double hasil;
            if (pilih.equals("Android Developer")){
                double writingS = writing * 0.20;
                double codingS = coding * 0.50;
                double interS = interview * 0.30;
                hasil = writingS + codingS + interS;
          
            } else {
                double writingS = writing * 0.40;
                double codingS= coding * 0.35;
                double interS = coding * 0.25;
                hasil = writingS + codingS + interS;
                     
            }
            
            
            
            // Pindah ke halaman berikutnya
              new ResultPage(nama, nim, pilihan, hasil);
              dispose();
           }
        } catch (Exception ex){
           
            JOptionPane.showMessageDialog(this, "Tolong isi umur dengan angka", "Error", JOptionPane.ERROR_MESSAGE);
        
        }
   
 }
    
    public FormPage(){
        initComponents();
    }    
}
