
package proyectofinal;

/**
 *
 * @author Julian Gonzalez Medina 1077225505
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

// Clase Componente
abstract class Componente implements Comparable<Componente> {
    int id;
    String nombre;
    String talla;
    String color;
    boolean escomunitario;
    double precio;

    public Componente(int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.escomunitario = escomunitario;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTalla() {
        return talla;
    }

    public String getColor() {
        return color;
    }

    public boolean isEscomunitario() {
        return escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", escomunitario=" + escomunitario +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Componente that = (Componente) o;

        return id == that.id;
    }

    @Override
    public int compareTo(Componente o) {
        return Integer.compare(this.id, o.id);
    }
}

// Subclases de Componente
class Falda extends Componente {
    boolean conCremallera;

    public Falda(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio + (conCremallera ? 1 : 0));
        this.conCremallera = conCremallera;
    }

    public boolean isConCremallera() {
        return conCremallera;
    }

    @Override
    public String toString() {
        return super.toString() + " Falda{" +
                "conCremallera=" + conCremallera +
                '}';
    }
}

class Chaqueta extends Componente {
    int numBotones;

    public Chaqueta(int id, String nombre, String talla, String color, boolean escomunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, escomunitario, precio + (numBotones * 2));
        this.numBotones = numBotones;
    }

    public int getNumBotones() {
        return numBotones;
    }

    @Override
    public String toString() {
        return super.toString() + " Chaqueta{" +
                "numBotones=" + numBotones +
                '}';
    }
}

class Pantalon extends Componente {
    boolean conCremallera;

    public Pantalon(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio + (conCremallera ? 1 : 0));
        this.conCremallera = conCremallera;
    }

    public boolean isConCremallera() {
        return conCremallera;
    }

    @Override
    public String toString() {
        return super.toString() + " Pantalon{" +
                "conCremallera=" + conCremallera +
                '}';
    }
}

class Blusa extends Componente {
    boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    @Override
    public String toString() {
        return super.toString() + " Blusa{" +
                "mangaLarga=" + mangaLarga +
                '}';
    }
}

// Clase Traje
class Traje {
    ArrayList<Componente> piezas;
    String nombre;

    public Traje(String nombre, ArrayList<Componente> piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    @Override
    public String toString() {
        return "Traje{" +
                "nombre='" + nombre + '\'' +
                ", piezas=" + piezas +
                '}';
    }
}

// Excepciones personalizadas
class IdException extends Exception {
    public IdException(String message) {
        super(message);
    }
}

class MuchoExtracomunitarioException extends Exception {
    public MuchoExtracomunitarioException(String message) {
        super(message);
    }
}

class MangaException extends Exception {
    public MangaException(String message) {
        super(message);
    }
}

class ColoresException extends Exception {
    public ColoresException(String message) {
        super(message);
    }
}

class TallaException extends Exception {
    public TallaException(String message) {
        super(message);
    }
}

class TrajeYaExisteException extends Exception {
    public TrajeYaExisteException(String message) {
        super(message);
    }
}

// Interfaz IFabricaDeTrajes
interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen();
    void listarComponentes();
    void añadirTrajeAAlmacen();
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvio();
    void crearComponentesDePrueba();
}

// Clase FabricaDeTrajes
public class FabricaDeTrajes implements IFabricaDeTrajes {
    ArrayList<Componente> componentesEnAlmacen = new ArrayList<>();
    TreeSet<Traje> trajesEnAlmacen = new TreeSet<>((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
    boolean sonRebajas = false;

    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            fabrica.escribirMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    fabrica.añadirComponenteAAlmacen();
                    break;
                case 2:
                    fabrica.listarComponentes();
                    break;
                case 3:
                    fabrica.añadirTrajeAAlmacen();
                    break;
                case 4:
                    fabrica.listarTrajes();
                    break;
                case 7:
                    fabrica.activarDesactivarRebajas();
                    break;
                case 8:
                    fabrica.crearEnvio();
                    break;
                case 9:
                    fabrica.crearComponentesDePrueba();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public void escribirMenu() {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir a almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("8.- Crear envío");
        System.out.println("9.- Crear componentes de prueba");
        System.out.println("0.- Salir");
    }

    @Override
    public void añadirComponenteAAlmacen() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            validarId(id);
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Talla: ");
            String talla = scanner.next();
            System.out.print("Color: ");
            String color = scanner.next();
            System.out.print("¿Es comunitario (true/false)?: ");
            boolean escomunitario = scanner.nextBoolean();
            validarExtracomunitario(escomunitario);
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            System.out.println("Seleccione el tipo de componente:");
            System.out.println("1. Chaqueta");
            System.out.println("2. Blusa");
            System.out.println("3. Falda");
            System.out.println("4. Pantalón");
            int tipo = scanner.nextInt();

            Componente componente = null;
            switch (tipo) {
                case 1:
                    System.out.print("Número de botones: ");
                    int numBotones = scanner.nextInt();
                    componente = new Chaqueta(id, nombre, talla, color, escomunitario, precio, numBotones);
                    break;
                case 2:
                    System.out.print("¿Manga larga (true/false)?: ");
                    boolean mangaLarga = scanner.nextBoolean();
                    validarBlusaManga(color, mangaLarga);
                    componente = new Blusa(id, nombre, talla, color, escomunitario, precio, mangaLarga);
                    break;
                case 3:
                    System.out.print("¿Con cremallera (true/false)?: ");
                    boolean conCremalleraFalda = scanner.nextBoolean();
                    componente = new Falda(id, nombre, talla, color, escomunitario, precio, conCremalleraFalda);
                    break;
                case 4:
                    System.out.print("¿Con cremallera (true/false)?: ");
                    boolean conCremalleraPantalon = scanner.nextBoolean();
                    componente = new Pantalon(id, nombre, talla, color, escomunitario, precio, conCremalleraPantalon);
                    break;
                default:
                    System.out.println("Tipo de componente no válido.");
                    return;
            }

            componentesEnAlmacen.add(componente);
            System.out.println("Componente añadido correctamente.");

        } catch (IdException | MuchoExtracomunitarioException | MangaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validarId(int id) throws IdException {
        for (Componente c : componentesEnAlmacen) {
            if (c.getId() == id) {
                throw new IdException("El ID ya existe.");
            }
        }
    }

    private void validarExtracomunitario(boolean escomunitario) throws MuchoExtracomunitarioException {
        if (!escomunitario) {
            long count = componentesEnAlmacen.stream().filter(c -> !c.isEscomunitario()).count();
            if (count >= componentesEnAlmacen.size() / 2) {
                throw new MuchoExtracomunitarioException("Ya hay más del 50% de componentes extracomunitarios.");
            }
        }
    }

    private void validarBlusaManga(String color, boolean mangaLarga) throws MangaException {
        boolean existeContrario = componentesEnAlmacen.stream()
                .filter(c -> c instanceof Blusa)
                .anyMatch(c -> c.getColor().equals(color) && ((Blusa) c).isMangaLarga() != mangaLarga);

        if (!existeContrario) {
            throw new MangaException("Debe existir una blusa del mismo color con manga diferente.");
        }
    }

    @Override
    public void listarComponentes() {
        componentesEnAlmacen.forEach(System.out::println);
    }

    @Override
    public void añadirTrajeAAlmacen() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Blusas disponibles:");
            componentesEnAlmacen.stream().filter(c -> c instanceof Blusa).forEach(System.out::println);

            System.out.print("ID de la blusa: ");
            int idBlusa = scanner.nextInt();
            Blusa blusa = (Blusa) encontrarComponentePorId(idBlusa);

            System.out.println("Chaquetas disponibles:");
            componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta).forEach(System.out::println);

            System.out.print("ID de la chaqueta: ");
            int idChaqueta = scanner.nextInt();
            Chaqueta chaqueta = (Chaqueta) encontrarComponentePorId(idChaqueta);

            System.out.println("Faldas y Pantalones disponibles:");
            componentesEnAlmacen.stream().filter(c -> c instanceof Falda || c instanceof Pantalon).forEach(System.out::println);

            System.out.print("ID de la falda o pantalón: ");
            int idFaldaPantalon = scanner.nextInt();
            Componente faldaPantalon = encontrarComponentePorId(idFaldaPantalon);

            validarTraje(blusa, chaqueta, faldaPantalon);

            ArrayList<Componente> piezas = new ArrayList<>();
            piezas.add(blusa);
            piezas.add(chaqueta);
            piezas.add(faldaPantalon);

            System.out.print("Nombre del traje: ");
            String nombreTraje = scanner.next();

            validarNombreTraje(nombreTraje);

            Traje traje = new Traje(nombreTraje, piezas);
            trajesEnAlmacen.add(traje);
            componentesEnAlmacen.remove(blusa);
            componentesEnAlmacen.remove(chaqueta);
            componentesEnAlmacen.remove(faldaPantalon);

            System.out.println("Traje añadido correctamente.");

        } catch (ColoresException | TallaException | TrajeYaExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    private Componente encontrarComponentePorId(int id) {
        return componentesEnAlmacen.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    private void validarTraje(Blusa blusa, Chaqueta chaqueta, Componente faldaPantalon) throws ColoresException, TallaException {
        if (!blusa.getColor().substring(0, 1).equalsIgnoreCase(chaqueta.getColor().substring(0, 1)) ||
                !blusa.getColor().substring(0, 1).equalsIgnoreCase(faldaPantalon.getColor().substring(0, 1))) {
            throw new ColoresException("Los colores no son amigos.");
        }

        if (!blusa.getTalla().equals(chaqueta.getTalla()) || (!faldaPantalon.getTalla().equals(chaqueta.getTalla()))) {
            throw new TallaException("Las tallas no coinciden.");
        }
    }

    private void validarNombreTraje(String nombre) throws TrajeYaExisteException {
        for (Traje t : trajesEnAlmacen) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                throw new TrajeYaExisteException("El nombre del traje ya existe.");
            }
        }
    }

    @Override
    public void listarTrajes() {
        trajesEnAlmacen.forEach(System.out::println);
    }

    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas;
        double factor = sonRebajas ? 0.9 : 1 / 0.9;
        for (Componente c : componentesEnAlmacen) {
            c.setPrecio(c.getPrecio() * factor);
        }
        for (Traje t : trajesEnAlmacen) {
            for (Componente c : t.getPiezas()) {
                c.setPrecio(c.getPrecio() * factor);
            }
        }
        System.out.println("Rebajas " + (sonRebajas ? "activadas" : "desactivadas") + ".");
    }

    @Override
    public void crearEnvio() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Traje> envio = new ArrayList<>();
        String continuar;
        do {
            System.out.println("Trajes disponibles:");
            trajesEnAlmacen.forEach(t -> System.out.println(t.getNombre()));
            System.out.print("Nombre del traje a añadir: ");
            String nombre = scanner.next();
            Traje traje = encontrarTrajePorNombre(nombre);
            if (traje != null) {
                envio.add(traje);
                trajesEnAlmacen.remove(traje);
            } else {
                System.out.println("Traje no encontrado.");
            }
            System.out.print("¿Desea añadir otro traje al envío? (s/n): ");
            continuar = scanner.next();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("Envío creado con " + envio.size() + " trajes.");
    }

    private Traje encontrarTrajePorNombre(String nombre) {
        return trajesEnAlmacen.stream().filter(t -> t.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    @Override
    public void crearComponentesDePrueba() {
        componentesEnAlmacen.add(new Blusa(1, "Blusa1", "M", "Rojo", true, 10.0, true));
        componentesEnAlmacen.add(new Blusa(2, "Blusa2", "M", "Rojo", true, 10.0, false));
        componentesEnAlmacen.add(new Chaqueta(3, "Chaqueta1", "M", "Rojo", true, 20.0, 3));
        componentesEnAlmacen.add(new Falda(4, "Falda1", "M", "Rojo", true, 15.0, true));
        componentesEnAlmacen.add(new Pantalon(5, "Pantalon1", "M", "Rojo", true, 15.0, false));
        System.out.println("Componentes de prueba creados.");
    }
}
