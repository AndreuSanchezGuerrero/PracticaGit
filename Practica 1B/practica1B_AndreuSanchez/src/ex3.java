import java.util.InputMismatchException;
import java.util.Scanner;

//----------------------------------------------------------------------------------------------------------
//Classe per realitzar l'equació de segon grau
class equacioSegonGrau {
    public static void operacio(int a, int b, int c) throws Exception {
        //calculem el discriminant
        double d = Math.pow(b, 2) - 4 * a * c;
        //Comprovem que es més gran de 0
        if (d < 0) {
            throw new ExcepcioDeDiscriminant("El discriminant no pot ser negatiu.");
        }

        //Calculem les dues solucions, fent l'arrel cuadrada utilitzant la funció Match.sqrt.
        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);

        //Les mostrem per pantalla
        System.out.println("Solució de l'equació:");
        System.out.println("       x1 = " + x1);
        System.out.println("       x2 = " + x2);
    }
}
//----------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------
//Creem la nostra propia classe, la heredem directament de la superclasse exception
//El nostre constructor serà el missatge de la superclasse
class ExcepcioDeDiscriminant extends Exception {
    public ExcepcioDeDiscriminant(String message) {
        super(message);
    }
}
//----------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------
public class ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entra els coeficients de l'equació de segon grau (a, b, c):");

        try {
            //--------------------------------------------------------------------------
            //Inputs variables i control de si es un integer o no
            System.out.println("Donem el valor de 'a': ");
            if (!scan.hasNextInt()) {
                throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
            }
            int a = scan.nextInt();

            System.out.println("Donem el valor de 'b': ");
            if (!scan.hasNextInt()) {
                throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
            }
            int b = scan.nextInt();

            System.out.println("Donem el valor de 'c': ");
            if (!scan.hasNextInt()) {
                throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
            }
            int c = scan.nextInt();
            //----------------------------------------------------------------------------

            //Operació de l'equació
            equacioSegonGrau.operacio(a, b, c);
        }

        //-------------------------------------------------------------------------------------------------------------
        //Capturem l'excepció InputMismatchException
        catch (InputMismatchException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error durant el procés (InputMismatchException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: El valor que s'ha introduit com entrada, no es un enter.");
            }
            scan.next(); // Netejar el buffer del Scanner es necessari en aquest cas
        }
        //-------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------
        //Capturem el nostre propi error quan el discriminant sigui negatiu
        catch (ExcepcioDeDiscriminant e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error durant el procés (ExcepcioDeDiscriminant): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
        }

        //Per qualsevol altre tipus d'excepció
        catch (Exception e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error durant el procés: " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
        }

    }
}

