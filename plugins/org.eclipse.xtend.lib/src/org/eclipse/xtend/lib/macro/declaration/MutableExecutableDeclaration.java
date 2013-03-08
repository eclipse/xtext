/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.expression.Expression;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface MutableExecutableDeclaration extends MutableTypeParameterDeclarator, ExecutableDeclaration {
	public List<MutableParameterDeclaration> getParameters();
	
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
	 * If this {@link MutableExecutableDeclaration} has already set another expression or compilation strategy the old one will be detached and returned.
	 * 
	 * If the given expression is already assigned to another {@link MutableExecutableDeclaration} or {@link MutableFieldDeclaration}
	 * it will be automatically detached from it.
	 * 
	 * @param compilationStrategy the compilation startegy
	 * 
	 */
	void setBody(CompilationStrategy compilationStrategy);
	
	/**
	 * Sets the declared exceptions.
	 * 
	 * @param exceptions the declared exceptions
	 */
	void setExceptions(TypeReference... exceptions);
	
	/**
	 * Adds a parameter
	 * 
	 * @param name the name of the parameter, must not be <code>null</code>
	 * @param type the type of the parameter, must not be <code>null</code>
	 * @return the created parameter
	 */
	MutableParameterDeclaration addParameter(String name, TypeReference type);
}
