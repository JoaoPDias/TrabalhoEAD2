
package trabalhoead2;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class DisciplinaTableModel extends AbstractTableModel {

    private List<Disciplina> disciplinas;
    private DisciplinaDao disciplinaDAO;

    public DisciplinaTableModel() {
            this.disciplinaDAO= new DisciplinaDao();
            this.disciplinas = disciplinaDAO.ListarTodos();       
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.toString(disciplinas.get(rowIndex).getId());
            case 1:
                return disciplinas.get(rowIndex).getNome_disciplina();
            case 2:
                return disciplinas.get(rowIndex).getCurso();
            case 3:
                return disciplinas.get(rowIndex).getPeriodo();    
            case 4:
                return Integer.toString(disciplinas.get(rowIndex).getCargahoraria());
            case 5:
                return Integer.toString(disciplinas.get(rowIndex).getVagas());    
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public void setValueAt(String value,int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                disciplinas.get(rowIndex).setId((Integer.parseInt(value)));
                break;
            case 1:
                disciplinas.get(rowIndex).setNome_disciplina(value);
                break;
            case 2:
                disciplinas.get(rowIndex).setCurso(value);
                break;
            case 3:
                disciplinas.get(rowIndex).setPeriodo(value);
                break;
            case 4:
                disciplinas.get(rowIndex).setCargahoraria(Integer.parseInt(value));
                break;
            case 5:
                disciplinas.get(rowIndex).setVagas(Integer.parseInt(value));
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome da Disciplina";
            case 2:
                return "Curso";
            case 3:
                return "Período";
            case 4:
                return "Carga Horária";
            case 5:
                return "Vagas";
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public void addRow(Disciplina d) throws SQLException{
        disciplinaDAO.adiciona(d);
        this.fireTableDataChanged();
    }
    public void removeRow(Disciplina d) throws SQLException{
        disciplinaDAO.remover(d);
        this.fireTableDataChanged();
    }

}
