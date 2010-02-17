/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TransformationDiagnostic extends AbstractDiagnostic {

	private final AbstractNode node;
	private final String message;
	private final TransformationErrorCode errorCode;

	public TransformationDiagnostic(AbstractNode node, String message, TransformationErrorCode errorCode) {
		if (node == null)
			throw new NullPointerException("node may not be null");
		this.node = node;
		this.message = message;
		this.errorCode = errorCode;
	}
	
	@Override
	protected AbstractNode getNode() {
		return node;
	}
	
	@Override
	public String getCode() {
		return errorCode.getFullyQualifiedCode();
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer(super.toString());
		b.append(" (ErrorCode: ").append(errorCode).append(')');
		return b.toString();
	}

}
