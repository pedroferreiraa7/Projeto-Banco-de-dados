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

public class Cadastro extends JFrame implements ActionListener {

    JLabel ltexto, lcpf, lrecarregue, lnome;
    JButton bvoltar, bcadastrarusu;
    JTextField tcpf, trecarregue, tnome;

    public Cadastro() {

        ltexto = new JLabel("Cadastro Assur");
        ltexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        lnome = new JLabel("Digite o seu Nome:");
        tnome = new JTextField("");

        lcpf = new JLabel("Digite o Seu CPF:");
        tcpf = new JTextField("");

        lrecarregue = new JLabel("Recarregue o cartão (OBRIGATORIO):");
        trecarregue = new JTextField("");

        bvoltar = new JButton("Voltar");

        bcadastrarusu = new JButton("Cadastrar");

        ltexto.setBounds(160, 1, 200, 200);
        lrecarregue.setBounds(10, 220, 300, 200);
        trecarregue.setBounds(270, 310, 123, 20);
        bcadastrarusu.setBounds(140, 370, 120, 20);
        lcpf.setBounds(10, 100, 200, 200);
        tcpf.setBounds(140, 190, 123, 20);
        bvoltar.setBounds(10, 450, 150, 50);
        lnome.setBounds(10, 170, 200, 200);
        tnome.setBounds(150, 260, 123, 20);

        this.add(ltexto);
        this.add(lcpf);
        this.add(bvoltar);
        this.add(tnome);
        this.add(lnome);

        this.add(tcpf);
        this.add(trecarregue);
        this.add(bcadastrarusu);
        this.add(lrecarregue);

        this.add(trecarregue);

        this.add(bcadastrarusu);

        this.add(bcadastrarusu);

        bvoltar.addActionListener(this);
        bcadastrarusu.addActionListener(this);

        this.setBounds(10, 10, 500, 600);
        this.setBackground(Color.gray);

        this.setLayout(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bvoltar)) {
            Index tela = new Index();
        } else if (ae.getSource().equals(bcadastrarusu)) {
            try {
                Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cartaoassur", "root", "");
                System.out.println("passou conexao");
                Contato contato = new Contato();
                contato.setNome(tnome.getText());
                contato.setCpf(Integer.parseInt(tcpf.getText()));
                contato.setRecarga(Double.parseDouble(trecarregue.getText()));

                String sql = "INSERT INTO assur(nome, cpf, valorrecarga) values (?,?,?);";
                System.out.println("passou insert");
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, contato.getNome());
                ps.setInt(2, contato.getCpf());
                ps.setDouble(3, contato.getRecarga());

                JOptionPane.showMessageDialog(null, "Cadastro e recarga Efetuada");
                System.out.println("Conectado!");

                tnome.setText("");
                trecarregue.setText("");
                tcpf.setText("");

                ps.executeUpdate();
                conexao.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não Cadastrado!!");
            }
        }
    }
}
