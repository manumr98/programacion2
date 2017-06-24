package alquiler_Viviendas;

public class Cliente {
		
		private String nombre, dni;
		private float tarjeta_credito;
		private boolean  habitual;
		private Solicitud [] solicitudes;
		
		public Cliente(String dni, String nombre, float tarjeta_credito) {
			this.dni = dni;
			this.nombre = nombre;
			this.tarjeta_credito = tarjeta_credito;
		}

		public String getDNI() {
			return dni;
		}

		public void setDNI(String dni) {
			this.dni = dni;
		}

		public String getnombre() {
			return nombre;
		}

		public void setnombre(String nombre) {
			this.nombre = nombre;
		}

		public float gettarjeta_credito() {
			return tarjeta_credito;
		}

		public void settarjeta_credito(int tarjeta_credito) {
			this.tarjeta_credito = tarjeta_credito;
		}
		
		public boolean gethabitual() {
			return habitual;
		}

		public void sethabitual(boolean habitual) {
			this.habitual = habitual;
		}
		public int calculardescuentocliente(){
			if(nsolucitudes()>=3){
				return 10;
			}else{
				return 0;
			}
		}
		protected int nsolucitudes(){
			int num=0;
			for(int i=0;i<solicitudes.length;i++){
				num++;
			}
			return num;
		}

		
		
	}
