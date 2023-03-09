/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class TransformationException extends Exception {

	private static final long serialVersionUID = -6324965070089590590L;

	private EObject erroneousElement;

	private TransformationErrorCode errorCode;

	public TransformationException(TransformationErrorCode errorCode, String message, EObject erroneousElement) {
		super(message);
		this.errorCode = errorCode;
		this.erroneousElement = erroneousElement;
	}
	
	public TransformationErrorCode getErrorCode() {
		return errorCode;
	}

	public EObject getErroneousElement() {
		return erroneousElement;
	}

	public void setErroneousElement(EObject erroneousElement) {
		this.erroneousElement = erroneousElement;
	}

}
