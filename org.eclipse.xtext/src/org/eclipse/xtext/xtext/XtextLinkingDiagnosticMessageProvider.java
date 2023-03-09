/*******************************************************************************
 * Copyright (c) 2010, 2020 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ParserRule;
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
	public static final String UNRESOLVED_TERMINAL_RULE = "org.eclipse.xtext.grammar.UnresolvedTerminalRule";

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {
		DiagnosticMessage diagnosticMessage = new XtextSwitch<DiagnosticMessage>() {
			
			@Override
			public DiagnosticMessage caseRuleCall(RuleCall ruleCall) {
				ParserRule parserRule = EcoreUtil2.getContainerOfType(ruleCall, ParserRule.class);
				if (parserRule != null) {
					return new DiagnosticMessage(context.getLinkText() + " cannot be resolved to a rule",
							Severity.ERROR, UNRESOLVED_RULE, context.getLinkText());
				} else {
					return new DiagnosticMessage(context.getLinkText() + " cannot be resolved to a terminal rule",
							Severity.ERROR, UNRESOLVED_TERMINAL_RULE, context.getLinkText());
				}
			}
		}.doSwitch(context.getContext());
		return diagnosticMessage != null ? diagnosticMessage : super.getUnresolvedProxyMessage(context);
	}
}
