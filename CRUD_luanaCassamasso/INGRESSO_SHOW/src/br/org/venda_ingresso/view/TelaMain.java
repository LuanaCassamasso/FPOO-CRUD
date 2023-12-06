package br.org.venda_ingresso.view;

import java.util.Scanner;
import br.org.venda_ingresso.dao.crudDAO;
import br.org.venda_ingresso.model.Cliente;

public class TelaMain {
	
public static void main(String[] args) {
		
		//instanciar um objeto aluno
		Scanner entrada = new Scanner(System.in);
		crudDAO inserir_cliente = new crudDAO();
		//instanciar um objeto aluno
		Cliente cliente1 = new Cliente();
		exibirOpcoes();    //metodo (acao) construido fora do main
		int opcao = entrada.nextInt();
		
		do {
		switch(opcao) {
		case 1:
			System.out.println("Categoria");
			cliente1.setCategoria(entrada.next());
			System.out.println("Preco");
			cliente1.setPreco(entrada.nextInt());
			System.out.println("Forma de pagamento");
			cliente1.setFormaDePagamento(entrada.next());
			inserir_cliente.create(cliente1);
			System.out.println("Categoria:" + cliente1.getCategoria());
		    System.out.println("Preco:" + cliente1.getPreco());
		    System.out.println("Forma de pagamento:" + cliente1.getFormaDePagamento());
		    
		    
			 break;
		case 2:
			System.out.println("Id");
			cliente1.setId(entrada.nextInt());
			System.out.println("Categoria");
			cliente1.setCategoria(entrada.next());
			System.out.println("Preco");
			cliente1.setPreco(entrada.nextInt());
			System.out.println("Forma de pagamento");
			cliente1.setFormaDePagamento(entrada.next());
			inserir_cliente.update(cliente1);
			System.out.println("Id:" + cliente1.getId());
			System.out.println("Categoria:" + cliente1.getCategoria());
			 break;
		case 3:
			 crudDAO remover_cliente = new crudDAO();
			 System.out.println("Digite o RA do aluno que deseja excluir");
			 remover_cliente.delete(entrada.nextInt());
			 break;
		case 4:
			 for (Cliente olho : inserir_cliente.read()) {
				 System.out.println("Dados do cliente:" + olho.getId() + " " + olho.getCategoria() + " " +olho.getPreco() +  " " + olho.getFormaDePagamento());
			 }
			 break;
		}
		 System.out.println();
		}while(opcao <= 0);
		
		
		}
	
	private static void exibirOpcoes() {
		System.out.println("1- Criar um cliente");
		System.out.println("2- Atualizar");
		System.out.println("3- Deletar");
		 System.out.println("4- Ver lista");
}
}
