/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ILinkingDiagnosticMessageProvider.Extended.class)
public interface ILinkingDiagnosticMessageProvider {
	
	DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context);

	interface ILinkingDiagnosticContext {
		EObject getContext();

		EReference getReference();

		String getLinkText();
	}

	@ImplementedBy(LinkingDiagnosticMessageProvider.class)
	interface Extended extends ILinkingDiagnosticMessageProvider {
		DiagnosticMessage getIllegalNodeMessage(ILinkingDiagnosticContext context, IllegalNodeException ex);

		DiagnosticMessage getIllegalCrossReferenceMessage(ILinkingDiagnosticContext context, CrossReference reference);

		DiagnosticMessage getViolatedBoundsConstraintMessage(ILinkingDiagnosticContext context, int size);

		DiagnosticMessage getViolatedUniqueConstraintMessage(ILinkingDiagnosticContext context);
	}

}
