public abstract class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    public abstract double calcularPreco(double desconto);
    public abstract String exibirDetalhes();

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n"+
                "Nome" + nome + "\n" +
                "Descricao: " + descricao + "\n" +
                "Preco: " + preco;
    }
}
