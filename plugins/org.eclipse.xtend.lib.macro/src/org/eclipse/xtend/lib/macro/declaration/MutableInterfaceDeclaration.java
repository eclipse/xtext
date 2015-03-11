/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

/**
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MutableInterfaceDeclaration extends MutableTypeParameterDeclarator, MutableTypeDeclaration, InterfaceDeclaration {

	/**
	 * @param isStrictFloatingPoint
	 */
	void setStrictFloatingPoint(boolean isStrictFloatingPoint);

	/**
	 * @param superinterfaces the interfaces this class implements, must be not <code>null</code>
	 * @exception IllegalArgumentException if <code>superinterfaces</code> is <code>null</code> or contains <code>null</code>
	 */
	public void setExtendedInterfaces(Iterable<? extends TypeReference> superinterfaces);
}
