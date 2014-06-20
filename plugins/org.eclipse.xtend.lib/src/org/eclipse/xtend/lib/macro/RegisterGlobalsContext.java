/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;

import com.google.common.annotations.Beta;

/**
 * Provides services to be used during register-globals phase.
 * 
 * @author Sven Efftinge
 * 
 * @see RegisterGlobalsParticipant
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface RegisterGlobalsContext extends FileSystemSupport, FileLocations {
	
	/**
	 * Registers and creates an empty Java class with given qualified name
	 * 
	 * If the name's namespace part refers to another derived Java type, this type will become a static member of that type.
	 * 
	 * For instance, given an 
	 * <pre>
	 *  // creates a type 'MyClass' in the package 'my.pack'
	 *  registerClass("my.pack.MyClass") 
	 * 
	 *  // creates a type 'MyInnerClass' as a member of the type 'my.pack.MyClass'
	 *  registerClass("my.pack.MyClass.MyInnerClass") 
	 * </pre>
	 * 
	 * @param qualifiedName
	 * @throws IllegalArgumentException if the qualifiedName conflicts with any existing types.
	 * @exception IllegalArgumentException if the <code>qualifiedName</code> is not a valid qualified name
	 */
	void registerClass(String qualifiedName) throws IllegalArgumentException ;
	
	/**
	 * Registers and creates an empty Java interface with given qualified name
	 * 
	 * If the name's namespace part refers to another derived Java type, this type will become a static member of that type.
	 * 
	 * For instance, given an 
	 * <pre>
	 *  // creates a type 'MyClass' in the package 'my.pack'
	 *  registerClass("my.pack.MyClass") 
	 * 
	 *  // creates a type 'MyInnerClass' as a member of the type 'my.pack.MyClass'
	 *  registerClass("my.pack.MyClass.MyInnerClass") 
	 * </pre>
	 * 
	 * @param qualifiedName
	 * @throws IllegalArgumentException if the qualifiedName conflicts with any existing types.
	 * @exception IllegalArgumentException if the <code>qualifiedName</code> is not a valid qualified name
	 */
	void registerInterface(String qualifiedName) throws IllegalArgumentException ;
	
	/**
	 * Registers and creates an empty Java annotation type with given qualified name
	 * 
	 * If the name's namespace part refers to another derived Java type, this type will become a static member of that type.
	 * 
	 * For instance, given an 
	 * <pre>
	 *  // creates a type 'MyClass' in the package 'my.pack'
	 *  registerClass("my.pack.MyClass") 
	 * 
	 *  // creates a type 'MyInnerClass' as a member of the type 'my.pack.MyClass'
	 *  registerClass("my.pack.MyClass.MyInnerClass") 
	 * </pre>
	 * 
	 * @param qualifiedName
	 * @throws IllegalArgumentException if the qualifiedName conflicts with any existing types.
	 * @exception IllegalArgumentException if the <code>qualifiedName</code> is not a valid qualified name
	 */
	void registerAnnotationType(String qualifiedName) throws IllegalArgumentException ;
	
	/**
	 * Registers and creates an empty Java enumeration type with given qualified name
	 * 
	 * If the name's namespace part refers to another derived Java type, this type will become a static member of that type.
	 * 
	 * For instance, given an 
	 * <pre>
	 *  // creates a type 'MyClass' in the package 'my.pack'
	 *  registerClass("my.pack.MyClass") 
	 * 
	 *  // creates a type 'MyInnerClass' as a member of the type 'my.pack.MyClass'
	 *  registerClass("my.pack.MyClass.MyInnerClass") 
	 * </pre>
	 * 
	 * @param qualifiedName
	 * @throws IllegalArgumentException if the qualifiedName conflicts with any existing types.
	 * @exception IllegalArgumentException if the <code>qualifiedName</code> is not a valid qualified name
	 */
	void registerEnumerationType(String qualifiedName) throws IllegalArgumentException ;
}
