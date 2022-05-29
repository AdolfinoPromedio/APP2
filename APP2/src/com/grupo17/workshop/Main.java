package com.grupo17.workshop;
import  com.grupo17.workshop.archivos.Archivo;
import com.grupo17.workshop.biblioteca.Libros;
import com.grupo17.workshop.vista.ChoiceMenu;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main {
    public static void main(String @NotNull [] args){

        Archivo the_file = new Archivo(args[0]); //Se da el archivo.
        List<Libros> libro = the_file.leerDatos(); //Se crea el Arraylist con todos los libros del csv.
        ChoiceMenu M = new ChoiceMenu(libro); //Se crea la instancia del menu con el arraylist seleccionado.
        while(true) {
            M.init(); //Se inicializa el menu.
            int eleccion = M.getChoice(); //Se solicita la eleccion
            if (eleccion == 0){break;} //Si es igual a 0, se rompe el ciclo y se termina todo.
            M.decision(); //En caso contrario, se llama un procedimiento que actua según la elección del usuario.
            the_file.rewrite(libro); //Se reescribe el csv.
       }
    }
}
