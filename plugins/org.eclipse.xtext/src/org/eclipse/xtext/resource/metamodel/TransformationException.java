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
import org.eclipse.xtext.resource.metamodel.ErrorAcceptor.ErrorCode;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class TransformationException extends Exception {

	private static final long serialVersionUID = -6324965070089590590L;

	private EObject erroneousElement;

	private ErrorCode errorCode;

	public TransformationException(ErrorCode errorCode, String message, EObject erroneousElement) {
		super(message);
		this.errorCode = errorCode;
		this.erroneousElement = erroneousElement;
	}
	
	@Deprecated
	public TransformationException(ErrorCode errorCode, String message) {
		this(errorCode, message, null);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public EObject getErroneousElement() {
		return erroneousElement;
	}

	public void setErroneousElement(EObject erroneousElement) {
		this.erroneousElement = erroneousElement;
	}

}
