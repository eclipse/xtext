/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;

@SuppressWarnings("serial")
public class XtextSerializationException extends RuntimeException {
	private TreeConstructionReport rep;

	public XtextSerializationException(TreeConstructionReport rep, String msg) {
		super(msg + "\n" + rep.toString());
		this.rep = rep;
	}

	public XtextSerializationException(String message) {
		super(message);
	}

	public TreeConstructionReport getReport() {
		return rep;
	}
}
