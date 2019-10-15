/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoMercado;
import javax.swing.JOptionPane;
import modelo.Mercado;
import tela.manutencao.ManutencaoMercado;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorMercado {

public static void inserir(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        objeto.setRazao_social(man.jtf_Razao_social.getText());
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNr_funcionario(Integer.parseInt(man.jtfNr_funcionario.getText()));
        objeto.setValor_bolsa(Double.parseDouble(man.jtfValor_bolsa.getText()));
        boolean resultado = DaoMercado.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.Tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

public static void alterar(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        objeto.setRazao_social(man.jtf_Razao_social.getText());
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNr_funcionario(Integer.parseInt(man.jtfNr_funcionario.getText()));
        objeto.setValor_bolsa(Double.parseDouble(man.jtfValor_bolsa.getText()));
        
        boolean resultado = DaoMercado.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.Tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

 public static void excluir(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoMercado.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.Tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome Fantasia");
        modelo.addColumn("Razão Social");
        modelo.addColumn("Fundação");
        modelo.addColumn("Número de Funcionário");
        modelo.addColumn("Valor na Bolsa");

        List<Mercado> resultados = DaoMercado.consultar();
        for (Mercado objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome_fantasia());
            linha.add(objeto.getRazao_social());
            linha.add(objeto.getFundacao());
            linha.add(objeto.getNr_funcionario());
            linha.add(objeto.getValor_bolsa());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoMercado man, Integer pk){ 
        Mercado objeto = DaoMercado.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome_fantasia.setText(objeto.getNome_fantasia());
        man.jtf_Razao_social.setText(objeto.getRazao_social());
        man.jtfFundacao.setText(objeto.getFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfNr_funcionario.setText(objeto.getNr_funcionario().toString());
        man.jtfValor_bolsa.setText(objeto.getValor_bolsa().toString());
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
}
