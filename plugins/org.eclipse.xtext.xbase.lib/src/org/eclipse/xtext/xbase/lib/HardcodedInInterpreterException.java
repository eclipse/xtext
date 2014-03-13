/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * This exception is thrown if a method was invoked directly though it is usually inlined by the compiler by means of
 * the {@link Inline @Inline annotation} and executed in a custom manner by the interpreter.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
class HardcodedInInterpreterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
