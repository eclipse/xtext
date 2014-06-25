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
public interface EnumerationTypeDeclaration extends TypeDeclaration {

	/**
	 * @return the values directly declared and contained in the enumeration type declaration
	 */
	Iterable<? extends EnumerationValueDeclaration> getDeclaredValues();
	
	/**
	 * @param name of the feature
	 * @return the declared value with the given name or <code>null</code> of no such value exists.
	 */
	EnumerationValueDeclaration findDeclaredValue(String name);
	
}