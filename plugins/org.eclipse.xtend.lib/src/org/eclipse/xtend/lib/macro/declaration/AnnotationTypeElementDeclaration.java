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
 * Represents an annotation property.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface AnnotationTypeElementDeclaration extends MemberDeclaration {

	/**
	 * @return the expression describing the default value, or <code>null</code>
	 *         if there is no default value or this annotation element is
	 *         declared in an external Java class.
	 */
	Expression getDefaultValueExpression();

	/**
	 * @return the value or <code>null</code> if the is no default value
	 */
	Object getDefaultValue();

	/**
	 * @return the type of this annotation element
	 */
	TypeReference getType();
}