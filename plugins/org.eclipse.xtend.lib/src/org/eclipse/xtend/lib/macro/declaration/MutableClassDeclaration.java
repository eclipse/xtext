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
 */
@Beta
public interface MutableClassDeclaration extends MutableTypeDeclaration, ClassDeclaration {
	
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
	 * @param superclass the type reference to the super type.
	 */
	public void setExtendedClass(TypeReference superclass);
	
	/**
	 * @param superinterfaces the interfaces this class implements
	 */
	public void setImplementedInterfaces(Iterable<? extends TypeReference> superinterfaces);
	
}
