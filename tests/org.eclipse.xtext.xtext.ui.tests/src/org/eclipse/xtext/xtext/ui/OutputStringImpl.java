/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui;

import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutputStringImpl implements Output {

	private StringBuffer currentBuffer;
	
	public OutputStringImpl() {
		currentBuffer = new StringBuffer();
	}

	public void addOutlet(Outlet outlet) {
		// ignore
	}

	public Outlet getOutlet(String name) {
		// ignore
		return null;
	}

	public void closeFile() {
		// ignore
	}

	public void openFile(String path, String outletName) {
		// ignore
	}

	public SyntaxElement popStatement() {
		// ignore
		return null;
	}

	public void pushStatement(SyntaxElement stmt, XpandExecutionContext ctx) {
		// ignore
	}

	public void write(String bytes) {
		currentBuffer.append(bytes);
	}

	public String getContent(String path) {
		return currentBuffer.toString();
	}
}
