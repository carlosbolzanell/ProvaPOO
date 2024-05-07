import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private static List<Pessoa> usuarios = new ArrayList<>();
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public Pessoa(){

    }

    public static Pessoa login(String nome){
        for(Pessoa pessoa : usuarios){
            if(pessoa.nome.equals(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public static Pessoa procuraCliente(String nome){
        for(Pessoa pessoa : usuarios){
            if(pessoa.getNome().equals(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public static List<Pessoa> getUsuarios() {
        return usuarios;
    }
    public static void adicionarUsuarios(Pessoa usuario){
        usuarios.add(usuario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
