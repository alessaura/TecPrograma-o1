package Models;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AlterarUsuarioInterface extends JFrame {
    private ModeloDados modelo;
    private Usuario usuario;
    private JTextField nomeField;
    private JTextField dataNascimentoField;
    private JTextField generoField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private JTextField emailField;
    private JTextField senhaField;

    public AlterarUsuarioInterface(ModeloDados modelo, Usuario usuario) {
        super("Alterar Usuário");

        this.modelo = modelo;
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(String.valueOf(usuario.getId())));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField(usuario.getNome());
        panel.add(nomeField);

        panel.add(new JLabel("Gênero (F/M/O):"));
        generoField = new JTextField(String.valueOf(usuario.getGenero()));
        panel.add(generoField);

        panel.add(new JLabel("Telefone (+55XXXXXXXXXXX):"));
        telefoneField = new JTextField(usuario.getTelefone());
        panel.add(telefoneField);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField(usuario.getEndereco());
        panel.add(enderecoField);

        panel.add(new JLabel("E-mail:"));
        emailField = new JTextField(usuario.getEmail());
        panel.add(emailField);

        panel.add(new JLabel("Senha:"));
        senhaField = new JTextField(usuario.getSenha());
        panel.add(senhaField);

        JButton salvarButton = new JButton("Salvar Alterações");
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = usuario.getId();
                    String nome = nomeField.getText();
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    char genero = generoField.getText().charAt(0);
                    String telefone = telefoneField.getText();
                    String endereco = enderecoField.getText();
                    String email = emailField.getText();
                    String senha = senhaField.getText();

                    Usuario usuarioAtualizado = new Usuario(id, nome, dataNascimento, genero, telefone, endereco, email, senha);
                    modelo.atualizarUsuario(usuarioAtualizado);

                    dispose();
                    new InterfacePerfil(modelo, usuarioAtualizado);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(salvarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfacePerfil(modelo, usuario);
            }
        });
        panel.add(cancelarButton);

        add(panel);
        setVisible(true);
    }

	public AlterarUsuarioInterface() {
		// TODO Auto-generated constructor stub
	}
}
