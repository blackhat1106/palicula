import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    // Atributo que define el nombre de la película
    private String nombre;
    // Atributo que define el director de la película
    private String director;
    // Tipo de película como un valor enumerado
    public enum Tipo { ACCIÓN, COMEDIA, DRAMA, SUSPENSO }
    // Atributo que define los géneros de la película
    private List<Tipo> generos;
    // Atributo que define la duración de la película
    private int duracion; 
    // Atributo que define el año de estreno de la película
    private int año;
    // Atributo que define la calificación de la película por el público
    private double calificacion;

    // Constructor
    public Pelicula(String nombre, String director, List<Tipo> generos, int duracion, int año, double calificacion) {
        this.nombre = nombre;
        this.director = director;
        this.generos = generos;
        this.duracion = duracion;
        this.año = año;
        this.calificacion = calificacion;
    }

    // Método para imprimir detalles de la película
    public void imprimir() {
        imprimirCartel();
    }

    // Método privado para imprimir el cartel de la película
    private void imprimirCartel() {
        // Imprimir el título
        System.out.println(centerText("-------- " + nombre + " ----------"));
        
        // Convertir la calificación a asteriscos
        int estrellas = (int) Math.round(calificacion); // Redondear a la cantidad entera más cercana
        System.out.println(centerText("*".repeat(Math.min(estrellas, 10)))); // Limitar a 10 asteriscos como máximo

        // Imprimir el año
        System.out.println(centerText(String.valueOf(año)));

        // Imprimir los géneros, limitando a 3 y separando por comas
        String generosStr = String.join(", ", generos.stream().map(Enum::name).toArray(String[]::new));
        System.out.println(centerText(generosStr));

        // Imprimir el director
        System.out.println(centerText(director));
    }

    // Método privado para centrar el texto
    private String centerText(String text) {
        int width = 60; // Ajusta el ancho según la consola
        int padding = Math.max(0, (width - text.length()) / 2);
        StringBuilder paddedText = new StringBuilder();

        // Añadir espacios en blanco a la izquierda
        for (int i = 0; i < padding; i++) {
            paddedText.append(" ");
        }
        paddedText.append(text); // Añadir el texto original
        return paddedText.toString();
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        List<Tipo> generos1 = new ArrayList<>();
        generos1.add(Tipo.DRAMA);
        Pelicula pelicula1 = new Pelicula("Gandhi ej idjfmszxjj", "Richard Attenborough", generos1, 191, 1982, 1.3);

        List<Tipo> generos2 = new ArrayList<>();
        generos2.add(Tipo.ACCIÓN);
        Pelicula pelicula2 = new Pelicula("Thor", "Kenneth Branagh", generos2, 115, 2011, 7.0);
        
        pelicula1.imprimir();
        System.out.println();
        pelicula2.imprimir();
    }
}

