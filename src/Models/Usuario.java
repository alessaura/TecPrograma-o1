package Models;
import java.time.LocalDate;

public class Usuario {
	private int id;
    private String nome;
    private char genero;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;
    
    public Usuario(int id, String nome, char genero, String telefone,
                   String endereco, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public char getGenero() {
        return genero;
    }
    
    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
};

