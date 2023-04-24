package Models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class InterfaceCadastro extends JFrame implements ActionListener {

    private JPanel pnlForm;
    private JPanel pnlRodape;

    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JButton btnSair;

    // Campos do formulário
    private JLabel lblNome;
    private JTextField txtNome;

    private JLabel lblEmail;
    private JTextField txtEmail;

    private JLabel lblSenha;
    private JPasswordField pwdSenha;

    private JLabel lblTelefone;
    private JTextField txtTelefone;

    private JLabel lblGenero;
    private JComboBox<String> cmbGenero;


    public InterfaceCadastro() {
        this.setResizable(false);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
    }

    private JPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCadastrar = new JButton("Cadastrar");
            btnVoltar = new JButton("Voltar");
            btnSair = new JButton("Sair");

            pnlRodape.add(btnCadastrar);
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);
            
            btnCadastrar.addActionListener(this);
            btnVoltar.addActionListener(this);
            btnSair.addActionListener(this);
        }
        return pnlRodape;
    }


    private JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel(new GridLayout(6, 2));
            
            lblNome = new JLabel("Nome (contendo ao menos 3 caracteres):");
            txtNome = new JTextField(20);
            
            lblEmail = new JLabel("Email (Exemplo: usuário@email.com):");
            txtEmail = new JTextField(20);

            lblSenha = new JLabel("Senha(Deve conter 4 numeros no minimo):");
            pwdSenha = new JPasswordField(20);

            lblTelefone = new JLabel("Telefone:(No formato +55***********)");
            txtTelefone = new JTextField(20);

            lblGenero = new JLabel("Gênero:");
            cmbGenero = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});

            pnlForm.add(lblNome);
            pnlForm.add(txtNome);

            pnlForm.add(lblTelefone);
            pnlForm.add(txtTelefone);

            pnlForm.add(lblEmail);
            pnlForm.add(txtEmail);

            pnlForm.add(lblSenha);
            pnlForm.add(pwdSenha);

            pnlForm.add(lblGenero);
            pnlForm.add(cmbGenero);

        }
        return pnlForm;
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            try {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String senha = new String(pwdSenha.getPassword());
                String telefone = txtTelefone.getText();
                char genero = cmbGenero.getSelectedItem().toString().charAt(0);

                ModeloDados modelo = new ModeloDados();
                modelo.cadastrarUsuario(0, nome, genero, telefone, "", email, senha);

                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

                int opcao = JOptionPane.showOptionDialog(this, "Deseja realizar o login?", "Sucesso!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, "Não");

                if (opcao == JOptionPane.YES_OPTION) {
                	
                    this.setVisible(false);
                    InterfaceCrud interfaceCrud = new InterfaceCrud();
                    interfaceCrud.setVisible(true); 
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage());
            }
        } else if (e.getSource() == btnVoltar) {
            this.setVisible(false);
            InterfaceCrud interfaceCrud = new InterfaceCrud();
            interfaceCrud.setVisible(true); 
        } else if (e.getSource() == btnSair) {
            dispose();
        }
    }
}