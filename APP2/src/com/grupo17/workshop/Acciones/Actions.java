package com.grupo17.workshop.Acciones;

import com.grupo17.workshop.biblioteca.Libros;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class Actions extends Edition{ //Clase de acciones de la biblioteca virtual.
    //SpecificActions userinput = new SpecificActions(); //Se instancia un objeto que básicamente pedirá datos.

    public void buscarLibro(@NotNull List<Libros> libro){ //Procedimiento que Buscará un libro e imprimirá sus datos.
        String nombre_libro = introducirLibro(); //Se introduce el título del libro solicitado.

        for(int i=0; i<=(libro.size()-1); i++){
            if (nombre_libro.equals(libro.get(i).getTitulo())==true){ //Se busca el libro con el ciclo, si se encuentra, se imprimen sus datos.
                libro.get(i).printDatos();
            }
        }
    }

    public void agregarLibro(@NotNull List<Libros> libro){ //Procedimiento que agrega un libro a la Arraylist dada.
        Scanner input = new Scanner(System.in);  // Se crea un Scanner object.
        String[] datos_libro = input.nextLine().split(" "); //Se ingresan los datos y se guardan en una lista de Strings. Los datos se toman por cada espacio.
        Libros aux = new Libros(datos_libro[0], datos_libro[1], Integer.parseInt(datos_libro[2]),Integer.parseInt(datos_libro[3]), datos_libro[4], Integer.parseInt(datos_libro[5]), datos_libro[6], datos_libro[7]); //Se crea un objeto libro nuevo.
        libro.add(aux); //Se añade el libro a la Arraylist.
    }
    public void quitarLibro(@NotNull List<Libros> libro){ //Procedimiento que quita un libro de la Arraylist dada.
        String nombre_libro = introducirLibro(); //Se introduce el título del libro solicitado.

        for(int i=0; i<=(libro.size()-1); i++){ //Ciclo que busca el libro por el título.
            if (nombre_libro.equals(libro.get(i).getTitulo())==true){
                libro.remove(i); //Si se encuentra, se elimina.
            }
        }
    }

    public void editarLibro(@NotNull List<Libros> libro){ //Procedimiento que edita los atributos de un libro de la Arraylist dada.

        String nombre_libro = introducirLibro(); //Se introduce título del libro.
        String carac = elegirCarac(); //Se introduce atributo a cambiar.
        String new_dato = introducirDato(); //Se introduce nuevo valor del atributo a cambiar.

        for(int i=0; i<=(libro.size()-1); i++){ //Ciclo que busca el libro por título.
            if (nombre_libro.equals(libro.get(i).getTitulo())==true){
                //Edition aux = new Edition(libro, carac, new_dato, i); //Se crea un objeto de edición, el cual según el atributo a cambiar, hará cierta acción con la función de debajo. Se le dan los valores pedidos más el libro solicitado.
                Cambio(libro, carac, new_dato, i); //Se hace la modificación al atributo de la Arraylist.
                System.out.println("Libro modificado, queda con los siguientes datos:");
                libro.get(i).printDatos();
            }
        }
    }

    public void Alternativas(List<Libros> libro){ //Procedimiento que permite modificar, eliminar o añadir libros con base en las secciones, pisos y sedes.
        String accion = elegirAccion(); //Se ingresa la acción a hacer. Dependiendo de la acción, se hará lo correspondiente.

        if (accion.equals("modificar") ==true){
            editarLibro(libro);
        }if (accion.equals("eliminar") ==true){
            System.out.println("Para eliminar esta variable, se debe eliminar el libro o los libros asociados a esta.");
            quitarLibro(libro);
        }if (accion.equals("añadir") ==true){
            agregarLibro(libro);
        }
    }
}