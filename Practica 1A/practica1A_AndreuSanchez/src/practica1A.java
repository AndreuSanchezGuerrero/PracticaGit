package practica1A_AndreuSanchez.src;

import java.util.*;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class practica1A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcio;
        do {
            System.out.println("1. Error > OutOfMemoryError");
            System.out.println("2. Error > stackOverFlowError");
            System.out.println("3. RunTimeException > IllegalArgumentExceptions");
            System.out.println("4. RunTimeException > ArithmeticException");
            System.out.println("5. RunTimeException > IndexOutOfBoundException");
            System.out.println("6. RunTimeException > NullPointerException");
            System.out.println("7. IOException > SocketException");
            System.out.println("8. IOException > FileNotFoundException");
            System.out.println("9. IOException > EOFException");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció (0-9): ");
            opcio = scan.nextInt();
            scan.nextLine();
            switch (opcio) {
                case 1:
                    OutOfMemoryError();
                    break;
                case 2:
                    stackOverFlowError();
                    break;
                case 3:
                    illegalArgumentExceptionsArrays();
                    illegalArgumentExceptionsMath();
                    break;
                case 4:
                    arithmeticException();
                    break;
                case 5:
                    indexOutOfBoundException();
                    break;
                case 6:
                    nullPointerException();
                    break;
                case 7:
                    socketException();
                    break;
                case 8:
                    fileNotFoundException();
                    break;
                case 9:
                    eOFException();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 9");
            }
        } while (opcio != 0);
    }

    //------------------------------------------------------------------------------------------------------------------
    static void OutOfMemoryError(){
        // OutOfMemoryError no pot ser capturat utilitzant blocs try-catch normals a Java.
        // Això és perquè OutOfMemoryError és una subclasse d'Error, que és una classe que estén de Throwable, però no estén d'Exception.
        // Tot i aixì et deixo la forma que jo utilitzaria per capturarla
        List<Integer> list = new ArrayList<>();
        try {
            System.out.println("Iniciant el procés per fer un OutOfMemoryError...");
            while (true) {
                list.add(999999999); //
            }
        } catch (OutOfMemoryError e) {
            // Captuerm l'error OutOfMemory.
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error durant el procés (OutOfMemoryError): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Fuga de memòria.");
            }
            System.out.println("Rastreig de la pila:");
            e.printStackTrace();
        } finally {
            // Mostrem la mida de la llista.
            System.out.println("La mida de la llista és: " + list.size());
            //Netejem l'array per no ocupar memoria.
            list = null;
            System.out.println("Llista netejada");
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void stackOverFlowError() {
        try {
            System.out.println("Iniciant procés per fer un stackOverFlowError...");
            cridaRecursiva(0);
        } catch (StackOverflowError e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error de desbordament de la pila (StackOverflowError)");
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Desbordament de la pila.");
            }
        } finally {
            System.out.println("Fi del mètode stackOverFlowError.");
        }
    }

    public static void cridaRecursiva(int i) {
        System.out.println("Número: " + i);
        cridaRecursiva(i + 1);
    }

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void illegalArgumentExceptionsArrays(){
        System.out.println("Inici del mètode illegalArgumentExceptionsArrays...");
        int[] array = {10, 20, 30, 40, 50};
        Scanner scan = new Scanner(System.in);
        try {
            // Preguntar a l'usuari si vol canviar el valor d'alguna posició.
            System.out.println("Començarem amb el mètode illegalArgumentExceptionsArrays");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Tenim els seguents valors a la llista: "+ Arrays.toString(array));
            System.out.println("Vols canviar el valor d'alguna posició de la llista? (S/N)");
            String resposta = scan.nextLine();
            //EqualsIgnoreCase ignora si es mayus o minus
            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Introdueix l'índex de la posició a canviar (0 - " + (array.length - 1) + "):");
                int posicio = scan.nextInt();
                System.out.println("Introdueix el nou valor:");
                int nouValor = scan.nextInt();

                // Canviar el valor en la posició especificada
                array[posicio] = nouValor;
                System.out.println("Valor canviat correctament.");
            } else {
                System.out.println("No s'han realitzat canvis.");
            }
            System.out.println();
            System.out.println("Digues un número i et diré en quina posició de la llista es troba.");
            int num = scan.nextInt();
            int index = trobarElement(array, num); // provem de trobar l'índex d'un element que no es troba a l'array
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("index element: " + index);
        } catch (IllegalArgumentException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'argument no vàlid (IllegalArgumentException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: No es troba l'element dins l'array.");
            }
        }
        finally {
            System.out.println("Fi del mètode (IllegalArgumentException)");
            System.out.println("Elements de la llista: " + Arrays.toString(array));
            System.out.println("Element més gran:" + Arrays.stream(array).max());
            System.out.println("Element més petit:" + Arrays.stream(array).min());
            //Neteja de la llista
            array = null;
            System.out.println("Array netejada correctament");
        }
    }

    public static int trobarElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        throw new IllegalArgumentException("L'element " + element + " no es troba a l'array");
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void illegalArgumentExceptionsMath(){
        System.out.println("Inici del mètode illegalArgumentExceptionsMath...");
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println();
            System.out.println("Continuem amb el mètode illegalArgumentExceptionsMath");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("De quin número vols fer l'arrel cuadrada? ");
            int numArrel = scan.nextInt();
            System.out.println("--------------------------------------------------------------------------------------");
            int result = arrelQuadrada(numArrel); // Intentem obtenir l'arrel quadrada d'un nombre negatiu
            System.out.println("Resultat: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'argument no vàlid (IllegalArgumentException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Intent d'obtenir l'arrel quadrada d'un nombre negatiu.");
            }
        }
        finally {
            System.out.println("El mètode illegalArgumentExceptionsMath ha finalitzat.");
        }
    }

    public static int arrelQuadrada(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("El nombre no pot ser negatiu");
        }
        return (int) Math.sqrt(number);
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void arithmeticException(){
        System.out.println("Inici del mètode arithmeticException...");
        int resultat;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Diguem un dividend: ");
            int dividend = scan.nextInt();
            System.out.println("Diguem un divisor: ");
            int divisor = scan.nextInt();
            resultat = dividir(dividend, divisor);
            System.out.println("Resultat de la divisió: " + resultat);
        } catch (ArithmeticException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'aritmètica (ArithmeticException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Divisor amb valor 0.");
            }
        }finally {
            System.out.println("El mètode arithmeticException ha finalitzat.");
            // Realitzem una operació de neteja.
            resultat = 0;
        }
    }

    public static int dividir(int dividend, int divisor) {
        if (divisor == 0) {
            // Si el divisor és zero, llancem una ArithmeticException
            throw new ArithmeticException("Divisió per zero no està permessa");
        }
        return dividend / divisor;
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void indexOutOfBoundException(){
        System.out.println("Inici del mètode indexOutOfBoundException...");
        int[] array = {1, 2, 3, 4, 5};
        try {
            System.out.println("accedim a la posicio 6 de l'array!!!");
            int element = array[6]; // Intentem accedir a un índex fora dels límits de l'array
        } catch (IndexOutOfBoundsException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'índex fora de límits (IndexOutOfBoundsException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Intent d'accedir a un índex fora dels límits de l'array.");
            }
        }finally {
            // Neteja de l'array per lliurar mèmoria.
            array = null;
            System.out.println("L'array s'ha netejat correctament.");
        }

    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void nullPointerException(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inici del mètode nullPointerException...");
        String text = null;
        try {
            int length = text.length(); // Intentem obtenir la longitud d'una string
            System.out.println("Longitud del text: " + length);
        } catch (NullPointerException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error de punter nul (NullPointerException): " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Intent d'obtenir la longitud d'una cadena nul·la.");
            }
            System.out.println();
            System.out.println("Corregirem l'error. Diguem una paraula:  ");
            text = scan.nextLine();
            int length = text.length();
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Longitud del text: " + length);
        }finally {
            System.out.println("Ha finalitzat el mètode nullPointerException.");
            //Tanquem l'scanner
            scan.close();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void socketException(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inici del mètode socketException...");
        System.out.println("Si vols fer saltar l'exception SocketException, desconnectat de la xarxa");
        System.out.println("Si vols fer saltar l'exception IOException, introdueix un host invàlid");
        System.out.println("Si vols que la connexió sigui correcte, introdueix un host vàlid");
        System.out.println("Host: ");
        String host = scan.nextLine();
        try {
            connexioSrv(host, 80); // Intentem connectar-nos a un servidor que pot no existir
        } catch (SocketException e1) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error de connexió de xarxa (SocketException): " + e1.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e1.getClass());
            Throwable causa = e1.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Error de connexió de xarxa.");
            }
        } catch (IOException e2) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'entrada/sortida (IOException): ");
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e2.getClass());
            Throwable causa = e2.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Host "+ e2.getMessage() + " invàlid.");
            }

        }finally {
            System.out.println("Ha finalitzat el mètode socketException.");
        }
        //podriem fer només un catch amb una sola variable e >>> catch (SocketException | IOException e)
    }

    public static void connexioSrv(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        // Aquí es realitzaria la lògica de comunicació amb el servidor
        System.out.println("Connexió correcte amb el servidor " +host);
        socket.close();
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void fileNotFoundException(){
        try {
            llegirSolucioExamen("solucio_examen_uf5.txt"); // Intentem llegir un fitxer que no existeix
        } catch (FileNotFoundException e) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("No s'ha trobat el fitxer: " + e.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e.getClass());
            Throwable causa = e.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: No es pot trobar el fitxer.");
            }
        }
        finally {
            System.out.println("Fi del mètode fileNotFoundException");
        }
    }
    public static void llegirSolucioExamen(String nomFitxer) throws FileNotFoundException {
        File fitxer = new File(nomFitxer);
        Scanner scanner = new Scanner(fitxer);
        // Aquí es realitzaria la lectura del fitxer
        scanner.close();
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    static void eOFException(){
        String nomFitxer = "notes_finals.dat";

        try (DataInputStream lectura = new DataInputStream(new FileInputStream(nomFitxer))){
            while (true) {
                int valor = lectura.readInt();
                System.out.println("Valor llegit: " + valor);
            }
        } catch (EOFException e1) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha arribat al final del fitxer: " + e1.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e1.getClass());
            Throwable causa = e1.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: S'ha arribat al final del fitxer.");
            }
        } catch (IOException e2) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S'ha produït un error d'entrada/sortida: " + e2.getMessage());
            System.out.println("Detalls addicionals:");
            System.out.println("       Classe de l´excepció: " + e2.getClass());
            Throwable causa = e2.getCause();
            if (causa != null) {
                System.out.println("       La causa de l'excepció és: " + causa.getMessage());
            } else {
                System.out.println("       La causa de l'excepció és: Error d'entrada/sortida.");
            }
        }
        finally {
            System.out.println("El mètode eOFException ha finalitzat");
        }
    }
}
