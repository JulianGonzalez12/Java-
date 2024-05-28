
package proyectofinal;

/**
 *
 * @author Julian Gonzalez Medina 1077225505
 */
public class Componente implements Comparable<Componente> {
    private int id;
    private String nombre;
    private String talla;
    private String color;
    private boolean escomunitario;
    private double precio;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscomunitario() {
        return escomunitario;
    }

    public void setEscomunitario(boolean escomunitario) {
        this.escomunitario = escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Componente{id=" + id + ", nombre='" + nombre + "', talla='" + talla + "', color='" + color + "', escomunitario=" + escomunitario + ", precio=" + precio + '}';
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


import java.util.ArrayList;

public class Traje {
    private ArrayList<Componente> piezas;
    private String nombre;

    public Traje(String nombre, ArrayList<Componente> piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Traje{nombre='" + nombre + "', piezas=" + piezas + '}';
    }
}


public class Falda extends Componente {
    private boolean conCremallera;

    public Falda(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.conCremallera = conCremallera;
        if (conCremallera) {
            setPrecio(precio + 1);
        }
    }

    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    @Override
    public String toString() {
        return super.toString() + ", Falda{conCremallera=" + conCremallera + '}';
    }
}

public class Chaqueta extends Componente {
    private int numBotones;

    public Chaqueta(int id, String nombre, String talla, String color, boolean escomunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.numBotones = numBotones;
        setPrecio(precio + 2 * numBotones);
    }

    public int getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chaqueta{numBotones=" + numBotones + '}';
    }
}

public class Pantalon extends Componente {
    private boolean conCremallera;

    public Pantalon(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.conCremallera = conCremallera;
        if (conCremallera) {
            setPrecio(precio + 1);
        }
    }

    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pantalon{conCremallera=" + conCremallera + '}';
    }
}

public class Blusa extends Componente {
    private boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Blusa{mangaLarga=" + mangaLarga + '}';
    }
}


public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen();
    void listarComponentes();
    void añadirTrajeAAlmacen();
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvio();
    void crearComponentesDePrueba();
}


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FabricaDeTrajes implements IFabricaDeTrajes {
    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas = false;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>();
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
        System.out.println("¿Qué tipo de componente desea añadir?");
        System.out.println("1. Chaqueta");
        System.out.println("2. Blusa");
        System.out.println("3. Falda");
        System.out.println("4. Pantalón");

        int opcion = scanner.nextInt();
        System.out.println("Ingrese los datos del componente:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Talla: ");
        String talla = scanner.next();
        System.out.print("Color: ");
        String color = scanner.next();
        System.out.print("Es comunitario (true/false): ");
        boolean escomunitario = scanner.nextBoolean();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        try {
            validarId(id);
            validarExtracomunitario(escomunitario);
            Componente componente = null;

            switch (opcion) {
                case 1:
                    System.out.print("Número de botones: ");
                    int numBotones = scanner.nextInt();
                    componente = new Chaqueta(id, nombre, talla, color, escomunitario, precio, numBotones);
                    break;
                case 2:
                    System.out.print("¿Manga larga (true/false)?: ");
                    boolean mangaLarga = scanner.nextBoolean();
                    validarManga(color, mangaLarga);
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
                    System.out.println("Opción no válida.");
            }

            if (componente != null) {
                componentesEnAlmacen.add(componente);
                System.out.println("Componente añadido al almacén.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listarComponentes() {
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente);
        }
    }

    @Override
    public void añadirTrajeAAlmacen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Blusas:");
        ArrayList<Componente> blusas = listarComponentesPorTipo(Blusa.class);
        System.out.print("Seleccione el ID de la blusa: ");
        int idBlusa = scanner.nextInt();

        System.out.println("Lista de Chaquetas:");
        ArrayList<Componente> chaquetas = listarComponentesPorTipo(Chaqueta.class);
        System.out.print("Seleccione el ID de la chaqueta: ");
        int idChaqueta = scanner.nextInt();

        System.out.println("Lista de Faldas y Pantalones:");
        ArrayList<Componente> faldasYPantalones = listarComponentesPorTipo(Falda.class);
        faldasYPantalones.addAll(listarComponentesPorTipo(Pantalon.class));
        System.out.print("Seleccione el ID de la falda o pantalón: ");
        int idFaldaOPantalon = scanner.nextInt();

        System.out.print("Nombre del traje: ");
        String nombreTraje = scanner.next();

        try {
            Componente blusa = buscarComponentePorId(idBlusa);
            Componente chaqueta = buscarComponentePorId(idChaqueta);
            Componente faldaOPantalon = buscarComponentePorId(idFaldaOPantalon);

            validarColores(blusa, chaqueta, faldaOPantalon);
            validarTallas(blusa, chaqueta, faldaOPantalon);
            validarNombreTraje(nombreTraje);

            ArrayList<Componente> piezas = new ArrayList<>();
            piezas.add(blusa);
            piezas.add(chaqueta);
            piezas.add(faldaOPantalon);

            Traje traje = new Traje(nombreTraje, piezas);
            trajesEnAlmacen.add(traje);
            componentesEnAlmacen.remove(blusa);
            componentesEnAlmacen.remove(chaqueta);
            componentesEnAlmacen.remove(faldaOPantalon);

            System.out.println("Traje añadido al almacén.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listarTrajes() {
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje);
        }
    }

    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas;
        for (Componente componente : componentesEnAlmacen) {
            if (sonRebajas) {
                componente.setPrecio(componente.getPrecio() * 0.9);
            } else {
                componente.setPrecio(componente.getPrecio() / 0.9);
            }
        }
        for (Traje traje : trajesEnAlmacen) {
            for (Componente componente : traje.getPiezas()) {
                if (sonRebajas) {
                    componente.setPrecio(componente.getPrecio() * 0.9);
                } else {
                    componente.setPrecio(componente.getPrecio() / 0.9);
                }
            }
        }
        System.out.println("Estado de rebajas actualizado.");
    }

    @Override
    public void crearEnvio() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Traje> envio = new ArrayList<>();

        while (true) {
            System.out.println("Lista de Trajes:");
            for (Traje traje : trajesEnAlmacen) {
                System.out.println(traje.getNombre());
            }

            System.out.print("Seleccione el nombre del traje a enviar (o 'fin' para terminar): ");
            String nombreTraje = scanner.next();

            if (nombreTraje.equalsIgnoreCase("fin")) {
                break;
            }

            Traje traje = buscarTrajePorNombre(nombreTraje);
            if (traje != null) {
                envio.add(traje);
                trajesEnAlmacen.remove(traje);
                System.out.println("Traje añadido al envío.");
            } else {
                System.out.println("Traje no encontrado.");
            }
        }

        System.out.println("Envío creado con " + envio.size() + " trajes.");
    }

