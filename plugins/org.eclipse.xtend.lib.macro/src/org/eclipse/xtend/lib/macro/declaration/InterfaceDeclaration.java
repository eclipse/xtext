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
public interface InterfaceDeclaration extends TypeDeclaration, TypeParameterDeclarator {
	
	/**
	 * @return whether this class is marked <code>strictfp</code>
	 */
	boolean isStrictFloatingPoint();
	
	/**
	 * @return the extended interfaces
	 */
	Iterable<? extends TypeReference> getExtendedInterfaces();
	
}