package poo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;



public class Config_Quarry {

    public void inserir(Estoque p) {
      
        String sql = "INSERT INTO \"PRODUTOS\" (\"EAN\", \"DESCRICAO\", \"QUANTIDADE\", \"VALOR\") VALUES (?, ?, ?, ?)";

        try (Connection conn = Conector_DB.criarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, p.getEAN());
            stm.setString(2, p.getDESCRICAO());
            stm.setInt(3, p.getQUANTIDADE());
            stm.setBigDecimal(4, BigDecimal.valueOf(p.getValor()));

            int linhas = stm.executeUpdate();
            if (linhas > 0) {
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Nenhum produto foi inserido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
         
        }
    }

    public static List<Estoque> listarEstoque() {
        List<Estoque> listaDeProdutos = new ArrayList<>();
       
        String sql = "SELECT \"EAN\", \"DESCRICAO\", \"QUANTIDADE\", \"VALOR\" FROM \"PRODUTOS\"";

        try (Connection conn = Conector_DB.criarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                
                String ean = rs.getString("EAN");
                String descricao = rs.getString("DESCRICAO");
                int quantidade = rs.getInt("QUANTIDADE");
                double valor = rs.getBigDecimal("VALOR").doubleValue();

                Estoque produto = new Estoque(ean, descricao, quantidade, valor);
                listaDeProdutos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os produtos: " + e.getMessage());
  
        }
        return listaDeProdutos;
    }
}