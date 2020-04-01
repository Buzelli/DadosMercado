
package entidades;

import java.time.LocalDate;

public class Operacao{
	
	private int Id_Preco;
	private double Quantidade;
	private String Nm_SubProduto;
	private int NM_PD;
	
	public void InserirOperacao(String[] linha) {
		this.Id_Preco = Integer.parseInt(linha[13].toString());
		this.Quantidade = Double.parseDouble(linha[12].replace(",", "."));
		this.Nm_SubProduto = linha[9];
		this.NM_PD = Diferenca(linha[1].split("/"),linha[2].split("/"));
	}
	
	private int Diferenca(String[] ob1,String[] ob2) {
		
		LocalDate ini = LocalDate.of(Integer.parseInt(ob1[2]), 
                Integer.parseInt(ob1[1]), 
                Integer.parseInt(ob1[0]));
		
		LocalDate fim = LocalDate.of(Integer.parseInt(ob2[2]), 
                Integer.parseInt(ob2[1]), 
                Integer.parseInt(ob2[0])); 
		
		int data1 = ini.getDayOfYear();
		int data2 = fim.getDayOfYear();
		int dif = data2 - data1;
		
		return dif;
	}
	public int getId_Preco() {
		return Id_Preco;
	}
	public void setId_Preco(int id_Preco) {
		Id_Preco = id_Preco;
	}
	public double getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(double quantidade) {
		Quantidade = quantidade;
	}
	public String getNm_SubProduto() {
		return Nm_SubProduto;
	}
	public void setNm_SubProduto(String nm_SubProduto) {
		Nm_SubProduto = nm_SubProduto;
	}
	public int getNM_PD() {
		return NM_PD;
	}
	public void setNM_PD(int nM_PD) {
		NM_PD = nM_PD;
	}
	
	
	
	

}
