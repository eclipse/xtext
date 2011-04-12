package xtend.tutorial.basics;

import xtend.tutorial.util.Person;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

public class Xtend11_ModularizationMain {
	
	public static void main(String[] args) {
		Person p = new Person("Joe","Developer");
		
		// use the standard configuration
		Xtend11_Modularization instance = Guice.createInjector().getInstance(Xtend11_Modularization.class);
		
		// use a special module
		Xtend11_Modularization instance2 = Guice.createInjector(new SpecialModule()).getInstance(Xtend11_Modularization.class);
		
		System.out.print("Standard config :\t");
		instance.printTheName(p);
		
		System.out.print("Special config :\t");
		instance2.printTheName(p);
	}
	
	static class SpecialModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(Xtend11_PersonExtensions.class).to(Xtend11_PersonExtensionsSubclass.class);
		}
	}
}
