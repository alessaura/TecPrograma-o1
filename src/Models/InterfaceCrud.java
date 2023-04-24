package Models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCrud extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel labelEmail, labelSenha;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoAcessar, botaoCadastrar, botaoPerfil, botaoAlterar, botaoCadastro, botaoSair;
    private JLabel labelErro;

    public InterfaceCrud() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setTitle("Energy");
        getContentPane().setBackground(Color.WHITE);

        JPanel painel = criarPainel();
        JPanel painelPrincipal = criarPainelPrincipal(painel);
        JPanel painelRodape = criarPainelRodape();
        adicionarComponentes(painelPrincipal, painelRodape);

        botaoAcessar.addActionListener(this);
        botaoCadastrar.addActionListener(this);
        botaoSair.addActionListener(this);
    }

    private JPanel criarPainel() {
        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));
        painel.setBackground(Color.WHITE);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(15);
        painel.add(labelEmail);
        painel.add(campoEmail);

        labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(15);
        painel.add(labelSenha);
        painel.add(campoSenha);

        botaoAcessar = new JButton("Entrar");
        botaoAcessar.setBackground(new Color(29, 161, 242));
        botaoAcessar.setForeground(Color.WHITE);
        painel.add(new JLabel(""));
        painel.add(botaoAcessar);

        botaoCadastrar = new JButton("Cadastre-se");
        botaoCadastrar.setBackground(new Color(29, 161, 242));
        botaoCadastrar.setForeground(Color.WHITE);
        painel.add(new JLabel(""));
        painel.add(botaoCadastrar);

        return painel;
    }

    private JPanel criarPainelPrincipal(JPanel painel) {
        JPanel painelPrincipal = new JPanel(new GridLayout(0, 1, 10, 10));
        painelPrincipal.setBackground(Color.WHITE);
        painelPrincipal.add(painel);
        return painelPrincipal;
    }

    private JPanel criarPainelRodape() {
        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelRodape.setBackground(Color.WHITE);
        labelErro = new JLabel("");
        botaoSair = new JButton("Sair");
        painelRodape.add(labelErro);
        painelRodape.add(botaoSair);
        return painelRodape;
    }
    private void adicionarComponentes(JPanel painelPrincipal, JPanel painelRodape) {
        add(painelPrincipal);
        painelPrincipal.add(painelRodape);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAcessar) {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());
            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            } else {
                ModeloDados modelo = new ModeloDados();
                boolean autenticado = modelo.autenticarUsuario(email, senha);
                if (autenticado) {
                    setVisible(false);
                    InterfaceCadastro interfaceCadastro = new InterfaceCadastro();
                } else {
                    JOptionPane.showMessageDialog(this, "Email ou senha incorretos. Por favor, tente novamente.");
                }
            }
        } else if (e.getSource() == botaoCadastrar) {
            InterfaceCadastro interfaceCadastro = new InterfaceCadastro();
            interfaceCadastro.setVisible(true); 
            setVisible(false);
        }
    }
}