
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCInsere {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "insert into livros" +
                " (titulo, edicao, publicacao, descricao)" +
                " values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, "A Teoria de Tudo");
        stmt.setInt(2, 1);
        stmt.setInt(3, 123);
        stmt.setString(4, "História de Jane e Stephen Hawking.");
        
        
        stmt.execute();
        stmt.close();
        
        System.out.println("Gravado!");
        
        con.close();
    }
}
