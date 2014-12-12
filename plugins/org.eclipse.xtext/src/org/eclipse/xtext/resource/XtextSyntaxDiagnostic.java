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
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class XtextSyntaxDiagnostic extends AbstractDiagnostic {

	private final INode errorNode;

	public XtextSyntaxDiagnostic(INode errorNode) {
		this.errorNode = errorNode;
	}
	
	@Override
	public String getCode() {
		return errorNode.getSyntaxErrorMessage().getIssueCode();
	}
	
	@Override
	public String[] getData() {
		return errorNode.getSyntaxErrorMessage().getIssueData();
	}

	@Override
	protected INode getNode() {
		return errorNode;
	}

	@Override
	public String getMessage() {
		return errorNode.getSyntaxErrorMessage().getMessage();
	}
	
}
