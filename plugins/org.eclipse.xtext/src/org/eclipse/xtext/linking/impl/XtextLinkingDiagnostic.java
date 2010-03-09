/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextLinkingDiagnostic extends AbstractDiagnostic {

	private final AbstractNode node;
	
	private final String message;
	
	private final String code;
	
	private final String[] data;
	
	public XtextLinkingDiagnostic(AbstractNode node, String message, String code, String... data) {
		if (node == null)
			throw new NullPointerException("node may not be null");
		this.node = node;
		this.message = message;
		this.code = code;
		this.data = data;
	}

	@Override
	protected AbstractNode getNode() {
		return node;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String[] getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XtextLinkingDiagnostic other = (XtextLinkingDiagnostic) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	
	

}
