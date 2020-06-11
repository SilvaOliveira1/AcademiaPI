package Bridge;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GeradorTxt implements GeradorFuncoes {

	@Override
	public void gerar(String conteudo) {
		 PrintStream print = null;

	        try {
	            print = new PrintStream("Error.txt");
	            print.println("-=--=-=-=- ERROR -=-=-=-=-=");
	            print.println("Error: " + conteudo);

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            print.close();
	        }
		
	}
}
