package alquiler_Viviendas;

public class Vivienda {
	protected int vivienda_ID, m2, precio, ant;
	protected String tipo, alquiler, tipo_especifico;
	protected boolean caracteristicas;
	
	public Vivienda(int vivienda_ID, int m2,int ant,  String tipo, int precio) {
		this.vivienda_ID = vivienda_ID;
		this.m2 = m2;
		this.precio = precio;
		this.ant = ant;
		this.tipo = tipo;
	}
	
	public int getprecio() {
		return precio;
	}

	public void setprecio(int precio) {
		this.precio = precio;
	}

	public String getalquiler() {
		return alquiler;
	}

	public void setalquiler(String alquiler) {
		this.alquiler = alquiler;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	public int getvivienda_ID() {
		return vivienda_ID;
	}

	public int getm2() {
		return m2;
	}

	public int getant() {
		return ant;
	}

	public String gettipo_especifico() {
		return tipo_especifico;
	}

	public void settipo_especifico(String tipo_especifico) {
		this.tipo_especifico = tipo_especifico;
	}

	public boolean caracteristicas() {
		return caracteristicas;
	}

	public void setcaracteristicas(boolean caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String toString() {
		return "[viviendaID=" + vivienda_ID + ", m2=" + m2 + ", antiguedad="
				+ ant + ", precio=" + precio + ", tipo=" + tipo + ", alquiler="
				+ alquiler + "]";
	}
}
