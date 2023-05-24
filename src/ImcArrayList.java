import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImcArrayList {
    ArrayList<String> nombres;
    ArrayList<Double> imc;
    double peso, talla;
    double calculoIMC;
    String evaluacion;

    public ImcArrayList() {
        nombres = new ArrayList<String>();
        imc = new ArrayList<Double>();
        iniciar();
    }

    private void iniciar() {
        String respuesta = "";

        do {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
            nombres.add(nombre);

            try {
                peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de " + nombre));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se ingresó un dato inválido, el peso se establecerá en 60");
                peso = 60;
            }

            try {
                talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla de " + nombre));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se ingresó un dato inválido, la talla se establecerá en 1.70");
                talla = 1.70;
            }

            calculoIMC = CalcularIMC(peso, talla);
            imc.add(calculoIMC);
            evaluacion = evaluar(calculoIMC);

            System.out.println("El índice de masa corporal de " + nombre + " es " + calculoIMC + ", se encuentra en " + evaluacion);

            respuesta = JOptionPane.showInputDialog("¿Desea evaluar otra persona? (si/no)");
        }while (respuesta.equalsIgnoreCase("si"));
    }

    private double CalcularIMC(double peso, double talla) {
        return peso / Math.pow(talla, 2);
    }

    private String evaluar(double IMC) {
        if (IMC >= 40) {
            return "Obesidad Mórbida";
        } else if (IMC >= 35) {
            return "Obesidad grado 3";
        } else if (IMC >= 30) {
            return "Obesidad grado 2";
        } else if (IMC >= 27) {
            return "Obesidad grado 1";
        } else if (IMC >= 20) {
            return "Normalidad";
        } else if (IMC >= 18) {
            return "Delgadez";
        } else {
            return "Anorexia";
        }
    }
}
