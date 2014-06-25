/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface TypeDeclaration extends Type, MemberDeclaration {

	/**
	 * @return the members directly declared and contained in the type declaration
	 */
	Iterable<? extends MemberDeclaration> getDeclaredMembers();
	
	/**
	 * @return the methods directly declared and contained in the type declaration
	 */
	Iterable<? extends MethodDeclaration> getDeclaredMethods();
	
	/**
	 * @return the fields directly declared and contained in the type declaration
	 */
	Iterable<? extends FieldDeclaration> getDeclaredFields();
	
	/**
	 * @return the constructors directly declared and contained in the type declaration
	 */
	Iterable<? extends ConstructorDeclaration> getDeclaredConstructors();
	
	/**
	 * @return the classes directly declared and contained in the type declaration
	 */
	Iterable<? extends ClassDeclaration> getDeclaredClasses();
	
	/**
	 * @return the interfaces directly declared and contained in the type declaration
	 */
	Iterable<? extends InterfaceDeclaration> getDeclaredInterfaces();
	
	/**
	 * @param name of the feature
	 * @return the declared field with the given name or <code>null</code> of no such field exists.
	 */
	FieldDeclaration findDeclaredField(String name);
	
	/**
	 * @param name of the method
	 * @param parameterTypes - the types of the method
	 * @return the declared method with the given name and the specified parameter types or <code>null</code> if no such method exists.
	 */
	MethodDeclaration findDeclaredMethod(String name, TypeReference... parameterTypes);
	
	/**
	 * @param parameterTypes - the parameter types of the constructor
	 * @return the declared constructor with the exact same parameter types or <code>null</code> if no such constructors exists.
	 */
	ConstructorDeclaration findDeclaredConstructor(TypeReference... parameterTypes);
}