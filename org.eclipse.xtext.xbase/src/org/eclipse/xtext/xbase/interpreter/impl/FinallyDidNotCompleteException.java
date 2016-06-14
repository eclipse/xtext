/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FinallyDidNotCompleteException extends Exception {

	private static final long serialVersionUID = 1L;

	public FinallyDidNotCompleteException(Throwable cause) {
		super(cause);
	}
}
