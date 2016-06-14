/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
	public static final String UNRESOLVED_RULE = "org.eclipse.xtext.grammar.UnresolvedRule";

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {
		DiagnosticMessage diagnosticMessage = new XtextSwitch<DiagnosticMessage>() {
			@Override
			public DiagnosticMessage caseRuleCall(RuleCall ruleCall) {
				return new DiagnosticMessage(context.getLinkText()+" cannot be resolved to a rule", Severity.ERROR,
						UNRESOLVED_RULE, context.getLinkText());
			}

		}.doSwitch(context.getContext());
		return diagnosticMessage != null ? diagnosticMessage : super.getUnresolvedProxyMessage(context);
	}
}
