import java.util.InputMismatchException;
import java.util.Scanner;

class MyCalculator {
    // La nostre funció power verifica si n o p són negatius, si n o p son més grans de 10, o si tots dos són 0.
    // Si es compleix alguna d'aquestes condicions, llença una excepció amb el missatge adequat.
    // Si no es compleixen les condicions, calcula n elevat a la potència p utilitzant la funció Math.pow()
    // i torna el resultat com un long perquè per defecte ve un double.
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("Ni 'n' ni 'p' poden ser negatius.");
        }else if (n > 10 || p > 10) {
            throw new Exception("Ni 'n' ni 'p' poden ser més grans de 10.");
        } else if (n == 0 && p == 0) {
            throw new Exception("Ni 'n' ni 'p' poden ser zero.");
        } else {
            return (long) Math.pow(n, p);
        }
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyCalculator calculadora = new MyCalculator();
        //Variable per controlar si sortir o continuar
        boolean sortir = false;

        //Si no sortim, farem tantes operacions com volem
        while (!sortir) {
            try {
                //--------------------------------------------------------------------------
                //Inputs variables i control de si es un integer o no
                System.out.println("Donem el valor de n: ");
                if (!scan.hasNextInt()) {
                    throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
                }
                int n = scan.nextInt();
                System.out.println("Donem el valor de p: ");
                if (!scan.hasNextInt()) {
                    throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
                }
                int p = scan.nextInt();
                //--------------------------------------------------------------------------
                //Operació
                long result = calculadora.power(n, p);
                System.out.println(result);
            }
            //----------------------------------------------------------------------------------------------------------
            //Controlem també l'error d'InputMismatchException
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
            }
            //----------------------------------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------------------------------
            //Capturem les altres excepcions
            catch (Exception e) {
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("S'ha produït un error durant el procés: " + e.getMessage());
                System.out.println("Detalls addicionals:");
                System.out.println("       Classe de l´excepció: " + e.getClass());
            }
            //----------------------------------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------------------------------
            System.out.println();
            System.out.println("Vols sortir? (S/n)");
            String opcion = scan.next();
            System.out.println();
            if (opcion.equalsIgnoreCase("S")) {
                sortir = true;
            }
            //----------------------------------------------------------------------------------------------------------
        }
    }
}
