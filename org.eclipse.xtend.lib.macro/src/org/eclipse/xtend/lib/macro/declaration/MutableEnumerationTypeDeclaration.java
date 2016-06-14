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
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableEnumerationTypeDeclaration extends MutableTypeDeclaration, EnumerationTypeDeclaration {

	Iterable<? extends MutableEnumerationValueDeclaration> getDeclaredValues();
	
	MutableEnumerationValueDeclaration findDeclaredValue(String name);
	
	/**
	 * Adds a new value with the given name. 
	 * 
	 * @param name the name of the field to be added, must be not <code>null</code>
	 * @param initializer a callback for further initialization of the created value, must be not <code>null</code>
	 * @return the created value declaration
	 * @exception IllegalArgumentException if the <code>name</code> is not a valid java identifier or the <code>initializer</code> is <code>null</code>
	 */
	MutableEnumerationValueDeclaration addValue(String name, Procedures.Procedure1<MutableEnumerationValueDeclaration> initializer);

}
