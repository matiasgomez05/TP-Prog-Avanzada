package ATM;

import java.util.Scanner;

//Programa de prueba para el funcionamiento del ATM
public class PruebaATM {
	
	public static void main(String[] args) {
		BaseDeDatos conexion = new BaseDeDatos();
		ATM atm = new ATM(conexion);
		
		atm.iniciar();
	}
}
