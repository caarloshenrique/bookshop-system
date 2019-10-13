import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroDAO {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement stmt;
    
    public LivroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Livro livro) throws SQLException {
        String sql = "insert into livros" +
                " (titulo, edicao, publicacao, descricao)" +
                " values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getEdicao());
            stmt.setInt(3, livro.getPublicacao());
            stmt.setString(4, livro.getDescricao());
            
            stmt.execute();
            //stmt.close();
            
            System.out.println("Gravado!");
            
            //connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Livro procurarLivro(Integer id) throws SQLException, Exception {
        ResultSet rs = null;
        Livro livro = null;
        PreparedStatement stmt = this.connection.
                prepareStatement("select * from livros where id=?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        if (!rs.next()) {
            throw new Exception("Não foi encontrado nenhum "
                    + "livro com id:" + id);
        }
        livro = new Livro();
        livro.setId(id.longValue());
        livro.setTitulo(rs.getString(2));
        livro.setEdicao(rs.getInt(3));
        livro.setPublicacao(rs.getInt(4));
        livro.setDescricao(rs.getString(5));
        
        return livro;
    }
    
    public List<Livro> procurarTodosLivros() throws SQLException, Exception {
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();
        PreparedStatement stmt = this.connection.
                prepareStatement("select * from livros");
        rs = stmt.executeQuery();
        while (rs.next()) {
            livros.add(
                    new Livro (
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5)
                    )
            );
        }
        return livros;
    }
    
    public void atualizarLivro(Livro l) throws SQLException, Exception {
       rs = null;
       Livro livro = null;
       stmt = this.connection.prepareStatement("UPDATE LIVROS SET DESCRICAO=? WHERE ID=?");
       stmt.setString(1, livro.getTitulo());
       stmt.setLong(2, livro.getId());
       stmt.execute();  
    }
    
    public void close () throws Exception {
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
     public static void main(String[] args) throws Exception {
        LivroDAO dao = new LivroDAO();
        
        dao.adiciona(new Livro("Revista Tititi", 2, 2019, "Revista de fofoca"));
        
        List<Livro> livros = dao.procurarTodosLivros();
        for (Livro l : livros) {
            System.out.println(l.getTitulo());
        }
   }
}
