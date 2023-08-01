package ATM;

public class ConsultaSaldo extends Transaccion {

	private int numeroCuenta; 
	private Cuenta[] cuentas;
	
	public ConsultaSaldo(int numeroCuenta, Cuenta[] cuentas) {
		super(numeroCuenta, cuentas);
	}

	@Override
	public boolean ejecutar() {
		boolean operacionRealizada = false;
		for(Cuenta cuenta : cuentas ) {
			if(cuenta.getNumeroCuenta() == numeroCuenta) {
				System.out.println("Su saldo actual es: " + cuenta.getSaldoActual());
				operacionRealizada = true;
			} 
		}
		
		return operacionRealizada;
	}

}
