package br.org.venda_ingresso.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import br.org.venda_ingresso.controller.Conexao;
import br.org.venda_ingresso.model.Cliente;

public class crudDAO {
	public void create(Cliente cliente) {
		String sql = "INSERT INTO tabela_ingresso(categoria, preco, formaDePagamento) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setString( 1 , cliente.getCategoria());
			p.setInt(2, cliente.getPreco());
			p.setString( 3, cliente.getFormaDePagamento());
			p.execute();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO:" + e);
			}finally {
			try {
				if(p != null);
				p.close();
			} catch (Exception e) {
				e.printStackTrace(); //ALTER TABLE alunos AUTO_INCREMENT = 1;
			  }
		              }
	}//fim CREATE
	//**********************************************************************************
	
	
	//METODO U - update
	public void update(Cliente cliente) {
		String sql =  "UPDATE tabela_ingresso SET categoria = ?, preco = ?, formaDePagamento = ?,  WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null; //link com banco 
	try {
		conn = Conexao.criandoConexao();
		p = (PreparedStatement) conn.prepareStatement(sql); //cast
		p.setInt(1, cliente.getId());
		p.setString(2 , cliente.getCategoria());
		p.setInt(3, cliente.getPreco());
		p.setString(4, cliente.getFormaDePagamento());
		p.execute(); //executa inst para gravar, dados no banco
		}catch(Exception e ) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO:" + e);
		}finally {
		try {
			if(p != null);
			p.close();
		} catch (Exception e) {
			e.printStackTrace(); //ALTER TABLE alunos AUTO_INCREMENT = 1;
		}
		}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
	}//fim update
	//*************************************************************************
	//R - Read
	public List<Cliente> read(){
		String sql = "SELECT * FROM tabela_ingresso";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); 
			resultado = p.executeQuery(); //mostra os dados da consulta sql
			while(resultado.next()) {
				Cliente ver_cliente = new Cliente();
				//recuperar RA
				ver_cliente.setId(resultado.getInt("id"));
				//recuperar idade
				ver_cliente.setCategoria(resultado.getString("categoria"));
				//recuperar nome
				ver_cliente.setPreco(resultado.getInt("preco"));
				//adicionar na lista
				ver_cliente.setFormaDePagamento(resultado.getString("formaDePagamento"));
				//
				clientes.add(ver_cliente);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(p != null);
				p.close();
			} catch (Exception e) {
				e.printStackTrace(); //ALTER TABLE alunos AUTO_INCREMENT = 1;
			}
		
		}
		return clientes;
	}//fim read
	//**********************************************************************************
	//D - Delete
	public boolean delete(int id) {
		String sql = "DELETE FROM tabela_ingresso WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null;
    try {
    	conn = Conexao.criandoConexao();
    	p = (PreparedStatement) conn.prepareStatement(sql);
    	p.setInt(1, id);
    	p.execute();
    	JOptionPane.showConfirmDialog(null, "dados excluidos com sucesso!");
    	System.out.println("dados excluidos com sucesso");
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "erro ao excluir dados \nERRO:" + e);
    	}finally {
    		try {
    			if(p != null);
    			p.close();
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    return false;

	}
}

