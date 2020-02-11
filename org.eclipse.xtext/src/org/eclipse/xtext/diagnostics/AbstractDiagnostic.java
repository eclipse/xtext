/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.LineAndColumn;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDiagnostic implements Diagnostic {

	protected abstract INode getNode();
	
	public abstract String getCode();
	
	public abstract String[] getData();

	@Override
	public int getLength() {
		INode node = getNode();
		if (node != null)
			return node.getLength();
		return 1;
	}

	@Override
	public int getOffset() {
		INode node = getNode();
		if (node != null)
			return node.getOffset();
		return 0;
	}

	@Override
	public int getColumn() {
		INode node = getNode();
		if (node != null) {
			LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(node, getOffset());
			return lineAndColumn.getColumn();
		}
		return 0;
	}

	@Override
	public int getLine() {
		INode node = getNode();
		if (node != null)
			return node.getStartLine();
		return -1;
	}
	

	@Override
	public int getLineEnd() {
		INode node = getNode();
		if (node != null)
			return node.getEndLine();
		return -1;
	}

	@Override
	public int getColumnEnd() {
		INode node = getNode();
		if (node != null) {
			LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(node, getOffset() + getLength());
			return lineAndColumn.getColumn();
		}
		return 0;
	}

	@Override
	public String getLocation() {
		return null;
	}

	public URI getUriToProblem() {
		INode node = getNode();
		if (node == null)
			return null;
		EObject eObject = node.getSemanticElement();
		if (eObject==null || eObject.eResource()==null)
			return null;
		return EcoreUtil.getURI(eObject);
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(getClass().getSimpleName());
		b.append(": ");
		b.append(getLocation());
		b.append(":");
		b.append(getLine());
		b.append(" ");
		b.append(getMessage());
		return b.toString();
	}
}