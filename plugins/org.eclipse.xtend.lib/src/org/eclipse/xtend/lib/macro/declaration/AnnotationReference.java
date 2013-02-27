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
 * Represents an annotation.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface AnnotationReference extends Element {

	/**
	 * @return the annotation type
	 */
	AnnotationTypeDeclaration getAnnotationTypeDeclaration();

	/**
	 * @param property the name of the property
	 * @return the evaluated result
	 */
	Object getValue(String property);
	
	/**
	 * @param property the name of the property
	 * @return the expression
	 */
	Expression getExpression(String property);

	
//	<T extends Annotation> T get(Class<? extends T> annotationType);
}