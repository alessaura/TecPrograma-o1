package Models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Usuario;
import Models.ModeloDados;


public class InterfacePerfil JFrame implements ActionListener {
    private Usuario usuario;
    private ModeloDados modeloDados;
    
    private JLabel nomeLabel;
    private JLabel emailLabel;
    private JButton excluirButton;
    private JButton editarButton;
    
    public InterfacePerfil(ModeloDados modeloDados, Usuario usuario) {
        this.modeloDados = modeloDados;
        this.usuario = usuario;
        
        setTitle("Meu Perfil");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        
        nomeLabel = new JLabel("Nome: " + usuario.getNome());
        emailLabel = new JLabel("Email: " + usuario.getEmail());
        excluirButton = new JButton("Excluir Registro");
        editarButton = new JButton("Editar Usuario");
        
        panel.add(nomeLabel);
        panel.add(emailLabel);
        panel.add(excluirButton);
        panel.add(editarButton);
        
        getContentPane().add(panel);
        setVisible(true);
        
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloDados.removeUsuario(usuario);
                dispose();
            }
        });
        
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlterarUsuarioInterface();
                dispose();
            }
        });
    }
    protected void dispose() {
		// TODO Auto-generated method stub
		
	}
	void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	private void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}
	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public InterfacePerfil() {
       
    }

}
