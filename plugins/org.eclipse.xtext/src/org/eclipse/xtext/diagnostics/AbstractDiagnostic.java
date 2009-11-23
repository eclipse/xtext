/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDiagnostic implements Diagnostic {

	protected abstract AbstractNode getNode();

	public int getLength() {
		return getNode().getLength();
	}

	public int getOffset() {
		return getNode().getOffset();
	}

	public int getColumn() {
		throw new UnsupportedOperationException();
	}

	public int getLine() {
		return getNode().getLine();
	}

	public String getLocation() {
		return null;
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