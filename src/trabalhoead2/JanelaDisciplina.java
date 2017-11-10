/*package trabalhoead2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaDisciplina extends JFrame {

    private JTable tabela;
    private JLabel lblID = new JLabel("ID: ");
    private JLabel lblDescricao = new JLabel("Descrição: ");
    private JLabel lblValor = new JLabel("Valor: ");
    private JTextField txtID = new JTextField(10);
    private JTextField txtDescricao = new JTextField(10);
    private JTextField txtValor = new JTextField(10);
    private JButton adicionar = new JButton("Adicionar");
    private JButton remover = new JButton("Remover");
    private JButton salvar = new JButton("Salvar");
    private List<Disciplina> dados;

    public JanelaDisciplina() throws HeadlessException, SQLException {
        super("Gerenciar Disciplina");
        setMinimumSize(new Dimension(500, 500));
        salvar.setEnabled(false);
        remover.setEnabled(false);
        JPanel formulario = new JPanel();
        JPanel campoID = new JPanel();
        JPanel campoDescricao = new JPanel();
        JPanel campoValor = new JPanel();
        formulario.setLayout(new GridLayout(2, 3));
        campoID.setLayout(new GridLayout(2, 1));
        campoDescricao.setLayout(new GridLayout(2, 1));
        campoValor.setLayout(new GridLayout(2, 1));
        campoID.add(lblID);
        campoID.add(txtID);
        campoDescricao.add(lblDescricao);
        campoDescricao.add(txtDescricao);
        campoValor.add(lblValor);
        campoValor.add(txtValor);
        formulario.add(campoID);
        formulario.add(campoDescricao);
        formulario.add(campoValor);
        salvar.setBackground(new Color(000, 000, 205));
        salvar.setForeground(Color.WHITE);
        adicionar.setBackground(new Color(034, 139, 034));
        adicionar.setForeground(Color.WHITE);
        remover.setBackground(Color.red);
        remover.setForeground(Color.WHITE);
        formulario.add(salvar);
        formulario.add(remover);
        formulario.add(adicionar);
        add(formulario, BorderLayout.SOUTH);
        this.dados = data;
        tabela = new JTable(new DisciplinaTableModel());
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tabela.getSelectedRowCount() == 0) {
                    adicionar.setEnabled(true);
                    remover.setEnabled(false);
                    salvar.setEnabled(false);
                } else {
                    adicionar.setEnabled(false);
                    remover.setEnabled(true);
                    salvar.setEnabled(true);
                    DisciplinaTableModel modelo = (DisciplinaTableModel) tabela.getModel();
                    int linha = tabela.getSelectedRow();
                    txtID.setText(modelo.getValueAt(linha, 0));
                    txtDescricao.setText(modelo.getValueAt(linha, 1));
                    txtValor.setText(modelo.getValueAt(linha, 2));
                }
            }
        });
        adicionar.addActionListener((ActionEvent e) -> {
            DisciplinaTableModel modelo = (DisciplinaTableModel) tabela.getModel();
            Integer id;
            String descricao;
            Double valor;
            if (isValid(txtID.getText()) && isValid(txtDescricao.getText()) && isValid(txtValor.getText())) {
                try {
                    id = Integer.parseInt(txtID.getText());
                    descricao = txtDescricao.getText();
                    valor = Double.parseDouble(txtValor.getText().replace(",", "."));
                    modelo.addRow(new Disciplina(id, descricao, valor));
                    txtValor.setText("");
                    txtDescricao.setText("");
                    txtID.setText(Integer.toString(Disciplina.gerarCodigo()));
                    txtID.setEnabled(false);
                    txtDescricao.requestFocus();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato Inválido para o Valor do Produto", "ERRO", JOptionPane.ERROR_MESSAGE);
                    
                }

            } else {
                JOptionPane.showMessageDialog(null, "Campo Vazio", "Advertência", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabela.getSelectedRowCount() == 0) {
                    return;
                } else {
                    DisciplinaTableModel modelo = (DisciplinaTableModel) tabela.getModel();
                    modelo.removeRow(tabela.getSelectedRow());
                    txtValor.setText("");
                    txtDescricao.setText("");
                    txtID.setText(Integer.toString(Disciplina.gerarCodigo()));
                    txtID.setEnabled(false);
                    txtDescricao.requestFocus();
                }
            }
        });

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabela.getSelectedRowCount() == 0) {
                    return;
                } else {
                    int linha = tabela.getSelectedRow();
                    DisciplinaTableModel modelo = (DisciplinaTableModel) tabela.getModel();
                    modelo.setValueAt(txtID.getText(), linha, 0);
                    modelo.setValueAt(txtDescricao.getText(), linha, 1);
                    modelo.setValueAt(txtValor.getText(), linha, 2);
                    txtValor.setText("");
                    txtDescricao.setText("");
                    txtID.setText(Integer.toString(Disciplina.gerarCodigo()));
                    txtID.setEnabled(false);
                    txtDescricao.requestFocus();
                    tabela.clearSelection();
                }
            }
        });
    }

    public void solicitaProduto() {
        setLocationRelativeTo(null);
        setVisible(true);
        txtValor.setText("");
        txtDescricao.setText("");
        txtID.setText(Integer.toString(Disciplina.gerarCodigo()));
        txtID.setEnabled(false);
        txtDescricao.requestFocus();
    }

    private boolean isValid(String text) {
        return !text.isEmpty();
    }

    public List<Disciplina> getDados() {
        return dados;
    }
    

}
*/