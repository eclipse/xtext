/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.SyntaxError;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class XtextSyntaxDiagnostic extends AbstractDiagnostic {

	private final SyntaxError error;

	public XtextSyntaxDiagnostic(SyntaxError error) {
		this.error = error;
	}
	
	@Override
	public String getCode() {
		return error.getIssueCode();
	}

	@Override
	protected AbstractNode getNode() {
		return error.getNode();
	}

	public String getMessage() {
		return error.getMessage();
	}
	
	@Override
	public String getLocation() {
		if (error.eResource() != null)
			return error.eResource().getURI().toString();
		return super.getLocation();
	}
}
