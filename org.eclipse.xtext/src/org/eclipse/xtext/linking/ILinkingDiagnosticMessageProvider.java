/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	/**
	 * @return the error message for the unresolved cross link or <code>null</code> if it is ok to have an unresolved reference.
	 */
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
