package alquiler_Viviendas;

public class Chalet extends Vivienda {
	
	private boolean piscina;
	private double distancia;
	
	public Chalet(int Vivienda_ID, int m2, int precio, int ant, String tipo,double distancia,boolean piscina) {
	super(Vivienda_ID, m2, ant, tipo, precio);
		this.piscina = piscina;
		this.distancia = distancia;
	}
	
	public boolean getpiscina() {
		return piscina;
	}

	public void setpiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public double getdistancia() {
		return distancia;
	}

	public void setdistancia(double distancia) {
		this.distancia = distancia;
	}
}

