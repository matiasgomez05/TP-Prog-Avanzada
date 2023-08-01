package ATM;

public class BaseDeDatos {
	
	private Cuenta[] cuentas;

	public BaseDeDatos() {
		cuentas = inicializarCuentas();
	}
	
	public Cuenta[] inicializarCuentas() {
		Cuenta c1 = new Cuenta(1, 1000, 1000);
		Cuenta c2 = new Cuenta(2, 2000, 500);
		Cuenta c3 = new Cuenta(3, 3000, 2000);
		Cuenta c4 = new Cuenta(4, 4000, 100);
		
		Cuenta[] cuentas = { c1, c2, c3, c4 };
		return cuentas;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}
	
}
