/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;

import com.google.common.annotations.Beta;

/**
 * Represents an annotation property.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableAnnotationTypeElementDeclaration extends MutableMemberDeclaration, AnnotationTypeElementDeclaration {
	
	/**
	 * Setting an expression will alter the scope of it accordingly.
	 * Each expression can only be assigned to one element, if this {@link MutableExecutableDeclaration} has already set 
	 * another expression or compilation strategy the old one will be detached.
	 * 
	 * If the given expression is already assigned to another {@link MutableExecutableDeclaration} or {@link MutableFieldDeclaration}
	 * it will be automatically detached from it.
	 * 
	 * @param value the expression to set as the default value of this annotation property
	 * 
	 * @since 2.12
	 */
	void setDefaultValueExpression(Expression value);
	
	/**
	 * Sets the given {@link CompilationStrategy} as the default value.
	 * 
	 * <b>The given {@link CompilationStrategy} will be executed later during code generation, not immediately.</b>
	 * 
	 * If this {@link MutableExecutableDeclaration} has already set another expression or compilation strategy the old one will be detached.
	 * 
	 * @param compilationStrategy the compilation strategy, must not be <code>null</code>
	 * @exception IllegalArgumentException if <code>compilationStrategy</code> is <code>null</code>
	 * 
	 * @since 2.12
	 */
	void setDefaultValueExpression(CompilationStrategy compilationStrategy);
	
	/**
	 * Sets the given {@link StringConcatenationClient} as the default value.
	 * 
	 * <b>The given {@link StringConcatenationClient} will be executed later during code generation, not immediately.</b>
	 * 
	 * If this {@link MutableExecutableDeclaration} has already set another expression or compilation strategy the old one will be detached.
	 * 
	 * @param compilationTemplate the compilation strategy, must not be <code>null</code>
	 * @exception IllegalArgumentException if <code>compilationStrategy</code> is <code>null</code>
	 * 
	 * @since 2.12
	 */
	void setDefaultValueExpression(StringConcatenationClient compilationTemplate);
	
	/**
	 * @param type the type of this annotation property, must be not <code>null</code>
	 * @exception IllegalArgumentException if the <code>type</code> is <code>null</code>
	 * 
	 * @since 2.12
	 */
	void setType(TypeReference type);
	
}
