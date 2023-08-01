package ATM;

public class Cuenta {
	
	private int numeroCuenta;
	private int NIP;
	private double saldoActual;

	public Cuenta(int numeroCuenta, int NIP, double saldoActual) {
		this.numeroCuenta = numeroCuenta;
		this.NIP = NIP;
		this.saldoActual = saldoActual;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getNIP() {
		return NIP;
	}

	public void setNIP(int nIP) {
		NIP = nIP;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

}
