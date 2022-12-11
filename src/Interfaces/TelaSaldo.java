package Interfaces;

import Contato.Contato;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaSaldo extends JFrame implements ActionListener {

    JLabel ltexto, lcpf, lsaldoatual, lnome;
    JButton bvoltar, bpesquisar;
    JTextField tcpf, tsaldoatual, tnome;

    public TelaSaldo() {

        ltexto = new JLabel("Seu Saldo Assur");
        ltexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        lnome = new JLabel("Seu nome");
        tnome = new JTextField("");

        lcpf = new JLabel("Digite o Seu CPF:");
        lsaldoatual = new JLabel("Seu Saldo e:");
        tsaldoatual = new JTextField("");
        tcpf = new JTextField("");
        bvoltar = new JButton("Voltar");

        bpesquisar = new JButton("Pesquisar");

        ltexto.setBounds(160, 1, 200, 200);
        lsaldoatual.setBounds(10, 220, 200, 200);
        tsaldoatual.setBounds(140, 310, 123, 20);
        bpesquisar.setBounds(140, 250, 120, 20);
        lcpf.setBounds(10, 100, 200, 200);
        tcpf.setBounds(140, 190, 123, 20);
        bvoltar.setBounds(10, 450, 150, 50);
        lnome.setBounds(10, 300, 200, 200);
        tnome.setBounds(140, 390, 123, 20);

        this.add(ltexto);
        this.add(lcpf);
        this.add(bvoltar);
        this.add(lnome);
        this.add(tnome);

        this.add(tcpf);
        this.add(lsaldoatual);
        this.add(tsaldoatual);
        this.add(bpesquisar);

        bvoltar.addActionListener(this);
        bpesquisar.addActionListener(this);

        this.setBounds(10, 10, 500, 600);
        this.setBackground(Color.gray);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bvoltar)) {
            Index tela = new Index();

        } else if (ae.getSource().equals(bpesquisar)) {

            try {
                Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cartaoassur", "root", "");
                System.out.println("Conectado!");
                tnome.setText("");
                int cpf=Integer.parseInt(tcpf.getText());
                tsaldoatual.setText("");
                String sql = "SELECT *FROM assur WHERE cpf =" + cpf + ";";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("informações" + rs.getString("nome"));
                    tsaldoatual.setText(Double.toString(rs.getDouble("valorrecarga")));
                    tnome.setText(rs.getString("nome"));
                }else
               
                    JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado !");             
                rs.close();
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não conectado!");
            }

        }
    }

}
