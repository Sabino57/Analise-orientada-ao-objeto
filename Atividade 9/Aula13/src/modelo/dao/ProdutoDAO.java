package modelo.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    private static final String LISTAR = "SELECT * FROM dbloja.produtos";
    private static final String INSERIR = "INSERT INTO dbloja.produtos (nome, categoria) VALUES (?, ?)";
    private static final String DELETAR = "DELETE FROM produtos WHERE id = ?";
    
    public static java.util.List<modelo.Produto> listarTodos() {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;
        java.util.List<modelo.Produto> retorno = new java.util.ArrayList<>();
        
        try{
            try {
                con = util.FabricaConexao.getConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            pstmt = con.prepareStatement(LISTAR);
            rs = pstmt.executeQuery();
            while (rs.next()){
                modelo.Produto prod = new modelo.Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                retorno.add(prod);
            }
        } catch (ClassNotFoundException | SQLException err){
            throw new RuntimeException(err);
        }
        return retorno;
    }
    
    public static boolean inserirProduto(modelo.Produto prod) throws ClassNotFoundException{
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
        try{
            con = util.FabricaConexao.getConexao();
            pstmt= con.prepareStatement(INSERIR);
            pstmt.setString(1,prod.getNome());
            pstmt.setInt(2, prod.getCategoria());
            pstmt.execute();
            util.FabricaConexao.fechaConexao(con, pstmt);
        } catch (java.sql.SQLException err){
            throw new RuntimeException(err);
        }
        return retorno;
    }
    
    

}
