package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Stack;

public class ConectionFactory {

    private String url = "jdbc:postgresql://localhost:5432/money";
    private String user = "postgres";
    private String senha = "123456";

    public static Connection con;

    public Connection getConnect() {
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, senha);
            if(con !=null){
                System.out.println("Conectado");
            }else {
                System.out.println("Não conectado");
            }
        }catch (Exception e){
            System.out.println("Erro de conexão" + e );
            e.printStackTrace();
        }
        return con;
    }

    public int adicionarEstado(String sql) {
        try {
            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet buscaEstado(String sqlBuscaEstado) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlBuscaEstado);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
