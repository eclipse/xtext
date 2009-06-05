/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;



@SuppressWarnings("serial")
public class XtextSerializationException extends RuntimeException {
//	private static String diagToString(
//			List<AbstractSerializationDiagnostic> diagnostic) {
//		Collections.sort(diagnostic);
//		StringBuffer b = new StringBuffer();
//		for (AbstractSerializationDiagnostic d : diagnostic) {
//			b.append("\n");
//			b.append(d.toString());
//		}
//		return b.toString();
//	}
//
	private IInstanceDescription desc;
//	private List<AbstractSerializationDiagnostic> diagnostic;
	public XtextSerializationException(IInstanceDescription desc, String msg) {
		super(msg);
		this.desc = desc;
//		this.diagnostic = null;
	}
//
//	public XtextSerializationException(IInstanceDescription desc, String msg,
//			List<AbstractSerializationDiagnostic> diagnostic) {
//		super(msg + diagToString(diagnostic));
//		this.desc = desc;
//		this.diagnostic = diagnostic;
//	}
//
//	public IInstanceDescription getDesc() {
//		return desc;
//	}
//
//	public List<AbstractSerializationDiagnostic> getDiagnostic() {
//		return diagnostic;
//	}
}
