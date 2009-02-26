/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextLinkingDiagnostic extends AbstractDiagnostic {

	private final AbstractNode node;
	
	private final String message;
	
	public XtextLinkingDiagnostic(AbstractNode node, String message) {
		if (node == null)
			throw new NullPointerException("node may not be null");
		this.node = node;
		this.message = message;
	}

	@Override
	protected AbstractNode getNode() {
		return node;
	}

	public String getMessage() {
		return message;
	}

}
