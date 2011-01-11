/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class TypeResolutionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private EObject astNode;

	public TypeResolutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeResolutionException(String message) {
		super(message);
	}
	public TypeResolutionException(String message, EObject astNode) {
		this(message);
		this.astNode = astNode;
	}

	public TypeResolutionException(Throwable cause) {
		super(cause);
	}
	
	public EObject getAstNode() {
		return astNode;
	}
}
