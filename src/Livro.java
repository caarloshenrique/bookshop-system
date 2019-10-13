public class Livro {
    private Long id;
    private String titulo;
    private int edicao;
    private int publicacao;
    private String descricao;
    
    public Livro(){}

    public Livro(Long id, String titulo, int edicao, int publicacao, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
    }

    public Livro(String titulo, int edicao, int publicacao, String descricao) {
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(int publicacao) {
        this.publicacao = publicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
