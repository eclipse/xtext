/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class LinkingDiagnosticMessageProvider implements ILinkingDiagnosticMessageProvider.Extended {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		String linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e){
			linkText = e.getNode().getText();
		}
		String msg = "Couldn't resolve reference to " + referenceType.getName() + " '" + linkText + "'.";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Override
	public DiagnosticMessage getIllegalNodeMessage(ILinkingDiagnosticContext context, IllegalNodeException ex) {
		String message = ex.getMessage();
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Override
	public DiagnosticMessage getIllegalCrossReferenceMessage(ILinkingDiagnosticContext context, CrossReference reference) {
		String message = "Cannot find reference " + reference;
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Override
	public DiagnosticMessage getViolatedBoundsConstraintMessage(ILinkingDiagnosticContext context, int size) {
		String message = "Too many matches for reference to '" + context.getLinkText() + "'. " 
				+ "Feature " + context.getReference().getName() + " can only hold " + context.getReference().getUpperBound()
				+ " reference" + (context.getReference().getUpperBound() != 1 ? "s" : "") + " but found " + size + " candidate" +
				(size!=1 ? "s" : "");
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}

	@Override
	public DiagnosticMessage getViolatedUniqueConstraintMessage(ILinkingDiagnosticContext context) {
		String message = "Cannot refer to '" + context.getLinkText() + "' more than once.";
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
}
