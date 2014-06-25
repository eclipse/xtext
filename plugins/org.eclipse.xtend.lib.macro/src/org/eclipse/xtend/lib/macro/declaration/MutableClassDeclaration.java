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
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableClassDeclaration extends MutableTypeParameterDeclarator, MutableTypeDeclaration, ClassDeclaration {
	
	/**
	 * @param isFinal 
	 */
	void setFinal(boolean isFinal);
	
	/**
	 * Sets the <code>abstract</code> property
	 * 
	 * @param isAbstract 
	 */
	void setAbstract(boolean isAbstract);
	
	/**
	 * @param isStatic
	 */
	void setStatic(boolean isStatic);
	
	/**
	 * @param isStrictFloatingPoint
	 */
	void setStrictFloatingPoint(boolean isStrictFloatingPoint);
	
	/**
	 * @param superclass the type reference to the super type. <code>null</code> resets the extended class to java.lang.Object (the default).
	 */
	public void setExtendedClass(TypeReference superclass);
	
	/**
	 * @param superinterfaces the interfaces this class implements
	 * @exception IllegalArgumentException if <code>superinterfaces</code> is <code>null</code> or contains <code>null</code>
	 */
	public void setImplementedInterfaces(Iterable<? extends TypeReference> superinterfaces);
	
}
