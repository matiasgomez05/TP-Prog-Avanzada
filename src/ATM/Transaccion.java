package ATM;

public abstract class Transaccion {

	private int numeroCuenta;
	private Cuenta[] cuentas;
	
	public Transaccion(int numeroCuenta, Cuenta[] cuentas) {
		this.numeroCuenta = numeroCuenta;
		this.cuentas = cuentas;
	}
	
	public abstract boolean ejecutar();

}
