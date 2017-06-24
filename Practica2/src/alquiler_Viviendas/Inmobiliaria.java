package alquiler_Viviendas;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Inmobiliaria {
private Cliente[] clientes;
private Vivienda[] viviendas;

	public Inmobiliaria(Cliente []clientes,Vivienda[] viviendas){
		this.clientes=clientes;
		this.viviendas=viviendas;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public Vivienda[] getViviendas() {
		return viviendas;
	}

	@Override
	public String toString() {
		return "Inmobiliaria [clientes=" + Arrays.toString(clientes) + ", viviendas=" + Arrays.toString(viviendas)
				+ "]";
	}
	
	
	

}