    @Override
    public void crearComponentesDePrueba() {
        componentesEnAlmacen.add(new Chaqueta(1, "Chaqueta Azul", "M", "Azul", true, 50, 4));
        componentesEnAlmacen.add(new Blusa(2, "Blusa Roja", "M", "Rojo", true, 30, true));
        componentesEnAlmacen.add(new Falda(3, "Falda Verde", "M", "Verde", false, 20, true));
        componentesEnAlmacen.add(new Pantalon(4, "Pantalón Negro", "M", "Negro", false, 40, false));
        System.out.println("Componentes de prueba creados.");
    }

    private void validarId(int id) throws IdException {
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                throw new IdException("El ID ya existe.");
            }
        }
    }

    private void validarExtracomunitario(boolean escomunitario) throws MuchoExtracomunitarioException {
        if (escomunitario) {
            long count = componentesEnAlmacen.stream().filter(Componente::isEscomunitario).count();
            if (count >= componentesEnAlmacen.size() / 2) {
                throw new MuchoExtracomunitarioException("Hay demasiados componentes extracomunitarios.");
            }
        }
    }

    private void validarManga(String color, boolean mangaLarga) throws MangaException {
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Blusa && componente.getColor().equals(color) && ((Blusa) componente).isMangaLarga() != mangaLarga) {
                return;
            }
        }
        throw new MangaException("No existe una blusa de manga corta del mismo color.");
    }

    private void validarColores(Componente... componentes) throws ColoresException {
        String colorBase = componentes[0].getColor();
        for (Componente componente : componentes) {
            if (!componente.getColor().substring(0, 1).equals(colorBase.substring(0, 1))) {
                throw new ColoresException("Los componentes deben ser del mismo color o colores amigos.");
            }
        }
    }

    private void validarTallas(Componente... componentes) throws TallaException {
        String tallaBase = componentes[0].getTalla();
        for (Componente componente : componentes) {
            if (!(componente instanceof Falda) && !componente.getTalla().equals(tallaBase)) {
                throw new TallaException("Todos los componentes deben ser de la misma talla, excepto la falda.");
            }
        }
    }

    private void validarNombreTraje(String nombre) throws TrajeYaExisteException {
        for (Traje traje : trajesEnAlmacen) {
            if (traje.getNombre().equals(nombre)) {
                throw new TrajeYaExisteException("El nombre del traje ya existe.");
            }
        }
    }

    private Componente buscarComponentePorId(int id) {
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                return componente;
            }
        }
        return null;
    }

    private Traje buscarTrajePorNombre(String nombre) {
        for (Traje traje : trajesEnAlmacen) {
            if (traje.getNombre().equals(nombre)) {
                return traje;
            }
        }
        return null;
    }

    private ArrayList<Componente> listarComponentesPorTipo(Class<? extends Componente> tipo) {
        ArrayList<Componente> lista = new ArrayList<>();
        for (Componente componente : componentesEnAlmacen) {
            if (tipo.isInstance(componente)) {
                lista.add(componente);
                System.out.println(componente);
            }
        }
        return lista;
    }
}
