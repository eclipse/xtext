/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingDiagnosticProducer extends AbstractDiagnosticProducer {

	public LinkingDiagnosticProducer(IDiagnosticConsumer consumer) {
		super(consumer);
	}

	@Override
	protected Diagnostic createDiagnostic(DiagnosticMessage message) {
		return new XtextLinkingDiagnostic(getNode(), message.getMessage(), message.getIssueCode());
	}
	
}
