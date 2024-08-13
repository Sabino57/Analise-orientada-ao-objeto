package controle;
public class CategoriaControle {
   
    public static java.util.List<String> listarTodas() throws ClassNotFoundException{
        java.util.List<String> categs = new java.util.ArrayList<>();
        java.util.List<modelo.Categoria> cats = modelo.dao.CategoriaDAO.listarTodas();
        for (modelo.Categoria c : cats){
            categs.add(c.getNome());
        }
        return categs;
    }
    
    public static String buscarId(String nome) throws ClassNotFoundException{
        Integer id = modelo.dao.CategoriaDAO.buscarId(nome);
        return id.toString();
    }
}
