package ATM;

import java.util.Scanner;

public class ATM {

	private ATM atm;
	private BaseDeDatos conexion;
	private boolean mostrarMenu;
	private double cantBilletes;

	public ATM(BaseDeDatos conexion) {
		
		atm = this;
		this.conexion = conexion;
		this.mostrarMenu = false;
		this.cantBilletes = 500;
	}
	
	public boolean getMostrarMenu() {
		return mostrarMenu;
	}
	
	public void setMostrarMenu(boolean mostrarMenu) {
		this.mostrarMenu = mostrarMenu;
	}
	
	public double getCantBilletes() {
		return cantBilletes;
	}
	
	public void setCantBilletes(double cantBilletes) {
		this.cantBilletes = cantBilletes;
	}
	
	public boolean autenticarCuenta(int numeroCuenta, int NIP) {
		boolean cuentaEncontrada = false;
		for(Cuenta cuenta : conexion.getCuentas() ) {
			if(cuenta.getNumeroCuenta() == numeroCuenta && cuenta.getNIP() == NIP) {
				cuentaEncontrada = true;
			} 
		}
		
		return cuentaEncontrada;
	}
	
	public void iniciar() {
		if(getMostrarMenu() == false) {
			do {
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Ingrese su número de cuenta:");
				int nroCuenta = sc1.nextInt();
				
				Scanner sc2 = new Scanner(System.in);
				System.out.println("\nIngrese su NIP:");
				int NIP = sc2.nextInt();
				
				mostrarMenu(nroCuenta, NIP);
				
			} while(getMostrarMenu() == false);
		}
	}
	
	public void mostrarMenu(int numeroCuenta, int NIP) {
		if(autenticarCuenta(numeroCuenta, NIP)) {
			System.out.println("\nIngreso correcto.");
			setMostrarMenu(true);
			
			do {
				System.out.println("Ingrese la operacion que desea realizar:");
				System.out.println("\n--> 1: Consultar saldo");
				System.out.println("\n--> 2: Retirar dinero");
				System.out.println("\n--> 3: Depositar dinero");
				System.out.println("\n--> 4: Salir");
							
				Scanner sw = new Scanner(System.in);
				int menu = sw.nextInt();
			
				switch(menu) {
				case 1:
					System.out.println("\nConsulta");
					ConsultaSaldo t1 = new ConsultaSaldo(numeroCuenta, conexion.getCuentas());
					t1.ejecutar();
					break;
					
				case 2:
					System.out.println("\n--> 2: ¿Cuánto dinero desea retirar? ");
					Scanner rt = new Scanner(System.in);
					int extraccion = rt.nextInt();
					
					Transaccion t2 = new Retiro(atm, numeroCuenta, conexion.getCuentas(), extraccion);
					t2.ejecutar();
					break;
					
				case 3:
					System.out.println("\nDeposito");
					break;
					
				case 4:
					System.out.println("\nGracias por utilizar nuestro servicio.");
					setMostrarMenu(false);
					break;
					
				default:
					System.out.println("Ingrese un valor válido");
				}
			} while (getMostrarMenu() == true);
			
		} else {
			System.out.println("\nDatos incorrectos, intente nuevamente.");
		}
	}
	

}
