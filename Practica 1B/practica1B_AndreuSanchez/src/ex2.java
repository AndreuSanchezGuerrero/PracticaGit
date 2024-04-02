import java.util.InputMismatchException;
import java.util.Scanner;

public class ex2 {

    //--------------------------------------------------------------------------------------------
    //Funció per dividir
    public static int divisio(int x, int y) {
        return x / y;
    }
    //--------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Variable per controlar si sortir o continuar
        boolean sortir = false;

        //Si no sortim, farem tantes operacions com volem
        while (!sortir) {
            try {
                //--------------------------------------------------------------------------
                //Inputs variables i control de si es un integer o no
                System.out.println("Donem el dividend: ");
                if (!scan.hasNextInt()) {
                    throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
                }
                int x = scan.nextInt();

                System.out.println("Donem el divisor: ");
                if (!scan.hasNextInt()) {
                    throw new InputMismatchException("Entrada no vàlida. S'esperava un enter.");
                }
                int y = scan.nextInt();
                //----------------------------------------------------------------------------

                //----------------------------------------------------------------------------
                if (y == 0) {
                    throw new ArithmeticException("Error aritmètic: No es por dividir per zero");
                }
                //----------------------------------------------------------------------------
                int result = divisio(x, y);
                System.out.println(result);
            }
            //--------------------------------------------------------------------------------

            //----------------------------------------------------------------------------
            //Catch InputMismatchException
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
            //--------------------------------------------------------------------------------------------------

            //---------------------------------------------------------------------------------------------------
            //Catch ArithmeticException
            catch (ArithmeticException e) {
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("S'ha produït un error durant el procés (ArithmeticException): " + e.getMessage());
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
            //Controlem si vol sortir o no l'usuari
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


