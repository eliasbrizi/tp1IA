package coronaTracker.Domain;

public class Camino {
	
	private String nodoInicial;
	private String nodoFinal;
	
	public Camino(String nodoInicial, String nodoFinal) {
		super();
		this.nodoInicial = nodoInicial;
		this.nodoFinal = nodoFinal;
	}
	
	public String getNodoInicial() {
		return nodoInicial;
	}
	public void setNodoInicial(String nodoInicial) {
		this.nodoInicial = nodoInicial;
	}
	public String getNodoFinal() {
		return nodoFinal;
	}
	public void setNodoFinal(String nodoFinal) {
		this.nodoFinal = nodoFinal;
	}
}
