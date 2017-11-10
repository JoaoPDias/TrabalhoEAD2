package trabalhoead2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDao {

    private Connection conexao;

    public DisciplinaDao() {
        try {
            this.conexao = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void adiciona(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina"
                + "(nome_disciplina,carga_horaria,curso,vagas,periodo)"
                + "VALUES"
                + "(?,?,?,?,?);";
        try (PreparedStatement operacao = conexao.prepareStatement(sql)) {
            operacao.setString(1, disciplina.getNome_disciplina());
            operacao.setInt(2, disciplina.getCargahoraria());
            operacao.setString(3, disciplina.getCurso());
            operacao.setInt(4, disciplina.getVagas());
            operacao.setString(5, disciplina.getPeriodo());
            operacao.execute();
            operacao.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    ;
    
    public void remover(Disciplina disciplina) {
        String sql = "DELETE FROM disciplina WHERE id_disciplina = ?";
        try (PreparedStatement operacao = conexao.prepareStatement(sql)) {
            operacao.setInt(1, disciplina.getId());
            operacao.execute();
            operacao.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Disciplina> ListarTodos() {
        List<Disciplina> disciplinas = new ArrayList();
        String sql = "SELECT id_disciplina,nome_disciplina,carga_horaria,curso,vagas,periodo FROM DISCIPLINA";
        try (PreparedStatement operacao = conexao.prepareStatement(sql)) {
            operacao.execute();
            ResultSet rs = operacao.getResultSet();
            while (rs.next()) {
                Integer id = rs.getInt("id_disciplina");
                String nome = rs.getString("nome_disciplina");
                Integer carga = rs.getInt("carga_horaria");
                String curso = rs.getString("curso");             
                Integer vagas = rs.getInt("vagas");
                String periodo = rs.getString("periodo");
                disciplinas.add(new Disciplina(id,nome,carga,curso,vagas,periodo));
            }
            operacao.close();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return disciplinas;
    }
}
