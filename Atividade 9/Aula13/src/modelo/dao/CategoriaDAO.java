package modelo.dao;
public class CategoriaDAO {
    private static final String LISTAR = "SELECT * FROM dbloja.categorias";
    private static final String BUSCARID = "SELECT id FROM dbloja.categorias where nome = ?";
   
    public static java.util.List<modelo.Categoria> listarTodas() throws ClassNotFoundException{
        java.sql.Connection con = null;
        java.sql.Statement stmt = null;
        java.sql.ResultSet rs = null;
        java.util.List<modelo.Categoria> categs = new java.util.ArrayList<>();
        try {
            con = util.FabricaConexao.getConexao();
            stmt = con.createStatement();
            rs = stmt.executeQuery(LISTAR);
            while (rs.next()){
                modelo.Categoria cat = new modelo.Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                categs.add(cat);
            }
            stmt.close();
            util.FabricaConexao.fechaConexao(con);
        } catch (java.sql.SQLException err){
            System.out.println(err.getMessage());
            throw new RuntimeException(err);
        }
        return categs;
    }
    
    public static int buscarId(String nome) throws ClassNotFoundException{
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;
        int result = 0;
        try{
            con = util.FabricaConexao.getConexao();
            pstmt = con.prepareStatement(BUSCARID);
            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();
            rs.next();
            result = rs.getInt("id");
            util.FabricaConexao.fechaConexao(con, pstmt, rs);
        } catch (java.sql.SQLException err){
            throw new RuntimeException(err);
        }
        return result;
    }
}
