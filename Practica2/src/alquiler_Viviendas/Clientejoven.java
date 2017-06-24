package alquiler_Viviendas;

public class Clientejoven extends Cliente {
	private int numero_carnet_joven;
	
	public Clientejoven(String dni, String nombre, float tarjeta_credito, int numero_carnet_joven) {
		super(dni, nombre, tarjeta_credito);
		this.numero_carnet_joven=numero_carnet_joven;
	}
	public int calculardescuentocliente(){
		if(nsolucitudes()>=3){
			return 25;
		}else{
			return 20;
		}
	}
	



}
