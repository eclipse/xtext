/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

/**
 * This resource validator for xtext grammars only reports syntactic errors and broken references to rule calls and super grammars.
 * 
 * @noreference This class is not intended to be referenced by clients.
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ReducedXtextResourceValidator extends ResourceValidatorImpl {

	@Override
	protected void validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		// do nothing
	}

	@Override
	protected void issueFromXtextResourceDiagnostic(Diagnostic diagnostic, Severity severity,
			IAcceptor<Issue> acceptor) {
		if (diagnostic instanceof XtextSyntaxDiagnostic) {
			super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
		} else if (diagnostic instanceof XtextLinkingDiagnostic) {
			XtextLinkingDiagnostic linkingDiagnostic = (XtextLinkingDiagnostic) diagnostic;
			if (linkingDiagnostic.getCode().equals(XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE)) {
				super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
			} else if (linkingDiagnostic.getMessage().contains("reference to Grammar")) {
				super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
			}
		}
	}
}