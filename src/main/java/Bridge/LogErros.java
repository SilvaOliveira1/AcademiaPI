package Bridge;

public class LogErros implements GerarArquivo {
	 	private String mensagem;
	    private GeradorFuncoes gerador;

	    public LogErros(String mensagem, GeradorFuncoes gerador) {
	        this.mensagem = mensagem;
	        this.gerador = gerador;
	    }
	
		@Override
	    public void gerarArquivo() {
	        gerador.gerar(this.mensagem);
	    }

}
