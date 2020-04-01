package main;


import processo.Funcao;

class Main {

   

    public static void main(String[] args) throws Exception {

    	long inicio = System.currentTimeMillis();
		
		Funcao.InserirArquivos();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Tempo de execução = "  + ((fim - inicio)/1000)+" Segundos");
 

    	
    }
}
