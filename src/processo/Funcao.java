package processo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entidades.DadosMercado;
import entidades.Operacao;

public class Funcao {
	
	public static void InserirArquivos() throws IOException {
		File arquivo1 = new File("DadosMercado.csv");
		File arquivo2 = new File("Operacoes.csv");
		Scanner sc1 = new Scanner(arquivo1);
		Scanner sc2 = new Scanner(arquivo2);
		
		ArrayList<DadosMercado> listaMercado = new ArrayList<DadosMercado>(); 
		ArrayList<Operacao> listaOperacoes = new ArrayList<Operacao>(); 
		
		int i=0;
		while(sc1.hasNextLine()) {
			String[] linha = sc1.nextLine().split(";");
			DadosMercado dado = new DadosMercado();
			
			if(i>0) {
			dado.InserirDados(linha);
			listaMercado.add(dado);
			}
			i++;
		}
		
		i=0;
		while(sc2.hasNextLine()) {
			String[] linha = sc2.nextLine().split(";");
			Operacao op = new Operacao();
			
			if(i>0) {
				op.InserirOperacao(linha);
				listaOperacoes.add(op);
			}
			i++;
		}
		
		sc1.close();
		sc2.close();
		
		Set<String> nomes_subprod = new HashSet<String>();
		for (Operacao ops : listaOperacoes) {
			nomes_subprod.add(ops.getNm_SubProduto());	
		}
		
		List<Operacao> nova = new ArrayList<Operacao>();
		List<String> resultados = new ArrayList<String>();
		
		for (String string : nomes_subprod) {
			
			nova = removeDuplicados(listaOperacoes, string);
			resultados.add("\""+string+"\""+";"+"\""+calcula_Lista(nova, listaMercado, string)+"\"");	
			
		}
		
		escreveCSV(resultados);		
	}
	
	
	public static double calcula_Lista(List<Operacao> operacoes, List <DadosMercado>mercados, String sub) {
		int v = 0;
		double resultado = 0;
		double preco = 0, quantidade = 0;
		
		for (int a = 0; a < operacoes.size();a++) {
			while(v < mercados.size()) {
				if((sub.equals(operacoes.get(a).getNm_SubProduto())) && (mercados.get(v).getId_Preco() == operacoes.get(a).getId_Preco()) &&	(mercados.get(v).getNP_PD() == operacoes.get(a).getNM_PD())){
						
					quantidade = operacoes.get(a).getQuantidade();
					preco = mercados.get(v).getVL_Preco();
					resultado =  (quantidade * preco) + resultado;										
				}
				v++;
			}
			v=0;
			}
		
		return resultado;
	}
	
	public static List<Operacao> removeDuplicados(List<Operacao> lista,String sub){
		List<Operacao> op = new ArrayList<Operacao>();
		
		for (Operacao operacao : lista) {
			if(operacao.getNm_SubProduto().equals(sub)) {
				op.add(operacao);
			}
			
				
		}
		return op;
	}
	
	public static void escreveCSV(List<String> lista) throws IOException {
		
		String[] cabecalho = {"NM_SubProduto", "RESULTADO"};
		
	
			FileWriter writer = new FileWriter("Resultado.csv");
			
			for(int i = 0; i < cabecalho.length; i++) {
				writer.append("\""+cabecalho[i]+"\"");
				if(i < cabecalho.length) {
					writer.append(';');
				}
			}
			writer.append('\n');

			for (String resultado : lista) {
				writer.append(resultado);
				writer.append('\n');
			}
			
			writer.flush();
	        writer.close();	
	}
		
}
	

