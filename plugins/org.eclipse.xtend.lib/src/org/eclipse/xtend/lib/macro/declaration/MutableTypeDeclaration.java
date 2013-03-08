/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Sven Efftinge
 */
@Beta
public interface MutableTypeDeclaration extends MutableMemberDeclaration, TypeDeclaration {
	
	Iterable<? extends MutableMemberDeclaration> getDeclaredMembers();
	
	Iterable<? extends MutableMethodDeclaration> getDeclaredMethods();
	
	Iterable<? extends MutableFieldDeclaration> getDeclaredFields();
	
	Iterable<? extends MutableConstructorDeclaration> getDeclaredConstructors();
	
	Iterable<? extends MutableClassDeclaration> getDeclaredClasses();
	
	Iterable<? extends MutableInterfaceDeclaration> getDeclaredInterfaces();
	
	MutableFieldDeclaration findField(String name);

	MutableMethodDeclaration findMethod(String name, TypeReference... parameterTypes);

	MutableConstructorDeclaration findConstructor(TypeReference... parameterTypes);
	
	/**
	 * Adds a new field with the given name. 
	 * 
	 * @param name the name of the field to be added
	 * @param initializer a callback for further initialization of the created field
	 * @return the created field declaration
	 * @throws UnsupportedOperationException if the underlying type declaration is not capable of containing methods.
	 */
	MutableFieldDeclaration addField(String name, Procedures.Procedure1<MutableFieldDeclaration> initializer);

	/**
	 * Adds a new method with the given name to this type declaration.
	 * 
	 * @param name the name of the method
	 * @param initializer a call back for further initialization of the method
	 * @return the created method declaration
	 * @throws UnsupportedOperationException if the underlying type declaration is not capable of containing methods.
	 */
	MutableMethodDeclaration addMethod(String name, Procedures.Procedure1<MutableMethodDeclaration> initializer);
	
	/**
	 * Adds a new method with the given name to this type declaration.
	 * 
	 * @param name the name of the method
	 * @param initializer a call back for further initialization of the method
	 * @return the created constructor declaration
	 * @throws UnsupportedOperationException if the underlying type declaration is not capable of containing methods.
	 */
	MutableConstructorDeclaration addConstructor(Procedures.Procedure1<MutableConstructorDeclaration> initializer);
	
}
