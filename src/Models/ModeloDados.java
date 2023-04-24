package Models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ModeloDados extends DefaultTableModel {
    private static ArrayList<Usuario> usuarios;
    
    public ModeloDados() {
        this.usuarios = new ArrayList<Usuario>();
    }
    
    public void cadastrarUsuario(int id, String nome, char genero,
                                  String telefone, String endereco, String email, String senha) throws Exception {
        validarNome(nome);
        validarGenero(genero);
        validarTelefone(telefone);
        validarEmail(email);
        validarSenha(senha);
        
        Usuario usuario = new Usuario(id, nome, genero, telefone, endereco, email, senha);
        usuarios.add(usuario);
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }
    
    private void validarNome(String nome) throws Exception {
        if (nome == null || nome.trim().length() < 3) {
            throw new Exception("O nome deve ter no mínimo 3 caracteres");
        }
    }
    
    private void validarGenero(char genero) throws Exception {
        if (genero != 'F' && genero != 'M' && genero != 'O') {
            throw new Exception("O gênero deve ser F, M ou O");
        }
    }
    
    private void validarTelefone(String telefone) throws Exception {
        if (telefone == null || !telefone.matches("\\+55\\d{11}")) {
            throw new Exception("O telefone deve ter início obrigatório com +55 e ter 11 dígitos");
        }
    }
    
    private void validarEmail(String email) throws Exception {
        if (email == null || !email.matches(".+@.+\\.com")) {
            throw new Exception("O email deve ter o formato válido");
        }
    }
    
    private void validarSenha(String senha) throws Exception {
        if (senha == null || senha.trim().length() < 3) {
            throw new Exception("A senha deve ter no mínimo 3 caracteres");
        }
    }
    
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

   
    public List<Usuario> getListaUsuarios() {
        return usuarios;
    }

    
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail() == email ) {
                return usuario;
            }
        }
        return null;
    }

 
    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                break;
            }
        }
    }
    
    
    public boolean autenticarUsuario(String email, String senha) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    
      
    public void removeUsuario(Usuario usuario) {
        int rowIndex = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(usuario.getEmail())) {
                rowIndex = i;
                break;
            }
        }
        if (rowIndex >= 0) {
            usuarios.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

}



