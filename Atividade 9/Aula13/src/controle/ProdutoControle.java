package controle;
public class ProdutoControle {
    /* elemento no índice 0 contém o nome do produto e no índice 1 o id da categoria */ 

    public static boolean inserirProduto(String[] atributos) throws ClassNotFoundException{ 
        modelo.Produto prod = new modelo.Produto(); 
        prod.setNome(atributos[0]); 
        prod.setCategoria(Integer.parseInt(atributos[1])); 
        boolean retorno = modelo.dao.ProdutoDAO.inserirProduto(prod); 
        return retorno; 
    } 

    public static java.util.List<Object[]> obterTodos(){ 
        java.util.List<Object[]> retorno = new java.util.ArrayList<>(); 
        java.util.List<modelo.Produto> produtos = modelo.dao.ProdutoDAO.listarTodos(); 
        for (modelo.Produto p : produtos){ 
            retorno.add(new Object[] {p.getId(), p.getNome(), p.getCategoria()}); 
        } 
        return retorno; 
    } 
    
    
}

  
