/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface MutableFieldDeclaration extends MutableMemberDeclaration, FieldDeclaration {
	
	/**
	 * sets the 'final' property
	 * 
	 * @param isFinal
	 */
	void setFinal(boolean isFinal);

	/**
	 * sets the 'static' property
	 * 
	 * @param isStatic
	 */
	void setStatic(boolean isStatic);
	
	/**
	 * sets the 'transient' property
	 * 
	 * @param isTransient
	 */
	void setTransient(boolean isTransient);
	
	/**
	 * sets the 'volatile' property
	 * 
	 * @param isVolatile
	 */
	void setVolatile(boolean isVolatile);
	
	/**
	 * sets the 'initializer' expression of this field declaration.
	 * Automatically detaches any previously assigned initializers from this field declaration.
	 * 
	 *  If the given expression is assigned to another {@link MutableExecutableDeclaration} or {@link MutableFieldDeclaration}, it
	 *  will be detached from there as well.
	 * 
	 * @param initializer
	 */
	void setInitializer(Expression initializer);
	
	/**
	 * sets the 'initializer' expression of this field declaration.
	 * Automatically detaches any previously assigned initializers from this field declaration.
	 * 
	 * <b>The given {@link CompilationStrategy} will be executed later during code generation, not immediately.</b>
	 * 
	 * @param initializer the compilation strategy, must not be <code>null</code>
	 * @exception IllegalArgumentException if the <code>initializer</code> is <code>null</code>
	 */
	void setInitializer(CompilationStrategy initializer);

	/**
	 * sets the 'initializer' expression of this field declaration.
	 * Automatically detaches any previously assigned initializers from this field declaration.
	 * 
	 * <b>The given {@link StringConcatenationClient} will be executed later during code generation, not immediately.</b>
	 * 
	 * @param template the compilation template, must not be <code>null</code>
	 * @exception IllegalArgumentException if the <code>initializer</code> is <code>null</code>
	 */
	void setInitializer(StringConcatenationClient template);
	
	/**
	 * sets the 'type' of this field declaration
	 * @param type the type, must be not <code>null</code>
	 * @exception IllegalArgumentException if the <code>type</code> is <code>null</code>l
	 */
	void setType(TypeReference type);
}
