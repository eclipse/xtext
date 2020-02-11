/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("serial")
public class XtextSerializationException extends RuntimeException {
	private TreeConstructionReport report;

	public XtextSerializationException(TreeConstructionReport report, String message) {
		super(message + "\n" + report.toString());
		this.report = report;
	}

	public XtextSerializationException(String message) {
		super(message);
	}

	public TreeConstructionReport getReport() {
		return report;
	}
}
