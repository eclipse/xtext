/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class TransformationException extends Exception {

	private static final long serialVersionUID = -6324965070089590590L;

	private EObject erroneousElement;

	public TransformationException(String message, EObject erroneousElement) {
		super(message);
		this.erroneousElement = erroneousElement;
	}

	public EObject getErroneousElement() {
		return erroneousElement;
	}

	public void setErroneousElement(EObject erroneousElement) {
		this.erroneousElement = erroneousElement;
	}
	
}
