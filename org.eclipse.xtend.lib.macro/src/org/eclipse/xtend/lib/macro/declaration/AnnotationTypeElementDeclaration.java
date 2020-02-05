/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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