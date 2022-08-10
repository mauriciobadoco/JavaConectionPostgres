package conexao;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        ConectionFactory con = new ConectionFactory();
        con.getConnect();

        String sql = "INSERT INTO  estado(id_estado, nome_estado, sigla_estado)" +
                "values(default, 'Para', 'PA')";
        int adicionarEstadoCon = con.adicionarEstado(sql);
        if(adicionarEstadoCon >0){
            System.out.println("cadastro realizado");
        }else{
            System.out.println("Cadstro não realizado");
        }



        String sqlBuscaEstado = "select * from estado";
        ResultSet rs = con.buscaEstado(sqlBuscaEstado);

        try{
            while(rs.next()){
                int id_estado = rs.getInt("id_estado");
                String nomeEstado = rs.getString("nome_estado");
                String siglaEstado = rs.getString("sigla_estado");
                System.out.println(id_estado + " - " + nomeEstado + " - " + siglaEstado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
