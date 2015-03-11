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
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableExecutableDeclaration extends MutableTypeParameterDeclarator, ExecutableDeclaration {
	
	Iterable<? extends MutableParameterDeclaration> getParameters();
	
	/**
	 * @param isVarArgs whether the last argument is a var arg.
	 */
	void setVarArgs(boolean isVarArgs);
	
	/**
	 * Setting an expression will alter the scope of it accordingly.
	 * Each expression can only be assigned to one element, if this {@link MutableExecutableDeclaration} has already set 
	 * another expression or compilation strategy the old one will be detached.
	 * 
	 * If the given expression is already assigned to another {@link MutableExecutableDeclaration} or {@link MutableFieldDeclaration}
	 * it will be automatically detached from it.
	 * 
	 * @param body the expression to set as the body of this executable
	 */
	void setBody(Expression body);
	
	/**
	 * Sets the given {@link CompilationStrategy} as the body.
	 * 
	 * <b>The given {@link CompilationStrategy} will be executed later during code generation, not immediately.</b>
	 * 
	 * If this {@link MutableExecutableDeclaration} has already set another expression or compilation strategy the old one will be detached.
	 * 
	 * @param compilationStrategy the compilation strategy, must not be <code>null</code>
	 * @exception IllegalArgumentException if <code>compilationStrategy</code> is <code>null</code>
	 */
	void setBody(CompilationStrategy compilationStrategy);
	
	/**
	 * Sets the given {@link StringConcatenationClient} as the body.
	 * 
	 * <b>The given {@link StringConcatenationClient} will be executed later during code generation, not immediately.</b>
	 * 
	 * If this {@link MutableExecutableDeclaration} has already set another expression or compilation strategy the old one will be detached.
	 * 
	 * @param compilationTemplate the compilation strategy, must not be <code>null</code>
	 * @exception IllegalArgumentException if <code>compilationStrategy</code> is <code>null</code>
	 */
	void setBody(StringConcatenationClient compilationTemplate);
	
	/**
	 * Sets the declared exceptions.
	 * 
	 * @param exceptions the declared exceptions
	 * @exception IllegalArgumentException if the <code>exceptions</code> is <code>null</code> or contains <code>null</code>
	 */
	void setExceptions(TypeReference... exceptions);
	
	/**
	 * Adds a parameter
	 * 
	 * @param name the name of the parameter, must be a valid java identifier
	 * @param type the type of the parameter, must not be <code>null</code>
	 * @return the created parameter
	 * @exception IllegalArgumentException if the name is not a valid java identifier or the type is <code>null</code>
	 */
	MutableParameterDeclaration addParameter(String name, TypeReference type);
}
