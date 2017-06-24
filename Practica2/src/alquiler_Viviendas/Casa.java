package alquiler_Viviendas;

public class Casa extends Vivienda {
	
	private boolean amueblado;
	private String tipo_Casa;
	
	public Casa(int Vivienda_ID, int m2, int ant, int precio, String tipo, boolean amueblado, String tipo_Casa) {
		super(Vivienda_ID, m2, ant, tipo, precio);
		this.amueblado = amueblado;
		this.tipo_Casa = tipo_Casa;
	}

	

	public boolean amueblado() {
		return amueblado;
	}

	public void setamueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public String gettipo_Casa() {
		return tipo_Casa;
	}

	public void settipo_Casa(String tipo_Casa) {
		this.tipo_Casa = tipo_Casa;
	}
}
