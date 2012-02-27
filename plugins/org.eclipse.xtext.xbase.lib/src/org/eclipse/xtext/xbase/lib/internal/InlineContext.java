/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

/**
 * Describes the context where a method inline annotation should be
 * respected.
 * @author Sebastian Zarnekow
 */
public enum InlineContext {
	/**
	 * Used to indicate that a method should be inlined by the compiler if
	 * used as expression and if used as statement.
	 */
	ALWAYS,
	/**
	 * Used to indicate that a method should be inlined by the compiler only if
	 * used as expression.
	 */
	EXPRESSION,
	/**
	 * Used to indicate that a method should be inlined by the compiler only if
	 * used as statement.
	 */
	STATEMENT
}