package alquiler_Viviendas;

public class Solicitud {
	private String solicitud;
	private int tiempo_alquiler;
	private Casa Casa;
	private Cliente Cliente;
	
	public Solicitud(String solicitud, int tiempo_alquiler, Casa casa, Cliente cliente) {
		this.solicitud = solicitud;
		this.tiempo_alquiler = tiempo_alquiler;
		this.Casa = casa;
		this.Cliente = cliente;
	}

	public String getsolicitud() {
		return solicitud;
	}

	public void setsolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public int gettiempo_alquiler() {
		return tiempo_alquiler;
	}

	public void settiempo_alquiler(int tiempo_alquiler) {
		this.tiempo_alquiler = tiempo_alquiler;
	}

	public Casa getcasa() {
		return Casa;
	}

	public void setcasa(Casa casa) {
		this.Casa = casa;
	}

	public Cliente getcliente() {
		return Cliente;
	}

	public void setcliente(Cliente cliente) {
		this.Cliente = cliente;
	}

	public String toString() {
		return "[solicitud=" + solicitud + ", tiempo_alquiler=" + tiempo_alquiler + "]";
	}
}
