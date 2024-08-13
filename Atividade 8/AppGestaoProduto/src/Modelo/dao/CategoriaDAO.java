package Modelo.dao;
public class CategoriaDAO {
    private static final String LISTAR = "SELECT * FROM dbloja.categorias";
    public List<Modelo.Categoria> listarTodas(){
        ResultSet rs = null;
        Statement stmt = null;
        Connection con = null;
        List<Modelo.Categoria> categs = new ArrayList<Categoria>();
        try {
            con = Util.ConectaBanco.obtemConexao();
            stmt = con.createStatement();
            rs = stmt.executeQuery(LISTAR);
            while (rs.next()){
                Modelo.Categoria cat = new Modelo.Categoria (rs.getInt("id"), rs.getString("nome"));
                categs.add(cat);
            }
        } catch (SQLException err1) {
            throw new RuntimeException(err1);
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException err2){
                throw new RuntimeException (err2);
            }
        } 
        return categs;
    }
    
}
