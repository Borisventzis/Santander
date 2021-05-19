package com.Santander.Santander;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;


@Service
public class SanService {

	//Crea el arrayList donde guardaremos los Usuarios
	static List<Name> Usuarios = new ArrayList<Name>();
	//Creamos el objeto Faker que rellenara los campos
	static Faker generador = new Faker();
	static int i=0;

	
	//Metodo para rellenar la tabla mediante Faker
	public static void RellenarTabla() {
		
		while(i<100) {
		Name crearObjeto = new Name(generador.name().fullName() , generador.name().firstName(), generador.name().lastName(),generador.name().name() , generador.name().username() );
			Usuarios.add(crearObjeto);
			i++;
		}
		
	}
	//Llamamos el metodo para rellenar la tabla
	static {
		RellenarTabla();
	}
	
	public List<Name> ShowAll() {
		
		return Usuarios;
		
	}
	
	public boolean NewUser(Name name) {
		
		Usuarios.add(name);
		return true;
	}
	
	public boolean DeleteUser(long dni) {
		
		for (Name name : SanService.Usuarios) {
			if(name.getDNI() == dni) {
				SanService.Usuarios.remove(dni);
				break;
			}
		}
		return true;
	}
	
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

	public boolean updateChamp(Name name ,int index) {
		
			this.Usuarios.set(index, name);
			
			return true;
		}
	 
}
