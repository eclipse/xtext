/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface FieldDeclaration extends MemberDeclaration {
	
	/**
	 * @return whether this field is declared 'final'
	 */
	boolean isFinal();

	/**
	 * @return whether this field is declared 'static'
	 */
	boolean isStatic();
	
	/**
	 * @return whether this field is declared 'transient'
	 */
	boolean isTransient();
	
	/**
	 * @return whether this field is declared 'volatile'
	 */
	boolean isVolatile();
	
	/**
	 * @return the initializer. <code>null</code> if no initializer is present or this is an external element.
	 */
	Expression getInitializer();
	
	/**
	 * @return the type of this expression. <code>null</code> if this is a source field declaration and the type is inferred from the initializer.
	 */
	TypeReference getType();
	
}