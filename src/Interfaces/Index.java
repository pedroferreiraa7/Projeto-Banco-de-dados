package Interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Index extends JFrame implements ActionListener {

    JLabel ltexto, lfoto;
    JButton bsaldo,bsair, bcadastro;

    public Index() {

        Container fundo;
        fundo = this.getContentPane();
        fundo.setBackground(Color.gray);

        lfoto = new JLabel("");
        ImageIcon img1 = new ImageIcon("src/Imagens/assur.png");

        ltexto = new JLabel("Use passe");
        ltexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        bsaldo = new JButton("Saldo");
      
        bsair = new JButton("Sair");
        bcadastro = new JButton("Cadastro");

        ltexto.setBounds(290, 1, 200, 200);
        bsaldo.setBounds(10, 500, 150, 50);
      
        lfoto.setBounds(180, 10, 600, 280);
        bsair.setBounds(230, 500, 150, 50);
        bcadastro.setBounds(430, 500, 150, 50);

        this.add(lfoto);
        this.add(ltexto);
        this.add(bsaldo);

        this.add(bsair);
        this.add(bcadastro);

        bsaldo.addActionListener(this);
        
        bsair.addActionListener(this);
        bcadastro.addActionListener(this);

        this.setSize(700, 700);

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bsaldo)) {
            TelaSaldo saldo = new TelaSaldo();

        } else if (ae.getSource().equals(bsair)) {
            this.setVisible(false);

        } else if (ae.getSource().equals(bcadastro)) {
            Cadastro cadastro = new Cadastro();

        }

    }

}
