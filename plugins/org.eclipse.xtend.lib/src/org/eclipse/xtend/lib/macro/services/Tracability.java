/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

import com.google.common.annotations.Beta;

/**
 * 
 * Support for navigating between the primary AST structure representing the Xtend code
 * and the corresponding Java elements derived from that.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface Tracability {
	
	/**
	 * @param element
	 * @return whether the given element is a source (i.e Xtend) element.
	 */
	boolean isSource(NamedElement element);
	
	/**
	 * @param element
	 * @return whether the given element is a Java element derived from the currently processed {@link CompilationUnit}
	 */
	boolean isGenerated(NamedElement element);
	
	/**
	 * @param element
	 * @return whether the given element is a Java element <b>not</b> derived from the currently processed {@link CompilationUnit}
	 */
	boolean isExternal(NamedElement element);
	
	/**
	 * @param source
	 * @return the primary generated element (Java) derived from the given source element (Xtend).
	 */
	MutableNamedElement getPrimaryGeneratedJavaElement(NamedElement source);
	
//	
//	/**
//	 * @param source
//	 * @return the primary generated Java class derived from the given source Xtend class element.
//	 */
//	MutableClassDeclaration getGeneratedClass(ClassDeclaration source);
//	
//	/**
//	 * @param source
//	 * @return the primary generated Java method derived from the given source Xtend method.
//	 */
//	MutableMethodDeclaration getGeneratedMethod(MethodDeclaration source);
//	
//	
//	MutableConstructorDeclaration getGeneratedConstructor(ConstructorDeclaration source);
//	MutableFieldDeclaration getGeneratedField(FieldDeclaration source);
}
