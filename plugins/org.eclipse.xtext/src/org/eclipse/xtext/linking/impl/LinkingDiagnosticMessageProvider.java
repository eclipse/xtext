/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.DiagnosticSeverity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingDiagnosticMessageProvider implements ILinkingDiagnosticMessageProvider.Extended {

	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = "Couldn't resolve reference to " + referenceType.getName() + " '" + context.getLinkText() + "'.";
		return new DiagnosticMessage(msg, DiagnosticSeverity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	public DiagnosticMessage getIllegalNodeMessage(ILinkingDiagnosticContext context, IllegalNodeException ex) {
		String message = ex.getMessage();
		return new DiagnosticMessage(message, DiagnosticSeverity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	public DiagnosticMessage getIllegalCrossReferenceMessage(ILinkingDiagnosticContext context, CrossReference reference) {
		String message = "Cannot find reference " + reference;
		return new DiagnosticMessage(message, DiagnosticSeverity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	public DiagnosticMessage getViolatedBoundsConstraintMessage(ILinkingDiagnosticContext context, int size) {
		String message = "Too many matches for reference to '" + context.getLinkText() + "'. " 
				+ "Feature " + context.getReference().getName() + " can only hold " + context.getReference().getUpperBound()
				+ " reference" + (context.getReference().getUpperBound() != 1 ? "s" : "") + " but found " + size + " candidates" +
				(size!=1 ? "s" : "");
		return new DiagnosticMessage(message, DiagnosticSeverity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}

	public DiagnosticMessage getViolatedUniqueConstraintMessage(ILinkingDiagnosticContext context) {
		String message = "Cannot refer to '" + context.getLinkText() + "' more than once.";
		return new DiagnosticMessage(message, DiagnosticSeverity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
}
