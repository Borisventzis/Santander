package com.Santander.Santander;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;


@Service
public class SanService {

	//Crea el arrayList donde guardaremos los Usuarios
	/*
	 * static List<Name> Usuarios = new ArrayList<Name>(); //Creamos el objeto Faker
	 * que rellenara los campos static Faker generador = new Faker(); static int
	 * i=0;
	 * 
	 * 
	 * //Metodo para rellenar la tabla mediante Faker public static void
	 * RellenarTabla() {
	 * 
	 * while(i<100) { Name crearObjeto = new Name(generador.name().fullName() ,
	 * generador.name().firstName(),
	 * generador.name().lastName(),generador.name().name() ,
	 * generador.name().username() ); Usuarios.add(crearObjeto); i++; }
	 * 
	 * } //Llamamos el metodo para rellenar la tabla static { RellenarTabla(); }
	 */
	//Metodo para mostrar los datos (Devuelve el Array con los usuarios)
	public List<Name> ShowAll() {
		
		return Usuarios;
		
	}
	//Metodo para introducir un nuevo usuario (Hay que pasarle un objeto para que lo cree)
	public boolean NewUser(Name name) {
		
		Usuarios.add(name);
		return true;
	}
	//Metodo para eliminar un usuario por su identificador unico el DNI (Hay que pasar por argumentos el DNI) 
	//Busca el usuario en el array coincidiendo con el DNI especificado y lo borra.
	public boolean DeleteUser(long dni) {
		
		for (Name name : SanService.Usuarios) {
			if(name.getDNI() == dni) {
				SanService.Usuarios.remove(dni);
				break;
			}
		}
		return true;
	}
	//Busca el objeto mediante DNI y devuelve la posicion en el array
	public int findByDNI(long dni) {

		/*
		 * int index = 0; for (Book bookInArray : this.books) {
		 * 
		 * if (bookInArray.getTitle().equals(title)) break; index++; }
		 */
		
		int index=-1;
		
		for(Name name : this.Usuarios) {
			if(name.getDNI() == dni) {
				index= this.Usuarios.indexOf(name);
				break;
			}
		}
		return index;
		
	}
	//Busca el objeto mediante DNI y devuelve el objeto entero
	public Name findObjChampByDNI(long dni) {

		/*
		 * int index = 0; for (Book bookInArray : this.books) {
		 * 
		 * if (bookInArray.getTitle().equals(title)) break; index++; }
		 */
		
		Name index = null;
		
		for(Name name : this.Usuarios) {
			if(name.getDNI()==dni) {
				index= name ;
				break;
			}
		}
		return index;
	}
//Actualiza el Usuario en la posicion indicada, Lo borra y pone un nuevo que se le pasa por argumentos
	public boolean updateName(Name name ,int index) {
		
			this.Usuarios.set(index, name);
			
			return true;
		}
	 
}
