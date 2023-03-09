/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Arrays;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextLinkingDiagnostic extends AbstractDiagnostic {

	private final INode node;
	
	private final String message;
	
	private final String code;
	
	private final String[] data;
	
	/**
	 * @param data optional user data. May not contain <code>null</code> entries.
	 * @throws NullPointerException if node is <code>null</code> or data contains <code>null</code>.
	 */
	public XtextLinkingDiagnostic(INode node, String message, String code, String... data) {
		if (node == null)
			throw new NullPointerException("node may not be null");
		if (Arrays.contains(data, null)) {
			throw new NullPointerException("data may not contain null");
		}
		this.node = node;
		this.message = message;
		this.code = code;
		this.data = data;
	}

	@Override
	protected INode getNode() {
		return node;
	}

	@Override
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
