package controle;
public class CategoriaControle {
    public static List<String> listarCategorias() throws ClassNotFoundException, SQLException{
        List<String> lista = new ArrayList<>();
        Modelo.dao.CategoriaDAO dao = new Modelo.dao.CategoriaDAO();
        List<Modelo.Categoria> itens = dao.listarTodas();
        for (Modelo.Categoria c : itens){
            lista.add(c.getNome());
        }
        return lista;
    }
}
