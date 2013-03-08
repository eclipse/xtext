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
 */
@Beta
public interface MutableMethodDeclaration extends MutableExecutableDeclaration, MethodDeclaration {
	
	/**
	 * @param type the return type of this method
	 */
	void setReturnType(TypeReference type);
	
	/**
	 * @param isStatic whether this method declaration is <code>static</code>
	 */
	void setStatic(boolean isStatic);
	
	/**
	 * @param isFinal whether this method declaration is <code>final</code>
	 */
	void setFinal(boolean isFinal);
	
	/**
	 * @param isAbstract whether this method declaration is <code>abstract</code>
	 */
	void setAbstract(boolean isAbstract);
}
