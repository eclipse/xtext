/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
