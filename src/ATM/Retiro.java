package ATM;

public class Retiro extends Transaccion{

	private ATM atm;
	private int numeroCuenta; 
	private Cuenta[] cuentas;
	private double extraccion;
	
	public Retiro(ATM atm, int numeroCuenta, Cuenta[] cuentas, double extraccion) {
		super(numeroCuenta, cuentas);
		this.atm = atm;
		this.extraccion = extraccion;
	}

	@Override
	public boolean ejecutar() {
		boolean operacionRealizada = false;
		for(Cuenta cuenta : cuentas ) {
			if(cuenta.getNumeroCuenta() == numeroCuenta) {
				
				if(extraccion % 20 != 0) {
					System.out.println("Ingrese un multiplo de $20 para realizar la operacion");
					return false;
				}
				
				if(extraccion > cuenta.getSaldoActual()) {
					System.out.println("Saldo insuficiente para realizar la operacion");
					return false;
				}
				
				if( (extraccion / 20) > atm.getCantBilletes() ) {
					System.out.println("El cajero no posee dinero suficiente");
					return false;
				}
				
				cuenta.setSaldoActual(cuenta.getSaldoActual() - extraccion);
				atm.setCantBilletes(extraccion / 20);
				
				System.out.println("Operacion realizada con exito."); 
				operacionRealizada = true;
			} 
		}
		
		return operacionRealizada;
	}

}
