/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TypeNotFoundException() {
		super();
	}

	public TypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeNotFoundException(String message) {
		super(message);
	}

	public TypeNotFoundException(Throwable cause) {
		super(cause);
	}

}
