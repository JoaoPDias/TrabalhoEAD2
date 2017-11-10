package trabalhoead2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class Disciplina {

    private Integer id_disciplina;

    private String nome_disciplina;

    private Integer cargahoraria;
    
    private String curso;
    
    private Integer vagas;
    
    private String periodo;

   

    public Disciplina() {
    }

    public Disciplina(Integer id_disciplina, String nome_disciplina, Integer cargahoraria, String curso, Integer vagas, String periodo) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.cargahoraria = cargahoraria;
        this.curso = curso;
        this.vagas = vagas;
        this.periodo = periodo;
    }

    public Disciplina(String nome_disciplina, Integer cargahoraria, String curso, Integer vagas, String periodo) {
        this.nome_disciplina = nome_disciplina;
        this.cargahoraria = cargahoraria;
        this.curso = curso;
        this.vagas = vagas;
        this.periodo = periodo;
    }
    
    

    public Integer getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(Integer cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    

    
    public int getId() {
        return id_disciplina;
    }

    public void setId(int id) {
        this.id_disciplina = id;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }
    

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    
    public Disciplina clonar(){
        Disciplina p = new Disciplina();
        p.setId(this.id_disciplina);
        p.setNome_disciplina(this.nome_disciplina);
        p.setCurso(this.curso);
        p.setVagas(this.vagas);
        p.setCargahoraria(this.cargahoraria);
        p.setPeriodo(this.periodo);
        return p;
    }
}
