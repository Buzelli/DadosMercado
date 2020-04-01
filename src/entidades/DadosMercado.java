package entidades;

public class DadosMercado{
	private int Id_Preco;
	private int NP_PD;
	private double VL_Preco;
	
	
	
	public void InserirDados(String[] linha) {
		this.Id_Preco =Integer.parseInt(linha[0].toString());
		this.NP_PD = Integer.parseInt(linha[1]);
		this.VL_Preco = Double.parseDouble(linha[2].replace(",","."));
		
	}
		
	
	public int getId_Preco() {
		return Id_Preco;
	}
	public void setId_Preco(int id_Preco) {
		Id_Preco = id_Preco;
	}
	public int getNP_PD() {
		return NP_PD;
	}
	public void setNP_PD(int nP_PD) {
		NP_PD = nP_PD;
	}
	public double getVL_Preco() {
		return VL_Preco;
	}
	public void setVL_Preco(double vL_Preco) {
		VL_Preco = vL_Preco;
	}
	
}
