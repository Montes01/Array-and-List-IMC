import javax.swing.JOptionPane;

public class ImcArrays {
	String[] Nombres;
	double[] IMC;
	double peso, talla;

	public ImcArrays() {
		try {
			Nombres = new String[Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas que desea evaluar"))];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresaste un dato invalido, por ende solo se evaluara una persona");
			Nombres = new String[1];
		}
		IMC = new double[Nombres.length];
		iniciar();
	}

	private void iniciar() {
		llenar();
	}

	private void llenar() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Nombres.length; i++) {
			Nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + i);
			try {peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de " + Nombres[i]));} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Se ingreso un dato invalido por ende el peso sera 60");
				peso = 60;
			}
			try {talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla de " + Nombres[i]));} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Se ingreso un dato invalido por ende la talla sera 1.70");
				talla = 1.70;
			}
			System.out.println("El indice de masa corporal es de " + CalcularIMC(peso, talla) + "se encuentra en " + evaluar(CalcularIMC(peso,talla)));
		}
	}

	private double CalcularIMC(double peso, double talla) {
		return peso / Math.pow(talla, 2);
	}
	
	private String evaluar(double IMC) {
		if(IMC >=40) {
			return "Obesidad Morbida";
		}else if(IMC >=35) {
			return "Obesidad grado 3";
		}else if(IMC >=30) {
			return "Obesidad grado 2";
		}else if(IMC >=27) {
			return "Obesidad grado 1";
		}else if(IMC >=20) {
			return "Normalidad";
		}else if(IMC >=18) {
			return "Delgadez";
		}else {
			return "Anorexia";
		}
	}

}
