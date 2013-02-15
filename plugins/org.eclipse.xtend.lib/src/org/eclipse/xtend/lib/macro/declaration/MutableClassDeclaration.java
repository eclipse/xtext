/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

@Beta
public interface MutableClassDeclaration extends MutableTypeDeclaration, ClassDeclaration {
	public void setSuperclass(TypeReference superclass);
	public void setImplementedInterfaces(List<? extends TypeReference> superclass);
	void setAbstract(boolean isAbstract);
	void setFinal(boolean isFinal);
	void setStatic(boolean isStatic);
	
	/**
	 * 
	 * @param name of the method
	 * @param parameterTypes - the types of the method
	 * @return the declared method with the given name and the specified parameter types or <code>null</code> if no such method exists.
	 */
	MutableMethodDeclaration findMethod(String name, TypeReference... parameterTypes);
	void addMethod(String name, Procedures.Procedure1<MutableMethodDeclaration> initializer);
	
	/**
	 * @param name of the feature
	 * @return the declared field with the given name or <code>null</code> of no such field exists.
	 */
	MutableFieldDeclaration findField(String name);
	void addField(String name, Procedures.Procedure1<MutableFieldDeclaration> initializer);
}
